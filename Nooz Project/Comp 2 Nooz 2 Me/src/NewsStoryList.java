import java.util.ArrayList;

/**
 * Object with two arraylists of different objects
 * 
 * @author cglen 
 * @author Dean Hougen
 *
 */
public class NewsStoryList 
{
	ArrayList<NewsStory>newsStories;
	
	public NewsStoryList()
	{
		newsStories = new ArrayList<NewsStory>();
	}
	
	/**
	 * Add Story to List
	 * 
	 * @param newsStory
	 */
	public void add(NewsStory newsStory)
	{
		boolean same = false;
		for(int i = 0; i < newsStories.size(); i++){
			if(newsStories.get(i).equals(newsStory)){
				same = true;
			}
		}
		if(same == false){
			newsStories.add(newsStory);
		}
		else{
			return;
		}
	}
	
	
	/**
	 * Get Stories size
	 * @return int size
	 */
	public int size()
	{
		//Find NewsStories size
		return newsStories.size();
	}
	
	
	/**
	 * get a certain story from Stories List
	 * 
	 * @param index
	 * @return NewsStory
	 */
	public NewsStory get(int index)
	{
		//Get NewsStory
		return newsStories.get(index);
	}
}
