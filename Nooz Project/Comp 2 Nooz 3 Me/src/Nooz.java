import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * This class drives an interface by using a nooz database and uses helper
 * methods to produce user interaction and loading data
 * 
 * @author cglen and Dean Hougen
 */
public class Nooz {

	private static NewsMakerList newsMakers;
	private static Map<String, String> sourceMap;
	private static Map<String, String> topicMap;
	private static Map<String, String> subjectMap;

	/**
	 * This method accesses loadData and LoopForUserQueries()
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Load necessary data to create NewsMakerList database
		loadData();

		// Find user queries to create output or graph
		loopForUserQueries();
	}

	/**
	 * This helper method loads the data for the database.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static void loadData() throws IOException, ClassNotFoundException {

		// Ask for text or binary file
		String answer = UserInterface.querySingleChoice("Read text or binary data (t or b)?",
				new String[] { "t", "b" });

		if (answer.equals("t")) {// If Text

			// Load source map
			String mapFileName = UserInterface.queryFileName("Enter the name of the source data file: ", true);
			sourceMap = CodeFileProcessor.readCodeFile(mapFileName);

			// Load topic map
			mapFileName = UserInterface.queryFileName("Enter the name of the topic data file: ", true);
			topicMap = CodeFileProcessor.readCodeFile(mapFileName);

			// Load subject map
			mapFileName = UserInterface.queryFileName("Enter the name of the subject data file: ", true);
			subjectMap = CodeFileProcessor.readCodeFile(mapFileName);

			// Load Story Data File
			String newsMakerFileName = UserInterface.queryFileName("Enter the name of the news story data file: ",
					true);
			newsMakers = NoozFileProcessor.readNoozFile(newsMakerFileName, sourceMap, topicMap, subjectMap);

			// ask to Save data in Binary Format for future loading
			answer = UserInterface.querySingleChoice("Save data in binary format (y/n)?", new String[] { "y", "n" });
			if (answer.equals("y")) {// If yes

				// Save data in Binary Format for future loading
				answer = UserInterface.queryFileName("Enter the name of the file the data should be saved to: ", false);
				FileOutputStream fileOutputStream = new FileOutputStream((answer));
				ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);

				// Write to file
				output.writeObject(newsMakers);
				output.close();
			}
		} else if (answer.equals("b")) {// If Binary

			// Ask name of Binary data file
			String fileName = UserInterface.queryFileName("Enter the name of the news story binary data file: ", true);

			// Try to access file. If file isnt found, state not found
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(fileName);
			} catch (FileNotFoundException e) {
				System.err.println(fileName + " file not found");
				System.exit(1);
			}
			ObjectInputStream input = new ObjectInputStream(fileInputStream);

			// Read NewsMaker list from file
			newsMakers = (NewsMakerList) input.readObject();

			// Close file stream
			input.close();
		} else {// If not Text or Binary

			// throw illegal exception
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This helper method loops for user queries and does not accept invalid
	 * answer choices
	 * 
	 * @throws IOException
	 */
	private static void loopForUserQueries() throws IOException {
		boolean loop = true;

		// Loop until the user does not want to continue
		while (loop) {

			// Ask for newspapers, tvstories, or online stories search
			String mediaType = UserInterface.queryMultipleChoices(
					"Search newspapers, TV news, and/or online news sources (n, t, and/or o)?",
					new String[] { "n", "t", "o" });

			// ask for exact or partial match
			String matchType = UserInterface.querySingleChoice(
					"Search news makers by exact or partial matches (e or p)?", new String[] { "e", "p" });

			String newsMakerName;
			NewsMaker foundNewsMaker = new NewsMaker();
			boolean matchFound = false;
			// Loop until newsMaker match is found
			while (!matchFound) {

				// Ask newsMaker's name
				newsMakerName = UserInterface.queryNewsMakerName(matchType);

				// If exact, search for exact match
				if (matchType.equals("e")) {
					foundNewsMaker = newsMakers.getExactMatch(newsMakerName);
				}

				// If partial, search for the partial match
				else {
					foundNewsMaker = newsMakers.getPartialMatch(newsMakerName);
				}

				// If no news maker with that name found, tell user
				if (foundNewsMaker == null) {
					UserInterface.reportNewsmakerNotFound(new NewsMaker(newsMakerName));
				}

				// If newsMaker found, exit loop
				else {
					matchFound = true;
				}
			}

			// Ask for text or graph
			String displayType = UserInterface.querySingleChoice("Display text or graph (t or g)?",
					new String[] { "t", "g" });

			// If text, display newsStories in text format to user
			if (displayType.equals("t")) {
				String[] sortCriteria = new String[4];

				// ask for sortcriteria for sorting the stories
				for (int i = 0; i < sortCriteria.length; i++) {
					sortCriteria[i] = UserInterface.querySortCriterion(sortCriteria);
				}

				// Sort the newsMakersList for binary search
				newsMakers.sort();

				// Build and present the stories to the user
				String listOfStories = UserInterface.createListOfNewsStoriesForNewsmaker(foundNewsMaker, mediaType,
						sortCriteria);
				UserInterface.presentNewspaperStories(listOfStories, foundNewsMaker.getName());

				// Ask to save
				String saveType = UserInterface.querySingleChoice("Save (y/n)?", new String[] { "y", "n" });
				if (saveType.equals("y")) { // If yes

					// Ask save type
					saveType = UserInterface.querySingleChoice("Save to text or binary data (t or b)?",
							new String[] { "t", "b" });
					String fileName = UserInterface
							.queryFileName("Enter the name of the file the data should be saved to: ", false);

					if (saveType.equals("b")) {
						// Save data in Binary Format for future loading

						FileOutputStream fileOutputStream = new FileOutputStream((fileName));
						ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);

						// Write to file
						output.writeObject(newsMakers.get(foundNewsMaker));
						output.close();
					} else {
						NoozFileProcessor.writeNewsStoriesFile(fileName, listOfStories);
					}
				}
			}

			// If graph, display graph to user in piechart format
			else {

				// Ask for source, topic, or subject
				String content = UserInterface.querySingleChoice("Graph source, topic, or big story (s, t, or b)?",
						new String[] { "s", "t", "b" });

				// Ask for measure, length or count
				String measure = UserInterface.querySingleChoice("Graph by length or count (l or c)?",
						new String[] { "l", "c" });

				UserInterface.displayPieChartForNewsMaker(foundNewsMaker, mediaType, content, measure);
			}

			// Ask to continue or not
			String answer = UserInterface.querySingleChoice("Continue (y/n)?", new String[] { "y", "n" });
			if (answer.equals("n")) {
				loop = false;
			}
		}

		// If the user chooses not to continue, message user with good tidings.
		System.out.println("Thanks for using Nooz!");
	}
}
