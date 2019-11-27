import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 * @Author			Clayton Chase Glenn
 * @Teacher		Deborah Trytten
 * @Version		Program 11
 * @Date				11/7/2016
 * 
 * 
 * This program creates multiple images of different variances with PGM's. 
 * Checkerboard, Diagonal, Vertical, and Horizontal Stripes.
 */

public class Project11_ClaytonGlenn 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Create Variables to change size of picture and width if needed
		int height = 1000, width = 1000, stripeWidth = 100;
		
		//Create char Table for images
		char[][] image = new char[height][width];
		
		//This Method produces a checkerboard image
		image = createCheckerBoardStripes(image, height, width, stripeWidth);
		writePGMFile("CheckerBoard.PGM", image, height, width);
		
		//This Method produces a Diagonal Stripe
		image = createDiagonalStripes(image, height, width, stripeWidth);
		writePGMFile("Diagonal.PGM", image, height, width);
		
		//This Method produces Vertical Stripes
		image = createVerticalStripes(image, height, width, stripeWidth);
		writePGMFile("Vertical.PGM", image, height, width);
		
		//This Method produces Horizontal Stripes
		image = createHorizontalStripes(image, height, width, stripeWidth);
		writePGMFile("Horizontal.PGM", image, height, width);
		
	}
	
	
	public static char[][] createCheckerBoardStripes(char[][] image, int ROWS, 
																								int COLS, int stripeWidth)
	{
		for(int row = 0; row < ROWS; row++)
		{
			for(int column = 0; column < COLS; column++)
			{
				
				//Color the checkers black
				if(row/ stripeWidth % 2 == 1 && column / stripeWidth % 2 == 1 || 
					row / stripeWidth % 2 == 0 && column / stripeWidth % 2 == 0)
					image[row][column] = (char)0;
				
				//Color the offsets grey
				else
					image[row][column] = (char)120;
			}
		}
		
		//Return the image
		return image;
	}
	
	public static char[][] createDiagonalStripes(char[][] image, int ROWS, 
																						int COLS, int stripeWidth)
	{
		for(int row = 0; row < ROWS; row++)
		{
			for(int column = 0; column < COLS; column++)
			{
				
				//Color the diagonal stripe white
				if((row + column) / stripeWidth  == 10)
					image[row][column] = (char)255;
				
				//Color everything else Grey
				else
					image[row][column] = (char)100;
			}
		}
		
		//Return the image
		return image;
	}
	
	public static char[][] createVerticalStripes(char[][] image, int ROWS, 
																					int COLS, int stripeWidth)
	{
		for(int row = 0; row < ROWS; row++)
		{
			for(int column = 0; column < COLS; column++)
			{
				
				//Color Stripes White
				if(column / stripeWidth % 2 == 0)
					image[row][column] = (char)255;
				
				//Color everything else Grey
				else
					image[row][column] = (char)100;
			}
		}
		
		//Return the image
		return image;
	}
	
	public static char[][] createHorizontalStripes(char[][] image, int ROWS, 
																							int COLS, int stripeWidth)
	{
		for(int row = 0; row < ROWS; row++)
		{
			for(int column = 0; column < COLS; column++)
			{
				
				//Color Stripes White
				if(row / stripeWidth % 2 == 0)
					image[row][column] = (char)255;
				
				//Color Stripes Grey
				else
					image[row][column] = (char)100;
			}
		}
		
		//Return the image
		return image;
	}
	
	public static void writePGMFile(String fileName, char[][] image, int height, int width) 
																									throws FileNotFoundException 
	{
		//Open File to Print Image
		PrintWriter file = new PrintWriter(new File(fileName));

		//Construct total amount of pixels
		file.println("P2");
		file.println(height+ " " + width);
		file.println((int) 255);

		//Print out the color of each pixel
		for (int row = 0; row < height; ++row)
		{
			for(int col = 0; col < width; ++col)
			{
				file.print((int)(image[row][col]));
				file.println(' ');
			}
		}

		//Close file
		file.close();
		}
}
