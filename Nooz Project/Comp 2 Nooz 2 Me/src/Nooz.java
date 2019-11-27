import java.io.IOException;

/**
 * This class is the driver class of Nooz
 * 
 * Creates database and promotes user interaction 
 * to find stories related to user's search
 * 
 * @author cglen 
 * @author Dean Hougen
 *
 */
public class Nooz
{
	private static NewsMakerList newsMakerList;
	
	/**
	 * Main method of program
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		
		/*
		 * Welcome user, recieve datafile and create database
		 */
		System.out.println("Welcome to NOOZ databases.");
		String message = "Enter the name of the news story data file: ";
		String fileName = UserInterface.queryFileName(message);
		newsMakerList = NoozFileProcessor.readNoozFile(fileName);
	
		NewsMaker newsMaker = null;
		boolean loop = true;
		
		/*
		 * Loop Interaction until user says no to Continue
		 */
		while(loop == true){
			/*
			 * Query User for all search information
			 */
			String mediaType = UserInterface.queryMediaType();
			String matchType = UserInterface.queryMatchType();
			String newsMakerQuery = UserInterface.queryNewsMakerName(matchType);
			while(newsMaker == null){
				if(matchType.equals("e")){
					newsMaker = newsMakerList.getExactMatch(newsMakerQuery);
				}
				else{
					newsMaker = newsMakerList.getPartialMatch(newsMakerQuery);
				}
				if(newsMaker == null){
					//Report news maker not found
					UserInterface.reportNewsmakerNotFound(newsMaker);
				}
			}
			String sort = UserInterface.querySortCriterion("");
			sort += UserInterface.querySortCriterion(sort) + " " + sort;
			sort += UserInterface.querySortCriterion(sort) + " " + sort;
		
			/*
			 * Split sortCriteria into an array
			 */
			String[] sortCriteria = sort.split(" ");
		
			/*
			 * Create list of appropriate sorted stories for newsMaker
			 */
			String listOfStories = UserInterface.createListOfNewsStoriesForNewsmaker(newsMaker, mediaType, sortCriteria);
		
			/*
			 * Present stories to user and prompt to save. 
			 * If save, then save to user specified file
			 */
			UserInterface.presentNewsStories(listOfStories, newsMaker.getName());
			if(UserInterface.queryBoolean("Save(Y/N)?")){		
				fileName = UserInterface.queryFileName("Enter the name of the file to save to:");
				listOfStories = newsMaker.getName() + "\n" + listOfStories;
				NoozFileProcessor.writeNewsStoriesFile(fileName, listOfStories);
			}
			
			/*
			 * Ask user to continue
			 */
			loop = UserInterface.queryBoolean("Continue(Y/N)?");
		}
		
		/*
		 * Thank user for using Nooz Databases
		 */
		System.out.println("Thanks for using Nooz!");
	}
}
