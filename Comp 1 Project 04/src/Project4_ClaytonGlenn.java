import java.util.Scanner;

/*
 * Clayton Chase Glenn
 * Program 4
 * Deborah Trytten
 * 9/19/2016
 */

public class Project4_ClaytonGlenn 
{
	/*
	 * Make and test a fool-proof program that determines whether the user
	 * is stressed or not and make the program repeatable for many users 
	 */
	
	public static void main(String[] args)
	{
		
		
		//Greet User and list parameters of the test
		System.out.println("This Test Determines Whether "
				+ "You are Stressed or Not.");
		System.out.println("Please Answer the following "
				+ "Questions with Yes or No.");
		
		
		//Declare Scanner and initialize answer to blank for priming read
		Scanner input = new Scanner(System.in);
		String answer = "";
		
	
		//Declare and Initialize testGrade for score and 
		//ctr to count amount of people taking test
		int testGrade = 0; int ctr = 0;
		
		
		//Prime the test by asking the user if He/She wants to 
		//continue with test and test data to see if it is valid
		while (answer.equalsIgnoreCase("Yes") == false && 
				answer.equalsIgnoreCase("No") == false)
		{
			System.out.println("Do You Want to take this Test?");
			answer = input.next();
			if (answer.equalsIgnoreCase("Yes") == false && 
					answer.equalsIgnoreCase("No") == false)
				System.out.println("Invalid Answer, please try again!");
		}
		
		//If Answer is yes, continue with test
		if (answer.equalsIgnoreCase("Yes") == true)
		{
			while (answer.equalsIgnoreCase("Yes"))
			{
				//Restart Test Grade
				testGrade = 0;
				
				//Ask first question
				System.out.println("My dedication to work, exercise, "
						+ "diet, and friendships is waning.");
				answer = "";
				
				while (answer.equalsIgnoreCase("Yes") == false && 
						answer.equalsIgnoreCase("No") == false)
				{
					answer = input.next();
					//If Yes, Increment
					if (answer.equalsIgnoreCase("Yes") == true)
						testGrade++;
					//Check Validity
					else if(answer.equalsIgnoreCase("No") == false)
						System.out.println("Incorrect Answer, Try Again!");
				}	
				
				
				
				//Ask second question
				System.out.println("I am losing my sense of humor.");
				answer = "";
				
				while (answer.equalsIgnoreCase("Yes") == false && 
						answer.equalsIgnoreCase("No") == false)
				{
					answer = input.next();
					//If Yes, Increment
					if (answer.equalsIgnoreCase("Yes") == true)
						testGrade++;
					//Check Validity
					else if(answer.equalsIgnoreCase("No") == false)
						System.out.println("Incorrect Answer, Try Again!");
				}	
				
				answer = "";
				
				//Ask third question
				System.out.println("I feel trapped.");
				
				while (answer.equalsIgnoreCase("Yes") == false && 
						answer.equalsIgnoreCase("No") == false)
				{
					answer = input.next();	
					//If answer is yes accumulate grade
					if (answer.equalsIgnoreCase("Yes") == true)
						testGrade++;
					//Check Validity
					else if(answer.equalsIgnoreCase("No") == false)
						System.out.println("Incorrect Answer, Try Again!");
				}	
				
				answer = "";
				
				
				
				//Ask Fourth question
				System.out.println("I know what will make me feel better, "
						+ "but I just can't push myself to do it and I will"
						+ " shut down any suggestions that people make.");
				
				//Check whether or not answer is valid
				while (answer.equalsIgnoreCase("Yes") == false && 
						answer.equalsIgnoreCase("No") == false)
				{
					answer = input.next();
					//If answer is yes, accumulate grade
					if (answer.equalsIgnoreCase("Yes") == true)
						testGrade++;
					//Check Validity
					else if(answer.equalsIgnoreCase("No") == false)
						System.out.println("Incorrect Answer, Try Again!");
				}	
				answer = "";
				
		
				
				//Determine the results from accumulated grade
				if (testGrade <= 0)
					System.out.println("You do not have a stressed bone "
							+ "in your body!");
				else if (testGrade <= 1)
					System.out.println("You feel a little stressed, but "
							+ "not much!");
				else if (testGrade <= 2)
					System.out.println("You are pretty stressed, please "
							+ "relax!");
				else if (testGrade <= 3)
					System.out.println("Please find help now, you are "
							+ "way too stressed out!");
				else
					System.out.println("Warning!!!!! Stress Alert!!!");
				
				
				
				//Increment count to count number of users 
				ctr++;
				
				//Ask user to take test again and test 
				//answer to see if it is valid
				while (answer.equalsIgnoreCase("Yes") == false && 
						answer.equalsIgnoreCase("No") == false)
				{
					System.out.println("Do You Want To Take The Test Again?");
					answer = input.next();
					
					//check answer
					if (answer.equalsIgnoreCase("Yes") == false && 
							answer.equalsIgnoreCase("No") == false)
						System.out.println("Invalid Answer, please "
								+ "try again.");
				}
			}
		}
		
		
		//Show how many people took test and say goodbye
		System.out.println(ctr + " People took this test.\nGoodbye.");
		
		
		//Make eclipse happy!
		input.close();
	}
}
