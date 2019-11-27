import java.io.Serializable;
import java.time.LocalDate;

/**
 * Abstract Class for 3 subclasses that creates a newsStory object for later use
 * 
 * @author cglen and Dean Hougen
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

		this.date = date;
		this.source = source;
		this.length = length;
		this.topic = topic;
		this.subject = subject;
		this.newsMaker1 = newsMaker1;
		this.newsMaker2 = newsMaker2;
	}

	/**
	 * Get date from newsStory
	 * 
	 * @return Date
	 */
	public LocalDate getDate() {

		return this.date;
	}

	/**
	 * Get source from newsStory
	 * 
	 * @return Source
	 */
	public String getSource() {

		return this.source;
	}

	/**
	 * Get length from newsStory
	 * 
	 * @return Length
	 */
	public int getLength() {

		return this.length;
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

		return this.topic;
	}

	/**
	 * Get subject from newsStory
	 * 
	 * @return subject
	 */
	public String getSubject() {

		return this.subject;
	}

	/**
	 * Get newsMaker1 from newsStory
	 * 
	 * @return newsMaker1
	 */
	public NewsMaker getNewsMaker1() {

		return this.newsMaker1;
	}

	/**
	 * get newsMaker2 from newsstory
	 * 
	 * @return NewsMaker2
	 */
	public NewsMaker getNewsMaker2() {

		return this.newsMaker2;
	}

	/**
	 * Check to see if two news stories are equal
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {

		if (o instanceof NewsStory) {
			NewsStory newsStory = (NewsStory) o;
			boolean equal = this.date.equals(newsStory.date);

			if (equal) {
				equal = this.source.equals(newsStory.source);
			}

			if (equal) {
				equal = this.length == newsStory.length;
			}

			if (equal) {
				equal = this.topic.equals(newsStory.topic);
			}

			if (equal) {
				equal = this.subject.equals(newsStory.subject);
			}

			if (equal) {
				equal = this.newsMaker1.equals(newsStory.newsMaker1);
			}

			if (equal) {
				equal = this.newsMaker2.equals(newsStory.newsMaker2);
			}

			if (equal) {
				if ((this instanceof TVNewsStory && newsStory instanceof TVNewsStory)) {
					TVNewsStory story1 = (TVNewsStory) this, story2 = (TVNewsStory) newsStory;
					equal = story1.getPartOfDay().equals(story2.getPartOfDay());
				}
				if ((this instanceof OnlineNewsStory && newsStory instanceof OnlineNewsStory)) {
					OnlineNewsStory story1 = (OnlineNewsStory) this, story2 = (OnlineNewsStory) newsStory;
					equal = story1.getPartOfDay().equals(story2.getPartOfDay());
				}

			}
			return equal;
		} else {
			return false;
		}
	}

	/**
	 * Compare the topics of 2 newsstories
	 * 
	 * @return compare
	 */
	@Override
	public int compareTo(NewsStory newsStory) {

		return this.topic.compareTo(newsStory.getTopic());
	}
}
