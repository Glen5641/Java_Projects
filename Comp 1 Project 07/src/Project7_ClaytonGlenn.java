import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * @Author Clayton Chase Glenn
 * @Teacher Deborah Trytten
 * @Version Project 7
 * @Date 10/10/16
 * 
 * This program reads in a file and counts the occurrences of each 
 * punctuation in each sentence and averages for whole text file.
 */

public class Project7_ClaytonGlenn 
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		//Declare Variables and Scanner
		Scanner input = new Scanner(System.in);
		String fileName = "";
		
		//Explain program to User
		System.out.println("This program reads in files and averages "
												+ "punctuation in sentences.");
		
		//Priming Read
		System.out.println("Enter the file name or Quit to stop");
		fileName = input.nextLine();
		
		//Loop until user prompts
		while(fileName.equalsIgnoreCase("QUIT") == false)
		{
			//Call Method to Analyze File
			analyzeText(fileName);
			
			//Prompt user to go again?
			System.out.println("Enter the file name or Quit to stop");
			fileName = input.nextLine();
		}
		//End Program with Good Will Closing
		System.out.println("That's all folks!");
		
		//Make Eclipse Happy
		input.close();
	}
	
	public static void analyzeText(String fileName) throws FileNotFoundException
	{
		//Declare Parallel Arrays and New Scanner for File
		Scanner file = new Scanner (new File (fileName));
		char[] punctuations = {'.', '?', '!', ',', ';', ':'};
		int[] punctuationAvg = new int[6];
		String singleLine = "";
		
		//Find Number of Lines in the File and jump to Next Line
		int numLines = file.nextInt();
		file.nextLine();
		
		//Loop while File has new Lines
		while(file.hasNextLine())
		{
			//Scan in Next Single Line
			singleLine = file.nextLine();
			
			//Loop the single line with different punctuations
			for(int ctr = 0; ctr < punctuationAvg.length; ctr++)
			{
				//Call a method to count occurrences of punctuation
				punctuationAvg[ctr] += countOccurences (singleLine, punctuations[ctr]);
			}
		}
		
		//Print Output of each of the punctuations
		System.out.println("The analysis of " + fileName);
		System.out.println("There were " + punctuationAvg[0] / (double)numLines + " periods per sentence.");
		System.out.println("There were " + punctuationAvg[1] / (double)numLines + " question marks per sentence.");
		System.out.println("There were " + punctuationAvg[2] / (double)numLines + " exclamation points per sentence.");
		System.out.println("There were " + punctuationAvg[3] / (double)numLines + " commas per sentence.");
		System.out.println("There were " + punctuationAvg[4] / (double)numLines + " semicolons per sentence.");
		System.out.println("There were " + punctuationAvg[5] / (double)numLines + " colons per sentence.");
		file.close();
	}
	
	public static int countOccurences(String line, char punctuation)
	{
		//Declare local count to count Occurrences
		int count = 0;
		
		//Loop until end of line is met
		for(int ctr = 0; ctr < line.length(); ctr++)
		{
			//If character is a punctuation, increment
			if(line.charAt(ctr) == punctuation)
			{
				++count;
			}
		}
		
		//Return count to AnalyzeText
		return count;
	}
}
