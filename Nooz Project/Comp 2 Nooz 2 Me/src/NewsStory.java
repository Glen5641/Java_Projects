import java.time.LocalDate;
/**
 * This class creates a Story object with many fields
 * 
 * @author cglen 
 * @author Dean Hougen
 */
public abstract class NewsStory implements Comparable<NewsStory>
{
	//Declare local variables
	private LocalDate date;
	private String source;
	private int length;
	private String topic;
	private NewsMaker newsMaker1;
	private NewsMaker newsMaker2;
	
	/**
	 * Constructs a NewsStory with multiple fields
	 * 
	 * @param date
	 * @param source
	 * @param length
	 * @param topic
	 * @param newsMaker1
	 * @param newsMaker2
	 */
	protected NewsStory(LocalDate date, String source, int length, String topic, 
			NewsMaker newsMaker1, NewsMaker newsMaker2)
	{
		//Build constructor
		
		this.date = date;
		this.source = source;
		this.length = length;
		this.topic = topic;
		this.newsMaker1 = newsMaker1;
		this.newsMaker2 = newsMaker2;
	}
	
	/**
	 * Get date of story
	 * 
	 * @return LocalDate
	 */
	public LocalDate getDate()
	{
		//Return LocalDate
		return date;
	}
	
	/**
	 * get name of news
	 * 
	 * @return String source
	 */
	public String getSource()
	{
		//Return NewsName
		return source;
	}
	
	/**
	 * Get Length
	 * 
	 * @return int length
	 */
	public int getLength()
	{
		//Return Length
		return length;
	}
	
	/**
	 * Get Length of the story in words
	 * 
	 * @return int LengthInWords
	 */
	abstract int getLengthInWords();
	
	/**
	 * Get topic
	 * 
	 * @return String topic
	 */
	public String getTopic()
	{
		//Return Topic
		return topic;
	}
	
	/**
	 * Get newsMaker1
	 * 
	 * @return NewsMaker newsMaker1
	 */
	public NewsMaker getNewsMaker1()
	{
		//Return NewsMaker1
		return newsMaker1;
	}
	
	/**
	 * Get NewsMaker 2
	 * 
	 * @return NewsMaker newsMaker2
	 */
	public NewsMaker getNewsMaker2()
	{
		//Return NewsMaker2
		return newsMaker2;
	}
	
	/**
	 * Check for equal objects
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		NewsStory compare = null;
		if(this instanceof NewspaperStory 	&& o instanceof NewspaperStory ||
			this instanceof TVNewsStory 		&& o instanceof TVNewsStory ){
			compare = (NewsStory) o;
		}
		else{
			return false;
		}
		
		//Check match
		if((compare.getDate() == null && this.date == null) || this.date.equals(compare.getDate())){
			if((compare.getSource() == null && this.source == null) || this.source.equals(compare.getSource())){
				if(this.length == (compare.getLength())){
					if((compare.getTopic() == null && this.topic == null) || this.topic.equals(compare.getTopic())){
						if((compare.getNewsMaker1() == null && this.newsMaker1 == null) || this.newsMaker1.equals(compare.getNewsMaker1())){
							if((compare.getNewsMaker2() == null && this.newsMaker2 == null) || this.newsMaker2.equals(compare.getNewsMaker2())){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Compare imported newsStory to current newsStory
	 * 
	 * @param newsStory
	 * @return int
	 */
	@Override
	public int compareTo(NewsStory newsStory)
	{
		return this.topic.compareTo(newsStory.getTopic());
	}
}
