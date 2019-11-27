import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This class creates a JComponent of a pie chart
 * 
 * @author cglen
 */
public class PieChart extends JComponent {

	private static final long serialVersionUID = 1L;
	protected String title;
	private ArrayList<Wedge> wedges;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param title
	 * @param wedges
	 */
	public PieChart(String title, ArrayList<Wedge> wedges) {
	}

	/**
	 * This method creates a pie chart in a JFrame
	 */
	public void paintComponent(Graphics g) {

	}
}
