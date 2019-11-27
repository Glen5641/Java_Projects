import java.io.IOException;

/**
 * Project 2, CS 2334, Section 010, February 22, 2017
 *
 * Nooz is the driver class for Nooz, a simple newspaper story data system.
 * Because user interaction with the date is focused on news makers, the primary
 * data structure used by the driver is a NewsMakerList, which is
 * used within main.
 * 
 *
 * @author Dean Hougen
 */
class Nooz {
	/** The list of news makers. */
	private static NewsMakerList newsMakers = new NewsMakerList();

	/**
	 * The main method creates the objects necessary to do the work, then lets
	 * them do it.
	 * 
	 * Reads a data file specified by the user at the console prompt; this loads
	 * in all data used by the program.
	 * 
	 * 
	 * Once the data is read in, it enters a user interaction loop, asking for
	 * the type of stories to search, the name of a news maker, etc., then
	 * displaying the stories about that news maker or reporting that the news
	 * maker is not found in the data, as appropriate. The loop continues until
	 * the user enters "n" to a "Continue (y/n)?" prompt.
	 * 
	 * 
	 * Note that this program doesn't attempt to deal with I/O errors. This is
	 * allowable at this point to keep this project relatively simple and
	 * because we haven't covered this topic yet. However, this is something to
	 * be refined in the future.
	 * 
	 * 
	 * @param args
	 *            The program arguments are not used in this program.
	 * @throws IOException
	 *             If there is an I/O problem reading the data file.
	 */
	public static void main(String[] args) throws IOException {
		// There should be no program arguments supplied
		if (args.length != 0) {
			// If the calling process specifies the wrong number of program
			// arguments, give an error message and exit with non-zero exit code
			System.err.println("Usage error. Program arguments are not used by this program.");
			System.exit(1);
		}

		// Prompt user for name of data file.
		String inputFileName = UserInterface.queryFileName("Enter the name of the news story data file: ");

		// Read file putting NewsMakers in the NewsMakerList
		// TODO Handle possible I/O errors (Eventually)
		newsMakers = NoozFileProcessor.readNoozFile(inputFileName);
		
		// Sort the news makers
		newsMakers.sort();

		boolean loop = true;
		// Enter GUI loop
		while (loop) {
			// Prompt user for type of media to search.
			String mediaType = UserInterface.queryMediaType();

			String matchType = UserInterface.queryMatchType();

			// Get the name of the news maker from the user
			String newsMakerName = UserInterface.queryNewsMakerName(matchType);

			// Determine the sort criteria to be used
			String[] sortCriteria = new String[3];
			sortCriteria[0] = UserInterface.querySortCriterion("");
			sortCriteria[1] = UserInterface.querySortCriterion(sortCriteria[0]);
			sortCriteria[2] = "stl".replace(sortCriteria[0], "");
			sortCriteria[2] = sortCriteria[2].replace(sortCriteria[1], "");

			NewsMaker foundNewsMaker;
			// Get the news maker from the list of news makers
			if (matchType.equals("e")) {
				foundNewsMaker = newsMakers.getExactMatch(newsMakerName);
			}
			// Otherwise, must be partial
			else {
				foundNewsMaker = newsMakers.getPartialMatch(newsMakerName);
			}

			// If no news maker with that name found, tell user
			if (foundNewsMaker == null) {
				UserInterface.reportNewsmakerNotFound(new NewsMaker(newsMakerName));
			}

			else {
				// Otherwise, get list of stories as a String from news maker
				String listOfStories = UserInterface.createListOfNewsStoriesForNewsmaker(foundNewsMaker, mediaType,
						sortCriteria);

				// And show the list of stories to the user
				UserInterface.presentNewspaperStories(listOfStories, foundNewsMaker.getName());

				if (UserInterface.queryBoolean("Save")) {
					String outputFileName = UserInterface.queryFileName("Enter the name of the file to save to: ");
					NoozFileProcessor.writeNewsStoriesFile(outputFileName, listOfStories);
				}
			}

			loop = UserInterface.queryBoolean("Continue");
		}
		System.out.println("Thanks for using Nooz.");
		System.exit(0);
	}
}
