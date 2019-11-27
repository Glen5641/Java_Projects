import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lab 3 CS 2334, Section 010 February 21, 2017
 * <P>
 * This class implements a program that tests the Book and BookList classes.
 * </P>
 * 
 * @author Dean Hougen and (your name)
 * @version 1.0
 */
public class Lab3Driver {
	private static BookList bookList = null;

	/**
	 * This is the main method for this test program. Since this is a simple
	 * test program, a lot of our code will be in the main method. Typically
	 * this would be a bad design, but we are just testing out some features of
	 * Java.
	 * <P>
	 * 
	 * @param args
	 *            Contains the command line arguments.
	 * @throws IOException
	 * 				If input or output has error, throw exception
	 * @throws ClassNotFoundException
	 * 				Thrown when an application tries to load in a class through its string name
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the name of the book file: ");
		String input = inputReader.readLine();

		// Read csv file putting books in the book list
		bookList = BookFileReader.readBookFile(input);
		
		// Get the first book from the list		
		Book book0 = bookList.get(0);
		
		// Write the first book in the list to a file
		Book.writeBook("BookFile", book0);
		
		// Set the Book object to null
		book0 = null;
		
		// Print the Book object to the console (show that the object is null)
		System.out.println("First book: " + book0);
		
		// Read the Book from a file
		book0 = Book.readBook("BookFile");
		
		// Print the Book to the console		
		System.out.println("First book: " + book0);
		
		// Write the BookList object to a file
		BookList.writeBookList("BookListFile", bookList);
		
		// Set the BookList object to null		
		BookList booklist = null;
		
		// Print the BookList object to the console (show that the object is empty)
		System.out.println("Book list:\n" + booklist);
		
		// Read in the BookList object from a file		
		booklist = BookList.readBookList("BookListFile");
		
		// Print the BookList object to the console
		System.out.println("Book list:\n" + booklist);
	}
}
