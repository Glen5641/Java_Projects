import java.util.ArrayList;
import java.util.Collections;

/**
 * This class creates an object of many newsMakers
 * 
 * @author cglen 
 * @author Dean Hougen
 */
public class NewsMakerList 
{
	private ArrayList<NewsMaker> newsMakers;
	
	/**
	 * CONSTRUCTOR
	 */
	public NewsMakerList()
	{
		newsMakers = new ArrayList<NewsMaker>();
	}
	
	/**
	 * Add newsmaker to list
	 * 
	 * @param newsMaker
	 */
	public void add(NewsMaker newsMaker)
	{
		if (!newsMakers.contains(newsMaker)) {
			newsMakers.add(newsMaker);
		}
	}
	
	/**
	 * If list contains newmaker or not
	 * 
	 * @param newsMaker
	 * @return boolean
	 */
	public boolean contains(NewsMaker newsMaker)
	{
		for(int i = 0; i < newsMakers.size(); i++){
			NewsMaker comparison = newsMakers.get(i);
			
			if(newsMaker.equals(comparison)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * get newsmaker
	 * 
	 * @param newsMaker
	 * @return NewsMaker
	 */
	public NewsMaker get(NewsMaker newsMaker)
	{
		for(int index = 0; index < newsMakers.size(); index++){
			if (newsMakers.get(index).getName().equals(newsMaker.getName())){
				return newsMakers.get(index);
			}
		}
		return null;
	}
	
	/**
	 * Get exact match of newsmaker
	 * 
	 * @param exactName
	 * @return NewsMaker
	 */
	public NewsMaker getExactMatch(String exactName)
	{
		for(int i = 0; i < newsMakers.size(); i++){
			if(this.newsMakers.get(i).getName().equals(exactName)){
				return newsMakers.get(i);
			}
		}
		return null;
	}

	/**
	 * Get partial match of newsMaker
	 * 
	 * @param partialName
	 * @return NewsMaker
	 */
	public NewsMaker getPartialMatch(String partialName)
	{
		for(int i = 0; i < newsMakers.size(); i++){
			if(this.newsMakers.get(i).getName().contains(partialName)){
				return newsMakers.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Sort newsMakers for searching
	 */
	public void sort()
	{
		Collections.sort(newsMakers);
	}
}
