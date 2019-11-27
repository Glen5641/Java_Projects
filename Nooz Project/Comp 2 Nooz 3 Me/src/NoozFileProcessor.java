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
 * @author cglen and Dean Hougen
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
	 * @throws IOException
	 */
	public static NewsMakerList readNoozFile(String fileName, Map<String, String> sourceMap,
			Map<String, String> topicMap, Map<String, String> subjectMap) throws IOException {

		// Open file
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);

		// Read past header line
		br.readLine();

		// Read next line of file into NextLine
		String nextLine = br.readLine();

		// Process each line while the lines are not null
		while (nextLine != null) {
			processLine(nextLine, sourceMap, topicMap, subjectMap);
			nextLine = br.readLine();
		}

		// Close Buffered Reader
		br.close();

		// Return NewsMakers to Nooz Class
		return newsMakers;
	}

	/**
	 * Write the newsStories to a specified file
	 * 
	 * @param fileName
	 * @param listOfStories
	 * @throws IOException
	 */
	public static void writeNewsStoriesFile(String fileName, String listOfStories) throws IOException {

		// Open new file
		FileWriter outfile = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(outfile);

		// Write the listofStories to file
		bw.write(listOfStories);
		bw.newLine();

		// Close the Buffered Writer
		bw.close();
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

		// Split the line into parts by comma delimitation
		String[] parts = line.split(",");

		/*
		 * Decode file
		 */
		// Decode Date
		LocalDate date = decodeDate(parts[0]);
		// Decode Source
		String source = sourceMap.get(parts[1]);
		// Decode WordCount
		int length = decodeLength(parts[2]);
		// Decode Subject
		String subject = subjectMap.get(parts[3]);
		// Decode Topic
		String topic = topicMap.get(parts[4]);
		// Decode NewsMaker Name 1
		String newsMakerName1 = decodeNewsmakerName(parts, 5);
		// Decode NewsMaker Name 2
		String newsMakerName2;
		if (newsMakerName1.contains(",")) {
			newsMakerName2 = decodeNewsmakerName(parts, 7);
		} else {
			newsMakerName2 = decodeNewsmakerName(parts, 6);
		}
		// Decode Part Of Day
		PartOfDay partOfDay;
		try {
			if (Integer.parseInt(parts[parts.length - 1]) != 99) {
				partOfDay = decodePartOfDay(parts[parts.length - 1]);
			} else {
				partOfDay = null;
			}
		} catch (NumberFormatException e) {
			partOfDay = null;
		}

		// Build NewsMaker Objects
		NewsMaker newsMaker1 = new NewsMaker(newsMakerName1);
		if (newsMakers.contains(newsMaker1)) {
			newsMaker1 = newsMakers.get(newsMaker1);
		} else {
			newsMakers.add(newsMaker1);
		}

		NewsMaker newsMaker2 = new NewsMaker(newsMakerName2);
		if (newsMakers.contains(newsMaker2)) {
			newsMaker2 = newsMakers.get(newsMaker2);
		} else {
			newsMakers.add(newsMaker2);
		}

		// Build NewsStory
		int sourceNum = Integer.parseInt(parts[1]);
		NewsStory newsStory = null;
		if (sourceNum < 200) {
			newsStory = new NewspaperStory(date, source, length, topic, subject, newsMaker1, newsMaker2);
		} else if (sourceNum >= 200 && sourceNum < 400) {
			newsStory = new OnlineNewsStory(date, source, length, topic, subject, partOfDay, newsMaker1, newsMaker2);
		} else {
			newsStory = new TVNewsStory(date, source, length, topic, subject, partOfDay, newsMaker1, newsMaker2);
		}

		// Add newsStories to Corresponding newsMakers
		newsMaker1.addNewsStory(newsStory);
		newsMaker2.addNewsStory(newsStory);
	}

	/**
	 * Decode local date
	 * 
	 * @param dateString
	 * @return date
	 */
	private static LocalDate decodeDate(String dateString) {

		// Get year from the dateString
		String yearString = dateString.substring(0, 4);
		int year = Integer.parseInt(yearString);

		// Get month from the dateString
		String monthString = dateString.substring(4, 6);
		int month = Integer.parseInt(monthString);

		// Get day of Month from the dateString
		String dayOfMonthString = dateString.substring(6, 8);
		int dayOfMonth = Integer.parseInt(dayOfMonthString);

		// Build localDate from year, month, and day
		LocalDate date = LocalDate.of(year, month, dayOfMonth);

		// Return date to processLine
		return date;
	}

	/**
	 * Decode length from line
	 * 
	 * @param lengthString
	 * @return length
	 */
	private static int decodeLength(String lengthString) {

		// Parse the length string to an integer
		int length = Integer.parseInt(lengthString);

		// Return length to ProcessLine
		return length;
	}

	/**
	 * Decode newsMakerName to create a newsMaker
	 * 
	 * @param parts
	 * @param startingIndex
	 * @return Name
	 */
	private static String decodeNewsmakerName(String[] parts, int startingIndex) {

		String name = "";

		// Check for 99
		if ("99".equals(parts[startingIndex])) {
			name = "None";
		}

		// If the start of the name ends in quote, then name is only one part
		else if (parts[startingIndex].endsWith("\"")) {
			name = parts[startingIndex].replaceAll("\"", "");
		}

		// else the name is 2 parts
		else {
			name = (parts[startingIndex] + "," + parts[startingIndex + 1]).replaceAll("\"", "");
		}

		// Return name to processLine
		return name;
	}

	/**
	 * Decode part of day for tvStories and OnlineStories
	 * 
	 * @param partOfDayCode
	 * @return PartOfDay
	 */
	private static PartOfDay decodePartOfDay(String partOfDayCode) {

		int podNum = Integer.parseInt(partOfDayCode);

		// Use case switch to find string from enum and return string to
		// processLine
		switch (podNum) {
		case 4: {
			return PartOfDay.MORNING;
		}
		case 3: {
			return PartOfDay.AFTERNOON;
		}
		case 2: {
			return PartOfDay.EVENING;
		}
		case 1: {
			return PartOfDay.LATE_NIGHT;
		}

		// If none match, the argument is illegal
		default: {
			throw new IllegalArgumentException();
		}
		}
	}
}
