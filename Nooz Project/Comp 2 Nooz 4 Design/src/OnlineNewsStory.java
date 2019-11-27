import java.time.LocalDate;

/**
 * This subclass extends the NewsStory object as an instance of a
 * OnlineNewsStory.
 * 
 * @author cglen
 */
public class OnlineNewsStory extends NewsStory {

	private static final long serialVersionUID = 1L;
	private PartOfDay partOfDay;

	/**
	 * CONSTRUCTOR METHOD
	 * 
	 * @param date
	 * @param source
	 * @param length
	 * @param topic
	 * @param subject
	 * @param partOfDay
	 * @param newsMaker1
	 * @param newsMaker2
	 */
	public OnlineNewsStory(LocalDate date, String source, int length, String topic, String subject, PartOfDay partOfDay,
			NewsMaker newsMaker1, NewsMaker newsMaker2) {

		super(date, source, length, topic, subject, newsMaker1, newsMaker2);
	}

	/**
	 * This overriding method gets the length in words.
	 * 
	 * @return LengthInWords
	 */
	@Override
	public int getLengthInWords() {
		return 0;
	}

	/**
	 * This method gets the Part of day of the NewsStory
	 * 
	 * @return PartOfDay
	 */
	public PartOfDay getPartOfDay() {
		return null;
	}
}
