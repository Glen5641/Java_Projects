
import java.time.LocalDate;

/**
 * This subclass extends the NewsStory object as an instance of a TVNewsStory.
 * 
 * @author cglen and Dean Hougen
 */
public class TVNewsStory extends NewsStory {

	private static final long serialVersionUID = 1L;
	private PartOfDay partOfDay;

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
	 * @param partOfDay
	 *            Part of day of the NewsStory object
	 * @param newsMaker1
	 *            First newsMaker of the NewsStory object
	 * @param newsMaker2
	 *            Second newsMaker of the NewsStory object
	 */
	public TVNewsStory(LocalDate date, String source, int length, String topic, String subject, PartOfDay partOfDay,
			NewsMaker newsMaker1, NewsMaker newsMaker2) {

		// Initiallize variables of abstract class
		super(date, source, length, topic, subject, newsMaker1, newsMaker2);
		this.partOfDay = partOfDay;
	}

	/**
	 * This overriding method gets the seconds as a length in words. 150 words/
	 * minute
	 * 
	 * @return Integer lengthinwords
	 */
	@Override
	public int getLengthInWords() {
		return this.getLength() * 150 / 60;
	}

	/**
	 * This method gets the Part of day of the NewsStory
	 * 
	 * @return PartOfDay
	 */
	public PartOfDay getPartOfDay() {
		return partOfDay;
	}
}
