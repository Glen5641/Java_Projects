import javax.swing.JOptionPane;                     //Clayton Chase Glenn Program 2
public class Midwest
{
   public static void main(String[] args)
   {
      //Intialize Variables
      String Name, Input;
      int Years, Bonus;
      float Sales;
      double Salary, Pay, Commission;
   
      //Input
      Name = JOptionPane.showInputDialog("What is your Name?");
      Input = JOptionPane.showInputDialog("What is your Salary?");
      Salary = Double.parseDouble(Input);
      Input = JOptionPane.showInputDialog("How many years have you worked for us?");
      Years = Integer.parseInt(Input);
      Input = JOptionPane.showInputDialog("How much have you sold this month?");
      Sales = Float.parseFloat(Input);
      
      //Decision and Calculations
      if (Sales >= 10000)
         Commission = (Sales * .06);
      else if (Sales > 5000)
         Commission = (Sales * .03);
      else   
         Commission = 0;
      if (Years > 5)
         Bonus = (Years * 20);
      else
         Bonus = (Years * 10);
      
      //Calculations
      Pay = Salary + Bonus + Commission;
      
      //Output
      System.out.printf("Name: %s, ", Name);
      System.out.printf("Salary: $%,.2f, ", Salary);
      System.out.printf("Years: %d, ", Years);
      System.out.printf("Sales: $%,.2f, ", Sales);
      System.out.printf("Pay: $%,.2f", Pay);
   }
}