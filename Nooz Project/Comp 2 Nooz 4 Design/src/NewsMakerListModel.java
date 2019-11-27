import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class creates a model of the newsMakerlist and changes the list with
 * appropriate actions when called upon by the controller
 * 
 * @author cglen
 *
 */
public class NewsMakerListModel {

	private ArrayList<ActionListener> actionListeners;
	private NewsMakerList newsMakers;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param newsMaker
	 * @param newsStories
	 */
	public NewsMakerListModel(NewsMaker newsMaker, NewsStoryList newsStories) {

	}

	/**
	 * Add newsMaker to list
	 * 
	 * @param newsMaker
	 * @return
	 */
	public boolean addNewsMaker(NewsMaker newsMaker) {
		return false;
	}

	/**
	 * Edit newsMaker in list
	 * 
	 * @param newsMaker
	 * @return
	 */
	public boolean editNewsMaker(NewsMaker newsMaker) {
		return false;
	}

	/**
	 * Delete newsMaker from list
	 * 
	 * @param newsMaker
	 */
	public void deleteNewsMaker(NewsMaker newsMaker) {
	}

	/**
	 * Delete the whole newsMaker list
	 */
	public void deleteNewsMakerList() {
	}

	/**
	 * Add story to newsMaker
	 * 
	 * @param newsMaker
	 * @return
	 */
	public boolean addNewsStory(NewsMaker newsMaker) {
		return false;
	}

	/**
	 * Edit a newsMaker's stories
	 * 
	 * @param newsMaker
	 * @return
	 */
	public boolean editNewsStory(NewsMaker newsMaker) {
		return false;
	}

	/**
	 * Delete newsStory from newsMaker
	 * 
	 * @param newsMaker
	 */
	public void deleteNewsStory(NewsMaker newsMaker) {
	}

	/**
	 * Delete newsStoryList of NewsMaker
	 */
	public void deleteNewsStoryList() {
	}

	/**
	 * Sort the stories by users parameters
	 * 
	 * @param sortComparator
	 */
	public void sortNewsStoryList(Comparator<NewsStory> sortComparator) {
	}

	/**
	 * Load the newsMaker list from a file
	 * 
	 * @param fileName
	 */
	public void loadNewsMakerList(String fileName) {
	}

	/**
	 * Load list from Object I/O
	 * 
	 * @param fileName
	 */
	public void importNewsMakerList(String fileName) {
	}

	/**
	 * Add an action listener to the arraylist
	 * 
	 * @param i
	 */
	public void addActionListener(ActionListener i) {
	}

	/**
	 * Remove an action listener from the arraylist
	 * 
	 * @param i
	 */
	public void removeActionListener(ActionListener i) {
	}

	/**
	 * Process an event that happens between user and GUI
	 * 
	 * @param e
	 */
	private void processEvent(ActionEvent e) {
	}
}
