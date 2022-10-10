import java.util.Scanner;
//import java.io.*;

public class Blackjack extends Game
// Blackjack IS-A Game
{
    // Blackjack HAS-A dealer
    private static Dealer dealer = new Dealer();
    private static Player player = new Player();
    private static int pot;
    private static int selectPlay;
    private static Scanner userInput = new Scanner(System.in);
  
    
//    public static void selectPlay(String userMessage) 
//    {
//    	System.out.println(userMessage);
//    	
//    	selectPlay = userInput.nextInt();
//		if (selectPlay == 1)
//		{
//			;
//		}
//		if (selectPlay == 2)
//		{
//			userInput.close();
//			return;
//		}
//    }
    
    public static int getPlayerValue()
    {
    	return player.getHand().getHandValue(player.getHand().getHandCards());
    }
    
    public static int getDealerValue()
    {
    	return dealer.getHand().getHandValue(dealer.getHand().getHandCards());
    }
    
    public static void checkPlayerValue(int value)
    {
    	if (value == 21)
    	{
    		player.payout(pot);
    		pot = 0;
    		System.out.println("You won! You now have " + player.getChips() + " chips."
    				+ "\nPlay again? Enter 1 for yes, 2 for no");
    	}
    	if (value < 21)
    	{
    		System.out.println("You're at " + getPlayerValue());
    	}
    	
    	if (value > 21)
    	{
    		System.out.println("Bust! House wins. You know have " + player.getChips() + " chips."
    				+ "\nPlay again? Enter 1 for yes, 2 for no");
    	}
    }
    
    public static void checkDealerValue(int value)
    {
    	if (value == 21)
    	{
    		System.out.println("Blackjack for the house.");
    		pot = 0;
    		System.out.println("House wins. You now have " + player.getChips() + " chips. "
    				+ "\nPlay again? Enter 1 for yes, 2 for no");
    	}
    	
    	if (value > 21)
    	{
    		System.out.println("Dealer is at " + getDealerValue());
    	}
    	
    	if (value < 21)
    	{
    		System.out.println("House busts. You win!");
    		player.payout(pot);
    		pot = 0;
    		System.out.println("You win! You now have " + player.getChips() + " chips. "
    				+ "\nPlay again? Enter 1 for yes, 2 for no");
    	}
    }
    
    public static void playerHit() 
    {
    	dealer.dealCard(player.getHand());
    }
    
    public static void dealerHit()
    {
    	dealer.dealCard(dealer.getHand());
    }
    
    public static void main(String args[])
    {	
    	System.out.println("Welcome to Blackjack! Would you like to play? \nEnter 1 for yes, 2 to return to the Casino.");
    	
    	selectPlay = userInput.nextInt();
    	
    	if (selectPlay == 2)
    	{
    		userInput.close();
    		return;
    	}
    	
    	playAgain:
    	if (selectPlay == 1)
    	{
    		System.out.println("Perfect, lets begin! The house will match your bet. How much would you like to bet?"
    				+ "\nEnter a number between 2 and 500.");
    		
    		pot = 2 * player.bet(userInput.nextInt());
    		
    		System.out.println("You bet: " + (pot / 2) + " chips and have: " + player.getChips() + " chips remaining. "
    				+ "\nThe pot is: " + pot + "\nLet's begin.");
    		
    		for (int i = 0; i < 2; i++)
    		{
    			dealer.dealCard(player.getHand());
    			dealer.dealCard(dealer.getHand());
    		}
    		
    		System.out.println("Your hand: " + player.getHand().getHandCards().toString());
    		System.out.println("Dealers hand: " + dealer.getHand().getHandCards().toString());
    		
    		// FIRST ROUND //
    		if (player.getHand().getHandValue(player.getHand().getHandCards()) == 21)
    		{
    			player.payout(pot * 2);
    			System.out.println("Natural! You won " + (pot*2) + "chips. You now have " + player.getChips() + " chips."
    					+ "\nPlay again? (Enter 1 for yes, 2 for no)");
    			pot = 0;
    			
    			selectPlay = userInput.nextInt();
    			if (selectPlay == 1)
    			{
    				break playAgain;
    			}
    			if (selectPlay == 2)
    			{
    				userInput.close();
    				return;
    			}
    		
    		}
    		
    		if (dealer.getHand().getHandValue(dealer.getHand().getHandCards()) == 21)
    		{
    			pot = 0;
    			System.out.println("House wins! Play again? (Enter 1 for yes, 2 for no)");
    			
    			selectPlay = userInput.nextInt();
    			if (selectPlay == 1)
    			{
    				break playAgain;
    			}
    			if (selectPlay == 2)
    			{
    				userInput.close();
    				return;
    			}
    		}
    		
    		// ROUND 2+ (will be same)//
    		
    		// USER BEHAVIOR //
    		System.out.println("You are at " + player.getHand().getHandValue(player.getHand().getHandCards()) 
    				+ ". Enter 1 to hit, 2 to stand.");
    		
    		selectPlay = userInput.nextInt();
    		if (selectPlay == 1)
    		{
    			System.out.println("You hit.");
    			playerHit();
    			checkPlayerValue(getPlayerValue());
    		}
    		if (selectPlay == 2)
    		{
    			System.out.println("You stand.");
    		}
    		
    		// DEALER BEHAVIOR //
    		if (getDealerValue() > 17)
    		{
    			// Dealer hits, show dealers card, then output if dealer busts, if not output where dealer is at
    			dealerHit();
    			System.out.println("Dealer hits.");
    			checkDealerValue(getDealerValue());
    		}
    		
    		if (getDealerValue() < 17)
    		{
    			System.out.println("Dealer stands.");
    		}
    		
    	}
    	userInput.close();
    }
    
}