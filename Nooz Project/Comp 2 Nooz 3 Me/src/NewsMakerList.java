import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class creates a list of newsMakers for the mother class
 * 
 * @author cglen and Dean Hougen
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
	void add(NewsMaker newsMaker) {

		// If the newsMaker is new, add to list
		if (!this.newsMakers.contains(newsMaker)) {
			this.newsMakers.add(newsMaker);
		} else {
			throw new IllegalArgumentException("NewsMaker " + newsMaker.getName() + " already in list.");
		}

		// Show sorted as false
		sorted = false;
	}

	/**
	 * Check to see if the list contains a certain newsmaker
	 * 
	 * @param newsMaker
	 * @return boolean
	 */
	public boolean contains(NewsMaker newsMaker) {

		return this.newsMakers.contains(newsMaker);
	}

	/**
	 * This method accesses a newsmaker from the list
	 * 
	 * @param newsMaker
	 * @return NewsMaker
	 */
	public NewsMaker get(NewsMaker newsMaker) {

		// Get certain newsMaker
		int index = newsMakers.indexOf(newsMaker);
		if (index >= 0) {
			return this.newsMakers.get(index);
		} else {

			// If not found, return null
			return null;
		}
	}

	/**
	 * Get the exact newsMaker from the parameter name
	 * 
	 * @param newsMakerName
	 * @return NewsMaker
	 */
	public NewsMaker getExactMatch(String newsMakerName) {

		// If not sorted, sort the list
		if (!sorted) {
			this.sort();
		}

		// Binary search the newsMakerlist
		int index = Collections.binarySearch(newsMakers, new NewsMaker(newsMakerName));
		if (index >= 0) {
			return this.newsMakers.get(index);
		}

		// If no maker is found, return null
		return null;
	}

	/**
	 * Access the first instance of a newsMaker with a partial name
	 * 
	 * @param newsMakerName
	 * @return newsMaker
	 */
	public NewsMaker getPartialMatch(String newsMakerName) {

		if (!sorted) { // If not sorted, sort the list
			this.sort();
		}

		// Check through list for newsMaker match
		for (NewsMaker newsMaker : newsMakers) {
			if (newsMaker.getName().contains(newsMakerName)) {
				return newsMaker;
			}
		}

		// Return null if no news maker is found
		return null;
	}

	/**
	 * Sort the newsMaker List
	 */
	public void sort() {

		// Sort
		Collections.sort(newsMakers);
		sorted = true;
	}
}
