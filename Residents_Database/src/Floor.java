import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Roommate Matching, 4/1/2018
 * <P>
 * This enumerated type specifies the Floor Plan for the selected resident 
 * with the possibilities being two Floor, two Floor deluxe, three Floor open, 
 * three Floor closed, and four Floor.
 * </P>
 * 
 * @author Clayton Glenn
 * @version 1.0
 * 
 */
public enum Floor {

	FIRST_HANDICAP, FIRST, SECOND, THIRD, INDIFFERENT;

	public static final List<Floor> VALUES_LIST = new ArrayList<Floor>(
			Arrays.asList(FIRST_HANDICAP, FIRST, SECOND, THIRD, INDIFFERENT));

	/**
	 * The overridden <code>toString</code> method returns the Floor String in
	 * "Title Case."
	 * 
	 * @return String FloorString
	 */
	public String toString() {
		switch (this) {
		case FIRST_HANDICAP:	return "First Floor Handicap";
		case FIRST:				return "First Floor";
		case SECOND:			return "Second Floor";
		case THIRD:				return "Third Floor";
		case INDIFFERENT:		return "Indifferent";
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the Floor from the Floor String.
	 * 
	 * @param String string
	 * @return Floor Floor
	 */
	public static Floor fromString(String string) {
		
		//Convert String to Upper Case
		string = string.toUpperCase();
		
		switch (string) {
		case "HANDICAP":
		case "FIRSTHANDICAP":
		case "FIRST HANDICAP":
		case "FIRST-HANDICAP":
		case "FIRST - HANDICAP":
		case "FIRST FLOOR HANDICAP":
		case "FIRSTFLOOR HANDICAP":
		case "FIRST FLOORHANDICAP":
		case "FIRSTFLOORHANDICAP":	
		case "FIRSTFLOOR-HANDICAP":
		case "FIRST-FLOORHANDICAP":
		case "FIRST-FLOOR-HANDICAP":
		case "FIRST - FLOOR - HANDICAP":		return FIRST_HANDICAP;
		case "FIRST FLOOR":
		case "FIRSTFLOOR":	
		case "FIRST-FLOOR":
		case "FIRST - FLOOR":					return FIRST;
		case "SECOND FLOOR":
		case "SECONDFLOOR":
		case "SECOND-FLOOR":
		case "SECOND - FLOOR":					return SECOND;
		case "THIRD FLOOR":
		case "THIRDFLOOR":
		case "THIRD-FLOOR":
		case "THIRD - FLOOR":					return THIRD;
		case "INDIFFERENT":
		case "NONE":
		case "NA":
		case "OTHER":
		case "N/A":
		case "":								return INDIFFERENT;
		default:								throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of Floor.
	 * 
	 * @return int FloorNum
	 */
	public int toInt() {
		switch (this) {
		case FIRST_HANDICAP:	return 1;
		case FIRST:				return 2;
		case SECOND:			return 3;
		case THIRD:				return 4;
		case INDIFFERENT:		return 0;
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the Floor associated with a user defined integer.
	 * 
	 * @param int num
	 * @return Floor Floor
	 */
	public static Floor fromInt(int num) {
		switch (num) {
		case 4:			return THIRD;
		case 3:			return SECOND;
		case 2:			return FIRST;
		case 1:			return FIRST_HANDICAP;
		case 0:			return INDIFFERENT;
		default:		throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all Floor values as a list.
	 * 
	 * @return <code>List<Floor> Floors</code>
	 */
	public List<Floor> valuesAsList() {
		return VALUES_LIST;
	}
}
