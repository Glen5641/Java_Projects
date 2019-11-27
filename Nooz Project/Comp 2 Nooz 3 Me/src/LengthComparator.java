import java.util.Comparator;

/**
 * This class is a comparator that compares the lengths of 2 news stories.
 * 
 * @author cglen and Dean Hougen
 */
public class LengthComparator implements Comparator<NewsStory> {

	public static final LengthComparator LENGTH_COMPARATOR = new LengthComparator();

	/**
	 * This overriden method compares the lengths of 2 newsStories
	 * 
	 * @return int Compared integer from the length of 2 newsStories
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return newsStory1.getLengthInWords() - newsStory2.getLengthInWords();
	}
}