import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 * Lab 5, CS 2334, Section 010, 21 March 2017
 * <p>
 * Each object of this class represents a GUI input window (MVC view).
 * </p>
 * 
 * @author Dean Hougen and Clayton Glenn
 * @version 2.0
 */
public class SeriesInputWindow extends JFrame {
	/**
	 * Version number to allow for correct serialization. Because this version
	 * will not be binary compatible with the previous version, we have changed
	 * the serialVersionUID for it.
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Button to click to add new episode to the episode list based on filled
	 * text fields.
	 */
	JButton jbtAddEpisode = new JButton("Add Episode");

	/** Button to clear text fields of episode info. */
	JButton jbtClearInput = new JButton("Clear Input Fields");

	/** Button to clear episode list. */
	JButton jbtClearEpisodes = new JButton("Clear Episode List");

	/** TextField to input new episode title. */
	JTextField jtfTitle = new JTextField(20);

	/** Label to mark where the title goes. */
	JLabel lblTitle = new JLabel("Episode Title", JLabel.RIGHT);

	/** TextField to input episode's season number. */
	JTextField jtfSeasonNumber = new JTextField(20);

	/** Label to mark where the season number goes. */
	JLabel lblSeasonNumber = new JLabel("Season Number", JLabel.RIGHT);

	/** TextField to input episode's episode number. */
	JTextField jtfEpisodeNumber = new JTextField(20);

	/** Label to mark where the episode number goes. */
	JLabel lblEpisodeNumber = new JLabel("Episode Number", JLabel.RIGHT);

	/** TextField to input episode's year. */
	JTextField jtfYear = new JTextField(20);

	/** Label to mark where the year goes. */
	JLabel lblYear = new JLabel("Year", JLabel.RIGHT);

	/** Menu bar for Load, Save, and Exit */
	protected JMenuBar jmBar = new JMenuBar();
	protected JMenu jMenu = new JMenu("File");
	protected JMenuItem jmiLoad = new JMenuItem("Load");
	protected JMenuItem jmiSave = new JMenuItem("Save");
	protected JMenuItem jmiExit = new JMenuItem("Exit");
	
	/** ToolBar for printing */
	protected JToolBar jtBar = new JToolBar();
	protected JButton jbPrint = new JButton("Print");
	
	/**
	 * Constructor to create the window by putting all the pieces together and
	 * setting it visible.
	 */
	SeriesInputWindow() {
		setTitle("Add Episodes to Series");

		//Create panel for JMenu
		JPanel jplMenu = new JPanel(new GridLayout(1, 0, 2, 2));
		jMenu.add(jmiLoad);
		jMenu.add(jmiSave);
		jMenu.add(jmiExit);
		jmBar.add(jMenu);
		jplMenu.add(jmBar);
		
		//Create panel for toolbar
		JPanel jplToolBar = new JPanel(new GridLayout(1, 0, 2, 2));
		jtBar.add(jbPrint);
		jplToolBar.add(jtBar);
		
		// Create panels for name, season number, episode number, and command
		// buttons
		JPanel jplTitle = new JPanel(new GridLayout(1, 0, 5, 5));
		jplTitle.add(lblTitle);
		jplTitle.add(jtfTitle);

		JPanel jplSeasonNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplSeasonNumber.add(lblSeasonNumber);
		jplSeasonNumber.add(jtfSeasonNumber);

		JPanel jplEpisodeNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplEpisodeNumber.add(lblEpisodeNumber);
		jplEpisodeNumber.add(jtfEpisodeNumber);

		JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
		jplYear.add(lblYear);
		jplYear.add(jtfYear);

		JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtAddEpisode);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtClearEpisodes);

		// Set up the content pane and add all the panels to it.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplMenu);
		add(jplToolBar);
		add(jplTitle);
		add(jplSeasonNumber);
		add(jplEpisodeNumber);
		add(jplYear);
		add(jplButton);
		pack();
		setVisible(true);
	}

	/**
	 * Method to clear the input fields of the window for the user.
	 */
	public void clearInputFields() {
		jtfTitle.setText("");
		jtfSeasonNumber.setText("");
		jtfEpisodeNumber.setText("");
		jtfYear.setText("");
	}

	/**
	 * Method to add a listener to the "Add Episode" button, so that the program
	 * will take appropriate action when the button is pressed.
	 * 
	 * @param addEpisodeListener
	 *            The listener to add to the button.
	 */
	public void addAddEpisodeButtonListener(ActionListener addEpisodeListener) {
		jbtAddEpisode.addActionListener(addEpisodeListener);
	}

	/**
	 * Method to add a listener to the "Clear Episode List" button, so that the
	 * program will take appropriate action when the button is pressed.
	 * 
	 * @param clearEpisodeListener
	 *            The listener to add to the button.
	 */
	public void addClearEpisodesButtonListener(ActionListener clearEpisodeListener) {
		jbtClearEpisodes.addActionListener(clearEpisodeListener);
	}

	/**
	 * Method to add a listener to the "Clear Input Fields" button, so that the
	 * program will take appropriate action when the button is pressed.
	 * 
	 * @param clearInputFieldsListener
	 *            The listener to add to the button.
	 */
	public void addClearInputButtonListener(ActionListener clearInputFieldsListener) {
		jbtClearInput.addActionListener(clearInputFieldsListener);
	}
	
	/**
	 * Method to add a listener to Load button, so the 
	 * program can take action when the button is pressed
	 * 
	 * @param loadEpisodesListener
	 * 		The listener to add to the button
	 */
	public void addLoadEpisodesListener(ActionListener loadEpisodesListener) {
		jmiLoad.addActionListener(loadEpisodesListener);
	}
	
	/**
	 * Method to add a listener to Save button, so the 
	 * program can take action when the button is pressed
	 * 
	 * @param saveEpisodesListener
	 * 		The listener to add to the button
	 */
	public void addSaveEpisodesListener(ActionListener saveEpisodesListener) {
		jmiSave.addActionListener(saveEpisodesListener);
	}
	
	/**
	 * Method to add a listener to Exit button, so the 
	 * program can take action when the button is pressed
	 * 
	 * @param exitListener
	 * 		The listener to add to the button
	 */
	public void addExitListener(ActionListener exitListener) {
		jmiExit.addActionListener(exitListener);
	}
	
	/**
	 * Method to add a listener to Print button, so the 
	 * program can take action when the button is pressed
	 * 
	 * @param printListener
	 * 		The listener to add to the button
	 */
	public void addPrintEpisodesListener(ActionListener printListener) {
		jbPrint.addActionListener(printListener);
	}
}