import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;

public class ResidentDataBaseModel implements Serializable {

	private static final long serialVersionUID = 7876369843726837770L;
	private ArrayList<ActionListener> actionListenerList = new ArrayList<ActionListener>();
	private DefaultListModel<ResidentModel> residentListModel;

	public ResidentDataBaseModel() {

		this.residentListModel = new DefaultListModel<ResidentModel>();
	}

	public ResidentDataBaseModel(ResidentDataBaseModel residentListModel) {

		this.residentListModel = residentListModel.getResidents();
	}

	public boolean isEmpty() {

		if (residentListModel.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return residentListModel.size();
	}

	public boolean equalsExistingResident(ResidentModel residentModel) {
		for (int i = 0; i < residentListModel.size(); ++i) {
			if (residentListModel.get(i).equals(residentModel)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(ResidentModel residentModel) {
		if (residentListModel.contains(residentModel)) {
			return true;
		} else {
			return false;
		}
	}

	public ResidentModel get(ResidentModel residentModel) {
		int index = residentListModel.indexOf(residentModel);
		if (index > -1) {
			return residentListModel.get(index);
		} else {
			return null;
		}
	}

	public DefaultListModel<ResidentModel> getResidents() {
		return residentListModel;
	}

	public ResidentModel get(int index) {
		if (index > -1 && index < residentListModel.size()) {
			return residentListModel.get(index);
		} else {
			throw new IllegalArgumentException("Search index out of bounds");
		}
	}

	public String[] getresidentNames() {
		int size = residentListModel.size();
		String[] result = new String[size];
		for (int i = 0; i < size; ++i) {
			result[i] = residentListModel.get(i).getFirstName() + " " + residentListModel.get(i).getMiddleInitial()
					+ " " + residentListModel.get(i).getLastName();
		}
		return result;
	}

	public void add(ResidentModel residentModel) {
		if (!residentListModel.contains(residentModel)) {
			residentListModel.addElement(residentModel);
		}
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Resident List"));
	}

	public void replace(ResidentModel residentModel) {
		if (!(residentListModel.contains(residentModel)) || residentModel.getFirstName().toLowerCase().equals("n")) {
			throw new IllegalArgumentException();
		}
		remove(residentModel);
		residentListModel.addElement(residentModel);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Resident List"));
	}

	public void remove(ResidentModel residentModel) {
		
		ResidentModel targetResidentModel = null;
		for (int i = 0; i < residentListModel.size(); ++i) {
			if (residentListModel.get(i).equals(residentModel)) {
				targetResidentModel = residentListModel.get(i);
			}
		}

		if (targetResidentModel == null) {
			return;
		}

		if (targetResidentModel.getMate1() != null) {
			ResidentModel res = targetResidentModel.getMate1();
			if (res.getMate1() == targetResidentModel) {
				res.setMate1(null);
			} else if (res.getMate2() == targetResidentModel) {
				res.setMate2(null);
			} else {
				res.setMate3(null);
			}
			targetResidentModel.setMate1(null);
		}

		if (targetResidentModel.getMate2() != null) {
			ResidentModel res = targetResidentModel.getMate2();
			if (res.getMate1() == targetResidentModel) {
				res.setMate1(null);
			} else if (res.getMate2() == targetResidentModel) {
				res.setMate2(null);
			} else {
				res.setMate3(null);
			}
			targetResidentModel.setMate2(null);
		}

		if (targetResidentModel.getMate3() != null) {
			ResidentModel res = targetResidentModel.getMate3();
			if (res.getMate1() == targetResidentModel) {
				res.setMate1(null);
			} else if (res.getMate2() == targetResidentModel) {
				res.setMate2(null);
			} else {
				res.setMate3(null);
			}
			targetResidentModel.setMate3(null);
		}

		residentListModel.removeElement(targetResidentModel);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Resident List"));

	}

	public void removeListOfresidents(DefaultListModel<ResidentModel> residents) {
		for (int i = 0; i < residentListModel.size(); ++i) {
			try {
				remove(residents.get(i));
			} catch (ArrayIndexOutOfBoundsException a) {

			}
		}
	}

	public void removeAllresidents() {
		while (!residentListModel.isEmpty()) {
			remove(residentListModel.get(0));
		}

	}

	public void setresidentsFromResidentList(ResidentDataBaseModel residentListModel) {
		this.residentListModel = residentListModel.residentListModel;
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Resident List"));
	}

	public void sort() {
		ArrayList<ResidentModel> aux = new ArrayList<ResidentModel>();
		for (int i = 0; i < residentListModel.size(); ++i) {
			aux.add(residentListModel.get(i));
		}
		Collections.sort(aux);
		residentListModel.clear();
		for (ResidentModel resident : aux) {
			residentListModel.addElement(resident);
		}
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Modified Resident List"));

	}
	
	public ResidentDataBaseModel getResFromPartial(String name) {
		if(name.isEmpty() || name.charAt(0) == ' ') {
			return this;
		}
		
		StringBuilder first = new StringBuilder("");
		StringBuilder middle = new StringBuilder("");
		StringBuilder last = new StringBuilder("");
		
		int i = 0;
		while(i < name.length() && name.charAt(i) != ' ') {
			first.append(name.charAt(i));
			++i;
		}
		if(i < name.length()) {
			++i;
			while(i < name.length() && name.charAt(i) != ' ') {
				middle.append(name.charAt(i));
				++i;
			}
			if(i < name.length()) {
				++i;
				while(i < name.length() && name.charAt(i) != ' ') {
					last.append(name.charAt(i));
					++i;
				}
			} else {
				last.append(" ");
			}
		} else {
			middle.append(" ");
		}
		
		ResidentDataBaseModel model = new ResidentDataBaseModel();
		
		ResidentModel res = new ResidentModel(first.toString(), middle.toString(), last.toString());
		
		for(i = 0; i < this.residentListModel.size(); ++i) {
			if(this.residentListModel.get(i).partialMatch(res)) {
				model.add(this.residentListModel.get(i));
			}
		}
		return model;
	}

	public void addActionListener(ActionListener l) {
		actionListenerList.add(l);
	}

	public void removeActionListener(ActionListener l) {
		actionListenerList.remove(l);
	}

	private void processEvent(ActionEvent e) {
		for (int i = 0; i < actionListenerList.size(); ++i) {
			actionListenerList.get(i).actionPerformed(e);
		}
	}
}
