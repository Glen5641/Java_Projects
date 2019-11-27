

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


/**
 * @author Dean Hougen and Clayton Glenn
 * @param <T>
 *
 */
public class BookList 
{

	private ArrayList<Book> bookList = new ArrayList<Book>();

	public void add(Book book) 
	{
		// Check whether book is already in list
		
		// If so, throw illegal argument exception
			for(int index = 0; index < bookList.size(); index++)
			{
				if(bookList.get(index).equals(book)) throw new IllegalArgumentException();
		  	}
			
		//If not, add it
			bookList.add(book);
	}

	public void printBooks() 
	{
		Iterator<Book> iterator = bookList.iterator();

		while (iterator.hasNext()) 
		{
			// Note: This line of code will automatically call the toString
			// method of the Book class.
			System.out.println(iterator.next());
		}
	}
	
	public void sortBooks() 
	{
		// Call Collections.sort which will use compareTo
		Collections.sort(bookList);
	}
	
	public Book findBook(Book book) 
	{
		// Call Collections.binarySearch
		int found = Collections.binarySearch(bookList, book);
		
		// If the book is found, return it
		if(found >= 0)
		{
			return bookList.get(found);
		}
		// If not, return null
		else
		{
			return null;
		}
	}
}