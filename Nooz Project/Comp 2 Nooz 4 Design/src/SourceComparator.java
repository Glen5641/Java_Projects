import java.util.Comparator;

/**
 * This comparator compares the sources of 2 newsStories
 * 
 * @author cglen
 */
public class SourceComparator implements Comparator<NewsStory> {

	public static final SourceComparator SOURCE_COMPARATOR = new SourceComparator();

	/**
	 * Compare the 2 stories sources with this overriden method.
	 * 
	 * @return compare
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return 0;
	}
}
