/**
 * This class creates a wedge object for a pie chart
 * 
 * @author cglen and Dean Hougen
 */
public class Wedge {

	private double percent;
	private String text;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param percent
	 * @param text
	 */
	public Wedge(double percent, String text) {
		this.percent = percent;
		this.text = text;
	}

	/**
	 * Access percent
	 * 
	 * @return percent
	 */
	public Double getPercent() {
		return this.percent;
	}

	/**
	 * Set the percent of the wedge
	 * 
	 * @param percent
	 */
	public void setPercent(double percent) {
		this.percent = percent;
	}

	/**
	 * Get the text from wedge
	 * 
	 * @return text
	 */
	public String getText() {
		return this.text;
	}

	/**
	 * Set the text of the wedge
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
