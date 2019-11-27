import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Handicap {

	FIRST_FLOOR, YES, NO;

	public static final List<Handicap> VALUES_LIST = new ArrayList<Handicap>(
			Arrays.asList(FIRST_FLOOR, YES, NO));

	/**
	 * The overridden <code>toString</code> method returns the Handicap String in
	 * "Title Case."
	 * 
	 * @return String HandicapString
	 */
	public String toString() {
		switch (this) {
		case FIRST_FLOOR:	return "FIRST_FLOOR";
		case YES:			return "YES";
		case NO:			return "NO";
		default:			throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the Handicap from the Handicap String.
	 * 
	 * @param String string
	 * @return Handicap Handicap
	 */
	public static Handicap fromString(String string) {
		
		//Convert String to Upper Case
		string = string.toUpperCase();
		
		switch (string) {
		case "FIRST_FLOOR":
		case "FIRST":
		case "FIRSTFLOOR":
		case "FIRST FLOOR": 	return FIRST_FLOOR;
		case "YES":
		case "Y":				return YES;
		case "NO":
		case "N/A":
		case "N":
		case "": 				return NO;
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of Handicap.
	 * 
	 * @return int HandicapNum
	 */
	public int toInt() {
		switch (this) {
		case FIRST_FLOOR:	return 2;
		case YES:			return 1;
		case NO:			return 0;
		default:			throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the Handicap associated with a user defined integer.
	 * 
	 * @param int num
	 * @return Handicap Handicap
	 */
	public static Handicap fromInt(int num) {
		switch (num) {
		case 3:			return NO;
		case 2:			return YES;
		case 1:			return FIRST_FLOOR;
		default:		throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all Handicap values as a list.
	 * 
	 * @return <code>List<Handicap> Handicaps</code>
	 */
	public List<Handicap> valuesAsList() {
		return VALUES_LIST;
	}
}


