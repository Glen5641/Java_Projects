/*
 * Short program for Powerpoint in 8/29
 */
 
import javax.swing.JOptionPane;                     
public class NoCash
{
   public static void main(String[] args)
   {
      //Intialize Variables
      String Input;
      int boxes, crates;
      final int boxes_per_crate = 10;
   
      //Input
      Input = JOptionPane.showInputDialog("What is your number of boxes?");
      boxes = Integer.parseInt(Input);
      box = (int) boxes;
      
      //Calculations
      crates = boxes / boxes_per_crate;
      boxes = boxes % boxes_per_crate;
      
      if (boxes % boxes_per_crate != 0)
         crates += 1;
      
      //Output
      System.out.println("Number of crates is " + crates);
      System.out.println("Left over boxes in crate number " + crates + 
                     " are " + boxes);
   }
}