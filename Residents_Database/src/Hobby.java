import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Roommate Matching, 4/1/2018
 * <P>
 * This enumerated type specifies the Hobby Plan for the selected resident 
 * with the possibilities being two Hobby, two Hobby deluxe, three Hobby open, 
 * three Hobby closed, and four Hobby.
 * </P>
 * 
 * @author Clayton Glenn
 * @version 1.0
 * 
 */
public enum Hobby {

	TV, DRINK, STAY_UP, ART, OUTDOORS, TRAVEL, GAMES, FRIENDS, READING, 
	ENGINEERING, DIY, FANTASY_SPORTS, DIGITAL_ARTS, PROGRAMMING, OTHER;

	public static final List<Hobby> VALUES_LIST = new ArrayList<Hobby>(Arrays.asList(TV, DRINK, STAY_UP, ART, OUTDOORS,
			TRAVEL, GAMES, FRIENDS, READING, ENGINEERING, DIY, FANTASY_SPORTS, DIGITAL_ARTS, PROGRAMMING, OTHER));

	/**
	 * The overridden <code>toString</code> method returns the Hobby String in
	 * "Title Case."
	 * 
	 * @return String HobbyString
	 */
	public String toString() {
		switch (this) {
		case TV:				return "Television";
		case DRINK:				return "Drinking";
		case STAY_UP:			return "Staying up";
		case ART:				return "Art";
		case OUTDOORS:			return "Outdoors";
		case TRAVEL:			return "Travel";
		case GAMES:				return "Games";
		case FRIENDS:			return "Friends";
		case READING:			return "Reading";
		case ENGINEERING:		return "Engineering";
		case DIY:				return "DIY";
		case FANTASY_SPORTS:	return "Fantasy Sports";
		case DIGITAL_ARTS:		return "Digital Arts";
		case PROGRAMMING:		return "Programming";
		case OTHER:				return "Other";
		default:				throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromString</code> method returns the Hobby from the Hobby String.
	 * 
	 * @param String string
	 * @return Hobby Hobby
	 */
	public static Hobby fromString(String string) {
		
		//Convert String to Title Case
		string = string.toUpperCase().charAt(0) + string.substring(1).toLowerCase();
		
		switch (string) {
		case "Television":			return TV;
		case "Drinking":			return DRINK;
		case "Staying up":return STAY_UP;
		case "Stayingup":return STAY_UP;
		case "Staying-up":return STAY_UP;
		case "Staying - up":		return STAY_UP;
		case "Art":					return ART;
		case "Outdoors":			return OUTDOORS;
		case "Travel":				return TRAVEL;
		case "Games":				return GAMES;
		case "Friends":				return FRIENDS;
		case "Reading":				return READING;
		case "Engineering":			return ENGINEERING;
		case "Diy":					return DIY;
		case "Fantasy sports":return FANTASY_SPORTS;
		case "Fantasysports":return FANTASY_SPORTS;
		case "Fantasy-sports":return FANTASY_SPORTS;
		case "Fantasy - sports":	return FANTASY_SPORTS;
		case "Digital arts":return DIGITAL_ARTS;
		case "Digitalarts":return DIGITAL_ARTS;
		case "Digital-arts":return DIGITAL_ARTS;
		case "Digital - arts":		return DIGITAL_ARTS;
		case "Programming":			return PROGRAMMING;
		case "Other":				return OTHER;
		default:					{System.out.println(string);throw new IllegalArgumentException();}
		}
	}

	/**
	 * The <code>toInt</code> method returns the Integer associated with the type of Hobby.
	 * 
	 * @return int HobbyNum
	 */
	public int toInt() {
		switch (this) {
		case OTHER:					return 15;
		case PROGRAMMING:			return 14;
		case DIGITAL_ARTS:			return 13;
		case FANTASY_SPORTS:		return 12;
		case DIY:					return 11;
		case ENGINEERING:			return 10;
		case READING:				return 9;
		case FRIENDS:				return 8;
		case GAMES:					return 7;
		case TRAVEL:				return 6;
		case OUTDOORS:				return 5;
		case ART:					return 4;
		case STAY_UP:				return 3;
		case DRINK:					return 2;
		case TV:					return 1;
		default:					throw new IllegalArgumentException();
		}
	}

	/**
	 * The <code>fromInt</code> method returns the Hobby associated with a user defined integer.
	 * 
	 * @param int num
	 * @return Hobby Hobby
	 */
	public static Hobby fromInt(int num) {
		switch (num) {
		case 15:	return OTHER;
		case 14:	return PROGRAMMING;
		case 13:	return DIGITAL_ARTS;
		case 12:	return FANTASY_SPORTS;
		case 11:	return DIY;
		case 10:	return ENGINEERING;
		case 9:		return READING;
		case 8:		return FRIENDS;
		case 7:		return GAMES;
		case 6:		return TRAVEL;
		case 5:		return OUTDOORS;
		case 4:		return ART;
		case 3:		return STAY_UP;
		case 2:		return DRINK;
		case 1:		return TV;
		default:	throw new IllegalArgumentException();
		}
	}

	/**
	 * The overridden <code>valuesAsList</code> method returns all Hobby values as a list.
	 * 
	 * @return <code>List<Hobby> Hobbys</code>
	 */
	public List<Hobby> valuesAsList() {
		return VALUES_LIST;
	}
}
