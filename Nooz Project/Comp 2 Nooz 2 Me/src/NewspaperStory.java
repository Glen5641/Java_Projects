import java.time.LocalDate;

/**
 * NewspaperStory object, used to build list of newsStories with polymorphism
 * 
 * @author cglen 
 * @author Dean Hougen
 *
 */

public class NewspaperStory extends NewsStory
{
	
	/**
	 * CONSTRUCTOR
	 * Construct newspaperStory
	 * 
	 * @param date
	 * @param source
	 * @param length
	 * @param topic
	 * @param newsMaker1
	 * @param newsMaker2
	 */
	public NewspaperStory(LocalDate date, String source, 
			int length, String topic, NewsMaker newsMaker1, 
			NewsMaker newsMaker2)
	{
		//Create newspaperStory Constructor
		super(date, source, length, topic, newsMaker1, newsMaker2);
	}
	
	/**
	 * get length of story in words
	 * 
	 * @return
	 */
	@Override
	public int getLengthInWords()
	{
		//Return wordCount
		return this.getLength();
	}
}
