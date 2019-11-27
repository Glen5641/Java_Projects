import javax.swing.JOptionPane;                     //Clayton Chase Glenn Program 3
public class KanOkla
{
   public static void main(String[] args)
   {
      
      //Intialize Variables
      String Name, Input;
      int Weight, Height;
      
      Input = JOptionPane.showInputDialog("What is your weight in LBS?");
      Weight = Integer.parseInt(Input);
      
      Input = JOptionPane.showInputDialog("What is your height in Inches?");
      Height = Integer.parseInt(Input);
               
      
      System.out.println("You weigh " + Weight + " Pounds and you are " + Height +
                ", and your BMI is fat... Fucking fat");
    }
}
