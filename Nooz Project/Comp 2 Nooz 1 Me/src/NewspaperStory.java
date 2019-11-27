import java.time.LocalDate;

/**
 * This class constructs an object called newspaperStory. 
 * This story will be used elsewhere.
 * 
 * @author cglen and Dean Hougen
 *
 */
public class NewspaperStory 
{
	/**
	 * Initiallize all variables for the Newspaperstory object
	 */
	private LocalDate date;
	private String newspaperName;
	private int wordCount;
	private String topic;
	private NewsMaker newsMaker1;
	private NewsMaker newsMaker2;
	
	/**
	 * CONSTRUCTOR 
	 * Build the object using a constructor
	 * 
	 * @param date
	 * @param newspaperName
	 * @param wordCount
	 * @param topic
	 * @param newsMaker1
	 * @param newsMaker2
	 * 
	 */
	public NewspaperStory(LocalDate date, String newspaperName, int wordCount, String topic, NewsMaker newsMaker1, NewsMaker newsMaker2)
	{
		this.date = date;
		this.newspaperName = newspaperName;
		this.wordCount = wordCount;
		this.topic = topic;
		this.newsMaker1 = newsMaker1;
		this.newsMaker2 = newsMaker2;
	}
	
	/**
	 * ACCESSOR
	 * Local date is sent back to driver class from this return
	 * 
	 * @return LocalDate
	 */
	public LocalDate getDate()
	{
		return date;
	}
	
	/**
	 * ACCESSOR
	 * newspaperName is sent back to driver class from this return
	 * 
	 * @return String
	 */
	public String getNewspaperName()
	{
		return newspaperName;
	}
	
	/**
	 * ACCESSOR
	 * wordCount is sent back to driver class using this return.
	 * 
	 * @return int
	 */
	public int getWordCount()
	{
		return wordCount;
	}
	
	/**
	 * ACCESSOR
	 * Topic is sent back to the driver class using this return.
	 * 
	 * @return
	 */
	public String getTopic()
	{
		return topic;
	}
	
	/**
	 * ACCESSOR
	 * newsMaker1 is sent back to driver class using this return.
	 * 
	 * @return NewsMaker
	 */
	public NewsMaker getNewsMaker1()
	{
		return newsMaker1;
	}
	
	/**
	 * ACCESSOR 
	 * newsMaker2 is sent back to driver class using this return.
	 * 
	 * @return NewsMaker
	 */
	public NewsMaker getNewsMaker2()
	{
		return newsMaker2;
	}
}

