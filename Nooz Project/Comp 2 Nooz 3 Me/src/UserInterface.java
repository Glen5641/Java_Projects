import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFrame;

/**
 * This class queries many questions and creates newsStories for newsMakers or
 * it creates a graph for a certain newsMakers
 * 
 * @author cglen and Dean Hougen
 */
public class UserInterface {

	/**
	 * This generic method asks a message and if the user answers from an array,
	 * return the choice
	 * 
	 * @param message
	 * @param options
	 * @return Choice
	 * @throws IOException
	 */
	public static String querySingleChoice(String message, String[] options) throws IOException {
		boolean isTrue = false;

		// ready for user input
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String answer = "";
		int i = 0;

		// Loop until correct answer
		while (!isTrue) {

			// Print message to console
			System.out.print(message);

			// Read user input
			answer = input.readLine();

			// Check for correct input
			for (i = 0; i < options.length; i++) {
				if (answer.toLowerCase().equals(options[i])) {
					isTrue = true;
					break;
				}
			}
			if (!isTrue) { // If wrong, state that the input is wrong
				System.out.println("Invalid input, please try again.");
			}
		}

		// Return the chosen option
		return options[i];
	}

	/**
	 * This generic method asks a message and if the user answers from an array,
	 * return the choice, but this can also have many correct answers
	 * 
	 * @param message
	 * @param options
	 * @return choice
	 * @throws IOException
	 */
	public static String queryMultipleChoices(String message, String[] options) throws IOException {
		ArrayList<Boolean> isTrue = new ArrayList<Boolean>();
		isTrue.add(false);

		// Read input
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String line = "", answer = "";

		// While the array has a false boolean, loop the queries
		while (Arrays.asList(isTrue).toString().contains("false")) {

			// Print the message and read input from user
			System.out.print(message);
			answer = input.readLine();

			// Split the answer line
			String[] answers = answer.split("(?!^)");
			isTrue = new ArrayList<Boolean>();

			// Check for all true answers
			for (int index = 0; index < answers.length; index++) {
				isTrue.add(false);
			}
			for (int index = 0; index < answers.length; index++) {
				for (int i = 0; i < options.length; i++) {
					if (answers[index].equals(options[i])) {
						isTrue.remove(0);
						isTrue.add(true);
						line += options[index];
					}
				}
			}
			// If isTrue contains a false statement, error the user
			if (Arrays.asList(isTrue).toString().contains("false")) {
				System.out.println("Invalid input, please try again.");
			}
		}
		// Return the choices
		return line;
	}

	/**
	 * Ask for the newsMaker name with this method
	 * 
	 * @param matchType
	 * @return name
	 * @throws IOException
	 */
	public static String queryNewsMakerName(String matchType) throws IOException {

		// Open input
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		// Ask correct message
		if (matchType.equals("e")) {
			System.out.print("Newsmaker (exact)? ");
		} else {
			System.out.print("Newsmaker (partial)? ");
		}

		// Read user input
		String newsMakerName = input.readLine();

		// If name is blank, change it to None.
		if (newsMakerName.equals("")) {
			newsMakerName = "None";
		}

		// Return the name
		return newsMakerName;
	}

