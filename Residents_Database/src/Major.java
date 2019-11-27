import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Roommate Matching, 4/1/2018
 * <P>
 * This enumerated type specifies the Major Plan for the selected resident 
 * with the possibilities being two Major, two Major deluxe, three Major open, 
 * three Major closed, and four Major.
 * </P>
 * 
 * @author Clayton Glenn
 * @version 1.0
 * 
 */
public enum Major {

	ARTS_SCIENCES, ATMOSPHERIC_GEOGRAPHIC, BUSINESS, EARTH_ENERGY, EDUCATION, ENGINEERING, 
	FINE_ARTS, INTERNATIONAL, MASS_COM, LAW, HEALTH_SCIENCE, MULTI_DISCIPLINE, OTHER, NONE;

	public static final List<Major> VALUES_LIST = new ArrayList<Major>(
			Arrays.asList(ARTS_SCIENCES, ATMOSPHERIC_GEOGRAPHIC, BUSINESS, EARTH_ENERGY, EDUCATION, ENGINEERING,
					FINE_ARTS, INTERNATIONAL, MASS_COM, LAW, HEALTH_SCIENCE, MULTI_DISCIPLINE, OTHER, NONE));

	/**
	 * The overridden <code>toString</code> method returns the Major String in
	 * "Title Case."
	 * 
	 * @return String MajorString
	 */
	public String toString() {
		switch (this) {
		case ARTS_SCIENCES:				return "Arts and Sciences";
		case ATMOSPHERIC_GEOGRAPHIC:	return "Atmospheric and Geographic Sciences";
		case BUSINESS:					return "Business";
		case EARTH_ENERGY:				return "Earth and Energy";
		case EDUCATION:					return "Education";
		case ENGINEERING:				return "Engineering";
		case FINE_ARTS:					return "Fine Arts";
		case INTERNATIONAL:				return "International Studies";
		case MASS_COM:					return "Journalism and Mass Communication";
		case LAW:						return "Law";
		case HEALTH_SCIENCE:			return "Health Science";
		case MULTI_DISCIPLINE:			return "Multi-Disciplinary Studies";
		case OTHER:						return "Other";
		case NONE:						return "None";
		default:						throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the Major from the Major String.
	 * 
	 * @param String string
	 * @return Major Major
	 */
	public static Major fromString(String string) {
		
		//Convert String to Title Case
		string = string.toUpperCase().charAt(0) + string.substring(1).toLowerCase();
		
		switch (string) {
		case "Arts":
		case "Sciences":
		case "Arts and sciences":
		case "Arts andsciences":
		case "Artsand sciences":
		case "Artsandsciences":
		case "Arts-and-sciences":						return ARTS_SCIENCES;
		case "Atmospheric":
		case "Geographic":
		case "Atmospheric sciences":
		case "Geographic sciences":
		case "Atmospheric and geographic sciences":
		case "Atmosphericandgeographicsciences":		return ATMOSPHERIC_GEOGRAPHIC;
		case "Business":								return BUSINESS;
		case "Earth":
		case "Energy":
		case "Earth and energy":
		case "Earthandenergy":							return EARTH_ENERGY;
		case "Education":								return EDUCATION;
		case "Engineering":								return ENGINEERING;
		case "Fine arts":
		case "Finearts":								return FINE_ARTS;
		case "International studies":
		case "International":
		case "Internationalstudies":					return INTERNATIONAL;
		case "Journalism and mass communication":
		case "Journalism":
		case "Mass":
		case "Communication":
		case "Mass com":
		case "Journalismandmasscommunication":			return MASS_COM;
		case "Law":										return LAW;
		case "Health":
		case "Health science":
		case "Healthscience":							return HEALTH_SCIENCE;
		case "Multi-disciplinary studies":
		case "Multi disciplinary studies":
		case "Multidisciplinary studies":
		case "Multi":
		case "Disciplinary":
		case "Studies":									return MULTI_DISCIPLINE;
		case "Other":									return OTHER;
		case "None":									return NONE;
		default:										throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of Major.
	 * 
	 * @return int MajorNum
	 */
	public int toInt() {
		switch (this) {
		case ARTS_SCIENCES:				return 1;
		case ATMOSPHERIC_GEOGRAPHIC:	return 2;
		case BUSINESS:					return 3;
		case EARTH_ENERGY:				return 4;
		case EDUCATION:					return 5;
		case ENGINEERING:				return 6;
		case FINE_ARTS:					return 7;
		case INTERNATIONAL:				return 8;
		case MASS_COM:					return 9;
		case LAW:						return 10;
		case HEALTH_SCIENCE:			return 11;
		case MULTI_DISCIPLINE:			return 12;
		case OTHER:						return 13;
		case NONE:						return 14;
		default:						throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the Major associated with a user defined integer.
	 * 
	 * @param int num
	 * @return Major Major
	 */
	public static Major fromInt(int num) {
		switch (num) {
		case 14:	return NONE;
		case 13:	return OTHER;
		case 12:	return ARTS_SCIENCES;
		case 11:	return ATMOSPHERIC_GEOGRAPHIC;
		case 10:	return BUSINESS;
		case 9:		return EARTH_ENERGY;
		case 8:		return EDUCATION;
		case 7:		return ENGINEERING;
		case 6:		return FINE_ARTS;
		case 5:		return INTERNATIONAL;
		case 4:		return MASS_COM;
		case 3:		return LAW;
		case 2:		return HEALTH_SCIENCE;
		case 1:		return MULTI_DISCIPLINE;
		default:	throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all Major values as a list.
	 * 
	 * @return <code>List<Major> Majors</code>
	 */
	public List<Major> valuesAsList() {
		return VALUES_LIST;
	}
}