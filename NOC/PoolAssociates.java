
      System.out.prin("What is your hourly rate? ");
      wages = keyboard.nextFloat();
      
      //Calculations
      volume = length * width * depth;
      capacity = volume * 7.5;
      flow = capacity / 60 / 50;
      pay = wages * flow;
      
      //Print Output
      System.out.println("Hi " + name + ",");
      System.out.println("Your pools volume is " + volume + " cubic feet.");
      System.out.printf("Your pools holds %.0f gallons of water.\n", capacity);
      System.out.printf("We can fill your pool in %.0f hours.\n", flow);
      System.out.printf("The job will cost you $%.2f.", pay);
   }
}