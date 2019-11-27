import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Driver implements ActionListener {
	static private HashMap<String, String> passwords;
	static private ResidentDataBaseModel residentDataBaseModel;
	static private SelectionView selectionView;
	static private LoginView loginView;
	static private Controller controller;
	static String fileName = "C:\\Users\\The Commons\\Documents\\Occupoint_Program_files\\data.txt";

	public static void main(String[] args) {

		// Create the M, V, and C
		passwords = new HashMap<String, String>();
		passwords.put("glen5641", "Ftrwurbg_1");
		passwords.put("commons", " ");
		residentDataBaseModel = new ResidentDataBaseModel();
		loadData();
		loginView = new LoginView();
		loginView.setPasswords(passwords);
	}

	@SuppressWarnings("unchecked")
	public static void loadData() {
		try {
			FileInputStream fileInputStream = new FileInputStream(fileName);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			DefaultListModel<ResidentModel> residents = ((DefaultListModel<ResidentModel>) objectInputStream
					.readObject());
			for (int i = 0; i < residents.size(); ++i) {

				residentDataBaseModel.add(residents.get(i));
			}
			residentDataBaseModel.sort();
			objectInputStream.close();
		} catch (ClassNotFoundException | IOException | ClassCastException e) {
			JOptionPane.showMessageDialog(selectionView, "Problem occurred Loading Data", "System Error",
					JOptionPane.WARNING_MESSAGE);
			try {
				FileInputStream fileInputStream = new FileInputStream("data.txt");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

				DefaultListModel<ResidentModel> residents = ((DefaultListModel<ResidentModel>) objectInputStream
						.readObject());
				for (int i = 0; i < residents.size(); ++i) {

					residentDataBaseModel.add(residents.get(i));
				}
				residentDataBaseModel.sort();
				objectInputStream.close();
			} catch (ClassNotFoundException | IOException | ClassCastException j) {
				JOptionPane.showMessageDialog(selectionView, "Problem occurred Loading Data", "System Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	public static void setMVC() {
		selectionView = new SelectionView(residentDataBaseModel);
		controller = new Controller();

		// Make them aware of each other
		controller.setSelectionView(selectionView);
		selectionView.setResidentDataBaseModel(residentDataBaseModel);
		controller.setResidentDataBaseModel(residentDataBaseModel);

		selectionView.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				saveData();
			}
		});
	}

	public static void saveData() {
		if (JOptionPane.showConfirmDialog(selectionView, "Are you sure to close this window?", "Really Closing?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(fileName);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(selectionView.residentDataBaseModel.getResidents());
				objectOutputStream.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(selectionView, "Problem occurred Saving Data", "System Error",
						JOptionPane.WARNING_MESSAGE);
				try {
					FileOutputStream fileOutputStream = new FileOutputStream("data.txt");
					ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
					objectOutputStream.writeObject(selectionView.residentDataBaseModel.getResidents());
					objectOutputStream.close();
				} catch (IOException i) {
				}
			}
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
