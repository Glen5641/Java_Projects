import java.util.Comparator;

/**
 * This comparator compares the subjects of 2 newsStories
 * 
 * @author cglen
 */
public class SubjectComparator implements Comparator<NewsStory> {

	public static final SubjectComparator SUBJECT_COMPARATOR = new SubjectComparator();

	/**
	 * Compare the 2 stories subjects with this overriden method.
	 * 
	 * @return compare
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return 0;
	}
}
