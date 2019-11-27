import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * This class creates a window that lets the user view the current newsmaker and
 * their stories, and lets the user edit the newsmaker's name or stories.
 * 
 * @author cglen
 *
 */
public class NewsMakerEditView {
	protected JLabel lblName;
	protected JTextField jtfName;

	protected JList jlNewsStories;
	protected JScrollPane jlScroller;

	protected JButton jbEditNewsMakerButton;
	protected JButton jbRemoveStoriesButton;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param newsMaker
	 */
	public NewsMakerEditView(NewsMaker newsMaker) {

	}

	/**
	 * Add new button listener to the edit button
	 * 
	 * @param newsMakerButton
	 */
	public void addEditNewsMakerButtonListener(ActionListener newsMakerButton) {

	}

	/**
	 * Add new Button listener to the remove stories button
	 * 
	 * @param removeStoriesButton
	 */
	public void addRemoveStoriesButtonListener(ActionListener removeStoriesButton) {

	}
}
