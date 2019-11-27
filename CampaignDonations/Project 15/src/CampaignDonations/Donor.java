package CampaignDonations;
import java.util.ArrayList;

/*
 * @version Donor class
 * 
 * This class adds a new donor to the campaign class to be stored in an
 * arraylist. The new donor has his/her own donations and name that is
 * stored in the arraylist. This class is driven by the campaign class.
 */

public class Donor 
{
	
	private String donor;
	private ArrayList<Double> donations = new ArrayList<Double>();
		
	
	/*
	 * This constructor is called only when a new donor is being added.
	 */
	public Donor(String donorName)
	{
		
		//Add name to a new donor and return to campaign
		this.donor = donorName;									
		return;
	}
	
	
	/*
	 * This is a constructor that is done after a search of a 
	 * particular donor is found to construct a repeat donor.
	 */ 
	public Donor(String donorName, double donation)
	{
		
		//Add name to donor 
		this.donor = donorName;												
		
		//Add donations to donation arraylist
		addDonation(donation);
		
		//Return to campaign
		return;
	}
	
	
	/*
	 * Get users name with this method
	 */
	public String getName()
	{
		//Return name of donor to Campaign
		return donor; 																				
	}
	
	
	/*
	 * Use this method to Get total donations for 1 donor
	 */
	public double getTotalDonations()
	{
		
		//Initiallize total to zero for increment
		double totalDonations = 0;
		
		//Step through donations arraylist
		for(int donationIndex = 0; donationIndex < donations.size(); 
																					++donationIndex)                                   
		{
			//Add each donation to total
			totalDonations += donations.get(donationIndex);
		}
		
		//Return total to campaign
		return totalDonations;
	}

	
	/*
	 * Convert name and donations arraylist to a string
	 */
	public String toString()
	{
		//Add the name to a string
		String donorInfo = donor + ":";
		
		//Step through donations and add each donation to string
		for(int donationsIndex = 0; donationsIndex < donations.size(); 
																					++donationsIndex)
		{
			if(donationsIndex == 0)
			{
				donorInfo += donations.get(donationsIndex);
			}
			else
				donorInfo += ", " + donations.get(donationsIndex);
		}
		
		//Return the string to campaign
		return donorInfo;
	}
	
	
	/*
	 * Use this method to add donations to arraylist
	 */
	public void addDonation(double donation)
	{
		
		//Add donation to the donations arraylist
		donations.add(donation);		
		
		//Return to campaign
		return;
	}
}