import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Roommate Matching, 4/1/2018
 * <P>
 * This enumerated type specifies the Bed Plan for the selected resident 
 * with the possibilities being two bed, two bed deluxe, three bed open, 
 * three bed closed, and four bed.
 * </P>
 * 
 * @author Clayton Glenn
 * @version 1.0
 * 
 */
public enum Bed {

	TWO_BED, TWO_BED_DELUXE, THREE_BED_OPEN, THREE_BED_CLOSED, FOUR_BED;

	public static final List<Bed> VALUES_LIST = new ArrayList<Bed>(
			Arrays.asList(TWO_BED, TWO_BED_DELUXE, THREE_BED_OPEN, THREE_BED_CLOSED, FOUR_BED));

	/**
	 * The overridden <code>toString</code> method returns the Bed String in
	 * "Upper Case."
	 * 
	 * @return String bedString
	 */
	public String toString() {
		switch (this) {
		case TWO_BED:			return "2 BED";
		case TWO_BED_DELUXE:	return "2 BED DELUXE";
		case THREE_BED_OPEN:	return "3 BED OPEN";
		case THREE_BED_CLOSED:	return "3 BED CLOSED";
		case FOUR_BED:			return "4 BED";
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the Bed from the Bed String.
	 * 
	 * @param String string
	 * @return Bed bed
	 */
	public static Bed fromString(String string) {
		
		//Convert to Upper Case
		string = string.toUpperCase();
		
		switch (string) {
		case "2 BED":			
		case "2BED":
		case "TWO BED":
		case "TWOBED":				return TWO_BED;
		case "2 BED DELUXE":
		case "2BED DELUXE":
		case "2 BEDDELUXE":
		case "2BEDDELUXE":
		case "2-BEDDELUXE":
		case "2BED-DELUXE":
		case "2-BED-DELUXE":
		case "TWO BED DELUXE":
		case "TWOBED DELUXE":
		case "TWO BEDDELUXE":
		case "TWOBEDDELUXE":
		case "TWO-BEDDELUXE":
		case "TWOBED-DELUXE":
		case "TWO-BED-DELUXE":		return TWO_BED_DELUXE;
		case "3 BED OPEN":
		case "3BED OPEN":
		case "3 BEDOPEN":
		case "3BEDOPEN":
		case "3-BEDOPEN":
		case "3BED-OPEN":
		case "3-BED-OPEN":
		case "THREE BED OPEN":
		case "THREEBED OPEN":
		case "THREE BEDOPEN":
		case "THREEBEDOPEN":
		case "THREE-BEDOPEN":
		case "THREEBED-OPEN":
		case "THREE-BED-OPEN":		return THREE_BED_OPEN;
		case "3 BED CLOSED":
		case "3BED CLOSED":
		case "3 BEDCLOSED":
		case "3BEDCLOSED":
		case "3-BEDCLOSED":
		case "3BED-CLOSED":
		case "3-BED-CLOSED":
		case "THREE BED CLOSED":
		case "THREEBED CLOSED":
		case "THREE BEDCLOSED":
		case "THREEBEDCLOSED":
		case "THREE-BEDCLOSED":
		case "THREEBED-CLOSED":
		case "THREE-BED-CLOSED":	return THREE_BED_CLOSED;
		case "4 BED":
		case "4BED":
		case "FOUR BED":
		case "FOURBED":				return FOUR_BED;
		default:					throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of Bed.
	 * 
	 * @return int BedNum
	 */
	public int toInt() {
		switch (this) {
		case TWO_BED:				return 1;
		case TWO_BED_DELUXE:		return 2;
		case THREE_BED_OPEN:		return 3;
		case THREE_BED_CLOSED:		return 4;
		case FOUR_BED:				return 5;
		default:					throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the Bed associated with a user defined integer.
	 * 
	 * @param int num
	 * @return Bed bed
	 */
	public static Bed fromInt(int num) {
		switch (num) {
		case 5:			return FOUR_BED;
		case 4:			return THREE_BED_CLOSED;
		case 3:			return THREE_BED_OPEN;
		case 2:			return TWO_BED_DELUXE;
		case 1:			return TWO_BED;
		default:		throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all Bed values as a list.
	 * 
	 * @return <code>List<Bed> beds</code>
	 */
	public List<Bed> valuesAsList() {
		return VALUES_LIST;
	}
}