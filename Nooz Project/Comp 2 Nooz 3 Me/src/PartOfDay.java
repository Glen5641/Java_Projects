/**
 * This enum creates parts of day for its constants
 * 
 * @author cglen and Dean Hougen
 *
 */
public enum PartOfDay {

	// CONSTANTS
	MORNING, AFTERNOON, EVENING, LATE_NIGHT;

	/**
	 * Find string of method that corresponds to its constants
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		switch (this) {

		case MORNING: {
			return "Morning";
		}
		case AFTERNOON: {
			return "Afternoon";
		}
		case EVENING: {
			return "Evening";
		}
		case LATE_NIGHT: {
			return "Late Night";
		}
		default: {
			throw new IllegalArgumentException();
		}
		}
	}
}
