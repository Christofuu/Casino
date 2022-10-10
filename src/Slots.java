package project1;

import java.util.Scanner;

public class Slots
{
	
	
	public static void main(String args[])
	{
	
		Scanner scanner = new Scanner(System.in);
		int playCoin = 0, userTotalCoin = 100;
		
		String startString = "1";
		String endString = "2";
		String userInput = "";
		
		System.out.println("Welcom to Slot Machine!");
		Machine slotMachine = new Machine(userTotalCoin);
		
		
		while (startString.equals(startString))
		{
			
			System.out.println("How much coin do you want to play?");
			
			playCoin = scanner.nextInt();

			//compute slot Machine
			slotMachine.slotCompute();
			
			if (slotMachine.getWinOrLose() == true)
			{
				userTotalCoin = userTotalCoin + (playCoin * slotMachine.getWinningMultiplier());
				
			} else if (slotMachine.getWinOrLose() == false) {
				
				userTotalCoin = userTotalCoin - playCoin;

			}
			
			System.out.println("Your Coin is now " + userTotalCoin);
			System.out.println("Do you want to play again? 1.Yes 2.No");
			userInput = scanner.next();
			
			
		if(userInput.equals(endString)){
			
			System.out.println("Your total Coin is " + userTotalCoin);
			
		}
			
		
		}
			
	}
}
