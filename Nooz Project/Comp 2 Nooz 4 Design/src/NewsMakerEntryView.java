import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This class creates a window for the user to create a new newsMaker or lets
 * the user replace a current newsMaker with same name.
 * 
 * @author cglen
 *
 */
public class NewsMakerEntryView {

	protected JLabel lblName;
	protected JTextField jtfName;
	protected JButton jbNewsMakerButton;

	/**
	 * CONSTRUCTOR
	 * @param NewsMaker
	 */
	public NewsMakerEntryView(NewsMaker NewsMaker) {

	}

	/**
	 * Create listener for the add newsMaker Button
	 * @param newsMakerButton
	 */
	public void addAddNewsMakerButtonListener(ActionListener newsMakerButton) {

	}
}
