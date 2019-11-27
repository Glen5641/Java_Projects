import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Roommate Matching, 4/1/2018
 * <P>
 * This enumerated type specifies the Characteristic Plan for the selected resident 
 * with the possibilities being ADVENTUROUS, CULTURED, DEPENDABLE, DISCREET, INDEPENDENT, INTELLEGENT, CAPABLE, 
	CONFIDENT, DUTIFUL, RELIABLE, ENCOURAGING, HELPFUL, SARCASTIC, SHY, OPEN, GAMER, PARTIER, and OTHER.
 * </P>
 * 
 * @author Clayton Glenn
 * @version 1.0
 * 
 */
public enum Characteristic {

	ADVENTUROUS, CULTURED, DEPENDABLE, DISCREET, INDEPENDENT, INTELLEGENT, CAPABLE, 
	CONFIDENT, DUTIFUL, RELIABLE, ENCOURAGING, HELPFUL, SARCASTIC, SHY, OPEN, GAMER, PARTIER, OTHER;

	public static final List<Characteristic> VALUES_LIST = new ArrayList<Characteristic>(
			Arrays.asList(ADVENTUROUS, CULTURED, DEPENDABLE, DISCREET, INDEPENDENT, INTELLEGENT, CAPABLE, CONFIDENT,
					DUTIFUL, RELIABLE, ENCOURAGING, HELPFUL, SARCASTIC, SHY, OPEN, GAMER, PARTIER, OTHER));

	/**
	 * The overridden <code>toString</code> method returns the Characteristic String in
	 * "Title Case."
	 * 
	 * @return String CharacteristicString
	 */
	public String toString() {
		switch (this) {
		case ADVENTUROUS:		return "Adventurous";
		case CULTURED:			return "Cultured";
		case DEPENDABLE:		return "Dependable";
		case DISCREET:			return "Discreet";
		case INDEPENDENT:		return "Independent";
		case INTELLEGENT:		return "Intellegent";
		case CAPABLE:			return "Capable";
		case CONFIDENT:			return "Confident";
		case DUTIFUL:			return "Dutiful";
		case RELIABLE:			return "Reliable";
		case ENCOURAGING:		return "Encouraging";
		case HELPFUL:			return "Helpful";
		case SARCASTIC:			return "Sarcastic";
		case SHY:				return "Shy";
		case OPEN:				return "Open";
		case GAMER:				return "Gamer";
		case PARTIER:			return "Partier";
		case OTHER:				return "Other";
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the Characteristic from the Characteristic String.
	 * 
	 * @param String string
	 * @return Characteristic Characteristic
	 */
	public static Characteristic fromString(String string) {
		
		//Convert string to title case
		string = string.toUpperCase().charAt(0) + string.substring(1).toLowerCase();
		
		switch (string) {
		case "Adventurous":		return ADVENTUROUS;
		case "Cultured":		return CULTURED;
		case "Dependable":		return DEPENDABLE;
		case "Discreet":		return DISCREET;
		case "Independent":		return INDEPENDENT;
		case "Intellegent":		return INTELLEGENT;
		case "Capable":			return CAPABLE;
		case "Confident":		return CONFIDENT;
		case "Dutiful":			return DUTIFUL;
		case "Reliable":		return RELIABLE;
		case "Encouraging":		return ENCOURAGING;
		case "Helpful":			return HELPFUL;
		case "Sarcastic":		return SARCASTIC;
		case "Shy":				return SHY;
		case "Open":			return OPEN;
		case "Gamer":			return GAMER;
		case "Partier":			return PARTIER;
		case "Other":			return OTHER;
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of Characteristic.
	 * 
	 * @return int CharacteristicNum
	 */
	public int toInt() {
		switch (this) {
		case OTHER:			return 18;
		case PARTIER:		return 17;
		case GAMER:			return 16;
		case OPEN:			return 15;
		case SHY:			return 14;
		case SARCASTIC:		return 13;
		case HELPFUL:		return 12;
		case ENCOURAGING:	return 11;
		case RELIABLE:		return 10;
		case DUTIFUL:		return 9;
		case CONFIDENT:		return 8;
		case CAPABLE:		return 7;
		case INTELLEGENT:	return 6;
		case INDEPENDENT:	return 5;
		case DISCREET:		return 4;
		case DEPENDABLE:	return 3;
		case CULTURED:		return 2;
		case ADVENTUROUS:	return 1;
		default:			throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the Characteristic associated with a user defined integer.
	 * 
	 * @param int num
	 * @return Characteristic Characteristic
	 */
	public static Characteristic fromInt(int num) {
		switch (num) {
		case 18:	return OTHER;
		case 17:	return PARTIER;
		case 16:	return GAMER;
		case 15:	return OPEN;
		case 14:	return SHY;
		case 13:	return SARCASTIC;
		case 12:	return HELPFUL;
		case 11:	return ENCOURAGING;
		case 10:	return RELIABLE;
		case 9:		return DUTIFUL;
		case 8:		return CONFIDENT;
		case 7:		return CAPABLE;
		case 6:		return INTELLEGENT;
		case 5:		return INDEPENDENT;
		case 4:		return DISCREET;
		case 3:		return DEPENDABLE;
		case 2:		return CULTURED;
		case 1:		return ADVENTUROUS;
		default:	throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all Characteristic values as a list.
	 * 
	 * @return <code>List<Characteristic> Characteristics</code>
	 */
	public List<Characteristic> valuesAsList() {
		return VALUES_LIST;
	}
}
