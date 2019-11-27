import java.util.ArrayList;

/**
 * Class to Create story list object
 * 
 * @author cglen and Dean Hougen
	 *
 */
public class NewspaperStoryList 
{
	//Arraylist for stories
	private ArrayList <NewspaperStory> newspaperStories = new ArrayList<NewspaperStory>();
	
		
	/**
	 * add story to the story list
	 * 
	 * @param newspaperStory
	 */
	public void add(NewspaperStory newspaperStory)
	{
		newspaperStories.add(newspaperStory);
	}
	
		
	/**
	 * Find size of the stories list
	 * 
	 * @return int
	 */
	public int size()
	{
		return newspaperStories.size();
	}
	
	
	/**
	 * Get certain story from the list object
	 * 
	 * @param index
	 * @return NewsPaperStory
	 */
	public NewspaperStory get(int index)
	{
		return newspaperStories.get(index);
	}
}

