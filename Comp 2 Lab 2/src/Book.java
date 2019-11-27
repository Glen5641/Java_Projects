

import java.util.ArrayList;


/**
 * Lab 2 CS 2334, Section 010 7 February 2017
 * <P>
 * This class provides a very simple model for a book. A Book has a title, an
 * author, a publication year, and one or more genres.
 * </P>
 * 
 * @author Dean Hougen and Clayton Glenn
 * @version 1.0
 */
public class Book  implements Comparable <Book>{

	/** The title of the book. */
	private String title;

	/** The name of the book's author. */
	private String authorName;

	/** The year the book was published. */
	private int year;

	/** The genre(s) of the book. */
	private ArrayList<String> genres;

	/**
	 * This is the default constructor for the class.
	 */
	public Book()
	{
		this.title = "";
		this.authorName = "";
		this.year = -1;
		this.genres = null;
	}

	/**
	 * This is a constructor for the class. It instantiates the class with
	 * user-supplied values. This version of the constructor is used when only
	 * one genre is provided.
	 * <P>
	 * 
	 * @param title
	 *            The title of the book
	 * @param authorName
	 *            The name of the book's author
	 * @param year
	 *            The year that the book was published
	 * @param genre
	 *            The genre of the book
	 */
	public Book(String title, String lastName, int year, String genre) 
	{
		this.title = title;
		this.authorName = lastName;
		this.year = year;
		this.genres = new ArrayList<String>();
		genres.add(genre);
	}

	/**
	 * This is a constructor for the class. It instantiates the class with
	 * user-supplied values. This version of the constructor is used when
	 * multiple genres are provided.
	 * <P>
	 * 
	 * @param title
	 *            The title of the book
	 * @param authorName
	 *            The name of the book's author
	 * @param year
	 *            The year that the book was published
	 * @param genres
	 *            The genres of the book
	 */
	
	public Book(String title, String authorName, int year, ArrayList<String> genres) 
	{
		this.title = title;
		this.authorName = authorName;
		this.year = year;
		this.genres = genres;
	}

	/**
	 * This method returns the attributes of this class as a single string.
	 * </P>
	 * 
	 * @return String representing the contents of this object
	 */
	public String toString() 
	{
		// Format should be title, author, year, genres (separated by commas, if multiple)
		String stringForm = title + ", " + authorName + ", " +year + ", " + genres.get(0);
		for(int i = 1; i < genres.size(); i++)
			stringForm += ", " + genres.get(i);
		return stringForm;
	}

	/**
	 * This method checks to see whether two instances of Book are equal by
	 * comparing their fields other than genres.
	 * 
	 * @return boolean as to whether this book is equal to another object
	 */
	@Override
	public boolean equals(Object o) 
	{
		if (o instanceof Book) {
			Book book = (Book) o;
			boolean equivalent = this.title.equals(book.title);
			if (equivalent) 
			{
				equivalent = this.authorName.equals(book.authorName);
			}
			if (equivalent) 
			{
				equivalent = this.year == book.year;
			}
			return equivalent;
		}

		else 
		{
			return false;
		}
	}
	/**
	 * This method compares an instance of this Book, with another instance of
	 * Book. It should not consider genres.
	 * <P>
	 * Algorithm:<br>
	 * ????
	 * </P>
	 * 
	 * @param obj
	 *            The object to which we are comparing this instance of Book
	 * @return int 
	 * 				used for sorting algorithm for natural ascending order
	 */

	public int compareTo(Book book) 
	{
		/**
		 * If this comparison has all equal fields, int i should equal 0, 
		 * but if the comparison does not equal, another number is assigned to i
		 */
		    
		 	int i = 0;
		    if (this.title.compareTo(book.title) == 0)
		    {
		    	if(this.authorName.compareTo(book.authorName) == 0)
		    	{
		    		if(this.year == book.year)
		    		{
		    			return 0;
		    		}
		    		else if (this.year > book.year)
		    			i++;
		    		else
		    			i--;
		    	}
		    	else if (this.authorName.compareTo(book.authorName) > 0)
	    			i++;
	    		else
	    			i--;
		    }  
		    else if (this.title.compareTo(book.title) > 0)
    			i++;
    		else
    			i--;
		    return i;
	}
}