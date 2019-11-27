import javax.swing.JOptionPane;
public class Payroll
{
   public static void main(String[] args)
   {
      String InputString;
      String name;
      int Weight;
      
      name = JOptionPane.showInputDialog("What is your name?");
      
      InputString = JOptionPane.showInputDialog("What is your weight?");
      Weight = Integer.parseInt(InputString);
      
      JOptionPane.showMessageDialog(null, "Welp, " + name + ", you weigh " + Weight + " Lbs. You are fat!!!!");
   }
}