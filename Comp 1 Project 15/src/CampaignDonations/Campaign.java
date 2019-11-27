package CampaignDonations;
import java.util.ArrayList;


/*
 * @Version Campaign Class
 * 
 * This portion of the project creates new campaigns
 *  for candidates and drives the donor class, storing 
 *  each donor in a list. This class is ran by the driver.
 */

public class Campaign 
{
	private String candidateName;
	private ArrayList<Donor> donors = new ArrayList<Donor>();
	
	
	/*
	 * Construct the campaign class with candidates name
	 */
	public Campaign(String candidate)
	{
		
		//Add a name to campaign from driver and return void to driver
		candidateName = candidate;											
		return;
	}
	
	
	/*
	 * Return candidates name back to driver
	 */
	public String getCandidateName()
	{
		
		//Get candidate's name to send to Driver class
		return candidateName;
	}
	
	
	/*
	 * Get all donors for the candidate and send back to driver
	 */
	public String getDonors()											
	{
		String allDonors = "";
		
		//increment through donors to get names from donor class
		for(int donorIndex = 0; donorIndex < donors.size(); ++donorIndex)
		{
			Donor donor = donors.get(donorIndex);
			
			//Add names to all donors
			if(donorIndex == donors.size() - 1)
				allDonors += donor.getName();
			else
				allDonors += donor.getName() + ", ";
		}
		
		//Return allDonors to driver
		return allDonors;
	}

	
	/*
	 * Get all donations for the candidate and send back to driver
	 */
	public double getAllDonations()								
	{
		double total = 0;
		
		//Increment through donors
		for(int donorIndex = 0; donorIndex < donors.size(); ++donorIndex)
		{
			
			//Add all donations from all donors
			Donor donor = donors.get(donorIndex);
			total += donor.getTotalDonations();
		}
		
		//Return total to driver
		return total;
	}
	
	
	/*
	 * Add a donor to the candidate
	 */
	public void addDonor(String donorName)										
	{
		//add a new donor to the donor class
		Donor donor = new Donor(donorName);
		
		//Store the donor in the ArrayList
		donors.add(donor);
		
		//Return to driver
		return;
	}
		
	
	/*
	 * Get the donations from the specified donor and return to driver
	 */
	public double getDonation(String donorName)		
	{
		
		//Find specified donor
		int donorIndex = findDonor(donorName);
		Donor donor = donors.get(donorIndex);
		
		//Return all of the donor's donations to driver
		return donor.getTotalDonations();
	}
	
	
	/*
	 * Get each donation from a specified donor and return to driver
	 */
	public String getDonationList(String donorName)
	{
		
		//Find donorIndex in arraylist
		int donorIndex = findDonor(donorName);
		
		//Get each donation from the specified donor
		return donors.get(donorIndex).toString();
	}
	
	
	/*
	 * Add a donation to the donor and return to driver
	 */
	public void addDonation(String donorName, double donation)	
	{
		
		//Find the specified donor to add a donation
		int donorIndex = findDonor(donorName);
		
		//If donor is not found, return to menu
		if(donorIndex < 0)
		{
			System.out.println(donorIndex);
			System.out.println("Name Not Found!!!");
			return;
		}
		
		//If donor is found, open in donor class and remove from arraylist
		Donor donor = donors.get(donorIndex);
		donors.remove(donorIndex);
		
		//Add donation to the donor
		donor.addDonation(donation);
		
		//Add the donor back to arraylist with new information
		donors.add(donor);
		
		//Return to driver
		return;
	}

	
	/*
	 * Find the specified donor from an inputted name
	 */
	public int findDonor(String donorName)
	{
		int donorIndex;
		
		//Search through all donors to match the donor with the specified name
		for(donorIndex = 0; donorIndex < donors.size(); ++donorIndex)
		{
			//Add each donor to a new array and convert to string
			String[] temp = donors.get(donorIndex).toString().split(":");
			
			//If donor is found, return the index of the donor
			if(temp[0].equalsIgnoreCase(donorName))
			{
				return donorIndex;
			}
		}
		
		return -1;
	}
}
















