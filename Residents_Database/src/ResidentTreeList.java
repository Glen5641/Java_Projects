import java.util.ArrayList;
import java.util.TreeSet;

public class ResidentTreeList {

	
	private String[] criteria = {};
	
	private ArrayList<TreeSet<ResidentModel>> ResidentTreeList;
	
	ResidentTreeList(ResidentDataBaseModel model) {

		students = new TreeSet<ResidentModel>();
		adults = new TreeSet<ResidentModel>();
		smokingTree = new TreeSet<ResidentModel>();
		outdoorSmokingTree = new TreeSet<ResidentModel>();
		nonSmokingTree = new TreeSet<ResidentModel>();
		petTree = new TreeSet<ResidentModel>();
		noPetTree = new TreeSet<ResidentModel>();
		
		for(int i = 0; i < model.size(); ++i) {
			addSmokingList(model.get(i));
			addPetList(model.get(i));
		}
		
		ResidentTreeList = new ArrayList<TreeSet<ResidentModel>>();
	}	
	
	public void addSmokingList(ResidentModel res) {
		if((res.getSmoke() && !res.getSmokeOut()) || !res.getMindSmoke()) {
			smokingTree.add(res);
		} else if (!res.getSmoke() && res.getMindSmokeOut() && res.getMindSmoke()) {
			nonSmokingTree.add(res);
		} else {
			nonSmokingTree.add(res);
		}
	}
	
	public void addPetList(ResidentModel res) {
		if(res.getHavePet() || !res.getMindPet()) {
			petTree.add(res);
		} if(!res.getHavePet() && !res.getMindPet()) {
			
		}
	}
	
}
