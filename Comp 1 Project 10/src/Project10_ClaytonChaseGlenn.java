import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * @author Clayton Glenn
 * @version Project 10
 * @teacher Deborah Trytten
 * @date 10/31/16
 * 
 * This program allows the user to input a file into a list of arrays. The program,
 *  then, finds the smallest number, sorts the array, and shuffles the array.
 */

public class Project10_ClaytonChaseGlenn 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Prompt user
		System.out.println("This program takes in an array from a file of your "
				+ "choosing and show you the smallest number in your array, sorts"
				+ " your array from ascending order, and shuffles it around.\n"
				+ "Please enter the name of you file.");
		
		//Declare local variables
		Scanner input = new Scanner(System.in);
		String fileName = input.next();
		input.close();
		
		
		//Read file to collect array
		int[] array = readArray(fileName);
		System.out.print("You have chose this set of numbers:  ");
		for(int count = 0; count < array.length; ++count)
		{
			System.out.print(array[count] + " ");
		}
		System.out.println();
		
		
		//Find smallest number
		int smallestNum = findSmallest(array);
		System.out.println("The lowest number in the set of numbers is:  "
																							+ array[smallestNum]);
		
		
		//Sort array
		int[] sortedArray = sort(array);
		System.out.print("Your numbers sorted are:  ");
		for(int count = 0; count < sortedArray.length; ++count)
		{
			System.out.print(sortedArray[count] + " ");
		}
		System.out.println();
		
		
		//Shuffle array
		int[] shuffledArray = shuffle(array);
		System.out.print("Your numbers shuffled are:  ");
		for(int count = 0; count < array.length; ++count)
		{
			System.out.print(shuffledArray[count] + " ");
		}
		System.out.println();
	}
	
	
	public static int[] sort(int[] array)
	{
		//Use library to sort the array in ascending order
		Arrays.sort(array);
		return array;
	}
	
	
	public static int[] shuffle(int[] array)
	{
		//Declare and initialize parallel arrays
		int[] shuffledArray = new int[array.length];
		int[] usedIndexes = new int[shuffledArray.length];
		int randomNum = 0;
		
		//Randomly shuffle array, but only use numbers that have not been shuffled
		for(int count = 0; count < shuffledArray.length; ++count)
		{
			randomNum = (int)(Math.random() * shuffledArray.length);
			while(usedIndexes[randomNum] == 1)
			{
				randomNum = (int)(Math.random() * shuffledArray.length);
			}
			usedIndexes[randomNum] = 1;
			shuffledArray[count] = array[randomNum];
		}
		
		return shuffledArray;
	}
	
	
	public static int findSmallest(int[] array)
	{
		//Declare and initialize locals
		int smallestNum = array[0], smallestIndex = 0;
		
		//Step through each number in the array and determine the smallest
		for(int count = 0; count < array.length; ++count)
		{
			if(array[count] < smallestNum)
			{
				smallestNum = array[count];
				smallestIndex = count;
			}
		}
		
		return smallestIndex;
	}
	
	
	public static int[] readArray(String fileName) throws FileNotFoundException
	{
		//Declare and initialize
		Scanner file = new Scanner(new File(fileName));
		int count;
		
		//Read file and increment count as you step through
		for(count = 0; file.hasNext(); ++count)
		{
			file.next();
		}
		file.close();
		
		//Declare and initialize perfect array
		int[] array = new int[count];
		file = new Scanner(new File(fileName));
	
		//Fill array with files numbers
		for(count = 0; file.hasNext(); ++count)
		{
			array[count] = file.nextInt();
		}
		file.close();
		
		return array;
	}
}
