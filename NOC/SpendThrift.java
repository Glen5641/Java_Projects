import java.io.*;
import java.util.*;                    //Clayton Chase Glenn Program 5
public class SpendThrift
{
   public static void main(String[] args) throws IOException, FileNotFoundException
   {
      //Initiallize
      String name, inputLine, risk = "";
      int page = 0, month = 0;
      double balance, min, old, interest, total = 0, g_total = 0;
      char type;
      
      //Scan in file
      File input = new File ("E:/java5_credit.txt");
      Scanner inputFile = new Scanner (input);
      PrintWriter outfile = new PrintWriter(new FileWriter("E:\\Output.txt"));
      
      while(inputFile.hasNext())
      {
         int index = 0;
         inputLine = inputFile.nextLine();
         String[] tokens = inputLine.split ("\\s+");
         
         name = tokens[index++];
         old = Double.parseDouble (tokens[index++]);
         min = Double.parseDouble (tokens[index++]);
         type = tokens[index++].charAt(0);
         
         //Increment Page Number
         page += 1;
         
         //Find Credit Status
         if (type == 'E')
            risk = "Excellent";
         if (type == 'G')
            risk = "Good";
         if (type == 'P')
            risk = "Poor";
         
         //Reset Total
         total = 0;
         
         if(page > 1)
            outfile.printf("\f");
         //Call Heading Method
         PrintHeadings(page, name, old, min, risk, outfile);
         
         //Use loop to find payments
         while (old > 0)
         {
         
         //Increment Months
         month += 1;
         
         //Calculations
         interest = old * (.18 / 12);
         balance = old + interest;
         if (balance < min)
            min = balance;
         balance = balance - min;
         
         //Print Balances
         outfile.printf("%5d %14.2f %15.2f %14.2f %18.2f\n", month, old, interest, min, balance);
         
         //Reset Balances
         old = balance;
         
         //Increment Each File's Interest
         total += interest;
         }
         
         //Increment total interest
         g_total += total;
         
         //Print Interest
         outfile.printf("\n                Total Interest: %.2f", total);
      }
      outfile.printf("\n         Grand Total Interest: %.2f", g_total);
      outfile.close();
      inputFile.close();
   }

   public static void PrintHeadings(int page, String name, double old, double min, String risk, 
               PrintWriter outfile) throws IOException, FileNotFoundException
   {
   
   //Print Headings
   outfile.printf("SpendThrift     Clayton Glenn      Program 5      04/11/16      Page %d\n\n", page);
   outfile.printf("Name             Origional Balance     Minimum Payment     Credit Risk\n");
   outfile.printf("%-17s %16.2f %19.2f %15s\n\n\n", name, old, min, risk);
   outfile.printf("Month    Old Balance        Interest        Payment        New Balance\n");
   }
}