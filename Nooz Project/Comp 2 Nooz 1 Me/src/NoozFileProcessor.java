import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Class to process a comma delimited file and decode certain aspects
 * 
 * @author cglen and Dean Hougen
 */
public class NoozFileProcessor 
{
	//Create newsmaker list
	private static NewsMakerList newsMakers;
	
	/**
	 * Begin to read file line by line with buffered reader
	 * 
	 * @param fileName
	 * @return NewsMakerList
	 * @throws IOException
	 */
	public static NewsMakerList readNoozFile(String fileName) throws IOException
	{
		//Initialize
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		newsMakers = new NewsMakerList();
		
		//Skip first line and read line by line
		br.readLine();
		String nextLine = br.readLine();
		
		//Loop till end of file
		while(nextLine != null)
		{
			processLine(nextLine);
			nextLine = br.readLine();
		}
		
		//Close bufferedreader to make eclipse happy
		br.close();
		
		return newsMakers;
	}
	
	/**
	 * Process the file line and decode to be input into many variables for the story
	 * 
	 * @param line
	 */
	private static void processLine(String line)
	{
		//Initiallize variables
		String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
		NewsMaker newsMaker1, newsMaker2;
		
		//send "name" to decoder and add to newsmaker
		newsMaker1 = new NewsMaker(decodeNewsmakerName(data, 4));
		newsMakers.add(newsMaker1);
		
		newsMaker2 = new NewsMaker(decodeNewsmakerName(data, 5));
		newsMakers.add(newsMaker2);
		
		//Create single story to be stored
		NewspaperStory story = new NewspaperStory(decodeDate(data[0]), decodeNewspaper(data[1]), 
										decodeWordCount(data[2]), decodeTopic(data[3]), newsMaker1, newsMaker2);
		
		//Add stories to their newsmaker's story list
		newsMaker1 = newsMakers.get(newsMaker1);
		newsMaker1.addNewspaperStory(story);
		
		newsMaker2 = newsMakers.get(newsMaker2);
		newsMaker2.addNewspaperStory(story);
	}
	
	/**
	 * Decode Date
	 * 
	 * @param dateString
	 * @return LocalDate
	 * @throws ParseException 
	 */
	private static LocalDate decodeDate(String dateString)
	{   
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate date = LocalDate.parse(dateString, formatter);
		return date;
	}
	
	/**
	 * Decode newspaper code
	 * 
	 * @param newspaperCode
	 * @return String
	 */
	private static String decodeNewspaper(String newspaperCode)
	{
		int code = Integer.parseInt(newspaperCode);
		int[] newspaperCodes = {1, 2, 3, 4, 13, 117, 118, 119, 120, 121, 122};
		
		String[] newspaperTitles = {"New York Times", "Washington Post", 
				"Wall Street Journal", "USA Today", "Los Angeles Times", "Denver Post",
				"Houston Chronicle", "Orlando Sentinel", "Traverse City Record", 
				"Daily Herald (Everett, WA)", "Eagle Tribune (MA)"};
		
		int i;
		for(i = 0; i < newspaperCodes.length; i++)
		{
			if(newspaperCodes[i] == code)
				break;
		}
		
		return newspaperTitles[i];
	}
	
	/**
	 * Decode wordcount for story
	 * 
	 * @param wordCountString
	 * @return int
	 */
	private static int decodeWordCount(String wordCountString)
	{
		int wordCount = Integer.parseInt(wordCountString);
		return wordCount;
	}
	
	/**
	 * decode topic of story
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
		for(i = 0; i < topicCodes.length; i++)
		{
			if(topicCodes[i] == code)
				break;
		}
		
		return topics[i];
	}
	
	/**
	 * decode a single newsmaker
	 * 
	 * @param parts
	 * @return String
	 */
	private static String decodeNewsmakerName(String[] parts, int startingIndex)
	{
		String[] name = new String[0];
		try 
		{
			Integer.parseInt(parts[startingIndex]); 
			return "";
		} 
		catch (NumberFormatException e) 
		{
			if(parts[startingIndex].startsWith("\""))
			{
				name = parts[startingIndex].split("\"");
				return name[1];
			}
			else
				return parts[startingIndex];
		}
	}
}