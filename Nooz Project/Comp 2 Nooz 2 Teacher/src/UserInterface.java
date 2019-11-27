import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 * This class provides helper methods to interact with the user.
 * Note that all methods in this class are static because we don't need to make
 * several UserInterface objects and have them maintain their own
 * data. Instead, we simply need a collection of useful methods to create
 * windows that pop up one at a time, are used, and then are discarded.
 * 
 * @author Dean Hougen
 * @version 2.0
 *
 */
class UserInterface {

	
	
	
	/**
	 * This method asks the user (at the console):
	 * "Search newspapers, TV news, or both (n, t, or b)? "
	 * The method loops until a valid answer in given.
	 * 
	 * @return The media type as a String.
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static String queryMediaType() throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Search newspapers, TV news, or both (n, t, or b)? ");
		String mediaChoice = "";
		while (true) {
			mediaChoice = inputReader.readLine();
			if (mediaChoice.equals("n") || mediaChoice.equals("t") || mediaChoice.equals("b")) {
				return mediaChoice;
			} else {
				System.out.println("The choice you entered is invalid. Please enter a new choice.");
			}
		}
	}

	
	
	
	/**
	 * This method asks the user (at the console):
	 * "Search news makers by exact or partial matches (e or p)? "
	 * The method loops until a valid answer in given.
	 * 
	 * @return The match type as a String.
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static String queryMatchType() throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Search news makers by exact or partial matches (e or p)? ");
		String matchChoice = "";
		while (true) {
			matchChoice = inputReader.readLine();
			if (matchChoice.equals("e") || matchChoice.equals("p")) {
				return matchChoice;
			} else {
				System.out.println("The choice you entered is invalid. Please enter a new choice.");
			}
		}
	}

	
	
	
	/**
	 * This method asks the user for the name of a news maker using console
	 * input and returns it. It will ask for an exact or partial match,
	 * depending on the parameter matchType, which has "e" and "p"
	 * as its two valid options.
	 * 
	 * @param matchType
	 *            Whether the name match will be exact (e) or partial (p).
	 * @return The name provided by the user (or "None" if none provided).
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static String queryNewsMakerName(String matchType) throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		if (matchType.equals("e")) {
			System.out.print("Newsmaker (exact)? ");
		}
		// The only options are exact and partial
		else {
			System.out.print("Newsmaker (partial)? ");
		}
		String newsMakerName = inputReader.readLine();

		// If String returned is empty (""), news maker is "None" (a special
		// value).
		if (newsMakerName.equals("")) {
			newsMakerName = "None";
		}
		return newsMakerName;
	}

	
	
	
	/**
	 * This method asks the user (at the console) for a sort criterion. If
	 * called with an empty String (""), it will ask about the
	 * primary sort criterion. If called with a non-empty String,
	 * it will ask for a secondary sort criterion that isn't the sort criterion
	 * passed in as a parameter. The method loops until a valid answer in given.
	 * 
	 * @param sortCriterion
	 *            The primary sort criterion already specified by the user (if
	 *            any).
	 * @return The sort criterion specified by the user.
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static String querySortCriterion(String sortCriterion) throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		String criterionChoice = "";
		if (sortCriterion == "") {
			System.out.print("Primary sort criterion is source, topic, or length (s, t, or l)? ");
			while (true) {
				criterionChoice = inputReader.readLine();
				if (criterionChoice.equals("s") || criterionChoice.equals("t") || criterionChoice.equals("l")) {
					return criterionChoice;
				} else {
					System.out.println("The choice you entered is invalid. Please enter a new choice.");
				}
			}
		} else {
			if (sortCriterion.equals("s")) {
				System.out.print("Secondary sort criterion is topic or length (t or l)? ");
				while (true) {
					criterionChoice = inputReader.readLine();
					if (criterionChoice.equals("t") || criterionChoice.equals("l")) {
						return criterionChoice;
					} else {
						System.out.println("The choice you entered is invalid. Please enter a new choice.");
					}
				}
			} else if (sortCriterion.equals("t")) {
				System.out.print("Secondary sort criterion is source or length (s or l)? ");
				while (true) {
					criterionChoice = inputReader.readLine();
					if (criterionChoice.equals("s") || criterionChoice.equals("l")) {
						return criterionChoice;
					} else {
						System.out.println("The choice you entered is invalid. Please enter a new choice.");
					}
				}
			} else {
				System.out.print("Secondary sort criterion is source or topic (s or t)? ");
				while (true) {
					criterionChoice = inputReader.readLine();
					if (criterionChoice.equals("s") || criterionChoice.equals("t")) {
						return criterionChoice;
					} else {
						System.out.println("The choice you entered is invalid. Please enter a new choice.");
					}
				}
			}
		}
	}

	
	
	
	/**
	 * This method prompts the user (at the console) with whatever message is
	 * passed in through the parameter message. This message is
	 * intended to ask for filenames but does no checks on the
	 * String returned so it could be used to ask any question that
	 * takes a String as a response.
	 * 
	 * @param message
	 *            The message with which to prompt the user.
	 * @return The filename as a String.
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static String queryFileName(String message) throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(message);
		return inputReader.readLine();
	}

	
	
	
	/**
	 * This method prompts the user (at the console) with whatever message is
	 * passed in through the parameter message, followed by the
	 * String " (y/n)?". This message is intended to ask questions to which the
	 * answer should be yes (y) or no (n) and it returns a boolean value of
	 * true or false, respectively. The method loops
	 * until a valid answer in given.
	 * 
	 * @param message
	 *            The message with which to prompt the user.
	 * @return A boolean value of true for yes or false for no.
	 * @throws IOException
	 *             If something goes wrong reading a line from the console.
	 */
	public static boolean queryBoolean(String message) throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(message + " (y/n)? ");
		String booleanChoice = "";
		while (true) {
			booleanChoice = inputReader.readLine();
			if (booleanChoice.equals("y")) {
				return true;
			} else if (booleanChoice.equals("n")) {
				return false;
			} else {
				System.out.println("The choice you entered is invalid. Please enter a new choice.");
			}
		}
	}

	
	
	
	/**
	 * This method takes a news maker and turns its list of news stories into a
	 * String formated for display to the user. At the end it includes a line 
	 * summarizing the number of stories found, the number of different 
	 * news sources in which these stories were published, the total length 
	 * of these stories, and the number of different topics found. The summary 
	 * line will have a slightly different format depending on media type specified. 
	 * Newspapers: Number of Stories: n1; Number of Sources: n2; 
	 * Number of Words: n3; Number of Topics: n4; TV News: Number of Stories: n1;
	 * Number of Sources: n2; Seconds: n3; Number of Topics: n4; Both:
	 * Number of Stories:n1; Number of Sources: n2; Number of Word Equivalents: n3; 
	 * Number of Topics: n4
	 * 
	 * @param newsMaker
	 *            The news maker for which to create the story list as a string.
	 * @param mediaType
	 *            The type of media (newspaper, TV news, or both, given as n, t,
	 *            or b) that should be included in the list.
	 * @param sortCriteria
	 *            The primary, secondary, and tertiary sort criteria to use
	 *            (source, topic or length, given as s, t, or l), in an array
	 *            where element 0 corresponds to primary, 1 to secondary, and 2
	 *            to tertiary.
	 * @return The list of stories as one (potentially very large) string
	 */
	public static String createListOfNewsStoriesForNewsmaker(NewsMaker newsMaker, String mediaType,
			String[] sortCriteria) {
		/* The list of stories as a String */
		String listOfStories = "";

		/*
		 * Sets to keep track of the distinct news source names and topics found
		 * (for the summary line).
		 */
		Set<String> distinctNewsSourceNames = new TreeSet<String>();
		Set<String> distinctTopics = new TreeSet<String>();

		/* The running total of the words in the stories. */
		int totalLength = 0;

		/*
		 * A local reference to the story list so that we don't have use the
		 * accessor method repeatedly (wasting time).
		 */
		NewsStoryList newsStoryList = newsMaker.getNewsStories();

		// Make our own copy of the data so that we can sort it.
		List<NewsStory> newsStories = new ArrayList<NewsStory>(newsStoryList.size());

		// If the user asked for just newspaper stories, just add those.
		if (mediaType.equals("n")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof NewspaperStory) {
					newsStories.add(newsStory);
				}
			}
		}
		// If the user asked for just TV news stories, just add those.
		else if (mediaType.equals("t")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof TVNewsStory) {
					newsStories.add(newsStory);
				}
			}
		}
		// Otherwise, add them all.
		else {
			for (int i = 0; i < newsStoryList.size(); i++) {
				newsStories.add(newsStoryList.get(i));
			}
		}

		// Sort the list based on the user's sort criteria
		// Start with tertiary sort criterion and work to primary
		for (int i = 2; i >= 0; i--) {
			if (sortCriteria[i].equals("t")) {
				Collections.sort(newsStories);
			} else if (sortCriteria[i].equals("l")) {
				Collections.sort(newsStories, LengthComparator.LENGTH_COMPARATOR);
			} else {
				Collections.sort(newsStories, SourceComparator.SOURCE_COMPARATOR);
			}
		}

		// Cycle through the stories one at a time
		for (NewsStory newsStory : newsStories) {

			// Add any new source name encountered to the set of names
			// Since sets exclude duplicates, we don't need to check
			distinctNewsSourceNames.add(newsStory.getSource());

			// Add any new topic encountered to the set of topics
			// Since sets exclude duplicates, we don't need to check
			distinctTopics.add(newsStory.getTopic());

			// Add to the running total for length
			// If the type is TV news, use seconds (from length)
			if (mediaType.equals("t")) {
				totalLength += newsStory.getLength();
			}
			// If the type is newspaper, use words
			// If the type is mixed, use words as common unit
			else {
				totalLength += newsStory.getLengthInWords();
			}

			// Convert the story to the display format and add it to the end of
			// the list
			listOfStories += convertToOutputFormat(newsStory, mediaType) + "\n";
		}

		// Construct the summary line
		// If the type is newspaper, use words
		if (mediaType.equals("n")) {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Words: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size();
		}
		// If the type is TV news, use seconds (from length)
		else if (mediaType.equals("t")) {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Seconds: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size();
		}
		// If the type is mixed, use words as common unit
		else {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Word Equivalents: " + totalLength
					+ "; Number of Topics: " + distinctTopics.size();
		}
		return listOfStories;
	}

	
	
	
	/**
	 * This method converts an individual story to the desired display format.
	 * The returned line will have a slightly different format depending on
	 * media type specified. Newspapers: date; source; number words; topic
	 * TV News: date; source; number seconds; topic Both: date; source; 
	 * number word equivalents; topic
	 * 
	 * @param newsStory
	 *            The story to convert to the display format.
	 * @param mediaType
	 *            The type of media (newspaper, TV news, or both, given as n, t,
	 *            or b) that will be included in the list.
	 * @return The story in the display format.
	 */
	private static String convertToOutputFormat(NewsStory newsStory, String mediaType) {
		String storyString = "";
		LocalDate date = newsStory.getDate();
		// If the type is newspaper, use words
		if (mediaType.equals("n")) {
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " words; "
					+ newsStory.getTopic();
		}
		// If the type is TV news, use seconds (from length)
		else if (mediaType.equals("t")) {
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " seconds; "
					+ newsStory.getTopic();
		}
		// If the type is mixed, use words as common unit
		else {
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLengthInWords()
					+ " word equivalents; " + newsStory.getTopic();
		}
		return storyString;
	}

	
	
		
	/**
	 * This method displays the list of news stories to the user at the console.
	 * 
	 * @param listOfStories
	 *            The list of stories to display, all as one (potentially very
	 *            large) String.
	 * @param newsMakerName
	 *            The name of the news maker (which is put into the title of the
	 *            JOptionPane).
	 */
	public static void presentNewspaperStories(String listOfStories, String newsMakerName) {
		System.out.println("News stories for " + newsMakerName);
		System.out.println(listOfStories);
	}

	
	
		
	/**
	 * This method reports at the console that there were no relevant stories
	 * found. "There are no relevant stories about news maker in this database."
	 * 
	 * @param queriedNewsMaker
	 *            The news maker the user searched for.
	 */
	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker) {
		System.out.println("There are no relevant stories about " + queriedNewsMaker.getName() + " in this database.");
	}
}
