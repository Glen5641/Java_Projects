import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class EditView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 7654922804023547570L;

	ResidentModel residentModel;
	
	// Component Information
	private Integer[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	// First Tier Components
	JTextField jtfFirstName = new JTextField();
	JTextField jtfMiddleInitial = new JTextField();
	JTextField jtfLastName = new JTextField();
	JComboBox<GenderPreference> jcbGenderList = new JComboBox<GenderPreference>(GenderPreference.values());

	JTextField jtfMate1 = new JTextField();
	JTextField jtfMate2 = new JTextField();
	JTextField jtfMate3 = new JTextField();

	JComboBox<Bed> jcbBedList = new JComboBox<Bed>(Bed.values());
	JComboBox<Major> jcbMajorList = new JComboBox<Major>(Major.values());
	JComboBox<Enrollment> jcbEnrollmentList = new JComboBox<Enrollment>(Enrollment.values());
	JComboBox<Floor> jcbFloorList = new JComboBox<Floor>(Floor.values());

	JCheckBox jcbSmokey = new JCheckBox("Yes");
	JCheckBox jcbSmoken = new JCheckBox("No");
	JCheckBox jcbMindSmokey = new JCheckBox("Yes");
	JCheckBox jcbMindSmoken = new JCheckBox("No");
	JCheckBox jcbSmokeOuty = new JCheckBox("Yes");
	JCheckBox jcbSmokeOutn = new JCheckBox("No");
	JCheckBox jcbMindSmokeOuty = new JCheckBox("Yes");
	JCheckBox jcbMindSmokeOutn = new JCheckBox("No");

	JCheckBox jcbHavePety = new JCheckBox("Yes");
	JCheckBox jcbHavePetn = new JCheckBox("No");
	JCheckBox jcbMindPety = new JCheckBox("Yes");
	JCheckBox jcbMindPetn = new JCheckBox("No");
	JList<Pet> jlPetList = new JList<Pet>(Pet.values());

	JComboBox<Integer> jcbWorkList = new JComboBox<Integer>(nums);
	JComboBox<Integer> jcbNeatList = new JComboBox<Integer>(nums);
	JComboBox<Integer> jcbPersonalityList = new JComboBox<Integer>(nums);
	JComboBox<Integer> jcbSocialList = new JComboBox<Integer>(nums);
	JComboBox<Integer> jcbSleepList = new JComboBox<Integer>(nums);

	JList<Hobby> jlHobbyList = new JList<Hobby>(Hobby.values());
	JList<Characteristic> jlCharacteristicsList = new JList<Characteristic>(Characteristic.values());
	JList<Characteristic> jlSeekedCharacteristicsList = new JList<Characteristic>(Characteristic.values());

	JButton jbtOK = new JButton("OK");

	// Second Tier Components
	private JPanel jpSmoke1 = new JPanel(new BorderLayout());
	private JPanel jpSmoke2 = new JPanel(new BorderLayout());
	private JPanel jpSmoke3 = new JPanel(new BorderLayout());
	private JPanel jpSmoke4 = new JPanel(new BorderLayout());

	private JScrollPane jspBedList = new JScrollPane(jcbBedList);
	private JScrollPane jspMajorList = new JScrollPane(jcbMajorList);
	private JScrollPane jspEnrollmentList = new JScrollPane(jcbEnrollmentList);
	private JScrollPane jspFloorList = new JScrollPane(jcbFloorList);

	private JScrollPane jspPetList = new JScrollPane(jlPetList);

	private JScrollPane jspWorkList = new JScrollPane(jcbWorkList);
	private JScrollPane jspNeatList = new JScrollPane(jcbNeatList);
	private JScrollPane jspPersonalityList = new JScrollPane(jcbPersonalityList);
	private JScrollPane jspSocialList = new JScrollPane(jcbSocialList);
	private JScrollPane jspSleepList = new JScrollPane(jcbSleepList);

	private JScrollPane jspHobbyList = new JScrollPane(jlHobbyList);
	private JScrollPane jspCharacteristicsList = new JScrollPane(jlCharacteristicsList);
	private JScrollPane jspSeekedCharacteristicsList = new JScrollPane(jlSeekedCharacteristicsList);

	// Third Tier Components
	private JPanel jpFirstName = new JPanel(new BorderLayout());
	private JPanel jpMiddleInitial = new JPanel(new BorderLayout());
	private JPanel jpLastName = new JPanel(new BorderLayout());
	private JPanel jpGender = new JPanel(new BorderLayout());

	private JPanel jpMate1 = new JPanel(new BorderLayout());
	private JPanel jpMate2 = new JPanel(new BorderLayout());
	private JPanel jpMate3 = new JPanel(new BorderLayout());

	private JPanel jpBed = new JPanel(new BorderLayout());
	private JPanel jpMajor = new JPanel(new BorderLayout());
	private JPanel jpEnrollment = new JPanel(new BorderLayout());
	private JPanel jpFloor = new JPanel(new BorderLayout());

	private JPanel jpSmoke = new JPanel(new GridBagLayout());
	private JPanel jpMindSmoke = new JPanel(new GridBagLayout());
	private JPanel jpSmokeOut = new JPanel(new GridBagLayout());
	private JPanel jpMindSmokeOut = new JPanel(new GridBagLayout());

	private JPanel jpHavePet = new JPanel(new BorderLayout());
	private JPanel jpMindPet = new JPanel(new BorderLayout());
	private JPanel jpPetList = new JPanel(new BorderLayout());

	private JPanel jpWorkList = new JPanel(new BorderLayout());
	private JPanel jpNeatList = new JPanel(new BorderLayout());
	private JPanel jpPersonalityList = new JPanel(new BorderLayout());
	private JPanel jpSocialList = new JPanel(new BorderLayout());
	private JPanel jpSleepList = new JPanel(new BorderLayout());

	// Fourth Tier Components
	private JPanel jpName = new JPanel(new GridBagLayout());
	private JPanel jpMate = new JPanel(new GridBagLayout());
	private JPanel jpEdit = new JPanel(new GridBagLayout());
	private JPanel jpSmoking = new JPanel(new GridBagLayout());
	private JPanel jpPet = new JPanel(new GridBagLayout());
	private JPanel jpChar = new JPanel(new GridBagLayout());
	private JPanel jpHobby = new JPanel(new BorderLayout());
	private JPanel jpCharacteristics = new JPanel(new BorderLayout());
	private JPanel jpSeekedCharacteristics = new JPanel(new BorderLayout());

	// Fifth Tier Components
	JTabbedPane tab = new JTabbedPane();
	private JPanel jpOK = new JPanel();

	public EditView(ResidentDataBaseModel residentDataBaseModel, ResidentModel res) {

		residentModel = res;
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;

		//////////////////////////////////////////////////////////////////////////////////////////////////////
		// Tier 1 Settables
		//////////////////////////////////////////////////////////////////////////////////////////////////////

		//Set First Name
		jtfFirstName.setText(res.getFirstName());
		
		//Set Middle Initial
		jtfMiddleInitial.setText(res.getMiddleInitial());
		
		//Set Last Name
		jtfLastName.setText(res.getLastName());
		
		//Set Mate 1
		jtfMate1.setText(res.getMate1Name());
		
		//Set Mate 2
		jtfMate2.setText(res.getMate2Name());
		
		//Set Mate 3
		jtfMate3.setText(res.getMate3Name());
		
		//Set Bed
		jcbBedList.setSelectedItem(res.getBed());
		
		//Set Major
		jcbMajorList.setSelectedItem(res.getMajor());
		
		//Set Enrollment
		jcbEnrollmentList.setSelectedItem(res.getEnrollment());
		
		//Set Floor
		jcbFloorList.setSelectedItem(Floor.INDIFFERENT);
		
		//Set Smoke
		if(res.getSmoke()) {
			jcbSmokey.setSelected(true);
			jcbSmoken.setSelected(false);
			jcbMindSmokey.setEnabled(false);
			jcbMindSmoken.setEnabled(false);
			jcbSmokeOuty.setEnabled(true);
			jcbSmokeOutn.setEnabled(true);
			jcbMindSmokeOuty.setEnabled(false);
			jcbMindSmokeOutn.setEnabled(false);
		} else {
			jcbSmokey.setSelected(false);
			jcbSmoken.setSelected(true);
			jcbMindSmokey.setEnabled(true);
			jcbMindSmoken.setEnabled(true);
			jcbSmokeOuty.setEnabled(false);
			jcbSmokeOutn.setEnabled(false);
			jcbMindSmokeOuty.setEnabled(true);
			jcbMindSmokeOutn.setEnabled(true);
		}
		
		//Set Mind Smoke
		if(res.getMindSmoke()) {
			jcbMindSmokey.setSelected(false);
			jcbMindSmoken.setSelected(true);
		} else {
			jcbMindSmokey.setSelected(false);
			jcbMindSmoken.setSelected(true);
		}
		
		//Set Smoke Out
		if(res.getSmokeOut()) {
			jcbSmokeOuty.setSelected(false);
			jcbSmokeOutn.setSelected(true);
		} else {
			jcbSmokeOuty.setSelected(false);
			jcbSmokeOutn.setSelected(true);
		}
		
		//Set Mind Smoke Out
		if(res.getMindSmokeOut()) {
			jcbMindSmokeOuty.setSelected(false);
			jcbMindSmokeOutn.setSelected(true);
		} else {
			jcbMindSmokeOuty.setSelected(false);
			jcbMindSmokeOutn.setSelected(true);
		}
		
		//Set Have Pet
		if(res.getHavePet()) {
			jcbHavePety.setSelected(false);
			jcbHavePetn.setSelected(true);
		}else {
			jcbHavePety.setSelected(false);
			jcbHavePetn.setSelected(true);
		}
		
		//Set Mind Pet
		if(res.getMindPet()) {
			jcbMindPety.setSelected(false);
			jcbMindPetn.setSelected(true);
		} else {
			jcbMindPety.setSelected(false);
			jcbMindPetn.setSelected(true);
		}
		
		//Set Pets
		int[] indices = new int[res.getPets().size()];
		for(int i = 0; i < res.getPets().size(); ++i) {
			indices[i] = res.getPets().get(i).toInt() - 1;
		}
		jlPetList.setSelectedIndices(indices);
		
		//Set Work
		jcbWorkList.setSelectedItem(res.getWork());
		
		//Set Neat
		jcbNeatList.setSelectedItem(res.getNeat());
		
		//Set Personality
		jcbPersonalityList.setSelectedItem(res.getPersonality());
		
		//Set Social
		jcbSocialList.setSelectedItem(res.getSocial());
		
		//Set Sleep
		jcbSleepList.setSelectedItem(res.getSleep());
		
		jcbGenderList.setSelectedItem(res.getGender());
		
		//Set Hobbies
		indices = new int[res.getHobbies().size()];
		for(int i = 0; i < res.getHobbies().size(); ++i) {
			indices[i] = res.getHobbies().get(i).toInt() - 1;
		}
		jlHobbyList.setSelectedIndices(indices);
		
		//Set Characteristics
		indices = new int[res.getCharacteristics().size()];
		for(int i = 0; i < res.getCharacteristics().size(); ++i) {
			indices[i] = res.getCharacteristics().get(i).toInt() - 1;
		}
		jlCharacteristicsList.setSelectedIndices(indices);
		
		//Set Seeked Characteristics
		indices = new int[res.getSeekedCharacteristics().size()];
		for(int i = 0; i < res.getSeekedCharacteristics().size(); ++i) {
			indices[i] = res.getSeekedCharacteristics().get(i).toInt() - 1;
		}
		jlSeekedCharacteristicsList.setSelectedIndices(indices);

		jcbSmokey.setActionCommand("Smoke-True");
		jcbSmoken.setActionCommand("Smoke-False");
		jcbMindSmokey.setActionCommand("Mind Smoke-True");
		jcbMindSmoken.setActionCommand("Mind Smoke-False");
		jcbSmokeOuty.setActionCommand("Smoke Out-True");
		jcbSmokeOutn.setActionCommand("Smoke Out-False");
		jcbMindSmokeOuty.setActionCommand("Mind Smoke Out-True");
		jcbMindSmokeOutn.setActionCommand("Mind Smoke Out-False");
		jcbHavePety.setActionCommand("Pet-True");
		jcbHavePetn.setActionCommand("Pet-False");
		jcbMindPety.setActionCommand("Mind Pet-True");
		jcbMindPetn.setActionCommand("Mind Pet-False");
		
		jcbSmokey.addActionListener(this);
		jcbSmoken.addActionListener(this);
		jcbMindSmokey.addActionListener(this);
		jcbMindSmoken.addActionListener(this);
		jcbSmokeOuty.addActionListener(this);
		jcbSmokeOutn.addActionListener(this);
		jcbMindSmokeOuty.addActionListener(this);
		jcbMindSmokeOutn.addActionListener(this);
		jcbHavePety.addActionListener(this);
		jcbHavePetn.addActionListener(this);
		jcbMindPety.addActionListener(this);
		jcbMindPetn.addActionListener(this);

		//////////////////////////////////////////////////////////////////////////////////////////////////////
		// Tier 2
		//////////////////////////////////////////////////////////////////////////////////////////////////////

		// Name
		jpFirstName.add(new JLabel("<html><font color='red'>*</font><font color='black'> First Name: </html>"),
				BorderLayout.NORTH);
		jpFirstName.add(jtfFirstName, BorderLayout.CENTER);
		jpMiddleInitial.add(new JLabel("<html><font color='red'>*</font><font color='black'> Middle Initial: </html>"),
				BorderLayout.NORTH);
		jpMiddleInitial.add(jtfMiddleInitial, BorderLayout.CENTER);
		jpLastName.add(new JLabel("<html><font color='red'>*</font><font color='black'> Last Name: </html>"),
				BorderLayout.NORTH);
		jpLastName.add(jtfLastName, BorderLayout.CENTER);
		jpGender.add(new JLabel("<html><font color='red'>*</font><font color='black'> Gender Preference: </html>"),
				BorderLayout.NORTH);
		jpGender.add(jcbGenderList, BorderLayout.CENTER);
		
		// Mates
		jpMate1.add(new JLabel("Roommate 1: "), BorderLayout.NORTH);
		jpMate1.add(jtfMate1, BorderLayout.CENTER);
		jpMate2.add(new JLabel("Roommate 2: "), BorderLayout.NORTH);
		jpMate2.add(jtfMate2, BorderLayout.CENTER);
		jpMate3.add(new JLabel("Roommate 3: "), BorderLayout.NORTH);
		jpMate3.add(jtfMate3, BorderLayout.CENTER);

		// Edit
		jpBed.add(new JLabel("# Beds"), BorderLayout.NORTH);
		jpBed.add(jspBedList, BorderLayout.CENTER);
		jpMajor.add(new JLabel("Current Major"), BorderLayout.NORTH);
		jpMajor.add(jspMajorList, BorderLayout.CENTER);
		jpEnrollment.add(new JLabel("Enrollment Status"), BorderLayout.NORTH);
		jpEnrollment.add(jspEnrollmentList, BorderLayout.CENTER);
		jpFloor.add(new JLabel("Preferred Floor"), BorderLayout.NORTH);
		jpFloor.add(jspFloorList, BorderLayout.CENTER);

		// Smoking
		jpSmoke1.add(new JLabel("Do you Smoke: "), BorderLayout.WEST);
		jpSmoke.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		c.gridx = 0;
		jpSmoke.add(jcbSmokey, c);
		c.gridx = 1;
		jpSmoke.add(jcbSmoken, c);
		jpSmoke2.add(new JLabel("Do you mind Smoking: "), BorderLayout.WEST);
		jpMindSmoke.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		c.gridx = 0;
		jpMindSmoke.add(jcbMindSmokey, c);
		c.gridx = 1;
		jpMindSmoke.add(jcbMindSmoken, c);
		jpSmoke3.add(new JLabel("Will you only Smoke Outside: "), BorderLayout.WEST);
		jpSmokeOut.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		c.gridx = 0;
		jpSmokeOut.add(jcbSmokeOuty, c);
		c.gridx = 1;
		jpSmokeOut.add(jcbSmokeOutn, c);
		jpSmoke4.add(new JLabel("Do you mind if your roommate Smokes Outside: "), BorderLayout.WEST);
		jpMindSmokeOut.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		c.gridx = 0;
		jpMindSmokeOut.add(jcbMindSmokeOuty, c);
		c.gridx = 1;
		jpMindSmokeOut.add(jcbMindSmokeOutn, c);

		// Pets
		jpHavePet.add(new JLabel("Do you have Pets?"), BorderLayout.NORTH);
		jpHavePet.add(jcbHavePety, BorderLayout.WEST);
		jpHavePet.add(jcbHavePetn, BorderLayout.CENTER);
		jpMindPet.add(new JLabel("Do you mind if your roommate has Pets?"), BorderLayout.NORTH);
		jpMindPet.add(jcbMindPety, BorderLayout.WEST);
		jpMindPet.add(jcbMindPetn, BorderLayout.CENTER);
		jpPetList.add(new JLabel("What kind of Pet do you have? (Hold Ctrl and Select All That Apply)"),
				BorderLayout.NORTH);
		jpPetList.add(jspPetList, BorderLayout.CENTER);

		// Char
		jpWorkList.add(new JLabel("Work Habits"), BorderLayout.NORTH);
		jpWorkList.add(jspWorkList, BorderLayout.CENTER);
		jpNeatList.add(new JLabel("Neatness"), BorderLayout.NORTH);
		jpNeatList.add(jspNeatList, BorderLayout.CENTER);
		jpPersonalityList.add(new JLabel("Personality"), BorderLayout.NORTH);
		jpPersonalityList.add(jspPersonalityList, BorderLayout.CENTER);
		jpSocialList.add(new JLabel("Social Habits"), BorderLayout.NORTH);
		jpSocialList.add(jspSocialList, BorderLayout.CENTER);
		jpSleepList.add(new JLabel("Sleep Habits"), BorderLayout.NORTH);
		jpSleepList.add(jspSleepList, BorderLayout.CENTER);

		// Hobby
		jpHobby.add(new JLabel("Hobbies (Hold Ctrl and Select All That Apply)"), BorderLayout.NORTH);

		// Characteristic
		jpCharacteristics.add(new JLabel("Characteristics (Hold Ctrl and Select All That Apply)"), BorderLayout.NORTH);

		// Seeked Characteristic
		jpSeekedCharacteristics.add(new JLabel("Seeked Characteristics (Hold Ctrl and Select All That Apply)"),
				BorderLayout.NORTH);

		//////////////////////////////////////////////////////////////////////////////////////////////////////
		// Tier 3
		//////////////////////////////////////////////////////////////////////////////////////////////////////

		// Name Panel
		c.gridx = 0;
		c.gridy = 0;
		jpName.add(jpFirstName, c);
		c.gridy = 1;
		jpName.add(jpMiddleInitial, c);
		c.gridy = 2;
		jpName.add(jpLastName, c);
		c.gridy = 3;
		jpName.add(jpGender,c);

		// Mate Panel
		c.gridy = 0;
		jpMate.add(jpMate1, c);
		c.gridy = 1;
		jpMate.add(jpMate2, c);
		c.gridy = 2;
		jpMate.add(jpMate3, c);

		// Edit Panel
		c.gridy = 0;
		jpEdit.add(jpBed, c);
		c.gridy = 1;
		jpEdit.add(jpMajor, c);
		c.gridy = 2;
		jpEdit.add(jpEnrollment, c);
		c.gridy = 3;
		jpEdit.add(jpFloor, c);

		// Smoking Panel
		c.gridy = 0;
		jpSmoking.add(jpSmoke1, c);
		c.gridy = 1;
		jpSmoking.add(jpSmoke, c);
		c.gridy = 3;
		jpSmoking.add(jpSmoke2, c);
		c.gridy = 4;
		jpSmoking.add(jpMindSmoke, c);
		c.gridy = 5;
		jpSmoking.add(jpSmoke3, c);
		c.gridy = 6;
		jpSmoking.add(jpSmokeOut, c);
		c.gridy = 7;
		jpSmoking.add(jpSmoke4, c);
		c.gridy = 8;
		jpSmoking.add(jpMindSmokeOut, c);

		// Pet Panel
		c.gridy = 0;
		jpPet.add(jpHavePet, c);
		c.gridy = 1;
		jpPet.add(jpPetList, c);
		c.gridy = 2;
		jpPet.add(jpMindPet, c);

		// Char Panel
		c.gridy = 0;
		jpChar.add(jpWorkList, c);
		c.gridy = 1;
		jpChar.add(jpNeatList, c);
		c.gridy = 2;
		jpChar.add(jpPersonalityList, c);
		c.gridy = 3;
		jpChar.add(jpSocialList, c);
		c.gridy = 4;
		jpChar.add(jpSleepList, c);

		// Hobby Panel
		jpHobby.add(jspHobbyList, BorderLayout.CENTER);

		// Characteristic Panel
		jpCharacteristics.add(jspCharacteristicsList, BorderLayout.CENTER);

		// Seeked Characteristic Panel
		jpSeekedCharacteristics.add(jspSeekedCharacteristicsList, BorderLayout.CENTER);

		//////////////////////////////////////////////////////////////////////////////////////////////////////
		// Tier 4
		//////////////////////////////////////////////////////////////////////////////////////////////////////

		// Tab Panel
		tab.addTab("Name", null, jpName, null);
		tab.addTab("Mates", null, jpMate, null);
		tab.addTab("Info", null, jpEdit, null);
		tab.addTab("Smoking", null, jpSmoking, null);
		tab.addTab("Pets", null, jpPet, null);
		tab.addTab("Habits", null, jpChar, null);
		tab.addTab("Hobbies", null, jpHobby, null);
		tab.addTab("Characteristics", null, jpCharacteristics, null);
		tab.addTab("Seeked Characteristics", null, jpSeekedCharacteristics, null);

		// OK Panel
		jpOK.add(jbtOK, BorderLayout.SOUTH);

		//////////////////////////////////////////////////////////////////////////////////////////////////////
		// Tier 5
		//////////////////////////////////////////////////////////////////////////////////////////////////////

		// Add Panel
		setLayout(new BorderLayout());
		c.gridy = 0;
		add(tab, BorderLayout.NORTH);
		c.gridy = 1;
		add(jpOK, BorderLayout.SOUTH);

	}

	public void registerEditResidentListener(ActionListener EditResidentListener) {
		jbtOK.addActionListener(EditResidentListener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ("Smoke-True".equals(e.getActionCommand())) {
			jcbSmoken.setSelected(false);
			
			jcbMindSmokey.setSelected(true);
			jcbMindSmoken.setSelected(false);
			jcbMindSmokey.setEnabled(false);
			jcbMindSmoken.setEnabled(false);
			
			jcbSmokeOuty.setSelected(true);
			jcbSmokeOutn.setSelected(false);
			jcbSmokeOuty.setEnabled(true);
			jcbSmokeOutn.setEnabled(true);
			
			jcbMindSmokeOuty.setSelected(true);
			jcbMindSmokeOutn.setSelected(false);
			jcbMindSmokeOuty.setEnabled(false);
			jcbMindSmokeOutn.setEnabled(false);
		}
		if ("Smoke-False".equals(e.getActionCommand())) {
			jcbSmokey.setSelected(false);
			
			jcbMindSmokey.setSelected(false);
			jcbMindSmoken.setSelected(true);
			jcbMindSmokey.setEnabled(true);
			jcbMindSmoken.setEnabled(true);
			
			jcbSmokeOuty.setSelected(false);
			jcbSmokeOutn.setSelected(true);
			jcbSmokeOuty.setEnabled(false);
			jcbSmokeOutn.setEnabled(false);
			
			jcbMindSmokeOuty.setSelected(false);
			jcbMindSmokeOutn.setSelected(true);
			jcbMindSmokeOuty.setEnabled(true);
			jcbMindSmokeOutn.setEnabled(true);
		}
		if ("Mind Smoke-True".equals(e.getActionCommand())) {
			jcbMindSmoken.setSelected(false);
		}
		if ("Mind Smoke-False".equals(e.getActionCommand())) {
			jcbMindSmokey.setSelected(false);
		}
		if ("Smoke Out-True".equals(e.getActionCommand())) {
			jcbSmokeOutn.setSelected(false);
		}
		if ("Smoke Out-False".equals(e.getActionCommand())) {
			jcbSmokeOuty.setSelected(false);
		}
		if ("Mind Smoke Out-True".equals(e.getActionCommand())) {
			jcbMindSmokeOutn.setSelected(false);
		}
		if ("Mind Smoke Out-False".equals(e.getActionCommand())) {
			jcbMindSmokeOuty.setSelected(false);
		}
		if ("Pet-True".equals(e.getActionCommand())) {
			jcbHavePetn.setSelected(false);
		}
		if ("Pet-False".equals(e.getActionCommand())) {
			jcbHavePety.setSelected(false);
		}
		if ("Mind Pet-True".equals(e.getActionCommand())) {
			jcbMindPetn.setSelected(false);
		}
		if ("Mind Pet-False".equals(e.getActionCommand())) {
			jcbMindPety.setSelected(false);
		}
	}
}