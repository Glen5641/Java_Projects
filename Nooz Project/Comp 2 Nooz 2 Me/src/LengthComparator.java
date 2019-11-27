import java.util.Comparator;

/**
 * This class is a comparator that compares upon length of stories
 * 
 * @author cglen 
 * @author Dean Hougen
 *
 */
public class LengthComparator implements Comparator<NewsStory>
{
	public LengthComparator LENGTH_COMPARATOR;
	
	/**
	 * Compare two stories
	 * 
	 * @param newsStory1
	 * @param newsStory2
	 * @return
	 */
	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2)
	{
		if(newsStory1.getLengthInWords() < newsStory2.getLengthInWords()){
			return -1;
		}
		else if(newsStory1.getLengthInWords() > newsStory2.getLengthInWords()){
			return 1;
		}
		else{
			return 0;
		}
	}
}
