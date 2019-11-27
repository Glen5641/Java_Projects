import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SelectionView extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	ResidentDataBaseModel residentDataBaseModel;
	ResidentDataBaseModel searchModel;

	// Menu bar for selection view
	private JMenuBar jmbMenu = new JMenuBar();

	// Components for menu bar.
	private JMenu jmFile = new JMenu("File");
	private JMenuItem jmiImport = new JMenuItem("Import");
	private JMenuItem jmiExport = new JMenuItem("Export");
	private JMenuItem jmiExit = new JMenuItem("Exit");

	// All resident components
	private JMenu jmResident = new JMenu("Resident");
	private JMenuItem jmiAddResident = new JMenuItem("Add Resident");
	private JMenuItem jmiEditResident = new JMenuItem("Edit Resident");
	private JMenuItem jmiDeleteResident = new JMenuItem("Delete Resident");
	private JMenuItem jmiDeleteResidentList = new JMenuItem("Delete Resident List");

	// All display components
	private JMenu jmDisplay = new JMenu("Display");
	private JMenuItem jmiMatches = new JMenuItem("Matches");
	private JMenuItem jmiPotentialMatches = new JMenuItem("Potential Matches");
	
	// All Filter components
	private JMenu jmFilter = new JMenu("Filter");
	private JMenu jmiSmoke = new JMenu("Smoke");
	private JMenuItem jmiSmokey = new JMenuItem("Smoking");
	private JMenuItem jmiSmoken = new JMenuItem("NonSmoking");
	private JMenu jmiPet = new JMenu("Pet");
	private JMenuItem jmiPety = new JMenuItem("Yes");
	private JMenuItem jmiPetn = new JMenuItem("No");
	private JMenu jmiBed = new JMenu("Bed Plan");
	private JMenuItem jmi2Bed = new JMenuItem("2 Bed");
	private JMenuItem jmi2Bedd = new JMenuItem("2 Bed Deluxe");
	private JMenuItem jmi3Bedo = new JMenuItem("3 Bed-Open");
	private JMenuItem jmi3Bedc = new JMenuItem("3 Bed-Closed");
	private JMenuItem jmi4Bed = new JMenuItem("4 Bed");
	private JMenuItem jmiRemoveFilter = new JMenuItem("Remove Filter");

	JLabel jlsize = new JLabel();
	JTextField jtfSearch = new JTextField("");
	JPanel jpSearch = new JPanel(new GridBagLayout());
	JLabel res = new JLabel("Residents");
	JLabel selres = new JLabel("Selected Resident");
	JPanel s = new JPanel(new BorderLayout());
	
	// All components for news maker list
	private JList<ResidentModel> jlResidentList;
	private JScrollPane jspResidentList;
	private JPanel jpResidentList = new JPanel(new BorderLayout());

	private JPanel jpResidentInfo = new JPanel(new GridBagLayout());
	JLabel jlName = new JLabel("Name: ");
	JLabel jlBed = new JLabel("Bed Plan : ");
	JLabel jlMajor = new JLabel("Major: ");
	JLabel jlEnrollment = new JLabel("Enrollment: ");
	JLabel jlFloor = new JLabel("Floor: ");
	JLabel jlSmoke = new JLabel("Smoking: ");
	JLabel jlSmokeOut = new JLabel("Outdoor Smoking: ");
	JLabel jlHavePet = new JLabel("Pet: ");
	JLabel jlMindSmoke = new JLabel("Mind Smoke: ");
	JLabel jlMindSmokeOut = new JLabel("Mind Outdoor Smoking: ");
	JLabel jlMindPet = new JLabel("Mind Pet: ");
	JLabel jlWork = new JLabel("Work Habits: ");
	JLabel jlNeat = new JLabel("Neatness: ");
	JLabel jlPersonality = new JLabel("Personality: ");
	JLabel jlSocial = new JLabel("Social Habits: ");
	JLabel jlSleep = new JLabel("Sleep Habits: ");
	JLabel jlHobbies = new JLabel("Hobbies: ");
	JLabel jlCharacteristics = new JLabel("Characteristics: ");
	JLabel jlSeekedCharacteristics = new JLabel("Seeked Characteristics: ");
	JLabel jlMate1 = new JLabel("Roommate 1: ");
	JLabel jlMate2 = new JLabel("Roommate 2: ");
	JLabel jlMate3 = new JLabel("Roommate 3: ");
	JLabel jlPets = new JLabel("Pets: ");
	JLabel jlGender = new JLabel("Gender Preference: ");

	JPanel jpRes = new JPanel(new BorderLayout());

	GridBagConstraints c = new GridBagConstraints();

	/**
	 * Constructor for selection view that sets a frame for the UI
	 */
	public SelectionView(ResidentDataBaseModel residentDataBaseModel) {

		this.residentDataBaseModel = residentDataBaseModel;

		res.setFont(new Font("Arial", Font.BOLD, 20));
		selres.setFont(new Font("Calibri", Font.BOLD, 20));
		jlsize.setText("Size: " + residentDataBaseModel.size());
		
		setFrame();
		setButtonBorders();
		setResidentList();
		setSearchDocListener();
		setUI();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.WEST;
		
		addComponent(s, new JLabel("Search"), BorderLayout.WEST);
		addComponent(s, jtfSearch, BorderLayout.CENTER);
		addComponent(jmFile, jmiImport);
		addComponent(jmFile, jmiExport);
		addComponent(jmFile, jmiExit);
		addComponent(jmbMenu, jmFile);
		addComponent(jmResident, jmiAddResident);
		addComponent(jmResident, jmiEditResident);
		addComponent(jmResident, jmiDeleteResident);
		addComponent(jmResident, jmiDeleteResidentList);
		addComponent(jmbMenu, jmResident);
		addComponent(jmDisplay, jmiMatches);
		addComponent(jmDisplay, jmiPotentialMatches);
		addComponent(jmbMenu, jmDisplay);
		addComponent(jmiSmoke, jmiSmokey);
		addComponent(jmiSmoke, jmiSmoken);
		addComponent(jmFilter, jmiSmoke);
		addComponent(jmiPet, jmiPety);
		addComponent(jmiPet, jmiPetn);
		addComponent(jmFilter, jmiPet);
		addComponent(jmiBed, jmi2Bed);
		addComponent(jmiBed, jmi2Bedd);
		addComponent(jmiBed, jmi3Bedo);
		addComponent(jmiBed, jmi3Bedc);
		addComponent(jmiBed, jmi4Bed);
		addComponent(jmFilter, jmiBed);
		addComponent(jmFilter, jmiRemoveFilter);
		addComponent(jmbMenu, jmFilter);
		addComponent(jpSearch, res, 1, 0, 1, 1, 0, 0, 1, 0);
		addComponent(jpSearch, jlsize, 2, 0);
		addComponent(jpSearch, new JLabel(), 3, 0);
		addComponent(jpSearch, new JLabel(), 4, 0);
		addComponent(jpSearch, new JLabel(), 5, 0);
		addComponent(jpSearch, s, 6, 0, 2, 1, 0, 0, 1, 0);
		addComponent(jpResidentList, jspResidentList, BorderLayout.CENTER);
		addComponent(jpRes, selres, BorderLayout.WEST);
		addComponent(jpResidentInfo, jlName, 1, 1, 2, 1, 0, 1, 1, 0);
		addComponent(jpResidentInfo, jlBed, 1, 2);
		addComponent(jpResidentInfo, jlGender, 1, 3);
		addComponent(jpResidentInfo, jlEnrollment, 1, 4);
		addComponent(jpResidentInfo, jlFloor, 1, 5);
		addComponent(jpResidentInfo, jlMate1, 1, 6);
		addComponent(jpResidentInfo, jlMate2, 1, 7);
		addComponent(jpResidentInfo, jlMate3, 1, 8);
		addComponent(jpResidentInfo, jlMajor, 3, 1);
		addComponent(jpResidentInfo, jlSmoke, 3, 2);
		addComponent(jpResidentInfo, jlSmokeOut, 3, 3);
		addComponent(jpResidentInfo, jlMindSmoke, 3, 4);
		addComponent(jpResidentInfo, jlMindSmokeOut, 3, 5);
		addComponent(jpResidentInfo, jlHavePet, 3, 6);
		addComponent(jpResidentInfo, jlMindPet, 3, 7);
		addComponent(jpResidentInfo, jlPets, 3, 8);
		addComponent(jpResidentInfo, jlWork, 5, 1);
		addComponent(jpResidentInfo, jlNeat, 5, 2);
		addComponent(jpResidentInfo, jlPersonality, 5, 3);
		addComponent(jpResidentInfo, jlSocial, 5, 4);
		addComponent(jpResidentInfo, jlSleep, 5, 5);
		addComponent(jpResidentInfo, jlHobbies, 5, 6);
		addComponent(jpResidentInfo, jlCharacteristics, 5, 7);
		addComponent(jpResidentInfo, jlSeekedCharacteristics, 5, 8);

		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.ipady = 20;
		c.gridy = 0;
		c.gridx = 0;
		c.anchor = GridBagConstraints.NORTH;
		add(jmbMenu, c);
		c.anchor = GridBagConstraints.SOUTH;
		add(new JPanel(), c);
		c.gridy = 1;
		add(jpSearch, c);
		c.gridy = 2;
		c.ipady = 450;
		add(jpResidentList, c);
		c.gridy = 3;
		c.ipady = 10;
		add(jpRes, c);
		c.gridy = 4;
		c.ipady = GridBagConstraints.REMAINDER;
		add(jpResidentInfo, c);
		
		setVisible(true);
	}
	
	public void addComponent(JComponent to, JComponent from) {
		to.add(from);
	}
	
	public void addComponent(JComponent to, JComponent from, final String bl) {
		to.add(from, bl);
	}

	public void addComponent(JComponent to, JComponent from, int gridx, int gridy) {
		c.gridx = gridx;
		c.gridy = gridy;
		to.add(from, c);
	}

	public void addComponent(JComponent to, JComponent from, int gridx, int gridy, int gridwidth, int gridheight,
			int ipadx, int ipady, int weightx, int weighty) {
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.ipadx = ipadx;
		c.ipady = ipady;
		c.weightx = weightx;
		c.weighty = weighty;
		to.add(from, c);
	}

	public void setResidentDataBaseModel(ResidentDataBaseModel residentDataBaseModel) {
		this.residentDataBaseModel = residentDataBaseModel;
		this.residentDataBaseModel.addActionListener(this);
		this.jlResidentList.setModel(this.residentDataBaseModel.getResidents());
		this.jlsize.setText("Size: " + this.residentDataBaseModel.size());
		actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Loaded Data"));
	}

	public void setUI() {
		if (residentDataBaseModel.size() == 0) {
			disableAllMenus();
		} else {
			enableAllMenus();
		}

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
		setDefaultLookAndFeelDecorated(true);
	}
	
	public void setButtonBorders() {
		jmFile.setBorder(BorderFactory.createRaisedBevelBorder());
		jmResident.setBorder(BorderFactory.createRaisedBevelBorder());
		jmDisplay.setBorder(BorderFactory.createRaisedBevelBorder());
		jmFilter.setBorder(BorderFactory.createRaisedBevelBorder());
		jmbMenu.setBorder(BorderFactory.createLineBorder(Color.black));
		jpResidentInfo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		jpRes.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	}
	
	public void setFrame() {
		setLocation(0, 0);
		setSize(800, 1000);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("OccuPointer*");
		setLayout(new GridBagLayout());
	}
	
	public void setResidentList() {
		jlResidentList = new JList<ResidentModel>(residentDataBaseModel.getResidents());
		jlResidentList.addMouseListener(this);
		jspResidentList = new JScrollPane(jlResidentList);
	}
	
	public boolean isSearching() {
		if (jlResidentList.getModel().getSize() == residentDataBaseModel.size()) {
			return false;
		}
		return true;
	}

	public ResidentDataBaseModel getSearchModel() {
		return searchModel;
	}

	public int[] getSelectedResidents() {

		return jlResidentList.getSelectedIndices();
	}

	public void enableAllMenus() {
		jmiExport.setEnabled(true);
		jmiExport.setToolTipText("Export data to comma delimmited text file.");

		jmiEditResident.setEnabled(true);
		jmiEditResident.setToolTipText(null);
		jmiDeleteResident.setEnabled(true);
		jmiDeleteResident.setToolTipText(null);
		jmiDeleteResidentList.setEnabled(true);
		jmiDeleteResidentList.setToolTipText(null);

		jmiMatches.setEnabled(true);
		jmiMatches.setToolTipText(null);
		jmiPotentialMatches.setEnabled(true);
		jmiPotentialMatches.setToolTipText(null);
		
		jmFilter.setEnabled(true);
	}

	public void disableAllMenus() {
		jmiExport.setEnabled(false);
		jmiExport.setToolTipText("Cannot export data; no data present.");

		jmiEditResident.setEnabled(false);
		jmiEditResident.setToolTipText("Cannot edit residents; no residents present.");
		jmiDeleteResident.setEnabled(false);
		jmiDeleteResident.setToolTipText("Cannot delete residents; no residents present.");
		jmiDeleteResidentList.setEnabled(false);
		jmiDeleteResidentList.setToolTipText("Cannot delete resident list; no residents present.");

		jmiMatches.setEnabled(false);
		jmiMatches.setToolTipText("Cannot display matches; no residents present to display data.");
		jmiPotentialMatches.setEnabled(false);
		jmiPotentialMatches.setToolTipText("Cannot display Potential Matches; no residents present to display data.");
		
		jmFilter.setEnabled(false);
	}

	public void filterRes() {
		jlResidentList.setModel(searchModel.getResidents());
		jlsize.setText("Size: " + searchModel.size());
	}
	
	public void removeFilter() {

		jlResidentList.setModel(residentDataBaseModel.getResidents());
		jlsize.setText("Size: " + residentDataBaseModel.size());		
	}

	public void setActionCommands() {
		jmiImport.setActionCommand("Import");
		jmiImport.setToolTipText("Import new data from a Comma Delimited Text Tile.");
		jmiExport.setActionCommand("Export");
		jmiExit.setActionCommand("Exit");
		jmiExit.setToolTipText("Save and Exit Program.");
		jmiAddResident.setActionCommand("Add Resident");
		jmiEditResident.setActionCommand("Edit Resident");
		jmiDeleteResident.setActionCommand("Delete Resident");
		jmiDeleteResidentList.setActionCommand("Delete Resident List");
		jmiMatches.setActionCommand("Matches");
		jmiPotentialMatches.setActionCommand("Potential Matches");
		jmiSmokey.setActionCommand("Smoking");
		jmiSmoken.setActionCommand("NonSmoking");
		jmiPety.setActionCommand("Yes");
		jmiPetn.setActionCommand("No");
		jmi2Bed.setActionCommand("2 Bed");
		jmi2Bedd.setActionCommand("2 Bed Deluxe");
		jmi3Bedo.setActionCommand("3 Bed-Open");
		jmi3Bedc.setActionCommand("3 Bed-Closed");
		jmi4Bed.setActionCommand("4 Bed");
		jmiRemoveFilter.setActionCommand("Remove Filter");
		jtfSearch.setActionCommand("search");
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// Enable GUI components when appropriate

		// If any data has been entered, enable Save and Export, as well as Pie
		// Chart and Text, and set their tool tips to null
		try {
			if (!residentDataBaseModel.isEmpty()) {
				enableAllMenus();
			} else {
				disableAllMenus();
			}
		} catch (IllegalArgumentException i) {
			disableAllMenus();
		}

		// If a lot of news makers/news stories have been added in via
		// importing/loading, adjust the size of the GUI
		if (actionEvent.getActionCommand().equals("Loaded data")) {
			residentDataBaseModel.sort();
			this.jlResidentList.setModel(this.residentDataBaseModel.getResidents());
			this.jlsize.setText("Size: " + this.residentDataBaseModel.size());
		}
	}
	
	public void setSearchDocListener() {
		jtfSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				if (jtfSearch.getText().equals("")) {
					setResidentDataBaseModel(residentDataBaseModel);
				}
				searchModel = residentDataBaseModel.getResFromPartial(jtfSearch.getText());
				jlResidentList.setModel(searchModel.getResidents());
				jlsize.setText("Size: " + searchModel.size());
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				searchModel = residentDataBaseModel.getResFromPartial(jtfSearch.getText());
				jlResidentList.setModel(searchModel.getResidents());
				jlsize.setText("Size: " + searchModel.size());
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				searchModel = residentDataBaseModel.getResFromPartial(jtfSearch.getText());
				jlResidentList.setModel(searchModel.getResidents());
				jlsize.setText("Size: " + searchModel.size());
			}
		});
	}
	
	public void registerFileMenuListener(ActionListener fileMenuListener) {
		jmiImport.addActionListener(fileMenuListener);
		jmiExport.addActionListener(fileMenuListener);
		jmiExit.addActionListener(fileMenuListener);
	}

	public void registerResidentMenuListener(ActionListener residentMenuListener) {
		jmiAddResident.addActionListener(residentMenuListener);
		jmiEditResident.addActionListener(residentMenuListener);
		jmiDeleteResident.addActionListener(residentMenuListener);
		jmiDeleteResidentList.addActionListener(residentMenuListener);
	}

	public void registerDisplayMenuListener(ActionListener displayMenuListener) {
		jmiMatches.addActionListener(displayMenuListener);
		jmiPotentialMatches.addActionListener(displayMenuListener);
	}
	
	public void registerFilterMenuListener(ActionListener filterMenuListener) {
		jmiSmokey.addActionListener(filterMenuListener);
		jmiSmoken.addActionListener(filterMenuListener);
		jmiPety.addActionListener(filterMenuListener);
		jmiPetn.addActionListener(filterMenuListener);
		jmi2Bed.addActionListener(filterMenuListener);
		jmi2Bedd.addActionListener(filterMenuListener);
		jmi3Bedo.addActionListener(filterMenuListener);
		jmi3Bedc.addActionListener(filterMenuListener);
		jmi4Bed.addActionListener(filterMenuListener);
		jmiRemoveFilter.addActionListener(filterMenuListener);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (getSelectedResidents().length != 0) {
			ResidentModel res = null;
			if (!isSearching()) {
				res = residentDataBaseModel.get(getSelectedResidents()[0]);
			} else {
				res = searchModel.get(getSelectedResidents()[0]);
			}
			if (getSelectedResidents().length == 1) {
				jlName.setText("Name: " + res.getFirstName() + " " + res.getMiddleInitial() + " " + res.getLastName());
				jlBed.setText("Bed Plan : " + res.getBed());
				jlMajor.setText("Major: " + res.getMajor());
				jlEnrollment.setText("Enrollment: " + res.getEnrollment());
				jlFloor.setText("Floor: " + res.getFloor());
				if (res.getSmoke()) {
					jlSmoke.setText("Smoking: Yes");
				} else {
					jlSmoke.setText("Smoking: No");
				}
				if (res.getSmokeOut()) {
					jlSmokeOut.setText("Outdoor Smoking: Yes");
				} else {
					jlSmokeOut.setText("Outdoor Smoking: No");
				}
				if (res.getHavePet()) {
					jlHavePet.setText("Pet: Yes");
				} else {
					jlHavePet.setText("Pet: No");
				}
				if (res.getMindSmoke()) {
					jlMindSmoke.setText("Mind Smoke: Yes");
				} else {
					jlMindSmoke.setText("Mind Smoke: No");
				}
				if (res.getMindSmokeOut()) {
					jlMindSmokeOut.setText("Mind Outdoor Smoking: Yes");
				} else {
					jlMindSmokeOut.setText("Mind Outdoor Smoking: No");
				}
				if (res.getMindPet()) {
					jlMindPet.setText("Mind Pet: Yes");
				} else {
					jlMindPet.setText("Mind Pet: No");
				}
				jlWork.setText("Work Habits: " + res.getWork());
				jlNeat.setText("Neatness: " + res.getNeat());
				jlPersonality.setText("Personality: " + res.getPersonality());
				jlSocial.setText("Social Habits: " + res.getSocial());
				jlSleep.setText("Sleep Habits: " + res.getSleep());
				jlGender.setText("Gender Preference: " + res.getGender());
				jlHobbies.setText("Hobbies: " + res.getHobbiesString());
				jlCharacteristics.setText("Characteristics: " + res.getCharacteristicsString());
				jlSeekedCharacteristics.setText("Seeked Characteristics: " + res.getSeekedCharacteristicsString());
				jlMate1.setText("Roommate 1: " + res.getMate1Name());
				jlMate2.setText("Roommate 2: " + res.getMate2Name());
				jlMate3.setText("Roommate 3: " + res.getMate3Name());
				jlPets.setText("Pets: " + res.getPetsString());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
