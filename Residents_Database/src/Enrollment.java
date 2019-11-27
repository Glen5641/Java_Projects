import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Roommate Matching, 4/1/2018
 * <P>
 * This enumerated type specifies the Enrollment Plan for the selected resident 
 * with the possibilities being FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, GRADUATE, TRANSFER, and NONE.
 * </P>
 * 
 * @author Clayton Glenn
 * @version 1.0
 * 
 */
public enum Enrollment {

	FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, GRADUATE, TRANSFER, NONE;

	public static final List<Enrollment> VALUES_LIST = new ArrayList<Enrollment>(
			Arrays.asList(FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, GRADUATE, TRANSFER, NONE));

	/**
	 * The overridden <code>toString</code> method returns the Enrollment String in
	 * "Title Case."
	 * 
	 * @return String EnrollmentString
	 */
	public String toString() {
		switch (this) {
		case FRESHMAN:		return "Freshman";
		case SOPHOMORE:		return "Sophomore";
		case JUNIOR:		return "Junior";
		case SENIOR:		return "Senior";
		case GRADUATE:		return "Graduate";
		case TRANSFER:		return "Transfer";
		case NONE:			return "None";
		default:			throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the Enrollment from the Enrollment String.
	 * 
	 * @param String string
	 * @return Enrollment Enrollment
	 */
	public static Enrollment fromString(String string) {
		
		//Convert String to title case
		string = string.toUpperCase().charAt(0) + string.substring(1).toLowerCase();
		
		switch (string) {
		case "Freshman":	return FRESHMAN;
		case "Sophomore":	return SOPHOMORE;
		case "Junior":		return JUNIOR;
		case "Senior":		return SENIOR;
		case "Graduate":	return GRADUATE;
		case "Transfer":	return TRANSFER;
		case "None":		return NONE;
		default:			throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of Enrollment.
	 * 
	 * @return int EnrollmentNum
	 */
	public int toInt() {
		switch (this) {
		case FRESHMAN:		return 1;
		case SOPHOMORE:		return 2;
		case JUNIOR:		return 3;
		case SENIOR:		return 4;
		case GRADUATE:		return 5;
		case TRANSFER:		return 6;
		case NONE:			return 7;
		default:			throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the Enrollment associated with a user defined integer.
	 * 
	 * @param int num
	 * @return Enrollment Enrollment
	 */
	public static Enrollment fromInt(int num) {
		switch (num) {
		case 7:		return NONE;
		case 6:		return TRANSFER;
		case 5:		return GRADUATE;
		case 4:		return SENIOR;
		case 3:		return JUNIOR;
		case 2:		return SOPHOMORE;
		case 1:		return FRESHMAN;
		default:	throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all Enrollment values as a list.
	 * 
	 * @return <code>List<Enrollment> Enrollments</code>
	 */
	public List<Enrollment> valuesAsList() {
		return VALUES_LIST;
	}
}