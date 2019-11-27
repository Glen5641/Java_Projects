import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

/**
 * This class decodes the story data file into newsStories with corresponding
 * newsMakers and writes them to a file
 * 
 * @author cglen
 */
public class NoozFileProcessor {

	private static NewsMakerList newsMakers = new NewsMakerList();

	/**
	 * Read the nooz data from a file
	 * 
	 * @param fileName
	 * @param sourceMap
	 * @param topicMap
	 * @param subjectMap
	 * @return NewsMakerList
	 */
	public static NewsMakerList readNoozFile(String fileName, Map<String, String> sourceMap,
			Map<String, String> topicMap, Map<String, String> subjectMap) throws IOException {
		return null;
	}

	/**
	 * Write the newsStories to a specified file
	 * 
	 * @param fileName
	 * @param listOfStories
	 * @throws IOException
	 */
	public static void writeNewsStoriesFile(String fileName, String listOfStories) throws IOException {
	}

	/**
	 * Process each line of code with this method
	 * 
	 * @param line
	 * @param sourceMap
	 * @param topicMap
	 * @param subjectMap
	 */
	private static void processLine(String line, Map<String, String> sourceMap, Map<String, String> topicMap,
			Map<String, String> subjectMap) {
	}

	/**
	 * Decode local date
	 * 
	 * @param dateString
	 * @return date
	 */
	private static LocalDate decodeDate(String dateString) {
		return null;
	}

	/**
	 * Decode length from line
	 * 
	 * @param lengthString
	 * @return length
	 */
	private static int decodeLength(String lengthString) {
		return 0;
	}

	/**
	 * Decode newsMakerName to create a newsMaker
	 * 
	 * @param parts
	 * @param startingIndex
	 * @return Name
	 */
	private static String decodeNewsmakerName(String[] parts, int startingIndex) {
		return "";
	}

	/**
	 * Decode part of day for tvStories and OnlineStories
	 * 
	 * @param partOfDayCode
	 * @return PartOfDay
	 */
	private static PartOfDay decodePartOfDay(String partOfDayCode) {
		return null;
	}
}
