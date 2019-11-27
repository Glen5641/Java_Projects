/*
 * @Author Clayton Glenn
 * @Version Program 5
 * @Date 9/26/2017
 * @Teacher Deborah Trytten
 */

import java.util.Scanner;

public class Project5_ClaytonGlenn 
{
	
	/*
	 * This program prompts user to input results from a poll
	 *  and analyzes the results to find change in satisfaction
	 */
	
	public static void main(String[] args) 
	{
		
		//Declare and Initialize Scanner and various variables
		Scanner input = new Scanner(System.in);
		int previousData = 3, data_1 = 0, data_2 = 0, data_3 = 0, data_4 = 0,
				data_5 = 0, posChange = 0, negChange = 0, noChange = 0;
		
		
		//Explain Program to User
		System.out.println("This program analyzes your polling data.");
		
		
		//Priming Read to Prompt User
		System.out.println("Enter the polling data or -1 to stop");
		int pollingData = input.nextInt();
		
		
		//Use Sentinel Controlled Loop to Go X Number of Times
		while (pollingData != -1)
		{
			
			//Check Validity of User's Answer
			if(pollingData > 0 && pollingData <= 5)
			{
				
				//Use switch to Store Data in Variables 1-5
				switch(pollingData)
				{
					case 5: data_5++; break;
					case 4: data_4++; break; 
					case 3:	data_3++; break; 
					case 2: data_2++; break; 
					default: data_1++; break;
				}
				
				//Store Changes in Corresponding Variables
				if(pollingData > previousData)
					posChange++;
				else if(pollingData < previousData)
					negChange++;
				else
					noChange++;
				
				//Store Polling Data for Next Poll
				previousData = pollingData;
			}
			
			//If Answer is Invalid Prompt User
			else
				System.out.println("Invalid answer. Please try again.");
			
			//Prompt User to Go Again or End Program
			System.out.println("Enter the polling data or -1 to stop");
			pollingData = input.nextInt();
		}
		
		
		//Print out Results to user
		System.out.println("1 was chosen " + data_1 + " times.");
		System.out.println("2 was chosen " + data_2 + " times.");
		System.out.println("3 was chosen " + data_3 + " times.");
		System.out.println("4 was chosen " + data_4 + " times.");
		System.out.println("5 was chosen " + data_5 + " times.");
		System.out.println("\nThere were :");
		System.out.println(posChange + " Positive changes");
		System.out.println(negChange + " Negative changes");
		System.out.println(noChange + " No changes");
		
		
		//Make Java Happy
		input.close();
	}
}
