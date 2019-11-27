import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * @Author Clayton Glenn
 * @Teacher Deborah Trytten
 * @Version Project 14
 * @Date 11/28/2016
 * 
 * This program performs a spell check and adds words to userDictionary if needed
 */

public class Program14_ClaytonGlenn 
{
	public static void getDictionary (String fileName, ArrayList<String> dictionary) throws FileNotFoundException
	{
		
		//Read in file and add to Array List
		Scanner file = new Scanner(new File(fileName));
		while (file.hasNextLine())
		{
			dictionary.add(file.nextLine());
		}
		
		//Close file
		file.close();
	}
	
	public static void addToDictionary(ArrayList<String> dictionary, String word)
	{
		//add words to userDictionary and sort in ascending order
		dictionary.add(word);
		Collections.sort(dictionary);
	}
	
	public static void updateDictionaryFile(String fileName, ArrayList<String> dictionary) throws FileNotFoundException
	{
		//Print the new words from arraylist  into the userDictionary file
		PrintWriter writer = new PrintWriter(new File(fileName));
		for(int ctr = 0; ctr < dictionary.size(); ++ctr)
		{
			writer.write(dictionary.get(ctr) + "\n");
		}
		
		//Close the print writer
		writer.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//Declare scanner and 2 arraylists for both standard and personal dictionaries
		Scanner input = new Scanner(System.in);
		ArrayList<String> standardDictionary = new ArrayList<String>();
		ArrayList<String> userDictionary = new ArrayList<String>();
		
		//Fill arraylists from dictionaries
		getDictionary("Dictionary.txt", standardDictionary);
		getDictionary("userDictionary.txt", userDictionary);
		
		//Priming read for while loop
		System.out.println("Enter a word or Quit to stop:");
		String word = input.next();
		
		//Loop program until quit is typed
		while(!word.equalsIgnoreCase("quit"))
		{
			//Check if word is spelled correctly
			if(Collections.binarySearch(standardDictionary, word) >= 0 || 
				 Collections.binarySearch(userDictionary, word) >= 0)
			{
				System.out.println("That word is spelled correctly");
			}
			
			//If the word is not spelled correctly, ask the user if they want to add the word to their personal dictionary
			else
			{
				System.out.println("That word is not spelled correctly");
				String answer = "";
				
				//Check for validity
				while(!(answer.equalsIgnoreCase("yes")) && !(answer.equalsIgnoreCase("no")))
				{
					System.out.println("Would you like to add it to your personal dictionary Yes/No");
					answer = input.next();
					if(answer.equalsIgnoreCase("Yes"))
						addToDictionary(userDictionary, word);
					else if(answer.equalsIgnoreCase("No"))
						break;
					else
						System.out.println("Incorrect answer");
				}
			}
			
			//Restate the priming read
			System.out.println("Enter a word or Quit to stop:");
			word = input.next();
		}
		
		//Add the new words to the personal dictionary file
		updateDictionaryFile("userDictionary.txt", userDictionary);
		
		//End with goodwill closing and close input
		System.out.println("Goodbye");
		input.close();
	}
}
