import java.util.Comparator;

/**
 * This class is a comparator that compares the dates of 2 news stories. if the
 * dates match, part of day is the next to be compared
 * 
 * @author cglen
 */
public class DateComparator implements Comparator<NewsStory> {

	public static final DateComparator DATE_COMPARATOR = new DateComparator();

	/**
	 * This overriden method compares the times of 2 newsStories
	 * 
	 * @return int Compared integer from the dates of 2 newsStories
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return 0;
	}
}
