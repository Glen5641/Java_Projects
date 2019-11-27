import java.util.Comparator;

/**
 * This class is a comparator that compares upon sources ascending
 * 
 * @author cglen 
 * @author Dean Hougen
 *
 */
public class SourceComparator implements Comparator<NewsStory>
{
	public SourceComparator SOURCE_COMPARATOR;
	
	/**
	 * Compare two stories
	 * 
	 * @param newsStory1
	 * @param newsStory2
	 * @return int
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2)
	{
		return newsStory1.getSource().toUpperCase().compareTo(newsStory2.getSource().toUpperCase());
	}
}

