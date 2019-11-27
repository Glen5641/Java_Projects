/**
 * Newsmaker compiles a list of stories for a specified author.
 * 
 * @author cglen and Dean Hougen
 */
public class NewsMaker 
{
	
	//Local private variables for storing stories and name.
	private String name;
	private NewspaperStoryList newspaperStories = new NewspaperStoryList();
	
	
	/**
	 * CONSTRUCTOR 
	 * for a no named author
	 */
	public NewsMaker()
	{
		this.name = "";
	}
	
	
	/**
	 * CONSTRUCTOR
	 * Used for authors with specified names
	 * 
	 * @param name
	 */
	public NewsMaker(String name)
	{
		this.name = name;
	}
	
	
	/**
	 * Method to check match a name of another newsmaker object
	 * 
	 * @param Object
	 *  @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		NewsMaker compare = (NewsMaker) o;
		
		//Check match
		if(this.name.equals(compare.getName()))
			return true;
		else
			return false;
	}
	
	
	/**
	 * Return name to calling method
	 * 
	 * @return String
	 */
	public String getName()
	{
		return name;
	}
	
	
	/**
	 * Return list of stories
	 * 
	 * @return NewsPaperStoryList
	 */
	public NewspaperStoryList getNewspaperStories()
	{
		return newspaperStories;
	}
	
	
	/**
	 * Add a story to the list of Stories
	 * 
	 * @param newspaperStory
	 */
	public void addNewspaperStory(NewspaperStory newspaperStory)
	{
		this.newspaperStories.add(newspaperStory);
	}
}