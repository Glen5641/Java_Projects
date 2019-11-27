import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Lab 3 CS 2334, Section 010 February 21, 2017
 * <P>
 * This class models a list of books.
 * </P>
 * 
 * @author Dean Hougen and (your name)
 * @version 1.0
 */

public class BookList implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Book> bookList = new ArrayList<Book>();

	public void add(Book book) {
		// Check whether book is already in list
		// If so, throw illegal argument exception
		if (bookList.contains(book)) {
			throw new IllegalArgumentException("Cannot add the same book twice");
		}
		// If not, add it
		else {
			bookList.add(book);
		}
	}

	/**
	 * Get a certain book from the booklist
	 * 
	 * @param index
	 * 				Given index for searching
	 * @return Book
	 * 				Object that has been found in booklist
	 */
	public Book get(int index) {
		if (index >= 0 && index < bookList.size()) {
			return bookList.get(index);
		} else {
			throw new IllegalArgumentException("Index out of bounds");
		}
	}

	/**
	 * This method returns the attributes of this class as a single string with
	 * one resident per line.
	 * 
	 * @return String representing the contents of this object.
	 */
	public String toString() {
		String attributesAsString = "";
		for (Book book : bookList) {
			attributesAsString += book + "\n";
		}
		return (attributesAsString);
	}

	/**
	 * Write the whole booklist to a file
	 * 
	 * @param filename
	 * 				File used by programmer to write booklist. Hard coded
	 * @param bookList
	 * 				List of books
	 * @throws IOException
	 * 				if input or output has errors, throw exception
	 */
	public static void writeBookList(String filename, BookList bookList) throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream((filename));
		ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
		
		output.writeObject(bookList);
		
		output.close();
	}

	/**
	 * Read the booklist from the file and return to driver
	 * 
	 * @param filename
	 * 				name of file that user indicates for method to read
	 * @return Booklist
	 * 				list of book objects
	 * @throws ClassNotFoundException
	 * 				Thrown when an application tries to load in a class through its string name
	 * @throws IOException
	 * 				if input or output has error, throw exception
	 */
	public static BookList readBookList(String filename) throws ClassNotFoundException, IOException
	{
		FileInputStream fileInputStream = new FileInputStream(filename);
		ObjectInputStream input = new ObjectInputStream(fileInputStream);
		BookList bookList = (BookList) input.readObject();
		input.close();
		return bookList;
	}
}
