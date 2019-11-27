import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 * This class reads the news file and creates database
 * 
 * @author cglen
 * @author Dean Hougen
 *
 */
public class NoozFileProcessor
{
	private static NewsMakerList newsMakers = new NewsMakerList();
	
	/**
	 * Read the file using buffered reader
	 * 
	 * @param fileName
	 * @return NewsMakerList newsMakers
	 * @throws IOException 
	 */
	public static NewsMakerList readNoozFile(String fileName) throws IOException
	{
		/*
		 * Use buffered reader to read each line from a data file
		 */
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		String nextLine = br.readLine();
		
		while(nextLine != null){
			processLine(nextLine);
			nextLine = br.readLine();
		}
		
		br.close();
		
		/*
		 * Return newsMakers Database to main method
		 */
		return newsMakers;
	}
	
	/**
	 * Write new nooz file
	 * 
	 * @param fileName
	 * @param listOfStories
	 * @throws IOException 
	 */
	public static void writeNewsStoriesFile(String fileName, String listOfStories) throws IOException
	{
		FileWriter outfile = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(outfile);
		bw.write(listOfStories);
		bw.newLine();
		bw.close();
	}
	
	/**
	 * Process each file line
	 * 
	 * @param line
	 */
	private static void processLine(String line)
	{
		String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		
		NewsMaker newsMaker1 = new NewsMaker(decodeNewsmakerName(data, 4));
		newsMakers.add(newsMaker1);
				
		NewsMaker newsMaker2 = new NewsMaker(decodeNewsmakerName(data, 5));
		newsMakers.add(newsMaker2);
				
		//Create single story to be stored
		int sourceCheck = Integer.parseInt(data[1]);
		NewspaperStory newspaperStory;
		TVNewsStory tvNewsStory;
				
		if(sourceCheck < 400){
			newspaperStory = new NewspaperStory(decodeDate(data[0]), decodeSource(data[1]), 
								decodeLength(data[2]), decodeTopic(data[3]), newsMaker1, newsMaker2);
					
			newsMaker1 = newsMakers.get(newsMaker1);
			newsMaker1.addNewsStory(newspaperStory);
				
			newsMaker2 = newsMakers.get(newsMaker2);
			newsMaker2.addNewsStory(newspaperStory);
		}
		else{
			tvNewsStory = new TVNewsStory(decodeDate(data[0]), decodeSource(data[1]), 
					decodeLength(data[2]), decodeTopic(data[3]), newsMaker1, newsMaker2);
	
			newsMaker1 = newsMakers.get(newsMaker1);
			newsMaker1.addNewsStory(tvNewsStory);
					
			newsMaker2 = newsMakers.get(newsMaker2);
			newsMaker2.addNewsStory(tvNewsStory);
		}
	}
	
	/**
	 * Decode Date
	 * 
	 * @param dateString
	 * @return LocalDate
	 */
	public static LocalDate decodeDate(String dateString)
	{
		String yearString = dateString.substring(0, 4);
		String monthString = dateString.substring(4, 6);
		String dayOfMonthString = dateString.substring(6, 8);

		int year = Integer.parseInt(yearString);
		int month = Integer.parseInt(monthString);
		int dayOfMonth = Integer.parseInt(dayOfMonthString);
		
		return LocalDate.of(year, month, dayOfMonth);
	}
	
	/**
	 * decode Newspaper
	 * 
	 * @param sourceCode
	 * @return String
	 */
	private static String decodeSource(String sourceCode)
	{
		int code = Integer.parseInt(sourceCode);
		int[] sourceCodes = {1, 2, 3, 4, 13, 117, 118, 119, 120, 121, 122, 401, 402, 421, 
				422, 441, 442, 461, 462, 500, 501, 502, 504, 511, 514, 520, 521, 522, 
				528, 530, 532, 540, 541, 543, 545, 547, 548};
		
		String[] sourceTitles = {"New York Times", "Washington Post", 
				"Wall Street Journal", "USA Today", "Los Angeles Times", "Denver Post",
				"Houston Chronicle", "Orlando Sentinel", "Traverse City Record", 
				"Daily Herald (Everett, WA)", "Eagle Tribune (MA)", 
				"ABC Good Morning America", "ABC World News Tonight", 
				"NBC Today", "NBC Nightly News", "CBS The Early Show", 
				"CBS Evening News", "PBS NewsHour, 1st half hour", 
				"PBS NewsHour, 2nd half hour", "CNN unspecified show", 
				"CNN Daytime", "CNN Situation Room", "CNN Anderson Cooper 360", 
				"CNN John King, USA", "CNN Erin Burnett Outfront", 
				"MSNBC unspecified show", "MSNBC Daytime", 
				"MSNBC Hardball with Chris Matthews", "MSNBC Rachel Maddow Show", 
				"MSNBC The Ed Show", "MSNBC PoliticsNation", 	
				"Fox News unspecified show", "Fox News Daytime", 
				"Fox News O\'Reilly Factor", "Fox News Fox Report with Shepard Smith", 
				"Fox News Hannity", "Fox News Special Report with Bret Baier"};
		
		int i;
		for(i = 0; i < sourceCodes.length; i++){
			if(sourceCodes[i] == code){
				return sourceTitles[i];
			}
		}
		throw new IllegalArgumentException("Source does not Exist");
	}
	
	/**
	 * decode length of story
	 * 
	 * @param lengthString
	 * @return int 
	 */
	private static int decodeLength(String lengthString)
	{
		return Integer.parseInt(lengthString);
	}
	
	/**
	 * decode topic
	 * 
	 * @param topicCode
	 * @return String
	 */
	private static String decodeTopic(String topicCode)
	{
		int code = Integer.parseInt(topicCode);
		
		int[] topicCodes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};

		String[] topics = {"Government Agencies/Legislatures", 
				"Campaigns/Elections/Politics", "Defense/Military (Domestic)", 
				"Court/Legal System", "Crime", "Domestic Terrorism", "Business", 
				"Economy/Economics", "Environment", "Development/Sprawl", 
				"Transportation", "Education", "Religion", "Health/Medicine", 
				"Science and Technology", "Race/Gender/Gay Issues", "Immigration", 
				"Additional Domestic Affairs", "Disasters/Accidents",	
				"Celebrity/Entertainment", "Lifestyle", "Sports", "Media", 
				"U.S. Miscellaneous", "U.S. Foreign Affairs", "Foreign (non-U.S.)"};
		
		int i;
		for(i = 0; i < topicCodes.length; i++){
			if(topicCodes[i] == code){
				return topics[i];
			}
		}
		throw new IllegalArgumentException("Topic does not Exist");
	}
	
	/**
	 * Decode the newsmaker name
	 * 
	 * @param parts
	 * @param startingIndex
	 * @return String
	 */
	private static String decodeNewsmakerName(String[] parts, int startingIndex)
	{
		String[] name = new String[0];
		try{
			Integer.parseInt(parts[startingIndex]); 
			return "";
		}catch (NumberFormatException e){
			if(parts[startingIndex].startsWith("\"")){
				name = parts[startingIndex].split("\"");
				return name[1];
			}
			else{
				return parts[startingIndex];
			}
		}
	}
}
