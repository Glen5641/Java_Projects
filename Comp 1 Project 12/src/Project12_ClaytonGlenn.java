import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * @Author		Clayton Glenn
 * @Version	Project12
 * @Teacher	Deborah Trytten
 * @Date			11/14/2016
 * 
 * This program uses a new bag of goodies to 
 * create a picture out of 2D geometric shapes.
 */

public class Project12_ClaytonGlenn extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	
	//Declare a final constant for size
	private static final int SIZE = 300;
	
	public static void main(String[] args) 
	{
		//Create JFrame and set size
		JFrame frame = new JFrame("Line");
		JPanel panel = new Project12_ClaytonGlenn();
		frame.setSize(SIZE + 18, 500);
		
		//Add panel to JFrame
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//Make JFrame visible
		frame.setVisible(true);
	}
		
	
	public void paintComponent(Graphics g)
	{
		//Open paint component for goodies
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		//Draw lines diagonal across the JFrame
		Line2D.Double line = new Line2D.Double(0, 0, SIZE, SIZE);
		g2d.setColor(Color.BLACK);
		g2d.draw(line);
		line = new Line2D.Double(0, SIZE, SIZE, 0);
		g2d.setColor(Color.BLACK);
		g2d.draw(line);
		
		//Make arrays for plots of points in polygon
		int[] xCoordinates = {0, 75, 150, 225, 300, 225, 150, 75, 0};
		int[] yCoordinates = {150, 100, 0, 100, 150, 200, 300, 200, 150};
		Polygon polygon = new Polygon(xCoordinates, yCoordinates, 9);
		g2d.draw(polygon);
		
		//Draw stick of lollipop
		Rectangle2D.Double rectangle = new Rectangle2D.Double( 144, 144, 10, 300);
		g2d.setColor(Color.BLACK);
		g2d.fill(rectangle);
		g2d.draw(rectangle);
		
		//Draw outer black layer of "circles" for lollipop
		RoundRectangle2D.Double roundrectangle = new RoundRectangle2D.Double
																							(72, 72, SIZE/2, SIZE/2, SIZE, SIZE);
		g2d.setColor(Color.BLACK);
		g2d.fill(roundrectangle);
		g2d.draw(roundrectangle);
		
		//Use loop to alternate between red and white while getting smaller
		int point1 = 75, point2 = 75;
		for(int sizeCtr = (SIZE/2 - 5); sizeCtr >= 0; sizeCtr -= SIZE/50, point1 += SIZE/100, 
																															point2 += SIZE/100)
		{
			
			roundrectangle = new RoundRectangle2D.Double( point1, point2, sizeCtr, sizeCtr, 
																																		SIZE, SIZE);
			g2d.setColor(Color.RED);
			g2d.fill(roundrectangle);
			g2d.draw(roundrectangle);
			
			//Second half of loop for white circles
			point1 += SIZE/100;
			point2 += SIZE/100;
			sizeCtr -= SIZE/50;
			roundrectangle = new RoundRectangle2D.Double( point1, point2, sizeCtr, sizeCtr, 
																																		SIZE, SIZE);
			g2d.setColor(Color.WHITE);
			g2d.fill(roundrectangle);
			g2d.draw(roundrectangle);
		}
	}
}
