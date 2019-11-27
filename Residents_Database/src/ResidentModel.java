import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class ResidentModel implements Comparable<ResidentModel>, Serializable {

	/////////////////////////////////////////////////////////////////////////////////////////
	// Variables
	/////////////////////////////////////////////////////////////////////////////////////////

	private static final long serialVersionUID = -6200259360717296049L;
	private ArrayList<ActionListener> actionListenerList;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String mate1Name;
	private String mate2Name;
	private String mate3Name;
	
	private Bed bed;
	private Enrollment enrollment;
	private GenderPreference gender;
	
	private ResidentModel mate1;
	private ResidentModel mate2;
	private ResidentModel mate3;
	private boolean smoke;
	private boolean havePet;
	
	private boolean mindSmoke;
	private boolean smokeOut;
	private boolean mindSmokeOut;
	private boolean mindPet;
	
	private Major major;
	
	private int work;
	private int neat;
	private int personality;
	private int social;
	private int sleep;
	
	private ArrayList<Pet> pets;
	private ArrayList<Hobby> hobbies;
	private ArrayList<Characteristic> characteristics;
	private ArrayList<Characteristic> seekedCharacteristics;
	private Floor floor;

	/////////////////////////////////////////////////////////////////////////////////////////
	// Constructors
	/////////////////////////////////////////////////////////////////////////////////////////

	public ResidentModel(String firstName, String middleName, String lastName, Bed bed, String mate1, String mate2,
			String mate3, Major major, Enrollment enrollment, ArrayList<Hobby> hobbies,
			ArrayList<Characteristic> characteristics, ArrayList<Characteristic> seekedCharacteristics, Floor floor,
			boolean smoke, boolean mindSmoke, boolean smokeOut, boolean mindSmokeOut, boolean havePet, boolean mindPet,
			ArrayList<Pet> pets, int work, int neat, int personality, int social, int sleep, GenderPreference gender) {

		this.actionListenerList = new ArrayList<ActionListener>();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.bed = bed;
		this.mate1Name = mate1;
		this.mate2Name = mate2;
		this.mate3Name = mate3;
		this.mate1 = null;
		this.mate2 = null;
		this.mate3 = null;
		this.major = major;
		this.enrollment = enrollment;
		this.hobbies = hobbies;
		this.characteristics = characteristics;
		this.seekedCharacteristics = seekedCharacteristics;
		this.floor = floor;
		this.smoke = smoke;
		this.mindSmoke = mindSmoke;
		this.smokeOut = smokeOut;
		this.mindSmokeOut = mindSmokeOut;
		this.havePet = havePet;
		this.mindPet = mindPet;
		this.pets = pets;
		this.work = work;
		this.neat = neat;
		this.personality = personality;
		this.social = social;
		this.sleep = sleep;
		this.gender = gender;
	}
	
	public ResidentModel(String firstName, String middleName, String lastName) {

		this.actionListenerList = new ArrayList<ActionListener>();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.bed = null;
		this.mate1Name = "";
		this.mate2Name = "";
		this.mate3Name = "";
		this.mate1 = null;
		this.mate2 = null;
		this.mate3 = null;
		this.major = null;
		this.enrollment = null;
		this.hobbies = null;
		this.characteristics = null;
		this.seekedCharacteristics = null;
		this.floor = null;
		this.smoke = false;
		this.mindSmoke = false;
		this.smokeOut = false;
		this.mindSmokeOut = false;
		this.havePet = false;
		this.mindPet = false;
		this.pets = null;
		this.work = 0;
		this.neat = 0;
		this.personality = 0;
		this.social = 0;
		this.sleep = 0;
		this.gender = null;
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// Mutator Functions
	/////////////////////////////////////////////////////////////////////////////////////////

	public void setFirstName(String name) {
		this.firstName = name;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified First Name"));
	}

	public void setMiddleInitial(String name) {
		this.middleName = name;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Middle Name"));
	}

	public void setLastName(String name) {
		this.lastName = name;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Last Name"));
	}

	public void setBed(Bed bed) {
		this.bed = bed;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Bed"));
	}

	public void setMate1Name(String name) {
		this.mate1Name = name;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Roommate1 Name"));
	}

	public void setMate2Name(String name) {
		this.mate2Name = name;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Roommate2 Name"));
	}

	public void setMate3Name(String name) {
		this.mate3Name = name;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Roommate3 Name"));
	}

	public void setMate1(ResidentModel res) {
		this.mate1 = res;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Roommate 1"));
	}

	public void setMate2(ResidentModel res) {
		this.mate2 = res;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Roommate 2"));
	}

	public void setMate3(ResidentModel res) {
		this.mate3 = res;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Roommate 3"));
	}

	public void removeMate1() {
		this.mate1 = null;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Removed Roommate 1"));
	}

	public void removeMate2() {
		this.mate2 = null;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Removed Roommate 2"));
	}

	public void removeMate3() {
		this.mate3 = null;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Removed Roommate 3"));
	}

	public void setMajor(Major major) {
		this.major = major;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Major"));
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Enrollment"));
	}

	public void setHobbies(ArrayList<Hobby> hobbies) {
		this.hobbies = hobbies;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Hobbies"));
	}

	public void setHobbies() {
		hobbies = new ArrayList<Hobby>();
	}

	public void addHobby(Hobby hobby) {
		hobbies.add(hobby);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Added Hobby"));
	}

	public void setCharacteristics(ArrayList<Characteristic> characteristics) {
		this.characteristics = characteristics;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Characteristics"));
	}

	public void setCharacteristics() {
		characteristics = new ArrayList<Characteristic>();
	}

	public void addCharacteristic(Characteristic characteristic) {
		characteristics.add(characteristic);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Added Characteristic"));
	}

	public void setSeekedCharacteristics(ArrayList<Characteristic> characteristics) {
		this.seekedCharacteristics = characteristics;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Seeked Characteristics"));
	}

	public void setSeekedCharacteristics() {
		seekedCharacteristics = new ArrayList<Characteristic>();
	}

	public void addSeekedCharacteristic(Characteristic characteristic) {
		seekedCharacteristics.add(characteristic);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Added Seeked Characteristic"));
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Floor"));
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Smoke"));
	}

	public void setMindSmoke(boolean mindSmoke) {
		this.mindSmoke = mindSmoke;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Mind Smoke"));
	}

	public void setSmokeOut(boolean smokeOut) {
		this.smokeOut = smokeOut;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Smoke Out"));
	}

	public void setMindSmokeOut(boolean mindSmokeOut) {
		this.mindSmokeOut = mindSmokeOut;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Mind Smoke Out"));
	}

	public void setHavePet(boolean havePet) {
		this.havePet = havePet;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Have Pet"));
	}

	public void setMindPet(boolean mindPet) {
		this.mindPet = mindPet;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Mind Pet"));
	}

	public void setPet(ArrayList<Pet> pets) {
		this.pets = pets;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Pets"));
	}

	public void setPet() {
		this.pets = new ArrayList<Pet>();
	}

	public void setPet(Pet pet) {
		pets.add(pet);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Added Pet"));
	}

	public void setWork(int work) {
		this.work = work;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Work"));
	}

	public void setNeat(int neat) {
		this.neat = neat;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Neat"));
	}

	public void setPersonality(int personality) {
		this.personality = personality;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Personality"));
	}

	public void setSocial(int social) {
		this.social = social;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Social"));
	}

	public void setSleep(int sleep) {
		this.sleep = sleep;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Sleep"));
	}
	
	public void setGender(GenderPreference gender) {
		this.gender = gender;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Gender"));
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	// Accessor Functions
	/////////////////////////////////////////////////////////////////////////////////////////

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleInitial() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public Bed getBed() {
		return bed;
	}

	public String getMate1Name() {
		return mate1Name;
	}

	public String getMate2Name() {
		return mate2Name;
	}

	public String getMate3Name() {
		return mate3Name;
	}

	public ResidentModel getMate1() {
		return mate1;
	}

	public ResidentModel getMate2() {
		return mate2;
	}

	public ResidentModel getMate3() {
		return mate3;
	}

	public Major getMajor() {
		return major;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public ArrayList<Hobby> getHobbies() {
		return hobbies;
	}

	public String getHobbiesString() {
		String line = "";
		if (hobbies.size() == 0) {
			line = Hobby.OTHER.toString();
		} else {
			line = hobbies.get(0).toString();
		}
		for (int i = 1; i < hobbies.size(); ++i) {
			line += ", " + hobbies.get(i).toString();
		}
		return line;
	}

	public String getCharacteristicsString() {
		String line = "";
		if (characteristics.size() == 0) {
			line = Characteristic.OTHER.toString();
		} else {
			line = characteristics.get(0).toString();
		}
		for (int i = 1; i < characteristics.size(); ++i) {
			line += ", " + characteristics.get(i).toString();
		}
		return line;
	}

	public String getSeekedCharacteristicsString() {
		String line = "";
		if (seekedCharacteristics.size() == 0) {
			line = Characteristic.OTHER.toString();
		} else {
			line = seekedCharacteristics.get(0).toString();
		}
		for (int i = 1; i < seekedCharacteristics.size(); ++i) {
			line += ", " + seekedCharacteristics.get(i).toString();
		}
		return line;
	}

	public String getPetsString() {
		String line = "";
		if (pets.size() == 0) {
			line = Pet.NONE.toString();
		} else {
			line = pets.get(0).toString();
		}
		for (int i = 1; i < pets.size(); ++i) {
			line += ", " + pets.get(i).toString();
		}
		return line;
	}

	public ArrayList<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public ArrayList<Characteristic> getSeekedCharacteristics() {
		return seekedCharacteristics;
	}

	public Floor getFloor() {
		return floor;
	}

	public boolean getSmoke() {
		return smoke;
	}

	public boolean getMindSmoke() {
		return mindSmoke;
	}

	public boolean getSmokeOut() {
		return smokeOut;
	}

	public boolean getMindSmokeOut() {
		return mindSmokeOut;
	}

	public boolean getHavePet() {
		return havePet;
	}

	public boolean getMindPet() {
		return mindPet;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public int getWork() {
		return work;
	}

	public int getNeat() {
		return neat;
	}

	public int getPersonality() {
		return personality;
	}

	public int getSocial() {
		return social;
	}

	public int getSleep() {
		return sleep;
	}

	public GenderPreference getGender() {
		return gender;
	}
	
	public boolean partialMatch(ResidentModel res) {
		
		if(res.getFirstName().isEmpty() || res.getFirstName().equals(" ")) {
			return false;
		}
		
		String resName = res.getFirstName();
		if(!res.getMiddleInitial().isEmpty() && !res.getMiddleInitial().equals(" ")) {
			resName += " " + res.getMiddleInitial();
			}
		if(!res.getLastName().isEmpty() && !res.getLastName().equals(" ")) {
			resName += " " + res.getLastName();
		}
		String name = this.firstName + " " + this.middleName + " " + this.lastName;
		
		if((resName.length() > name.length())) {
			return false;
		}
		
		if(resName.toLowerCase().equals(name.toLowerCase()) || name.toLowerCase().contains(resName.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public int match(ResidentModel res) {
		int comp = 0;
		if (this.work > (res.getWork() - 3) && this.work < (res.getWork() + 3)) {
			comp++;
		}
		if (this.neat > (res.getNeat() - 3) && this.neat < (res.getNeat() + 3)) {
			comp++;
		}
		if (this.personality > (res.getPersonality() - 3) && this.personality < (res.getPersonality() + 3)) {
			comp++;
		}
		if (this.social > (res.getSocial() - 3) && this.social < (res.getSocial() + 3)) {
			comp++;
		}
		if (this.sleep > (res.getSleep() - 3) && this.sleep < (res.getSleep() + 3)) {
			comp++;
		}
		if (this.floor == res.getFloor()) {
			comp++;
		}
		for (int i = 0; i < characteristics.size(); ++i) {
			if (res.getCharacteristics().contains(seekedCharacteristics.get(i))) {
				comp++;
			}
		}
		for (int i = 0; i < hobbies.size(); ++i) {
			if (res.getHobbies().contains(hobbies.get(i))) {
				comp++;
			}
		}
		if (this.major == res.getMajor()) {
			comp++;
		}
		return comp;
	}

	public boolean equals(Object o) {

		ResidentModel m = (ResidentModel) o;
		if (firstName.equals(m.getFirstName()) && lastName.equals(m.getLastName())) {
			return true;
		}
		return false;
	}

	public int compareTo(ResidentModel residentModel) {
		int i = 0;
		while(i < this.getFirstName().length() && i < residentModel.getFirstName().length()) {
			if(this.getFirstName().charAt(i) < residentModel.getFirstName().charAt(i)) {
				return -1;
			}
			if(this.getFirstName().charAt(i) > residentModel.getFirstName().charAt(i)){
				return 1;
			}
			++i;
		}
		return 1;
	}

	public String toString() {
		return firstName + " " + middleName + " " + lastName + " - " + bed.toString() + " - " + major.toString() + " - "
				+ enrollment.toString();
	}

	public String toReadable() {
		String line = firstName + "," + middleName + "," + lastName + "," + bed.toString() + "," + major.toString()
				+ "," + enrollment.toString() + "," + floor.toString() + ",";
		if (smoke) {
			line += "1,";
		} else {
			line += "0,";
		}
		if (mindSmoke) {
			line += "1,";
		} else {
			line += "0,";
		}
		if (smokeOut) {
			line += "1,";
		} else {
			line += "0,";
		}
		if (mindSmokeOut) {
			line += "1,";
		} else {
			line += "0,";
		}
		if (havePet) {
			line += "1,";
		} else {
			line += "0,";
		}
		if (mindPet) {
			line += "1,";
		} else {
			line += "0,";
		}
		line += work + "," + neat + "," + personality + "," + social + "," + sleep + "," + mate1Name + "," + mate2Name
				+ "," + mate3Name + "," + hobbiesToReadable() + ",!," + petsToReadable() + ",!,"
				+ characteristicsToReadable() + ",!," + seekedCharacteristicsToReadable() + ",!\n";
		return line;
	}

	public String hobbiesToReadable() {
		String line = "";
		if (hobbies.size() > 0) {
			line = hobbies.get(0).toString();
		} else {
			line = Hobby.OTHER.toString();
		}
		for (int i = 1; i < hobbies.size(); ++i) {
			line += "," + hobbies.get(i).toString();
		}
		return line;
	}

	public String characteristicsToReadable() {
		String line = "";
		if (characteristics.size() > 0) {
			line = characteristics.get(0).toString();
		} else {
			line = Characteristic.OTHER.toString();
		}
		for (int i = 1; i < characteristics.size(); ++i) {
			line += "," + characteristics.get(i).toString();
		}
		return line;
	}

	public String seekedCharacteristicsToReadable() {
		String line = "";
		if (seekedCharacteristics.size() > 0) {
			line = seekedCharacteristics.get(0).toString();
		} else {
			line = Characteristic.OTHER.toString();
		}
		for (int i = 1; i < seekedCharacteristics.size(); ++i) {
			line += "," + seekedCharacteristics.get(i).toString();
		}
		return line;
	}

	public String petsToReadable() {
		String line = "";
		if (pets.size() > 0) {
			line = pets.get(0).toString();
		} else {
			line = Pet.NONE.toString();
		}
		for (int i = 1; i < pets.size(); ++i) {
			line += "," + pets.get(i).toString();
		}
		return line;
	}
	
	public void addActionListener(ActionListener l) {
		actionListenerList.add(l);
	}

	public void removeActionListener(ActionListener l) {
		actionListenerList.remove(l);
	}

	private void processEvent(ActionEvent e) {
		for (ActionListener actionListener : actionListenerList) {
			actionListener.actionPerformed(e);
		}
	}
}