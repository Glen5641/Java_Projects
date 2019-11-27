import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DuplicatesView extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;

	private DefaultListModel<ResidentModel> dups;

	// All components for news maker list
	private JList<ResidentModel> jlResidentList;
	private JScrollPane jspResidentList;
	private JPanel jpResidentList = new JPanel(new BorderLayout());

	JButton jbReplace;
	JButton jbAll;
	private JPanel jpReplace = new JPanel(new BorderLayout());

	/**
	 * Constructor for selection view that sets a frame for the UI
	 */
	public DuplicatesView(DefaultListModel<ResidentModel> dup) {

		// Create new news database model
		dups = dup;

		// Create new JLists and add residents to it
		jlResidentList = new JList<ResidentModel>(dups);
		jspResidentList = new JScrollPane(jlResidentList);
		jpResidentList.add(new JLabel("Select all Residents you would like to Replace or Click all"),
				BorderLayout.NORTH);
		jpResidentList.add(jspResidentList, BorderLayout.CENTER);

		jbReplace = new JButton("Replace");
		jbReplace.setActionCommand("Replace");
		jbReplace.setText("Replace");
		jbReplace.setEnabled(false);

		jbAll = new JButton("Replace All");
		jbAll.setActionCommand("Replace All");
		jbAll.setText("Replace All");
		jbAll.setEnabled(true);
		jpReplace.add(jbReplace, BorderLayout.CENTER);
		jpReplace.add(jbAll, BorderLayout.EAST);

		// Add components to frame, pack, and set visible
		setSize(500, 500);
		setLocation(700, 300);

		BorderLayout bl = new BorderLayout();
		setLayout(bl);

		add(jpResidentList, BorderLayout.CENTER);
		add(jpReplace, BorderLayout.SOUTH);

		setVisible(true);
		jlResidentList.addMouseListener(this);
	}

	public void registerReplaceListener(ActionListener ReplaceListener) {
		jbReplace.addActionListener(ReplaceListener);
	}
	
	public void registerReplaceAllListener(ActionListener ReplaceListener) {
		jbAll.addActionListener(ReplaceListener);
	}

	public int[] getSelectedResidents() {

		return jlResidentList.getSelectedIndices();
	}
	
	public DefaultListModel<ResidentModel> getResidents(){
		return dups;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (getSelectedResidents().length == 0) {
			jbReplace.setEnabled(false);
		} else {
			jbReplace.setEnabled(true);
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
