import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * @Author Clayton Chase Glenn
 * @Date 10/17/2016
 * @Version Project 8
 * @Teacher Deborah Trytten
 * @Section 10
 */

public class Project8_ClaytonChaseGlenn
{
	
/*
 * This program is a slot machine at your local Comp Sci Sooner Slots. 
 * It generates random numbers and excites the user for a win or loss.
 */
	
	public static void main(String[] args) 
													throws InterruptedException
	{
		
		/* START PROGRAM */
		
		// Declare and Initialize local variables and Scanner
		Scanner input = new Scanner(System.in);

		// Greet user
		System.out.println("Welcome to Comp "
											+ "Sci Sooner Slots!!!");
		
		// Call playTheGame Method to START GAMBLING
		int tokens = playTheGame(input);
		
		
		/* END OF GAME */
		//If user came out ahead during the run, congratulate him/her
		if(tokens > 20)
			System.out.println("You came out ahead by " + (tokens - 20) 
																								+ " tokens!");
		
		// Tell user goodbye
		System.out.println("Thanks for playing here at Comp "
													+ "Sci Sooner Slots, Goodbye.");
		
		//Make eclipse Happy
		input.close();
		
		/* END PROGRAM */
		
	}
	
	public static int calculateWin (int[] scores)
	{
		
		/*	Find winnings for all possible 
		combinations and return to find random */
		
		//If all numbers are 7,7,7, user gets 750 tokens
		if(scores[0] == 7 &&
		     scores[1] == 7 && 
		     scores[2] == 7)
			return 750;
		
		//If all numbers are same, user gets 75 tokens
		else if	(scores[0] == scores[1] &&
					 scores[1] == scores[2])
			return 75;
		
		//If 2 numbers are 7's, user gets 20 tokens
		else if	((scores[0] == 7 && scores[1] == 7) ||
					 (scores[1] == 7 && scores[2] == 7) ||
					 (scores[0] == 7 && scores[2] == 7))
			return 20;
		
		//If 2 numbers match, user gets 5 tokens
		else if	(scores[0] == scores[1] || 
					  scores[1] == scores[2] || 
					  scores[2] == scores[0])
			return 5;
		
		//If none of the numbers match, user loses a token
		else
			return -1;
		
	}
	
	public static int playTheGame (Scanner input) 
													throws InterruptedException
	{
		
		// Declare and Initialize Local Variables
		final int LOW = 1, HIGH = 10;
		int tokens = 20;
		String answer = "yes";
		
		// Announce starting amount of tokens
		System.out.println("You have " + tokens + " tokens.");
		
		
		/* While user says yes, and has tokens, 
		loop game until otherwise told to do so*/
		while (answer.equalsIgnoreCase("yes") && tokens > 0)
		{
			
			//Call findRandom and find winnings from the game
			int winnings = findRandom (LOW, HIGH);
			
			//Tell user the outcome and increment tokens
			System.out.println("You earned " + winnings + " points.");
			tokens += winnings;
			System.out.println("You now have " + tokens + " tokens.");
			
			
			/*Only if tokens > 0, continue to ask user to play again, 
			and check validity of the answer. If yes, restart the loop*/
			if (tokens > 0)
			{
				//Ask user to play again
				System.out.println("Would you like to play again? Yes/No");
				answer = input.next();
				
				//Check Validity
				while (!(answer.equalsIgnoreCase("yes") || 
								answer.equalsIgnoreCase("no")))
				{
					if (!(answer.equalsIgnoreCase("yes") || 
							answer.equalsIgnoreCase("no")))
					{
						System.out.println("Invalid answer, please try again. "
																								+ "Yes/No");
						answer = input.next();
					}
				}
			}
			
			//If tokens have run out
			else
				System.out.println("You lose.");
		}
		
		//Return tokens to Main
		return tokens;
		
	}
	
	public static int findRandom (int low, int high) 
																throws InterruptedException
	{
		
		//Declare and Initialize Local Variables
		int roundCtr = 0, numCount = 0;
		int[] scores = new int[3];
		
		//Prompt user for number Roll
		System.out.println("Your spin is:");
		
		
		/* Loop 4 rounds of 3 numbers for a number roll with 
		the numbers showing up more and more slowly */
		
		//Loop for 4 rounds to gain suspense
		for(roundCtr = 1; roundCtr < 5; roundCtr++)
		{
			
			//Call timeDelay to slow round between numbers 
			timeDelay(roundCtr, numCount);
			System.out.print("[");
			
			/*Loop a random generator to make 
			an array of 3 numbers to make a set */
			for(numCount = 0; numCount < scores.length; numCount++)
			{
				scores[numCount] = (int)(Math.random() * high) + low;
				System.out.print(scores[numCount]);
				
				if(numCount < scores.length - 1)
					System.out.print(", ");
				
				//Call timeDelay to slow each number
				if(roundCtr != 4)
					timeDelay(roundCtr, numCount);
			}
			
			/*Do not leave ellipses on last set 
			of digits to show user their numbers */
			System.out.print("]");
			if(roundCtr < 4)
				System.out.print("   ???   ");
		}
		
		//Drop a line for readability once loop is exited
		timeDelay(roundCtr, numCount);
		System.out.println("");
		
		/*Calculate the winnings from the current 
				roll and return to playTheGame */
		return calculateWin (scores);
		
	}
	
	
	public static void timeDelay(int roundCtr, int numCount) 
																	throws InterruptedException
	{
		
		//Slow down number roll until last number is reached
		TimeUnit.MILLISECONDS.sleep(70 * roundCtr * (numCount + 1));
	}
}
