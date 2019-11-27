import java.time.LocalDate;

/**
 * This subclass extends the NewsStory object as an instance of a
 * NewspaperNewsStory.
 * 
 * @author cglen and Dean Hougen
 */
public class NewspaperStory extends NewsStory {

	private static final long serialVersionUID = 1L;

	/**
	 * CONSTRUCTOR METHOD
	 * 
	 * @param date
	 *            date of the NewsStory object
	 * @param source
	 *            source of the NewsStory object
	 * @param length
	 *            length of the NewsStory object
	 * @param topic
	 *            topic of the NewsStory object
	 * @param subject
	 *            subject of the NewsStory object
	 * @param newsMaker1
	 *            First newsMaker of the NewsStory object
	 * @param newsMaker2
	 *            Second newsMaker of the NewsStory object
	 */
	public NewspaperStory(LocalDate date, String source, int length, String topic, String subject, NewsMaker newsMaker1,
			NewsMaker newsMaker2) {

		super(date, source, length, topic, subject, newsMaker1, newsMaker2);
	}

	/**
	 * This overriding method gets the length in words.
	 * 
	 * @return Integer lengthinwords
	 */
	@Override
	public int getLengthInWords() {

		return this.getLength();
	}
}
