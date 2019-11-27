import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class creates a list of newsMakers for the mother class
 * 
 * @author cglen
 */
public class NewsMakerList implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<NewsMaker> newsMakers = new ArrayList<NewsMaker>();
	private boolean sorted;

	/**
	 * CONSTRUCTOR
	 */
	public NewsMakerList() {
	}

	/**
	 * Add newsMaker to the list
	 * 
	 * @param newsMaker
	 */
	public void add(NewsMaker newsMaker) {
	}

	/**
	 * Check to see if the list contains a certain newsmaker
	 * 
	 * @param newsMaker
	 * @return boolean
	 */
	public boolean contains(NewsMaker newsMaker) {

		return false;
	}

	/**
	 * This method accesses a newsmaker from the list
	 * 
	 * @param newsMaker
	 * @return NewsMaker
	 */
	public NewsMaker get(NewsMaker newsMaker) {
		return null;
	}

	/**
	 * Get the exact newsMaker from the parameter name
	 * 
	 * @param newsMakerName
	 * @return NewsMaker
	 */
	public NewsMaker getExactMatch(String newsMakerName) {
		return null;
	}

	/**
	 * Access the first instance of a newsMaker with a partial name
	 * 
	 * @param newsMakerName
	 * @return newsMaker
	 */
	public NewsMaker getPartialMatch(String newsMakerName) {
		return null;
	}

	/**
	 * Sort the newsMaker List
	 */
	public void sort() {
	}
}
