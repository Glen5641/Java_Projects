import java.util.TreeSet;

public class ResidentMatchingList {

	// Tier 1
	TreeSet<ResidentModel> twoBed;
	TreeSet<ResidentModel> twoBedDeluxe;
	TreeSet<ResidentModel> threeBedOpen;
	TreeSet<ResidentModel> threeBedClosed;
	TreeSet<ResidentModel> fourBed;

	// Tier 2
	TreeSet<ResidentModel> inSchool;
	TreeSet<ResidentModel> outSchool;

	// Tier 3
	TreeSet<ResidentModel> male;
	TreeSet<ResidentModel> female;
	TreeSet<ResidentModel> coed;
	TreeSet<ResidentModel> otherGender;

	TreeSet<ResidentModel> firstFloorOnly;
	TreeSet<ResidentModel> firstFloor;
	TreeSet<ResidentModel> secondFloor;
	TreeSet<ResidentModel> thirdFloor;

	// Tier 4
	TreeSet<ResidentModel> smokeInners;
	TreeSet<ResidentModel> dontMindSmokers;

	TreeSet<ResidentModel> smokeOuters;
	TreeSet<ResidentModel> dontMindSmokeOuters;

	TreeSet<ResidentModel> nonSmokers;
	TreeSet<ResidentModel> mindSmokers;
	TreeSet<ResidentModel> mindSmokeOuters;

	TreeSet<ResidentModel> petters;
	TreeSet<ResidentModel> dontMindPetters;

	TreeSet<ResidentModel> nonPetters;
	TreeSet<ResidentModel> mindPetters;

	TreeSet<TreeSet<ResidentModel>> matchedRoommates;

	public ResidentMatchingList(ResidentDataBaseModel model) {
		ResidentModel res;
		
		for (int i = 0; i < model.size(); ++i) {
			res = model.get(i);
			addResident(res);			
		}
	}
	
	public void addResident(ResidentModel res) {
		this.setBed(res);
		this.setSchool(res);
		this.setGender(res);
		this.setFloor(res);
		this.setPet(res);
		this.setSmoke(res);
	}
	
	
	
	private void setBed(ResidentModel res){
		int num;
		num = res.getBed().toInt();
		switch (num) {
		case 5:
			fourBed.add(res);
		case 4:
			threeBedClosed.add(res);
		case 3:
			threeBedOpen.add(res);
		case 2:
			twoBedDeluxe.add(res);
		case 1:
			twoBed.add(res);
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void setSchool(ResidentModel res) {
		int num;
		num = res.getEnrollment().toInt();
		switch (num) {
		case 7: outSchool.add(res);
		case 6:
		case 5:
		case 4:
		case 3:
		case 2:
		case 1: inSchool.add(res);
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void setGender(ResidentModel res) {
		int num;
		num = res.getGender().toInt();
		switch (num) {
		case 3: coed.add(res);
		case 2: female.add(res);
		case 1: male.add(res);
		case 0: otherGender.add(res);
		default:
			throw new IllegalArgumentException();
		}
	}
	
	private void setFloor(ResidentModel res) {
		int num;
		num = res.getFloor().toInt();
		switch (num) {
		case 4: thirdFloor.add(res);
		case 3: secondFloor.add(res);
		case 2: firstFloor.add(res); 
		case 1: firstFloorOnly.add(res);
		case 0: {firstFloor.add(res); secondFloor.add(res); thirdFloor.add(res);}
		default:
			throw new IllegalArgumentException();
		}
	}

	private void setSmoke(ResidentModel res) {
		if(res.getSmoke()) {
			dontMindSmokeOuters.add(res);
			dontMindSmokers.add(res);
			if(res.getSmokeOut()) {
				smokeOuters.add(res);
			} else {
				smokeInners.add(res);
			}
		} else {
			nonSmokers.add(res);
			if(res.getMindSmoke()) {
				mindSmokers.add(res);
			} else {
				dontMindSmokers.add(res);
			}
			if(res.getMindSmokeOut()) {
				mindSmokeOuters.add(res);
			} else {
				dontMindSmokeOuters.add(res);
			}
		}
	}
	
	private void setPet(ResidentModel res) {
		if(res.getHavePet()) {
			petters.add(res);
		} else {
			nonPetters.add(res);
		}
		if(res.getMindPet()) {
			mindPetters.add(res);
		} else {
			dontMindPetters.add(res);
		}
	}

}
