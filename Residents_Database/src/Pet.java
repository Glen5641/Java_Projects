import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Roommate Matching, 4/1/2018
 * <P>
 * This enumerated type specifies the Pet Plan for the selected resident 
 * with the possibilities being two Pet, two Pet deluxe, three Pet open, 
 * three Pet closed, and four Pet.
 * </P>
 * 
 * @author Clayton Glenn
 * @version 1.0
 * 
 */
public enum Pet {

	LARGE_DOG, MEDIUM_DOG, SMALL_DOG, CAT, SERVICE, RODENT, OTHER, NONE;

	public static final List<Pet> VALUES_LIST = new ArrayList<Pet>(
			Arrays.asList(LARGE_DOG, MEDIUM_DOG, SMALL_DOG, CAT, SERVICE, RODENT, OTHER, NONE));

	/**
	 * The overridden <code>toString</code> method returns the Pet String in
	 * "Title Case."
	 * 
	 * @return String PetString
	 */
	public String toString() {
		switch (this) {
		case LARGE_DOG:		return "Large Dog";
		case MEDIUM_DOG:	return "Medium Dog";
		case SMALL_DOG:		return "Small Dog";
		case CAT:			return "Cat";
		case SERVICE:		return "Service Animal";
		case RODENT:		return "Rodent";
		case OTHER:			return "Other";
		case NONE:			return "None";
		default:			throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the Pet from the Pet String.
	 * 
	 * @param String string
	 * @return Pet Pet
	 */
	public static Pet fromString(String string) {
		
		//Convert String to Title Case
		string = string.toUpperCase().charAt(0) + string.substring(1).toLowerCase();
		
		switch (string) {
		case "Large":
		case "Large dog":
		case "Largedog":
		case "Large-dog":
		case "Large - dog":			return LARGE_DOG;
		case "Medium":
		case "Medium dog":
		case "Mediumdog":
		case "Medium-dog":
		case "Medium - dog":		return MEDIUM_DOG;
		case "Small":	
		case "Small dog":
		case "Smalldog":
		case "Small-dog":
		case "Small - dog":			return SMALL_DOG;
		case "Cat":					return CAT;
		case "Service":
		case "Service animal":
		case "Serviceanimal":
		case "Service-animal":
		case "Service - animal":	return SERVICE;
		case "Rodent":				return RODENT;
		case "Other":				return OTHER;
		case "None":				return NONE;
		default:					throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of Pet.
	 * 
	 * @return int PetNum
	 */
	public int toInt() {
		switch (this) {
		case LARGE_DOG:		return 1;
		case MEDIUM_DOG:	return 2;
		case SMALL_DOG:		return 3;
		case CAT:			return 4;
		case SERVICE:		return 5;
		case RODENT:		return 6;
		case OTHER:			return 7;
		case NONE:			return 8;
		default:			throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the Pet associated with a user defined integer.
	 * 
	 * @param int num
	 * @return Pet Pet
	 */
	public static Pet fromInt(int num) {
		switch (num) {
		case 7:		return OTHER;
		case 6:		return RODENT;
		case 5:		return SERVICE;
		case 4:		return CAT;
		case 3:		return SMALL_DOG;
		case 2:		return MEDIUM_DOG;
		case 1:		return LARGE_DOG;
		default:	throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all Pet values as a list.
	 * 
	 * @return <code>List<Pet> Pets</code>
	 */
	public List<Pet> valuesAsList() {
		return VALUES_LIST;
	}
}
