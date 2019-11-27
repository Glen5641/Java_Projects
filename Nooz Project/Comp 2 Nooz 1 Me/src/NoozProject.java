import java.io.IOException;

/**
 * This project creates a database and allows the user to search 
 * through the database for newsmakers and their stories
 * 
 * @author cglen and Dean Hougen
 *
 */
public class NoozProject
{
	private static NewsMakerList newsMakers;
	
	public static void main(String[] args) throws IOException
	{
		newsMakers = NoozFileProcessor.readNoozFile(args[0]);
		UserInterface user = new UserInterface();
		NewsMaker maker = new  NewsMaker(); 
		String name = "";
		
		//Loop until name is null
		while(	name != null)
		{
			//Loop until name matches maker
			boolean found = false;
			while(!found)
			{
				name = user.queryNewsMakerName();
				maker = new NewsMaker(name); 
				
				try
				{
					if(name != null)
					{
						maker = newsMakers.get(maker);
						found = true;
					}
					else
						found = true;
				}
				
				catch(IndexOutOfBoundsException e)
				{
					user.reportNewsmakerNotFound(maker);
				}
			}
			
			if(maker.getName() != null)
				user.createListOfNewspaperStoriesForNewsmaker(maker);
		}	
	}
}