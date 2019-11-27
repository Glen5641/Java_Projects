

/*
 * Clayton Chase Glenn
 * @version Project 3
 * CS 1323
 * Section 1
 * Deborah Trytten
 *
 * Write a program that uses Integers, Constants, 
 * and Doubles to find total cost of books by using 
 * arithmetic operation and write output to console.
 */

public class Project3 
{
	public static void main(String[] args) 
	{
		//State Instructions for copies of books
		System.out.println("This program shows total amount " + 
							"for your bookstore purchase?\n");
		
		//Declare and initialize quantity of books purchased by user				//3 Integers
		int quantityGift = 3;
		int quantityEffective = 2;
		int quantityOperating = 1;
		
		//Print details of copies of books purchased at price
		System.out.println("You purchased 3 HardBack copies of " + 
							"Gift of Fire by Basse for $107.97.");
		System.out.println("You purchased 2 E-Book copies of " + 
							"Effective Java by Bloch and Gafter for $37.06.");
		System.out.println("You purchased 1 PaperBack copy of " + 
							"Operating Systems by Stallings for $209.75.");
		
		//find pricing of each version of book										//3 Constant Doubles
		final double costGift = quantityGift * 107.97;
		final double costEffective = quantityEffective * 37.06;
		final double costOperating = quantityOperating * 209.75;
		
		//Find the subtotal price of all books
		double subTotal = costGift + costEffective + costOperating;
		
		//Declare and initialize sales tax											//1 Constant Doubles
		final double salesTax = 0.065;
		
		//Find total cost															//1 Double
		double totalCost = salesTax * subTotal + subTotal;
		
		//Print out total to user for final cost of books
		System.out.printf("\nYour Purchase costs $%.2f.", totalCost);
	}
}