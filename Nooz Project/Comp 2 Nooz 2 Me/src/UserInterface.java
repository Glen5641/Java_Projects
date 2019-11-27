import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * This class shows the interface for the user and 
 * allows for many choices of sorting and saving
 * 
 * @author cglen
 * @author Dean Hougen
 *
 */
public class UserInterface 
{
	/**
	 *Find all user selection for media
	 *
	 * @throws IOException 
	 * @return String input
	 */
	public static String queryMediaType() throws IOException
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader( System.in ));
		String input = "";
		
		/*
		 * Query user for NewsPapers, TVStories, or both
		 */
		while(!input.equalsIgnoreCase("N") && !input.equalsIgnoreCase("T") && !input.equalsIgnoreCase("B")){
			
			System.out.print("Search newspapers, TV news, or both (n, t, or b)?");
			input = inputReader.readLine();
			
			if(!input.equalsIgnoreCase("n") && !input.equalsIgnoreCase("t") && !input.equalsIgnoreCase("b")){
				System.out.println("Invalid Answer, please try again.");
			}
		}
		
		return input;
	}
	
	/**
	 *Find all user selection for Match type
	 *
	 * @throws IOException 
	 * @return String input
	 */
	public static String queryMatchType() throws IOException
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader( System.in ));
		String input = "";
		
		/*
		 * Query match from user
		 */
		while(!input.equalsIgnoreCase("e") && !input.equalsIgnoreCase("p")){
			System.out.print("Search news makers by exact or partial matches (e or p)?");
			input = inputReader.readLine();
			
			if(!input.equalsIgnoreCase("e") && !input.equalsIgnoreCase("p")){
				System.out.println("Invalid Answer, please try again.");
			}
		}
		
		return input;
	}
	
	/**
	 * Ask for newsmaker name
	 * 
	 * @return String input
	 * @throws IOException 
	 */
	public static String queryNewsMakerName(String matchType) throws IOException
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader( System.in ));
		String input = "";
		
		/*
		 * Query newsMaker from User
		 */
		System.out.print("Newsmaker (" + matchType + ")");
		input = inputReader.readLine();
		
		return input;
	}
	
	/**
	 *Find all user selection for sort criterion
	 * 
	 * @throws IOException
	 * @return String input 
	 */
	public static String querySortCriterion(String sortCriterion) throws IOException
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader( System.in ));
		String input = "";
		
		/*
		 * If user has already chose, Source, choose secondary
		 */
		if(sortCriterion.equalsIgnoreCase("S")){
			while(!input.equalsIgnoreCase("T") && !input.equalsIgnoreCase("L")){
				
				System.out.println("Secondary sort criterion is topic or length (t or l)?");
				input = inputReader.readLine();
				
				if(!input.equalsIgnoreCase("t") && !input.equalsIgnoreCase("l")){
					System.out.println("Invalid Answer, please try again.");
				}
			}
		}
		
		/*
		 * If user has already chose, Topic, choose secondary
		 */
		if(sortCriterion.equalsIgnoreCase("T")){
			while(!input.equalsIgnoreCase("S") && !input.equalsIgnoreCase("L")){
				
				System.out.println("Secondary sort criterion is source or length (s or l)?");
				input = inputReader.readLine();
				
				if(!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("l")){
					System.out.println("Invalid Answer, please try again.");
				}
			}
		}
		
		/*
		 * If user has already chose, Length, choose secondary
		 */
		if(sortCriterion.equalsIgnoreCase("L")){
			while(!input.equalsIgnoreCase("S") && !input.equalsIgnoreCase("T")){
				
				System.out.println("Secondary sort criterion is source, or topic (s or t)?");
				input = inputReader.readLine();
				
				if(input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("t")){
					System.out.println("Invalid Answer, please try again.");
				}
			}
		}
		
		/*
		 * If user has already choosen two sorts, throw third on the end
		 */
		if(sortCriterion.contains("S") || sortCriterion.contains("s") && 
				(sortCriterion.contains("T") || sortCriterion.contains("t"))){
			return "L";
		}
		
		if(sortCriterion.contains("S") || sortCriterion.contains("s") && 
				(sortCriterion.contains("L") || sortCriterion.contains("l"))){
			return "T";
		}
		
		if(sortCriterion.contains("T") || sortCriterion.contains("t") && 
				(sortCriterion.contains("L") || sortCriterion.contains("l"))){
			return "S";
		}
		
		/*
		 * Ask user for primary sort criterion
		 */
		else{
			while(!input.equalsIgnoreCase("S") && !input.equalsIgnoreCase("T") && 
												!input.equalsIgnoreCase("L")){
				
				System.out.println("Primary sort criterion is source, topic, or length (s, t, or l)?");
				input = inputReader.readLine();
				
				if(!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("t") && 
													!input.equalsIgnoreCase("l")){
					System.out.println("Invalid Answer, please try again.");
				}
			}
		}
		
		return input;
	}
	
	/**
	 *Find all user selection for fileName
	 *
	 * @throws IOException 
	 * @return String input
	 */
	public static String queryFileName(String message) throws IOException
	{
		BufferedReader inputReader = new BufferedReader(new InputStreamReader( System.in ));
		
		/*
		 * Ask the user the prompted message and send back user's message
		 */
		System.out.print(message);
		String input = inputReader.readLine();

		return input;
	}
	
	/**
	 *Find all user selection for boolean continue
	 * 
	 * @throws IOException 
	 * @return boolean 
	 */
	public static boolean queryBoolean(String message) throws IOException
	{
		BufferedReader inputReader = new BufferedReader(
				new InputStreamReader( System.in ));
		String input = "";
		
		/*
		 * Show param message to user and ask for 
		 * y/n answer and return boolean
		 */
		while(!input.toUpperCase().equals("Y") && !input.toUpperCase().equals("N")){
			
			System.out.print(message);
			input = inputReader.readLine();
			
			if(input.toUpperCase().equals("Y")){
				return true;
			}
			
			if(!input.toUpperCase().equals("Y") && !input.toUpperCase().equals("N")){
				System.out.println("Invalid answer, please try again.");
			}
		}
		
		return false;
	}
	
	/**
	 * recieve list for each newsMaker
	 * 
	 * @param newsMaker
	 * @return String ListOfStories
	 */
	public static String createListOfNewsStoriesForNewsmaker(NewsMaker newsMaker, String mediaType, String[] sortCriteria)
	{
		String listOfStories = "";
		Set<String> distinctSources = new HashSet<String>();
		Set<String> distinctTopics = new HashSet<String>();
		int totalLength = 0, size = 0;
	
		/*
		 * Get newsStorylist object from newsmaker
		 */
		NewsStoryList newsStoryList = newsMaker.getNewsStories();

		ArrayList<NewsStory> newsStories = new ArrayList<NewsStory>();
		
		for(int i = 0; i < newsStoryList.size(); i++){
			newsStories.add(newsStoryList.get(i));
		}
		
		/*
		 * Sort stories by sort criteria
		 */
		for(int i = 0; i < sortCriteria.length ; i++){
			if(sortCriteria[i].equalsIgnoreCase("L")){
				Collections.sort(newsStories, new LengthComparator());
			}
			if(sortCriteria[i].equalsIgnoreCase("S")){
				Collections.sort(newsStories, new SourceComparator());
			}
			if(sortCriteria[i].equalsIgnoreCase("T")){
				Collections.sort(newsStories);
			}
		}
			
		/*
		 * Build summary line from newsstories
		 */
		for(int i = 0; i < newsStories.size(); i++) {
			NewsStory newsStory = newsStories.get(i);

			/* 
			 * Add sources, topics, increment total length 
			 * and increment size for specific newsStory subclass
			 */
			if(mediaType.equalsIgnoreCase("T")){
				if(newsStory instanceof TVNewsStory){
				
					String source = newsStory.getSource();
					if (!distinctSources.contains(source)) {
						distinctSources.add(source);
					}
					String topic = newsStory.getTopic();
					if (!distinctTopics.contains(topic)) {
						distinctTopics.add(topic);
					}
					totalLength += newsStory.getLength();
					size++;
				}
			}
			else if(mediaType.equalsIgnoreCase("N")){
				if(newsStory instanceof NewspaperStory){
				
					String source = newsStory.getSource();
					if (!distinctSources.contains(source)) {
						distinctSources.add(source);
					}
					String topic = newsStory.getTopic();
					if (!distinctTopics.contains(topic)) {
						distinctTopics.add(topic);
					}
					totalLength += newsStory.getLength();
					size++;
				}
			}
			
			/*
			 *  Add sources, topics, increment total length 
			 * and increment size for NewsStories
			 */
			else{
				String source = newsStory.getSource();
				if (!distinctSources.contains(source)) {
					distinctSources.add(source);
				}
				String topic = newsStory.getTopic();
				if (!distinctTopics.contains(topic)) {
					distinctTopics.add(topic);
				}
				totalLength += newsStory.getLengthInWords();
				size++;
			}
				
			// Convert the story objects to string format for display
			if(mediaType.equalsIgnoreCase("b")){
			listOfStories += convertToOutputFormat(newsStory, mediaType) + "\n";
			}
			else if(mediaType.equalsIgnoreCase("N")){
				if(newsStory instanceof NewspaperStory){
					listOfStories += convertToOutputFormat(newsStory, mediaType) + "\n";
				}
			}
			else{
				if(newsStory instanceof TVNewsStory){
					listOfStories += convertToOutputFormat(newsStory, mediaType) + "\n";
				}
			}
		}

		// Build the summary line
		listOfStories += "Number of Stories: " + size + "; Number of Sources: "
				+ distinctSources.size() + "; Number of Word Equivalents: " + totalLength + "; Number of Topics: "
				+ distinctTopics.size();

		return listOfStories;
	}
	
	/**
	 * Convert stories to string
	 * 
	 * @param newsStory
	 * @param mediaType
	 * @return String StoryString
	 */
	private static String convertToOutputFormat(NewsStory newsStory, String mediaType)
	{
		String storyString = "";
		
		/*
		 * Build string from object to print out for both
		 */
		if(mediaType.equalsIgnoreCase("B")){
			LocalDate date = newsStory.getDate();
			
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + 
				date.getDayOfMonth() + ", " + date.getYear() + "; " + newsStory.getSource() + "; " + 
				newsStory.getLengthInWords() +	" word equivalents; " + newsStory.getTopic();
		
			return storyString;
		}
		
		/*
		 * Build string from object to print out for specified newsStory
		 */
		if(mediaType.equalsIgnoreCase("T")){
			if(newsStory instanceof TVNewsStory){
				LocalDate date = newsStory.getDate();
			
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + 
						date.getDayOfMonth() + ", " + date.getYear() + "; " + newsStory.getSource() + "; " + 
						newsStory.getLength() +	" seconds; " + newsStory.getTopic();
				
				return storyString;
			}
		}
		if(mediaType.equalsIgnoreCase("N")){
			if(newsStory instanceof NewspaperStory){
				LocalDate date = newsStory.getDate();
				
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + 
					date.getDayOfMonth() + ", " + date.getYear() + "; " + newsStory.getSource() + "; " + 
					newsStory.getLength() +	" words; " + newsStory.getTopic();
					
				return storyString;
			}
		}
		return storyString;
	}
		
	/**
	 * Show user news Stories
	 * 
	 * @param listOfStories
	 * List of NewsStories
	 * @param newsMakerName
	 * Name of Queried NewsMaker
	 */
	public static void presentNewsStories(String listOfStories, String newsMakerName)
	{
		System.out.println("News stories for " + newsMakerName + "\n" + listOfStories);
	}
	
	/**
	 * Tell the user newsmaker isnt found
	 * 
	 * @param queriedNewsMaker
	 * Newsmaker that wasn't found
	 */
	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker)
	{
		System.out.println("There are no newspaper stories about " + 
				queriedNewsMaker.getName() + " in this database.");
	}
}
