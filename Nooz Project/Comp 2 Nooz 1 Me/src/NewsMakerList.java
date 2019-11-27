import java.util.ArrayList;

/**
 * Creates an list object to store all the newsmakers in the database
 * 
 * @author cglen and Dean Hougen
 */
public class NewsMakerList 
{
	//Arraylist for newsmakers
	private ArrayList <NewsMaker> newsMakers = new ArrayList<NewsMaker>();
	
	
	/**
	 * create default newsmaker list
	 */
	public NewsMakerList()
	{
		
	}
	
	
	/**
	 * Add newsmaker to list
	 * 
	 * @param newsMaker
	 */
	public void add(NewsMaker newsMaker)
	{
		if(!(newsMakers.contains(newsMaker)))
		this.newsMakers.add(newsMaker);
	}
	
	
	/**
	 * Check if list contains certain newsmaker
	 * 
	 * @param newsMaker
	 * @return boolean
	 */
	public boolean contains(NewsMaker newsMaker)
	{
		for(int i = 0; i < newsMakers.size(); i++)
		{
			NewsMaker comparison = newsMakers.get(i);
			
			if(newsMaker.equals(comparison))
				return true;
		}
		return false;
	}
	
	
	/**
	 * Get certain newsmaker
	 * 
	 * @param newsMaker
	 * @return NewsMaker
	 */
	public NewsMaker get(NewsMaker newsMaker)
	{	
		int i = 0;
		
		while(!newsMakers.get(i).equals(newsMaker))
		{
			i++;
		}
			
		return newsMakers.get(i);
	}
}
