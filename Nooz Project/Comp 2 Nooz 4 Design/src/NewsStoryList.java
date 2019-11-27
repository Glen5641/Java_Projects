import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a list of NewsStories for later use
 * 
 * @author cglen
 */
public class NewsStoryList implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<NewsStory> newsStories = new ArrayList<NewsStory>();

	/**
	 * Add newsStory to the list
	 * 
	 * @param newsStory
	 */
	public void add(NewsStory newsStory) {
	}

	/**
	 * Return size of the list
	 * 
	 * @return size
	 */
	public int size() {
		return 0;
	}

	/**
	 * Get indexed newsStory from the list
	 * 
	 * @param index
	 * @return NewsStory
	 */
	public NewsStory get(int index) {
		return null;
	}
}
