import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This class creates a window that allows the user to add a new newsstory
 * 
 * @author cglen
 *
 */
public class NewsStoryEntryView {

	protected JLabel lblDate;
	protected JTextField jtfDate;
	protected JLabel lblSource;
	protected JComboBox jcbSource;
	protected JLabel lblLength;
	protected JTextField jtfLength;
	protected JLabel lblTopic;
	protected JComboBox jcbTopic;
	protected JLabel lblSubject;
	protected JComboBox jcbSubject;
	protected JLabel lblNewsMaker1;
	protected JTextField jtfNewsMaker1;
	protected JLabel lblNewsMaker2;
	protected JTextField jtfNewsMaker2;
	protected JLabel lblPartOfDay;
	protected JComboBox jcbPartOfDay;
	protected JButton jbAddNewsStoryButton;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param newsStory
	 */
	public NewsStoryEntryView(NewsStory newsStory) {

	}

	/**
	 * Add a new Action Listener for the add newsstory button.
	 * 
	 * @param addNewsStoryButton
	 */
	public void addAddNewsStoryButtonListener(ActionListener addNewsStoryButton) {

	}
}