	/**
	 * Query sort Criteria from user
	 * 
	 * @param sortCriteria
	 * @return sortchoice
	 * @throws IOException
	 */
	public static String querySortCriterion(String[] sortCriteria) throws IOException {

		// Check for correct sort criteria
		if (sortCriteria.length != 4) {
			System.err.println("Internal Error.");
			System.exit(0);
		}

		// Check sort criteria for certain choices and send appropriate message
		// and get user input that is correct for the sort criteria
		if (!Arrays.asList(sortCriteria).contains(null) && !Arrays.asList(sortCriteria).contains("s")
				&& !Arrays.asList(sortCriteria).contains("t") && !Arrays.asList(sortCriteria).contains("l")
				&& !Arrays.asList(sortCriteria).contains("d")) {
			System.err.println("Internal Error.");
			for (int i = 0; i < sortCriteria.length; i++) {
				sortCriteria[i] = null;
			}
		}
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String criterionChoice = "";
		boolean match = false;
		while (match == false) {
			if (sortCriteria[0] == null) {
				// Ask for STLD criterion
				System.out.println("Primary sort criterion is source, topic, length, or date/time (s, t, l, or d)?");
				criterionChoice = input.readLine().toLowerCase();
				for (int i = 0; i < sortCriteria.length; i++) {
					if (criterionChoice.equals("s") || criterionChoice.equals("t") || criterionChoice.equals("l")
							|| criterionChoice.equals("d")) {
						return criterionChoice;
					}
				}
			} else if (sortCriteria[1] == null) {
				// If S, ask for TLD. If T, ask for SLD. If L, ask for STD. If
				// D, ask for STL
				if (Arrays.asList(sortCriteria).contains("s")) {
					System.out.println("Secondary sort criterion is topic, length, or date/time (t, l, or d)?");
					criterionChoice = input.readLine().toLowerCase();
					for (int i = 0; i < sortCriteria.length; i++) {
						if (criterionChoice.equals("t") || criterionChoice.equals("l") || criterionChoice.equals("d")) {
							return criterionChoice;
						}
					}
				} else if (Arrays.asList(sortCriteria).contains("t")) {
					System.out.println("Secondary sort criterion is source, length, or date/time (s, l, or d)?");
					criterionChoice = input.readLine().toLowerCase();
					for (int i = 0; i < sortCriteria.length; i++) {
						if (criterionChoice.equals("s") || criterionChoice.equals("l") || criterionChoice.equals("d")) {
							return criterionChoice;
						}
					}
				} else if (Arrays.asList(sortCriteria).contains("l")) {
					System.out.println("Secondary sort criterion is source, topic, or date/time (s, t, or d)?");
					criterionChoice = input.readLine().toLowerCase();
					for (int i = 0; i < sortCriteria.length; i++) {
						if (criterionChoice.equals("s") || criterionChoice.equals("t") || criterionChoice.equals("d")) {
							return criterionChoice;
						}
					}
				} else if (Arrays.asList(sortCriteria).contains("d")) {
					System.out.println("Secondary sort criterion is source, topic, or length (s, t, or l)?");
					criterionChoice = input.readLine().toLowerCase();
					for (int i = 0; i < sortCriteria.length; i++) {
						if (criterionChoice.equals("s") || criterionChoice.equals("t") || criterionChoice.equals("l")) {
							return criterionChoice;
						}
					}
				}
			} else if (sortCriteria[2] == null) {
				// If ST, ask for LD. If SL, ask for TD. If SD, ask for TL
				if (Arrays.asList(sortCriteria).contains("s")) {
					if (Arrays.asList(sortCriteria).contains("t")) {
						System.out.println("Tertiary sort criterion is length or date/time (l or d)?");
						criterionChoice = input.readLine().toLowerCase();
						for (int i = 0; i < sortCriteria.length; i++) {
							if (criterionChoice.equals("l") || criterionChoice.equals("d")) {
								return criterionChoice;
							}
						}
					} else if (Arrays.asList(sortCriteria).contains("l")) {
						System.out.println("Tertiary sort criterion is topic or date/time (t or d)?");
						criterionChoice = input.readLine().toLowerCase();
						for (int i = 0; i < sortCriteria.length; i++) {
							if (criterionChoice.equals("t") || criterionChoice.equals("d")) {
								return criterionChoice;
							}
						}
					} else {
						System.out.println("Tertiary sort criterion is topic or length (t or l)?");
						criterionChoice = input.readLine().toLowerCase();
						for (int i = 0; i < sortCriteria.length; i++) {
							if (criterionChoice.equals("t") || criterionChoice.equals("l")) {
								return criterionChoice;
							}
						}
					}
				} else if (Arrays.asList(sortCriteria).contains("t")) {
					// ST is already asked for. If TL, ask for SD. If TD, ask
					// for SL.
					if (Arrays.asList(sortCriteria).contains("l")) {
						System.out.println("Tertiary sort criterion is length or date/time (s or d)?");
						criterionChoice = input.readLine().toLowerCase();
						for (int i = 0; i < sortCriteria.length; i++) {
							if (criterionChoice.equals("s") || criterionChoice.equals("d")) {
								return criterionChoice;
							}
						}
					} else {
						System.out.println("Tertiary sort criterion is length or date/time (s or l)?");
						criterionChoice = input.readLine().toLowerCase();
						for (int i = 0; i < sortCriteria.length; i++) {
							if (criterionChoice.equals("s") || criterionChoice.equals("l")) {
								return criterionChoice;
							}
						}
					}
				} else {
					// All criterion have been covered, other than LD, ask for
					// ST
					System.out.println("Tertiary sort criterion is length or date/time (s or t)?");
					criterionChoice = input.readLine().toLowerCase();
					for (int i = 0; i < sortCriteria.length; i++) {
						if (criterionChoice.equals("s") || criterionChoice.equals("t")) {
							return criterionChoice;
						}
					}
				}
			} else if (sortCriteria[3] == null) {
				if (Arrays.asList(sortCriteria).contains("s") && Arrays.asList(sortCriteria).contains("t")
						&& Arrays.asList(sortCriteria).contains("l")) {
					return "d";
				} else if (Arrays.asList(sortCriteria).contains("s") && Arrays.asList(sortCriteria).contains("t")
						&& Arrays.asList(sortCriteria).contains("d")) {
					return "l";
				} else if (Arrays.asList(sortCriteria).contains("s") && Arrays.asList(sortCriteria).contains("l")
						&& Arrays.asList(sortCriteria).contains("d")) {
					return "t";
				} else {
					return "s";
				}
			}

			// Show invalid choice to user
			System.out.println("The choice you have entered is invalid.");
		}

		// Return null if the project makes it to this line
		return "";
	}

