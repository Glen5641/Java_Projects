import java.io.Serializable;

/**
 * This class creates a newsMaker object and stores newsStories in a list
 * 
 * @author cglen
 */
public class NewsMaker implements Comparable<NewsMaker>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private NewsStoryList newsStories = new NewsStoryList();

	/**
	 * CONSTRUCTOR
	 */
	public NewsMaker() {
	}

	/**
	 * OVERLOADED CONSTRUCTOR
	 * 
	 * @param name
	 */
	public NewsMaker(String name) {
	}

	/**
	 * Get name from news maker
	 * 
	 * @return name
	 */
	public String getName() {
		return null;
	}

	/**
	 * Return the news stories to mother class
	 * 
	 * @return NewsStoryList
	 */
	public NewsStoryList getNewsStories() {
		return null;

	}

	/**
	 * Add a new news story to the news maker
	 * 
	 * @param newsStory
	 */
	public void addNewsStory(NewsStory newsStory) {
		return;
	}

	/**
	 * This overridden method checks if 2 newsMakers are equal
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}

	/**
	 * This overridden method compares the names of 2 newsMakers
	 * 
	 * @return boolean
	 */
	@Override
	public int compareTo(NewsMaker newsMaker) {
		return 0;
	}
}
