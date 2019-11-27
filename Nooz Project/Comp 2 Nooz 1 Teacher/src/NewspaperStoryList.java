import java.util.ArrayList;

/**
 * Project #1 CS 2334, Section 010 February 22, 2017
 * <P>
 * A <code>NewspaperStoryList</code> is a list of <code>NewspaperStory</code>
 * objects.
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 *
 */
class NewspaperStoryList {
	/** The list of newspaper stories. */
	private ArrayList<NewspaperStory> newspaperStories = new ArrayList<NewspaperStory>();

	/**
	 * The mutator for adding a newspaper story to the list.
	 * <P>
	 * By using our own class with its own <code>add</code> method, rather than
	 * directly using the <code>add</code> method of <code>ArrayList</code>, we
	 * could ensure that we don't add duplicate <code>NewspaperStory</code>
	 * objects to our list. However, to keep the project relatively simple, this
	 * requirement was not made in the project description and this check
	 * doesn't need to be made yet.
	 * </P>
	 * 
	 * @param newspaperStory
	 *            The newspaper story to add.
	 */
	public void add(NewspaperStory newspaperStory) {
		// TODO Refine this to prevent duplicates (Eventually)
		this.newspaperStories.add(newspaperStory);
	}

	/**
	 * The accessor for determining the number of stories in the list.
	 * <P>
	 * Note that this accessor name violates the convention that accessor names
	 * should start with "get" (or "is" for booleans). However, "size" is an
	 * accepted convention for names serving this particular purpose, so we are
	 * following the second convention rather than the first.
	 * </P>
	 * 
	 * @return The number of stories in the list.
	 */
	public int size() {
		return this.newspaperStories.size();
	}

	/**
	 * An accessor for getting a story from the list based on its position
	 * (index) in the list.
	 * 
	 * @param index
	 *            The location from which to get the story.
	 * @return The newspaper story at the index, if the index is valid.
	 * @throws IllegalArgumentException
	 *             if the index is not valid.
	 */
	public NewspaperStory get(int index) {
		if (index >= 0 && index < this.newspaperStories.size()) {
			return this.newspaperStories.get(index);
		} else {
			throw new IllegalArgumentException("Index out of bounds: " + index);
		}
	}
}