	/**
	 * Query fileName from user
	 * 
	 * @param message
	 * @param mustExist
	 * @return fileName
	 * @throws IOException
	 */
	public static String queryFileName(String message, boolean mustExist) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		// Print message for user
		System.out.println(message);

		// Read input
		String fileName = input.readLine();
		boolean loop = false;

		// Loop until correct filename is found
		while (loop == false) {
			if (mustExist) {

				// Check if filename exists
				try {
					FileReader fr = new FileReader(fileName);
					fr.close();
					return fileName;
				} catch (FileNotFoundException e) {
					System.out.println("Incorrect file name, please enter another.");
					fileName = input.readLine();
					if (fileName.equals(null)) { // If not, exit the program
						System.exit(0);
					}
				}
			} else {
				// Exit loop
				loop = true;
			}
		}

		// Return the fileName
		return fileName;
	}

	/**
	 * Create the list of news stories to display to user
	 * 
	 * @param newsMaker
	 * @param mediaType
	 * @param sortCriteria
	 * @return list of stories
	 */
	public static String createListOfNewsStoriesForNewsmaker(NewsMaker newsMaker, String mediaType,
			String[] sortCriteria) {

		String listOfStories = "";
		Set<String> distinctNewsSourceNames = new TreeSet<String>();
		Set<String> distinctTopics = new TreeSet<String>();
		Set<String> distinctSubjects = new TreeSet<String>();
		int totalLength = 0;

		// Get newsStories from a newsMaker and put them in an arraylist
		NewsStoryList newsStoryList = newsMaker.getNewsStories();
		List<NewsStory> newsStories = new ArrayList<NewsStory>(newsStoryList.size());

		// Split the media type in to an array
		String[] media = mediaType.split("(?!^)");

		// Add newsStories to a list if it corresponds with the media type
		if (Arrays.asList(media).contains("n")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof NewspaperStory) {
					newsStories.add(newsStory);
				}
			}
		}
		if (Arrays.asList(media).contains("t")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof TVNewsStory) {
					newsStories.add(newsStory);
				}
			}
		}
		if (Arrays.asList(media).contains("o")) {
			for (int i = 0; i < newsStoryList.size(); i++) {
				NewsStory newsStory = newsStoryList.get(i);
				if (newsStory instanceof OnlineNewsStory) {
					newsStories.add(newsStory);
				}
			}
		}

		// Sort the list the way the user wants the list sorted
		for (int i = 3; i >= 0; i--) {
			if (sortCriteria[i].equals("t")) {
				Collections.sort(newsStories);
			} else if (sortCriteria[i].equals("l")) {
				Collections.sort(newsStories, LengthComparator.LENGTH_COMPARATOR);
			} else if (sortCriteria[i].equals("d")) {
				Collections.sort(newsStories, DateComparator.DATE_COMPARATOR);
			} else {
				Collections.sort(newsStories, SourceComparator.SOURCE_COMPARATOR);
			}
		}

		// Add only distinct sources, topics, and subjects to sets
		for (NewsStory newsStory : newsStories) {
			distinctNewsSourceNames.add(newsStory.getSource());
			distinctTopics.add(newsStory.getTopic());
			distinctSubjects.add(newsStory.getSubject());

			// Get the correct length of the stories
			if (media.length == 1) {
				totalLength += newsStory.getLength();
			} else {
				totalLength += newsStory.getLengthInWords();
			}

			// Create list of stories with each story
			listOfStories += convertToOutputFormat(newsStory, mediaType) + "\n";
		}

		// Create the summary line according to its media type
		if ((mediaType.equals("n") || mediaType.equals("o"))
				|| (Arrays.asList(media).contains("n") && Arrays.asList(media).contains("o"))) {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Words: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		} else if (mediaType.equals("t")) {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Seconds: " + totalLength + "; Number of Topics: "
					+ distinctTopics.size() + "; Number of Subjects: " + distinctSubjects.size();
		} else {
			listOfStories += "Number of Stories: " + newsStories.size() + "; Number of Sources: "
					+ distinctNewsSourceNames.size() + "; Number of Word Equivalents: " + totalLength
					+ "; Number of Topics: " + distinctTopics.size() + "; Number of Subjects: "
					+ distinctSubjects.size();
		}

		// Return the list of stories in string format
		return listOfStories;
	}

	/**
	 * Convert the story into a readable line for output
	 * 
	 * @param newsStory
	 * @param mediaType
	 * @return string
	 */
	private static String convertToOutputFormat(NewsStory newsStory, String mediaType) {
		String storyString = "";
		LocalDate date = newsStory.getDate();
		String[] media = mediaType.split("(?!^)");

		// date; source; words; topic; subject
		if (mediaType.equals("n")) {
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength() + " words; "
					+ newsStory.getTopic() + "; " + newsStory.getSubject();
		}

		// date; source; seconds; topic; subject; part of day
		else if (mediaType.equals("t")) {
			TVNewsStory tvStory = (TVNewsStory) newsStory;
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + tvStory.getSource() + "; " + tvStory.getLength() + " seconds; "
					+ tvStory.getTopic() + "; " + tvStory.getSubject() + "; " + tvStory.getPartOfDay();
		}

		// date; source; words; topic; subject; part of day
		else if (mediaType.equals("o")) {
			OnlineNewsStory onlineStory = (OnlineNewsStory) newsStory;
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + onlineStory.getSource() + "; " + onlineStory.getLength() + " words; "
					+ onlineStory.getTopic() + "; " + onlineStory.getSubject() + "; " + onlineStory.getPartOfDay();
		}

		// date; source; word equivalents; topic; subject
		else if (((Arrays.asList(media).contains("n") && Arrays.asList(media).contains("t"))
				|| (Arrays.asList(media).contains("n") && Arrays.asList(media).contains("o"))) && media.length == 2) {
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLength()
					+ " word equivalents; " + newsStory.getTopic() + "; " + newsStory.getSubject();
		}

		// date; source; words; topic; subject; partofday
		else if (Arrays.asList(media).contains("t") && Arrays.asList(media).contains("o") && media.length == 2) {
			if (newsStory instanceof TVNewsStory) {
				TVNewsStory tvStory = (TVNewsStory) newsStory;
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth()
						+ ", " + date.getYear() + "; " + tvStory.getSource() + "; " + tvStory.getLength() + " words; "
						+ tvStory.getTopic() + "; " + tvStory.getSubject() + "; " + tvStory.getPartOfDay();
			} else {
				OnlineNewsStory onlineStory = (OnlineNewsStory) newsStory;
				storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth()
						+ ", " + date.getYear() + "; " + onlineStory.getSource() + "; " + onlineStory.getLength()
						+ " words; " + onlineStory.getTopic() + "; " + onlineStory.getSubject() + "; "
						+ onlineStory.getPartOfDay();
			}
		}

		// date; source; word equivalents; topic; subject
		else {
			storyString += date.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + " " + date.getDayOfMonth() + ", "
					+ date.getYear() + "; " + newsStory.getSource() + "; " + newsStory.getLengthInWords()
					+ " word equivalents; " + newsStory.getTopic() + "; " + newsStory.getSubject();
		}
		return storyString;
	}

	/**
	 * Present the stories to the user
	 * 
	 * @param listOfStories
	 * @param newsMakerName
	 */
	public static void presentNewspaperStories(String listOfStories, String newsMakerName) {
		System.out.println("News stories for " + newsMakerName);
		System.out.println(listOfStories);
	}

	/**
	 * If newsMaker not found, show error to user
	 * 
	 * @param queriedNewsMaker
	 */
	public static void reportNewsmakerNotFound(NewsMaker queriedNewsMaker) {
		System.out.println("There are no relevant stories about " + queriedNewsMaker.getName() + " in this database.");
	}

	/**
	 * Display pie chart for user to see information
	 * 
	 * @param newsMaker
	 * @param mediaType
	 * @param content
	 * @param measure
	 */
	public static void displayPieChartForNewsMaker(NewsMaker newsMaker, String mediaType, String content,
			String measure) {
		ArrayList<Wedge> wedges = new ArrayList<Wedge>();
		ArrayList<String> contentNames = new ArrayList<String>();
		NewsStoryList newsStories = newsMaker.getNewsStories();
		int index = 0;

		// If newsStory is correct instance, increment index
		for (int i = 0; i < newsMaker.getNewsStories().size(); ++i) {
			if (mediaType.contains("n")) {
				if (newsStories.get(i) instanceof NewspaperStory) {
					index += 1;
				}
			}
			if (mediaType.contains("t")) {
				if (newsStories.get(i) instanceof TVNewsStory) {
					index += 1;
				}
			}
			if (mediaType.contains("o")) {
				if (newsStories.get(i) instanceof OnlineNewsStory) {
					index += 1;
				}
			}
			if (!mediaType.contains("o") && !mediaType.contains("n") && !mediaType.contains("t")) {
				throw new IllegalArgumentException();
			}
		}

		// Use index to create a perfect array
		Integer[] contentNum = new Integer[index];
		index = 0;

		// Loop for all newsStories
		for (int i = 0; i < newsMaker.getNewsStories().size(); ++i) {

			// get singular subjects, topics, or sources from the corresponding
			// stories and increment the measures in a parrallel array.
			if (content.equals("b")) {
				if (mediaType.contains("n")) {
					if (newsStories.get(i) instanceof NewspaperStory) {
						if (contentNames.contains(newsStories.get(i).getSubject())) {
							index = contentNames.indexOf(newsStories.get(i).getSubject());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getSubject());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getSubject())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getSubject())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
				}
				if (mediaType.contains("t")) {
					if (newsStories.get(i) instanceof TVNewsStory) {
						if (contentNames.contains(newsStories.get(i).getSubject())) {
							index = contentNames.indexOf(newsStories.get(i).getSubject());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getSubject());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getSubject())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getSubject())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
				}
				if (mediaType.contains("o")) {
					if (newsStories.get(i) instanceof OnlineNewsStory) {
						if (contentNames.contains(newsStories.get(i).getSubject())) {
							index = contentNames.indexOf(newsStories.get(i).getSubject());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getSubject());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getSubject())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getSubject())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
				} else {
					throw new IllegalArgumentException();
				}
			} else if (content.equals("t")) {
				if (mediaType.contains("n")) {
					if (newsStories.get(i) instanceof NewspaperStory) {
						if (contentNames.contains(newsStories.get(i).getTopic())) {
							index = contentNames.indexOf(newsStories.get(i).getTopic());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getTopic());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getTopic())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getTopic())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
				}
				if (mediaType.contains("t")) {
					if (newsStories.get(i) instanceof TVNewsStory) {
						if (contentNames.contains(newsStories.get(i).getTopic())) {
							index = contentNames.indexOf(newsStories.get(i).getTopic());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getTopic());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getTopic())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getTopic())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
				}
				if (mediaType.contains("o")) {
					if (newsStories.get(i) instanceof OnlineNewsStory) {
						if (contentNames.contains(newsStories.get(i).getTopic())) {
							index = contentNames.indexOf(newsStories.get(i).getTopic());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getTopic());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getTopic())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getTopic())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
				} else {
					throw new IllegalArgumentException();
				}
			} else if (content.equals("s")) {
				if (mediaType.contains("n")) {
					if (newsStories.get(i) instanceof NewspaperStory) {
						if (contentNames.contains(newsStories.get(i).getSource())) {
							index = contentNames.indexOf(newsStories.get(i).getSource());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getSource());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getSource())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getSource())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
				}
				if (mediaType.contains("t")) {
					if (newsStories.get(i) instanceof TVNewsStory) {
						if (contentNames.contains(newsStories.get(i).getSource())) {
							index = contentNames.indexOf(newsStories.get(i).getSource());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getSource());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getSource())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getSource())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
				}
				if (mediaType.contains("o")) {
					if (newsStories.get(i) instanceof OnlineNewsStory) {
						if (contentNames.contains(newsStories.get(i).getSource())) {
							index = contentNames.indexOf(newsStories.get(i).getSource());
							if (measure.equals("l")) {
								contentNum[index] += 1;
							} else {
								contentNum[index] += newsStories.get(i).getLength();
							}
						} else {
							contentNames.add(newsStories.get(i).getSource());
							if (measure.equals("l")) {
								contentNum[contentNames.indexOf(newsStories.get(i).getSource())] = 1;
							} else {
								contentNum[contentNames.indexOf(newsStories.get(i).getSource())] = newsStories.get(i)
										.getLengthInWords();
							}
						}
					}
					// If arguments are illegal, throw exception
				} else {
					throw new IllegalArgumentException();
				}
			} else {
				throw new IllegalArgumentException();
			}
		}

		// Increment the total of the contents
		double total = 0.0;
		for (int i = 0; i < contentNames.size(); i++) {
			total += contentNum[i];
		}

		Wedge wedge = new Wedge(0, "");
		double percent = 0.0;

		// Create wedges for each singular content with its percentages
		for (int i = 0; i < contentNames.size(); i++) {
			percent = contentNum[i] / total;
			wedge = new Wedge(percent, contentNames.get(i));
			wedges.add(wedge);
		}

		// Change the format of the content string
		if (content.equals("s")) {
			content = "Sources";
		} else if (content.equals("t")) {
			content = "Topics";
		} else if (content.equals("b")) {
			content = "Subjects";
		} else {
			throw new IllegalArgumentException();
		}

		// Change format of measure string
		if (measure.equals("l")) {
			measure = "Length";
		} else if (measure.equals("c")) {
			measure = "Count";
		} else {
			throw new IllegalArgumentException();
		}

		// Create title of the pieChart
		String title = newsMaker.getName() + " - " + content + " by " + measure;

		// Create pie Chart
		PieChart pieChart = new PieChart(title, wedges);

		// Create JFrame, add piechart, and set JFrame visible
		JFrame frame = new JFrame();
		frame.setTitle(pieChart.title);
		frame.getContentPane().add(pieChart);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
