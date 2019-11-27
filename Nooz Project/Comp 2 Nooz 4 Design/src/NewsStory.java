import java.io.Serializable;
import java.time.LocalDate;

/**
 * Abstract Class for 3 subclasses that creates a newsStory object for later use
 * 
 * @author cglen
 */
public abstract class NewsStory implements Comparable<NewsStory>, Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDate date;
	private String source;
	private int length;
	private String topic;
	private String subject;
	private NewsMaker newsMaker1;
	private NewsMaker newsMaker2;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param date
	 * @param source
	 * @param length
	 * @param topic
	 * @param subject
	 * @param newsMaker1
	 * @param newsMaker2
	 */
	protected NewsStory(LocalDate date, String source, int length, String topic, String subject, NewsMaker newsMaker1,
			NewsMaker newsMaker2) {
	}

	/**
	 * Get date from newsStory
	 * 
	 * @return Date
	 */
	public LocalDate getDate() {

		return null;
	}

	/**
	 * Get source from newsStory
	 * 
	 * @return Source
	 */
	public String getSource() {

		return "";
	}

	/**
	 * Get length from newsStory
	 * 
	 * @return Length
	 */
	public int getLength() {

		return 0;
	}

	/**
	 * Get length in words from subclasses
	 * 
	 * @return LengthInWords
	 */
	public abstract int getLengthInWords();

	/**
	 * Get topic from newsStory
	 * 
	 * @return topic
	 */
	public String getTopic() {

		return "";
	}

	/**
	 * Get subject from newsStory
	 * 
	 * @return subject
	 */
	public String getSubject() {

		return "";
	}

	/**
	 * Get newsMaker1 from newsStory
	 * 
	 * @return newsMaker1
	 */
	public NewsMaker getNewsMaker1() {

		return null;
	}

	/**
	 * get newsMaker2 from newsstory
	 * 
	 * @return NewsMaker2
	 */
	public NewsMaker getNewsMaker2() {

		return null;
	}

	/**
	 * Check to see if two news stories are equal
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		return false;
	}

	/**
	 * Compare the topics of 2 newsstories
	 * 
	 * @return compare
	 */
	@Override
	public int compareTo(NewsStory newsStory) {
		return 0;
	}
}
