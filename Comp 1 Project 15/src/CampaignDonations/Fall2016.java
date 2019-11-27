package CampaignDonations;

import java.util.Scanner;

/**
 * 
 * @author ClaytonGlenn
 * @version Project 16
 * @teacher Deborah Trytten
 * @Date 12/12/2016
 * 
 * This program uses the campaign and donor object to track
 * donations of a campaign of a certain candidate. This is the
 * driver of the objects and uses a menu for user interaction.
 */

public class Fall2016
{
	private static int ADD_DONOR = 1;
	private static int DONATION = 2;
	private static int SUM_DONATIONS = 3;
	private static int SINGLE_DONOR_DETAILS = 4;
	private static int QUIT = 5;

	public static void main(String[] args)
	{
		
		//Declare and initiallize needed variables
		Scanner input = new Scanner(System.in);
		int menuSelection = 0;
		
		//Assign name to the campaign object
		Campaign candidate = new Campaign("Barry Hodges");
		
		//Show candidate that the user is donating for
		System.out.println("Welcome to the donation booth for your candidate "
																+ candidate.getCandidateName() + "\n");
	
		//Go through menu selection for appropriate method
		while(menuSelection != QUIT)
		{
			menuSelection = menu(input);
		
			if(menuSelection == ADD_DONOR)
				addDonor(input, candidate);
			
			if(menuSelection == DONATION)
				addDonations(input, candidate);
			
			if(menuSelection == SUM_DONATIONS)
				sumDonations(candidate);
			
			if(menuSelection == SINGLE_DONOR_DETAILS)
				singleDonorDetails(input, candidate);
			
			if(menuSelection == QUIT)
				System.out.println("Thank you have a nice day!");
		}
		
		//Close input to make eclipse happy
		input.close();
	}
	
	private static int menu(Scanner keyboard)
	{
		
		//Display menu for user and find selection
		System.out.println("Type the number you would like to choose:");
		System.out.println("1: Add a donor");
		System.out.println("2: Make a donation");
		System.out.println("3: Find total donations");
		System.out.println("4: Find details of a single donor");
		System.out.println("5: Quit");
		int selection = keyboard.nextInt();
			
		//If selection is out of bounds, recur
		if(selection < ADD_DONOR || selection > QUIT)
		{
			System.out.println("Incorrect Answer, please try again.\n");
			return menu(keyboard);
		}
		
		//Return selection to main
		return selection;
	}
	
	private static void addDonor(Scanner input, Campaign candidate)
	{
		//Display method to user
		System.out.println("\n You have chosen: ADD DONOR\n");
		
		//Have user input name
		System.out.print("Name: ");
		String name = input.next();
		
		//Add donor to candidate object
		candidate.addDonor(name);
		
		//Ask user for initial donation, not needed, but functional
		System.out.println("Would you like to donate right now?");
		String answer = input.next();
		
		//If yes, add donation
		if(answer.equalsIgnoreCase("yes"))
		{
			System.out.print("Donation: ");
			double donation = input.nextDouble();
		
			candidate.addDonation(name, donation);
		}
		
		//Readability
		System.out.println();
		
		//Return to main
		return;
	}
	
	private static void addDonations(Scanner input, Campaign candidate)
	{
		
		//Show selection to user and find name
		System.out.println("You have chosen: ADD DONATIONS");
		System.out.println("\nEnter Name of existing donor.");
		String name = input.next();
		
		//Find donations, multiple if needed
		System.out.println("Add a donation or enter -1 to quit");
		System.out.print("Donation:");
		double donation = input.nextDouble();
		
		//While not -1, keep adding donations
		while(donation != -1)
		{
			candidate.addDonation(name, donation);
			
			System.out.print("Donation:");
			donation = input.nextDouble();
		}
		
		//Thank the user
		System.out.println("Thank you for your donations.\n");
		
		//Return to main
		return;
	}
	
	private static void sumDonations(Campaign candidate)
	{
		//Show output of all donors and total donations
		System.out.println("You have chosen: TOTAL DONATIONS\n");
		System.out.println("Donors: " + candidate.getDonors());
		System.out.println("Total Donations for " + candidate.getCandidateName() 
														+ " are $" + candidate.getAllDonations() + "\n");
		
		//Return to main
		return;
	}
	
	private static void singleDonorDetails(Scanner keyboard, Campaign candidate)
	{
		//Show menu selection, and find name
		System.out.println("You have chosen: SINGLE DONOR DETAILS");
		System.out.println("Which donor would you like details on?");
		String name = keyboard.next();
		
		//Show all information for the specified donor
		System.out.println("\n" + candidate.getDonationList(name) + "\n");
	}
}
