import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * This class provided helper methods to interact with the user.
 * </P>
 * <P>
 * Note that all methods in this class are static because we don't need to make
 * several <code>UserInterface</code> objects and have them maintain their own
 * data. Instead, we simply need a collection of useful methods to create
 * windows that pop up one at a time, are used, and then are discarded.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 *
 */
class UserInterface {

	/**
	 * This method asks the user for the name of a news maker using a
	 * <code>JOptionPane</code> and returns it.
	 * 
	 * @return The name provided by the user (or "None" if none provided).
	 */
	public static String queryNewsMakerName() {
		String newsMakerName = (String) JOptionPane.showInputDialog(null, "Enter the name of the news maker:",
				"News Maker Query", JOptionPane.PLAIN_MESSAGE, null, null, null);

		// If no String returned, news maker is "None" (a special value).
		if ((newsMakerName != null) && (newsMakerName.length() == 0)) {
			newsMakerName = "None";
		}
		return newsMakerName;
	}

	/**
	 * This method takes a news maker and turns its list of newspaper stories
	 * into a string formated for display to the user. At the end it includes
	 * line summarizing the number of stories found, the number of different
	 * newspapers in which these stories were published, the total number of
	 * words in these articles, and the number of different topics found.
	 * 
	 * @param newsMaker
	 *            The news maker for which to create the story list as a string
	 * @return The list of stories as one (potentially very large) string
	 */
	public static String createListOfNewspaperStoriesForNewsmaker(NewsMaker newsMaker) {
		/* The list of stories as a String */
		String listOfStories = "";

		/*
		 * Lists to keep track of the distinct newspaper names and topics found
		 * (for the summary line).
		 */
		// TODO Switch these from ArrayLists to a data structure that
		// automatically excludes duplicates
		ArrayList<String> distinctNewspaperNames = new ArrayList<String>();
		ArrayList<String> distinctTopics = new ArrayList<String>();

		/* The running total of the words in the stories. */
		int totalWords = 0;

		/*
		 * A local reference to the story list so that we don't have use the
		 * accessor method repeatedly (wasting time).
		 */
		NewspaperStoryList newspaperStoryList = newsMaker.getNewspaperStories();

		// Cycle through the stories one at a time
		// TODO Switch this to a for each loop
		for (int i = 0; i < newspaperStoryList.size(); i++) {
			NewspaperStory newspaperStory = newspaperStoryList.get(i);

			// Add any new newspaper name encountered to the list of names
			String newspaperName = newspaperStory.getNewspaperName();
			if (!distinctNewspaperNames.contains(newspaperName)) {
				distinctNewspaperNames.add(newspaperName);
			}

			// Add any new topic encountered to the list of topics
			String topic = newspaperStory.getTopic();
			if (!distinctTopics.contains(topic)) {
				distinctTopics.add(topic);
			}

			// Add to the running total of words
			totalWords += newspaperStory.getWordCount();

			// Convert the story to the display format and add it to the end of
			// the list
			listOfStories += convertToOutputFormat(newspaperStory) + "\n";
		}

		// Construct the summary line
		listOfStories += "Number of Stories: " + newspaperStoryList.size() + "; Number of Newspapers: "
				+ distinctNewspaperNames.size() + "; Number of Words: " + totalWords + "; Number of Topics: "
				+ distinctTopics.size();

		return listOfStories;
	}

	/**
	 * This method converts an individual story to the desired display format.
	 * 
	 * @param newspaperStory
	 *            The story to convert to the display format.
	 * @return The story in the display format.
	 */
	private static String convertToOutputFormat(NewspaperStory newspaperStory) {
		String storyString = "";
		LocalDate date = newspaperStory.getDate();
		storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
				+ date.getYear() + "; " + newspaperStory.getNewspaperName() + "; " + newspaperStory.getWordCount()
				+ " words; " + newspaperStory.getTopic();
		return storyString;
	}

	/**
	 * This method displays the list of newspaper stories to the user using a
	 * <code>JOptionPane</code>.
	 * <P>
	 * Note that a <code>JOptionPane</code> works fine for small messages but
	 * isn't suitable for large messages, such as those that can be generated
	 * for news makers for whom there are many stories. However, to keep this
	 * project relatively simple, we have gone with a <code>JOptionPane</code>
	 * here. We'll learn how to develop more suitable graphical user interfaces
	 * in later assignments.
	 * </P>
	 * 
	 * @param listOfStories
	 *            The list of stories to display, all as one (potentially very
	 *            large) String.
	 * @param newsMakerName
	 *            The name of the news maker (which is put into the title of the
	 *            JOptionPane).
	 */
	public static void presentNewspaperStories(String listOfStories, String newsMakerName) {
		JOptionPane.showMessageDialog(null, listOfStories, newsMakerName, JOptionPane.PLAIN_MESSAGE);
	}

	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker) {
		JOptionPane.showMessageDialog(null,
				"There are no newspaper stories about " + queriedNewsMaker.getName() + " in this database.",
				queriedNewsMaker.getName(), JOptionPane.PLAIN_MESSAGE);
	}
}
