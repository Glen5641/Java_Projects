/**
 * This class build a newsMaker object to assign newsStories to
 * 
 * @author cglen 
 * @author Dean Hougen
 *
 */
public class NewsMaker implements Comparable<NewsMaker>
{
	private String name;
	private NewsStoryList newsStories = new NewsStoryList();;
	
	/**
	 * CONSTRUCTOR
	 */
	public NewsMaker()
	{
		//CONSTRUCTOR
		name = "";
	}
	
	/**
	 * CONSTRUCTOR
	 * 
	 * @param name
	 */
	public NewsMaker(String name)
	{
		//CONSTRUCTOR
		this.name = name;
	}
	
	/**
	 * Get name
	 * 
	 * @return String name
	 */
	public String getName()
	{
		//Get name
		return this.name;
	}
	
	/**
	 * Get all stories
	 * 
	 * @return NewsStoryList newsStories
	 */
	public NewsStoryList getNewsStories()
	{
		//Get all stories
		return this.newsStories;
	}
	
	/**
	 * Add newsStory
	 * 
	 * @param newsStory
	 */
	public void addNewsStory(NewsStory newsStory)
	{
		//Add newsStory
		this.newsStories.add(newsStory);
	}
	
	/**
	 * If object equals another
	 * 
	 * @param o
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof NewsMaker) {
			NewsMaker newsMaker = (NewsMaker) o;
			return this.name.equals(newsMaker.getName());
		}
		return false;
	}
	
	/**
	 * Compares local newsmaker to an import
	 * 
	 * @param newsMaker
	 * @return int
	 */
	@Override
	public int compareTo(NewsMaker newsMaker)
	{
		return this.name.toUpperCase().compareTo(newsMaker.getName().toUpperCase());
	}
}
