import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum GenderPreference {

	MALE, FEMALE, COED, OTHER;

	public static final List<GenderPreference> VALUES_LIST = new ArrayList<GenderPreference>(
			Arrays.asList(MALE, FEMALE, COED, OTHER));

	/**
	 * The overridden <code>toString</code> method returns the GenderPreference String in
	 * "Title Case."
	 * 
	 * @return String GenderPreferenceString
	 */
	public String toString() {
		switch (this) {
		case MALE:				return "Male";
		case FEMALE:			return "Female";
		case COED:				return "Coed";
		case OTHER:				return "Other";
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the GenderPreference from the GenderPreference String.
	 * 
	 * @param String string
	 * @return GenderPreference GenderPreference
	 */
	public static GenderPreference fromString(String string) {
		
		//Convert String to Upper Case
		string = string.toUpperCase();
		
		switch (string) {
		case "MALE":
		case "MAN":	
		case "BOY":		return MALE;
		case "FEMALE":
		case "WOMAN":
		case "GIRL":		return FEMALE;
		case "COED":
		case "BOTH":
		case "MALE-FEMALE":
		case "MALE FEMALE":
		case "MALE AND FEMALE":
		case "MALEANDFEMALE":
		case "MALE ANDFEMALE":
		case "MALEAND FEMALE":
		case "MALE&FEMALE":
		case "MALE &FEMALE":
		case "MALE& FEMALE":
		case "MALE & FEMALE": return COED;
		case "INDIFFERENT":
		case "OTHER":
		case "NA":
		case "N/A":
		case "":					return OTHER;
		default:					throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of GenderPreference.
	 * 
	 * @return int GenderPreferenceNum
	 */
	public int toInt() {
		switch (this) {
		case MALE:				return 1;
		case FEMALE:			return 2;
		case COED:				return 3;
		case OTHER:				return 0;
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the GenderPreference associated with a user defined integer.
	 * 
	 * @param int num
	 * @return GenderPreference GenderPreference
	 */
	public static GenderPreference fromInt(int num) {
		switch (num) {
		case 3:			return COED;
		case 2:			return FEMALE;
		case 1:			return MALE;
		case 0:			return OTHER;
		default:		throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all GenderPreference values as a list.
	 * 
	 * @return <code>List<GenderPreference> GenderPreferences</code>
	 */
	public List<GenderPreference> valuesAsList() {
		return VALUES_LIST;
	}
}

