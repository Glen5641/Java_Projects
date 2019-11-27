import java.time.LocalDate;

/**
 * Builds subclass tvstory of story object
 * 
 * @author cglen
 *
 */
public class TVNewsStory extends NewsStory
{
	
	/**
	 * Constructs a TVStory with multiple fields
	 * 
	 * @param date
	 * @param source
	 * @param length
	 * @param topic
	 * @param newsMaker1
	 * @param newsMaker2
	 */
	public TVNewsStory(LocalDate date, String source, int length, String topic, 
			NewsMaker newsMaker1, NewsMaker newsMaker2)
	{
		super(date, source, length, topic, newsMaker1, newsMaker2);
	}
	
	/**
	 * 
	 * Get seconds in words
	 * 
	 * @return int
	 */
	@Override
	public int getLengthInWords()
	{
		//Get TVStory's seconds
		return this.getLength() * 150 / 60;
	}
}
