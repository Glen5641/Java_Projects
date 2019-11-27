import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Controller {

	private ResidentDataBaseModel residentDataBaseModel;
	private SelectionView selectionView;
	private DuplicatesView duplicatesView;
	private EditView editView;
	private AddView addView;
	private JDialog viewDialog;
	private DefaultListModel<ResidentModel> dup;

	public Controller() {
	}

	private class FileMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if ("Import".equals(actionEvent.getActionCommand())) {
				importData();
			}
			if ("Export".equals(actionEvent.getActionCommand())) {
				exportData();
			}
			if ("Exit".equals(actionEvent.getActionCommand())) {
				exitProgram();
			}
		}
	}

	public class ReplaceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			int[] indices = duplicatesView.getSelectedResidents();
			for (int i = 0; i < indices.length; ++i) {
				if (residentDataBaseModel.contains(dup.get(i))) {
					residentDataBaseModel.replace(dup.get(i));
				}
			}
			selectionView.setResidentDataBaseModel(residentDataBaseModel);
			selectionView.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Imported Data"));
			viewDialog.setVisible(false);
		}
	}

	public class ReplaceAllListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			DefaultListModel<ResidentModel> dup = duplicatesView.getResidents();
			ResidentModel model = null;
			for (int i = 0; i < dup.size(); ++i) {
				model = dup.get(i);
				if (residentDataBaseModel.contains(model)) {
					residentDataBaseModel.replace(model);
				}
			}
			selectionView.setResidentDataBaseModel(residentDataBaseModel);
			selectionView.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Imported Data"));
			viewDialog.setVisible(false);
		}
	}

	private class ResidentMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if ("Add Resident".equals(actionEvent.getActionCommand())) {
				viewDialog = new JDialog();
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
				}
				JDialog.setDefaultLookAndFeelDecorated(true);
				viewDialog.setTitle("Add Resident");
				addView = new AddView(residentDataBaseModel);
				addView.jbtOK.addActionListener(new AddResidentListener());
				viewDialog.add(addView);
				viewDialog.pack();
				viewDialog.setLocation(200, 200);
				viewDialog.setVisible(true);
			}
			if ("Edit Resident".equals(actionEvent.getActionCommand())) {
				int[] indices = selectionView.getSelectedResidents();
				if (0 == indices.length) {
					JOptionPane.showMessageDialog(selectionView, "No residents selected.", "Invalid Selection",
							JOptionPane.WARNING_MESSAGE);
				} else {
					// If there are selected news stories, go through the
					// process
					// for each.

					for (int index : indices) {
						ResidentModel selectedResident = null;
						if (!selectionView.isSearching()) {
							selectedResident = residentDataBaseModel.get(index);
						} else {
							selectedResident = selectionView.getSearchModel().get(index);
						}
						viewDialog = new JDialog();
						try {
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
								| UnsupportedLookAndFeelException e) {
						}
						JDialog.setDefaultLookAndFeelDecorated(true);
						viewDialog.setTitle("Edit Resident");
						editView = new EditView(residentDataBaseModel, selectedResident);
						editView.jbtOK.addActionListener(new EditResidentListener());
						viewDialog.add(editView);
						viewDialog.setSize(400, 400);
						viewDialog.setLocation(200, 200);
						viewDialog.setVisible(true);
					}
				}
			}
			if ("Delete Resident".equals(actionEvent.getActionCommand())) {
				deleteResidents();
			}
			if ("Delete Resident List".equals(actionEvent.getActionCommand())) {
				deleteResidentList();
			}
		}
	}

	private class DisplayMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if ("Matches".equals(actionEvent.getActionCommand())) {
				displayMatches();
			}
			if ("Potential Matches".equals(actionEvent.getActionCommand())) {
				displayPotentialMatches();
			}
		}
	}

	public class FilterMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {

			
			if ("Smoking".equals(actionEvent.getActionCommand())) {
				System.out.println("Hey");
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (residentDataBaseModel.get(i).getSmoke()) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("NonSmoking".equals(actionEvent.getActionCommand())) {
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (!residentDataBaseModel.get(i).getSmoke()) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("Yes".equals(actionEvent.getActionCommand())) {
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (residentDataBaseModel.get(i).getHavePet()) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("No".equals(actionEvent.getActionCommand())) {
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (!residentDataBaseModel.get(i).getHavePet()) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("2 Bed".equals(actionEvent.getActionCommand())) {
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (residentDataBaseModel.get(i).getBed().toInt() == 1) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("2 Bed Deluxe".equals(actionEvent.getActionCommand())) {
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (residentDataBaseModel.get(i).getBed().toInt() == 2) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("3 Bed-Open".equals(actionEvent.getActionCommand())) {
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (residentDataBaseModel.get(i).getBed().toInt() == 3) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("3 Bed-Closed".equals(actionEvent.getActionCommand())) {
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (residentDataBaseModel.get(i).getBed().toInt() == 4) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("4 Bed".equals(actionEvent.getActionCommand())) {
				selectionView.searchModel = new ResidentDataBaseModel();
				residentDataBaseModel = selectionView.residentDataBaseModel;
				for (int i = 0; i < residentDataBaseModel.size(); ++i) {
					if (residentDataBaseModel.get(i).getBed().toInt() == 5) {
						selectionView.searchModel.add(residentDataBaseModel.get(i));
					}
				}
				selectionView.filterRes();
			}

			if ("Remove Filter".equals(actionEvent.getActionCommand())) {
				selectionView.removeFilter();
			}
		}
	}

	public class AddResidentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (addView.jtfFirstName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(viewDialog, "Please Enter First Name.", "Invalid First Name",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (addView.jtfMiddleInitial.getText().isEmpty()) {
					JOptionPane.showMessageDialog(viewDialog, "Please Enter Middle Initial.", "Invalid Middle Initial",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (addView.jtfLastName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(viewDialog, "Please Enter Last Name.", "Invalid Last Name",
								JOptionPane.WARNING_MESSAGE);
					} else {
						addResident();
						viewDialog.setVisible(false);
						selectionView.setResidentDataBaseModel(residentDataBaseModel);
						selectionView.actionPerformed(
								new ActionEvent(addView.jtfFirstName, ActionEvent.ACTION_PERFORMED, "OK"));
					}
				}
			}
		}
	}

	public class EditResidentListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			editResidents();
			selectionView.setResidentDataBaseModel(residentDataBaseModel);
			selectionView.actionPerformed(new ActionEvent(editView.jtfFirstName, ActionEvent.ACTION_PERFORMED, "OK"));
		}
	}

	public void setResidentDataBaseModel(ResidentDataBaseModel DBModel) {
		this.residentDataBaseModel = DBModel;
	}

	public void setSelectionView(SelectionView SView) {
		this.selectionView = SView;
		selectionView.registerFileMenuListener(new FileMenuListener());
		selectionView.registerResidentMenuListener(new ResidentMenuListener());
		selectionView.registerDisplayMenuListener(new DisplayMenuListener());
		selectionView.registerFilterMenuListener(new FilterMenuListener());
	}

	private void importData() {
		String dataFile = null;

		JFileChooser fileChooser = new JFileChooser(".");
		int returnVal = fileChooser.showOpenDialog(selectionView);
		String fileName = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			try {
				fileName = fileChooser.getSelectedFile().getCanonicalPath();
				dataFile = fileName;
			} catch (IOException | StringIndexOutOfBoundsException s) {
				JOptionPane.showMessageDialog(selectionView, "Wrong file Selection", "Invalid Selection",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		dup = new DefaultListModel<ResidentModel>();

		if (residentDataBaseModel.isEmpty()) {
			try {
				residentDataBaseModel = FileProcessor.readFile(dataFile);
				selectionView.setResidentDataBaseModel(residentDataBaseModel);
				selectionView.enableAllMenus();
			} catch (IOException | NullPointerException | StringIndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(selectionView, "Invalid File Choices", "Invalid File",
						JOptionPane.WARNING_MESSAGE);
			}
			fileName = null;
		} else {
			ResidentDataBaseModel aux = null;
			try {
				aux = FileProcessor.readFile(dataFile);
			} catch (IOException e) {

			}
			for (int i = 0; i < aux.size(); ++i) {
				if (!residentDataBaseModel.contains(aux.get(i))) {
					residentDataBaseModel.add(aux.get(i));
				} else {
					dup.addElement(aux.get(i));
				}
			}
			if (dup.size() > 0) {
				viewDialog = new JDialog();
				// try {
				// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				// } catch (ClassNotFoundException | InstantiationException |
				// IllegalAccessException | UnsupportedLookAndFeelException e) {
				// }
				JDialog.setDefaultLookAndFeelDecorated(true);
				viewDialog.setTitle("Duplicate Residents");
				duplicatesView = new DuplicatesView(dup);
				duplicatesView.jbAll.addActionListener(new ReplaceAllListener());
				duplicatesView.jbReplace.addActionListener(new ReplaceAllListener());
				viewDialog.add(duplicatesView);
				viewDialog.setLocation(200, 200);
				viewDialog.pack();
				viewDialog.setVisible(true);
			}
		}
		residentDataBaseModel.sort();
		selectionView.setResidentDataBaseModel(residentDataBaseModel);
		selectionView.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Imported Data"));
	}

	public void resetViewDialogSize() {
		viewDialog.pack();
	}

	private void exportData() {
		JFileChooser fileChooser = new JFileChooser(".");
		int returnVal = fileChooser.showOpenDialog(selectionView);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = null;
			try {
				fileName = fileChooser.getSelectedFile().getCanonicalPath();
				FileWriter outfile = new FileWriter(fileName);
				BufferedWriter bw = new BufferedWriter(outfile);
				String listOfResidents = "HeaderLine \n";
				for (int i = 0; i < residentDataBaseModel.getResidents().getSize(); ++i) {
					listOfResidents += residentDataBaseModel.getResidents().get(i).toReadable();
				}
				bw.write(listOfResidents);
				bw.newLine();
				bw.close();
			} catch (IOException i) {
				JOptionPane.showMessageDialog(selectionView, "Error Occured in writing file", "System Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void exitProgram() {
		if (!residentDataBaseModel.isEmpty()) {
			Driver.saveData();
		}
	}

	private void addResident() {

		try {
			String firstName = addView.jtfFirstName.getText();
			String middleName = addView.jtfMiddleInitial.getText();
			String lastName = addView.jtfLastName.getText();
			Bed bed = (Bed) addView.jcbBedList.getSelectedItem();
			String mate1 = addView.jtfMate1.getText();
			String mate2 = addView.jtfMate2.getText();
			String mate3 = addView.jtfMate3.getText();
			Major major = (Major) addView.jcbMajorList.getSelectedItem();
			Enrollment enrollment = (Enrollment) addView.jcbEnrollmentList.getSelectedItem();
			Floor floor = (Floor) addView.jcbFloorList.getSelectedItem();

			boolean smoke, mindSmoke, smokeOut, mindSmokeOut, havePet, mindPet;
			if (addView.jcbSmokey.isSelected()) {
				smoke = true;
			} else {
				smoke = false;
			}
			if (addView.jcbMindSmokey.isSelected()) {
				mindSmoke = true;
			} else {
				mindSmoke = false;
			}
			if (addView.jcbSmokeOuty.isSelected()) {
				smokeOut = true;
			} else {
				smokeOut = false;
			}
			if (addView.jcbMindSmokeOuty.isSelected()) {
				mindSmokeOut = true;
			} else {
				mindSmokeOut = false;
			}
			if (addView.jcbHavePety.isSelected()) {
				havePet = true;
			} else {
				havePet = false;
			}
			if (addView.jcbMindPety.isSelected()) {
				mindPet = true;
			} else {
				mindPet = false;
			}

			ArrayList<Pet> pets = (ArrayList<Pet>) addView.jlPetList.getSelectedValuesList();
			ArrayList<Hobby> hobbies = (ArrayList<Hobby>) addView.jlHobbyList.getSelectedValuesList();
			ArrayList<Characteristic> characteristics = (ArrayList<Characteristic>) addView.jlCharacteristicsList
					.getSelectedValuesList();
			ArrayList<Characteristic> seekedCharacteristics = (ArrayList<Characteristic>) addView.jlSeekedCharacteristicsList
					.getSelectedValuesList();
			int work = (int) addView.jcbWorkList.getSelectedItem();
			int neat = (int) addView.jcbNeatList.getSelectedItem();
			int personality = (int) addView.jcbPersonalityList.getSelectedItem();
			int social = (int) addView.jcbSocialList.getSelectedItem();
			int sleep = (int) addView.jcbSleepList.getSelectedItem();
			GenderPreference gender = (GenderPreference) addView.jcbGenderList.getSelectedItem();

			ResidentModel res = new ResidentModel(firstName, middleName, lastName, bed, mate1, mate2, mate3, major,
					enrollment, hobbies, characteristics, seekedCharacteristics, floor, smoke, mindSmoke, smokeOut,
					mindSmokeOut, havePet, mindPet, pets, work, neat, personality, social, sleep, gender);

			if (!residentDataBaseModel.equalsExistingResident(res)) {
				residentDataBaseModel.add(res);
			} else {
				int choice = JOptionPane.showConfirmDialog(null, "Resident Already Exists. Do you want to Replace?",
						"Existing Resident", JOptionPane.YES_NO_OPTION);
				if (choice == 0) {
					residentDataBaseModel.replace(res);
				}
			}

			residentDataBaseModel.sort();
			selectionView.setResidentDataBaseModel(residentDataBaseModel);
			selectionView.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
		} catch (NullPointerException n) {

		}
	}

	private void editResidents() {

		residentDataBaseModel.remove(editView.residentModel);
		String firstName = editView.jtfFirstName.getText();
		String middleName = editView.jtfMiddleInitial.getText();
		String lastName = editView.jtfLastName.getText();
		Bed bed = (Bed) editView.jcbBedList.getSelectedItem();
		Major major = (Major) editView.jcbMajorList.getSelectedItem();
		Enrollment enrollment = (Enrollment) editView.jcbEnrollmentList.getSelectedItem();
		Floor floor = (Floor) editView.jcbFloorList.getSelectedItem();
		String mate1 = editView.jtfMate1.getText();
		String mate2 = editView.jtfMate2.getText();
		String mate3 = editView.jtfMate3.getText();
		boolean smoke = true, mindSmoke = true, smokeOut = true, mindSmokeOut = true, havePet = true, mindPet = true;
		if (editView.jcbSmokey.isSelected()) {
			smoke = true;
		} else {
			smoke = false;
		}

		if (editView.jcbSmokeOuty.isSelected()) {
			smokeOut = true;
		} else {
			smokeOut = false;
		}

		if (editView.jcbMindSmokey.isSelected()) {
			mindSmoke = true;
		} else {
			mindSmoke = false;
		}

		if (editView.jcbMindSmokeOuty.isSelected()) {
			mindSmokeOut = true;
		} else {
			mindSmokeOut = false;
		}

		if (editView.jcbHavePety.isSelected()) {
			havePet = true;
		} else {
			havePet = false;
		}

		ArrayList<Pet> pets = new ArrayList<Pet>();
		for (int i = 0; i < editView.jlPetList.getSelectedValuesList().size(); ++i) {
			pets.add(editView.jlPetList.getSelectedValuesList().get(i));
		}

		if (editView.jcbMindPety.isSelected()) {
			mindPet = true;
		} else {
			mindPet = false;
		}

		int work = (int) editView.jcbWorkList.getSelectedItem();
		int neat = (int) editView.jcbNeatList.getSelectedItem();
		int personality = (int) editView.jcbPersonalityList.getSelectedItem();
		int social = (int) editView.jcbSocialList.getSelectedItem();
		int sleep = (int) editView.jcbSleepList.getSelectedItem();
		
		
		ArrayList<Hobby> hobbies = new ArrayList<Hobby>();
		for (int i = 0; i < editView.jlHobbyList.getSelectedValuesList().size(); ++i) {
			hobbies.add(editView.jlHobbyList.getSelectedValuesList().get(i));
		}
		ArrayList<Characteristic> characteristics = new ArrayList<Characteristic>();
		for (int i = 0; i < editView.jlCharacteristicsList.getSelectedValuesList().size(); ++i) {
			characteristics.add(editView.jlCharacteristicsList.getSelectedValuesList().get(i));
		}
		ArrayList<Characteristic> seekedCharacteristics = new ArrayList<Characteristic>();
		for (int i = 0; i < editView.jlSeekedCharacteristicsList.getSelectedValuesList().size(); ++i) {
			seekedCharacteristics.add(editView.jlSeekedCharacteristicsList.getSelectedValuesList().get(i));
		}

		GenderPreference gender = (GenderPreference) addView.jcbGenderList.getSelectedItem();
		
		ResidentModel res = new ResidentModel(firstName, middleName, lastName, bed, mate1, mate2, mate3, major,
				enrollment, hobbies, characteristics, seekedCharacteristics, floor, smoke, mindSmoke, smokeOut,
				mindSmokeOut, havePet, mindPet, pets, work, neat, personality, social, sleep, gender);
		residentDataBaseModel.add(res);

		residentDataBaseModel.sort();
		selectionView.setResidentDataBaseModel(residentDataBaseModel);
		selectionView.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
		viewDialog.setVisible(false);
	}

	private void deleteResidents() {

		// Get all indices for selected residents
		int[] indices = selectionView.getSelectedResidents();
		if (indices.length == residentDataBaseModel.size()) {
			this.deleteResidentList();
		}
		DefaultListModel<ResidentModel> list = new DefaultListModel<ResidentModel>();
		// Remove residents from list
		try {
			for (int ctr = 0; ctr < indices.length; ++ctr) {
				if (!selectionView.isSearching()) {
					list.addElement(residentDataBaseModel.get(indices[ctr]));
				} else {
					list.addElement(selectionView.getSearchModel().get(indices[ctr]));
				}
			}
			residentDataBaseModel.removeListOfresidents(list);
		} catch (IllegalArgumentException i) {

		}
		if (!residentDataBaseModel.isEmpty()) {
			residentDataBaseModel.sort();
		}
		selectionView.setResidentDataBaseModel(residentDataBaseModel);
		selectionView.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
	}

	private void deleteResidentList() {

		residentDataBaseModel.removeAllresidents();
		residentDataBaseModel = new ResidentDataBaseModel();
		selectionView.setResidentDataBaseModel(residentDataBaseModel);
		selectionView.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
	}

	private void displayMatches() {

	}

	private void displayPotentialMatches() {

	}
}
