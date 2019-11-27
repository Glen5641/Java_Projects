import java.io.Serializable;

/**
 * This class creates a newsMaker object and stores newsStories in a list
 * 
 * @author cglen and Dean Hougen
 */
public class NewsMaker implements Comparable<NewsMaker>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private NewsStoryList newsStories = new NewsStoryList();

	/**
	 * CONSTRUCTOR
	 */
	public NewsMaker() {
		this.name = "None";
	}

	/**
	 * OVERLOADED CONSTRUCTOR
	 * 
	 * @param name
	 */
	public NewsMaker(String name) {
		this.name = name;
	}

	/**
	 * Get name from news maker
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the news stories to mother class
	 * 
	 * @return NewsStoryList
	 */
	public NewsStoryList getNewsStories() {

		return this.newsStories;
	}

	/**
	 * Add a new news story to the news maker
	 * 
	 * @param newsStory
	 */
	public void addNewsStory(NewsStory newsStory) {

		this.newsStories.add(newsStory);
	}

	/**
	 * This overridden method checks if 2 newsMakers are equal
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {

		if (o instanceof NewsMaker) {
			NewsMaker newsMaker = (NewsMaker) o;
			return this.name.equals(newsMaker.getName());
		}
		return false;
	}

	/**
	 * This overridden method compares the names of 2 newsMakers
	 * 
	 * @return boolean
	 */
	@Override
	public int compareTo(NewsMaker newsMaker) {

		return this.name.compareTo(newsMaker.getName());
	}
}
