import java.util.Scanner;

/*
 * @author Clayton Chase Glenn
 * @version Project 6
 * @date 10/1/16
 * @teacher Deborah Trytten
 */

public class Project6_ClaytonGlenn 
{
	/*
	 * This program has a limited amount of product and issues product
	 * for square footage of flooring
	 */
	
	//Main Method
	public static void main(String[] args)
	{
		
		//Declare Scanner and Various Variables
		Scanner input = new Scanner(System.in);
		String answer = "";
		int width = 0, height = 0, numBoxes = 0, totalBoxes = 100;
		final int SQFEETPERBOX = 155;
		
		//Prompt User By Starting Program
		System.out.println("Welcome to FloorsRUs.");
		
		//Loop Program While Boxes > 0
		while(totalBoxes > 0)
		{
			
			//Prompt User and Scan Weight and Height
			System.out.println("We now have " + totalBoxes + " boxes left.");
			System.out.println("What is the size of your room: enter the"
									+ " width and height in feet");
			width = input.nextInt(); height = input.nextInt();
			
			//Call Method to Find NumBoxes in Order
			numBoxes = findNumBoxes(width, height, SQFEETPERBOX);
			
			//If TotalBoxes <= NumBoxes, Ask User For Rest and Check Validity
			if(totalBoxes <= numBoxes)
			{
				System.out.println("We only have " + totalBoxes 
													+ " boxes left.");
				while (answer.equalsIgnoreCase("yes") == false && 
								answer.equalsIgnoreCase("no") == false)
				{
					System.out.println("Do want to purchase all of them? "
															+ "Yes or No");
					answer = input.next();
					if (answer.equalsIgnoreCase("Yes") == true)
					{
						System.out.println("Your " + totalBoxes + " boxes will"
																	+ " be shipped to you.");
						totalBoxes = 0;
					}
					else if	(answer.equalsIgnoreCase("No") == true)
						numBoxes = 0;
					else
						System.out.println("Invalid Answer, please try again.");
				}
				
				//ReInitialize Answer to Blank
				answer = "";
			}
			
			//If numBoxes < totalBoxes, Output to User and Decrement Boxes
			else
			{
				System.out.println("Your " + numBoxes + " boxes "
																+ "will be shipped to you.");
				totalBoxes -= numBoxes;
			}
		}
		
		//Output to User Program has Ended
		System.out.println("I'm sorry, but we are now sold out of "
																	+ "Bamboo Dream Flooring");
		
		//Make Eclipse Happy
		input.close();
	}
	
	//Define Method to Compute NumBoxes for Main Method
	public static int findNumBoxes(int weight, int height, 
																final int SQFEETPERBOX)
	{
		
		//Declare and Initialize Various Variables
		int numBoxes;
		double totalFeet;
		
		//Calculate Boxes
		totalFeet = (weight * height * 0.05) + (weight * height);
		numBoxes = (int)Math.ceil(totalFeet / SQFEETPERBOX);
		
		//Return boxes to NumBoxes in Main Method
		return numBoxes;
	}
}