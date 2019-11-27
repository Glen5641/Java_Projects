import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class deals with all user interaction
 * 
 * @author cglen and Dean Hougen
 *
 */
public class UserInterface 
{
	/**
	 * Find the name user wants to search for
	 * 
	 * @return String
	 */
	public String queryNewsMakerName()
	{
		String name = JOptionPane.showInputDialog("Enter Name:");
		
		return name;
	}
	
	
	/**
	 * call newsmakers story list object
	 * 
	 * @param newsMaker
	 */
	public void createListOfNewspaperStoriesForNewsmaker(NewsMaker newsMaker)
	{
		ArrayList<String> papers = new ArrayList<String>();
		ArrayList<String> topics = new ArrayList<String>();
		int numWords = 0;
		
		NewspaperStoryList stories = newsMaker.getNewspaperStories();
		String lines  = "";
		for(int i = 0; i < stories.size(); i++)
		{
			lines += convertToOutputFormat(stories.get(i)) + "\n";
		}
		
		for(int i = 0; i < stories.size(); i++)
		{
			//Find total papers
			if(!papers.contains(stories.get(i).getNewspaperName()))
				papers.add(stories.get(i).getNewspaperName());
			
			//Find word Count
			numWords += stories.get(i).getWordCount();
			
			//find total topics
			if(!papers.contains(stories.get(i).getTopic()))
				topics.add(stories.get(i).getTopic());
		}
		
		lines += "Number of Stories: " + stories.size() + "; "  + "Number of Newspapers: " + papers.size() + 
				"; " + "Number of words: " + numWords + "; " + "Number of topics: " + topics.size();
		
		
		 presentNewspaperStories(lines, newsMaker.getName());
		
		 System.out.println();
	}
	
	
	/**
	 * Convert newspaperStory to string
	 * 
	 * @param newspaperStory
	 * @return String
	 */
	private String convertToOutputFormat(NewspaperStory newspaperStory){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		
		return newspaperStory.getDate().format(formatter) + "; " + newspaperStory.getNewspaperName() + 
				"; " + newspaperStory.getWordCount() + " words; " + newspaperStory.getTopic();
	}
	
	
	/**
	 * output to user stories and makername
	 * 
	 * @param listOfStories
	 * @param newsMakerName
	 */
	public void presentNewspaperStories(String listOfStories, String newsMakerName){
		System.out.println(newsMakerName + "\n" + listOfStories);
	}
	
	
	/**
	 * Report error for user not found
	 * 
	 * @param queriedNewsMaker
	 */
	public void reportNewsmakerNotFound(NewsMaker queriedNewsMaker){
		 JFrame error = new JFrame();
		 JOptionPane.showMessageDialog(error, queriedNewsMaker.getName() + " is not found, please try again.");
	}
}
