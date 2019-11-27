import javax.swing.JOptionPane;
public class Midwest Ag
{
   public static void main(String[] args)
   {
   String Name, Input;
   int Years;
   float Sales;
   double Salary, Pay;
   
   Name = JOptionPane.showInputDialog("What is your Name?");
   Input = JOptionPane.showInputDialog("What is your Salary?");
   Salary = Double.parseDouble(Input);
   Input = JOptionPane.showInputDialog("How many years have you worked for us?");
   Years = Int.parseInt(Input);
   Input = JOptionPane.showInputDialog("How much have you sold this month?");
   Sales = Float.parseFloat(Input);
   
   if (Sales >= 10000)
      {
      if (Years > 5)
         Pay = Salary + (years * 20) + (Sales * .06);
      else
         Pay = Salary + (years * 10) + (Sales * .06);
      }
   else if (Sales > 5000)
      {
      if (Years > 5)
         Pay = Salary + (years * 20) + (Sales * .03);
      else
         Pay = Salary + (years * 10) + (Sales * .03);
      }
   else
      {
      if (Years > 5)
         Pay = Salary + (years * 20);
      else
         Pay = Salary + (years * 10);
      }
  
   System.out.printf("Name: %s \nSalary: $%.2f \nSales: $%.2f \nPaycheck: $%.2f", Name, Salary, Sales, Pay);
   }
}