import java.util.Scanner;

/*
 * @author Clayton Glenn
 * @teacher Deborah Trytten
 * @date 10/24/16
 * @version Project 9
 */

public class Project9_ClaytonGlenn 
{
	
	/*
	 * This program takes in user emails to create a database
	 * checks the emails for duplicates and adds to array
	 * Also perform search for emails with partials
	 */
	
	public static void main(String[] args)
	{
		//Initialize Variables
		Scanner input = new Scanner(System.in);
		final int MAX_SIZE = 200;
		String[] emails = new String[MAX_SIZE];
		int menuNum, index = 0, emailSize = 0;
		String answer = "";
		boolean isMatching = false;
		
		//Priming read for action to take with menu
		System.out.println("Please choose from the following menu of "
																						+ "choices:");
		System.out.println("1.	Enter a new email address");
		System.out.println("2.	Find an existing email address");
		System.out.println("3.	Quit");
		System.out.print("What is your choice?		");
		
		//Take input from users keyboard for menu
		menuNum = input.nextInt();
		
		//Loop until menuNum = 3
		while(menuNum != 3)
		{
			//Use switch to show readability
			switch (menuNum)
			{
				
				/*
				 * If 1 is chosen, enter a new email address and check if
				 * duplicate. If not, add to emailsArray. If so, output show
				 * email already exists
				 */
			
				case 1:
				{
					System.out.print("Enter the email address	");
					answer = input.next();
					
					isMatching = findDuplicates(emails, answer, emailSize, 
																								isMatching);
					if(isMatching == false)
						emailSize = addNewAddress(emails, emailSize, answer);
					
					else
						System.out.println("The email you entered already "
																									+ "exists.");
					break;
				}
				
				/*
				 * If 2 is chosen, have user enter the start of the address and 
				 * call findExistingEmails method to show all matches
				 */
				
				case 2:
				{
					System.out.print("Enter the partial address	");
					answer = input.next();
					
					String[] matches = findExistingEmails(emails, emailSize, 
																										answer);
					for(index = 0; index < matches.length; ++index)
						System.out.println(index + ".	" + matches[index]);
					
					break;
				}
				
				/*
				 * If any other number than 1,2,3, then reprompt user
				 */
				
				default:
				{
					System.out.println("Invalid Input, please try again.");
					
					break;
				}
			}
			
			//Restate priming read for next round of the loop
			System.out.println("\nPlease choose from the following menu of "
																											+ "choices:");
			System.out.println("1.	Enter a new email address");
			System.out.println("2.	Find an existing email address");
			System.out.println("3.	Quit");
			System.out.print("What is your choice?		");
			menuNum = input.nextInt();
			
			//Reset boolean to search for next search
			isMatching = false;
			
			//If array is full, end the program
			if(emailSize == MAX_SIZE)
			{
				System.out.println("Database is full. Sorry.");
				menuNum = 3;
			}
		}
		
		//Make eclipse happy
		input.close();
	}
	
	public static int addNewAddress(String[] emails, int size, String newEmail)
	{
		//Add the new email to the last element in the array and increment size
		emails[size] = newEmail;
		size++;
		
		//Return emailSize to main
		return size;
	}
	
	public static String[] findExistingEmails(String[] emails, int size, 
																								String partialEmail)
	{
		//Declare and Initialize Count for perfect sized array
		int count = 0;
		int index;
		
		//Count all matches in emailsArray
		for(index = 0; index < size; ++index)
		{
			if(emails[index].startsWith(partialEmail))
			{
				++count;
			}
		}
		
		//Declare matches array and reset count
		String[] matches = new String[count];
		count = 0;
		
		//Loop back through array to create matches array
		for(index = 0; index < size; ++index)
		{
			if(emails[index].startsWith(partialEmail))
			{
				matches[count] = emails[index];
				++count;
			}
		}
		
		//Return the matches array
		return matches;
	}
	
	public static boolean findDuplicates(String[] emails, String newEmail, 
																					int size, boolean isMatching)
	{
		//Check all elements in emails Array for duplicates
		for(int i = 0; i < size; ++i)
		{
			if(emails[i].contains(newEmail))
				isMatching = true;
		}
		
		//Return the boolean isMatching to main
		return isMatching;
	}
}