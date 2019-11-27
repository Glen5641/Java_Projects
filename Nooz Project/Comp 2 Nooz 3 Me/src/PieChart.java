import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * This class creates a JComponent of a pie chart
 * 
 * @author cglen and Dean Hougen
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
		this.title = title;
		this.wedges = wedges;
	}

	/**
	 * This method creates a pie chart in a JFrame
	 */
	public void paintComponent(Graphics g) {

		double curValue = 0.0D;
		int startAngle = 0;

		// Set font size
		g.setFont(new Font("TimesRoman", Font.PLAIN, 18));

		// Loop for num wedges
		for (int i = 0; i < wedges.size(); i++) {

			// Show where to start
			startAngle = (int) (curValue * 360);

			// Show how far the arc needs to be
			int arcAngle = (int) (wedges.get(i).getPercent() * 360);

			// Draw string of the text of the wedge
			g.setColor(Color.black);
			g.drawString(wedges.get(i).getText(), 75, 40 * i);

			// Rotate colors to make piechart
			if (i % 5 == 0) {
				g.setColor(Color.green);
			} else if (i % 5 == 1) {
				g.setColor(Color.red);
			} else if (i % 5 == 2) {
				g.setColor(Color.blue);
			} else if (i % 5 == 3) {
				g.setColor(Color.orange);
			} else {
				g.setColor(Color.gray);
			}

			// Fill the arc with the corresponding color
			g.fillArc(350, 0, 300, 300, startAngle, arcAngle);

			// Increment the current value of the arc
			curValue += wedges.get(i).getPercent();
		}
	}
}
