import java.util.Scanner;
//import java.io.*;

public class Blackjack extends Game
// Blackjack IS-A Game
{
	///// FIELDS /////
	
    // Blackjack HAS-A dealer
    private static Dealer dealer = new Dealer();
    private static Player player = new Player();
    private static int pot;
    private static int selectPlay;
    private static Scanner userInput = new Scanner(System.in);
    private static boolean gameState;
    
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
    
    ///// MAIN METHODS /////
    
    public static int getPlayerValue()
    {
    	return player.getHand().getHandValue(player.getHand().getHandCards());
    }
    
    public static int getDealerValue()
    {
    	return dealer.getHand().getHandValue(dealer.getHand().getHandCards());
    }
    
    public static boolean checkPlayerValue(int value)
    {
    	boolean exitState = true;
    	
    	if (value == 21)
    	{
    		player.payout(pot);
    		pot = 0;
    		System.out.println("You won! You now have " + player.getChips() + " chips.");
    		
    		exitState = true;
    	}
    	if (value < 21)
    	{
    		System.out.println("You're at " + getPlayerValue());
    		exitState = false;
    	}
    	
    	if (value > 21)
    	{
    		System.out.println("Bust! House wins. You know have " + player.getChips() + " chips.");
    		exitState = true;
    	}
    	return exitState;
    }
    
    public static String playerHandToString()
    {
    	return "Your hand: " + player.getHand().getHandCards().toString();
    }
    
    public static String dealerHandToString()
    {
    	return "Dealers hand: " + dealer.getHand().getHandCards().toString();
    }
    
    public static boolean checkDealerValue(int value)
    {
    	boolean exitState = true;
    	
    	if (value == 21)
    	{
    		System.out.println("Blackjack for the house.");
    		pot = 0;
    		System.out.println("House wins. You now have " + player.getChips() + " chips. ");
    		exitState = true;
    	}
    	
    	if (value > 21)
    	{
    		System.out.println("Dealer is at " + getDealerValue());
    		exitState = false;
    	}
    	
    	if (value < 21)
    	{
    		System.out.println("House busts. You win!");
    		player.payout(pot);
    		pot = 0;
    		System.out.println("You win! You now have " + player.getChips() + " chips. ");
    		exitState = true;
    	}
    	return exitState;
    }
    
    public static void playerHit() 
    {
    	dealer.dealCard(player.getHand());
    }
    
    public static void dealerHit()
    {
    	dealer.dealCard(dealer.getHand());
    }
    
    ///// MAIN METHOD /////
    
    public static void main(String args[])
    {
    	do
    	{
    		blackjack();
    		System.out.println("Do you want to play again? \nEnter 1 for yes, 2 to return to the Casino.");
    		selectPlay = userInput.nextInt();
    		
    		if (selectPlay == 1)
    		{
    			gameState = true;
    		} else 
    		{
    			gameState = false;
    			System.out.println("Returning to Casino. Thanks for Playing!");
    			userInput.close();
    		}
    		
    	} while (gameState);
    }
    
    ///// GAME LOGIC /////
    
    public static void blackjack()
    {	
    	System.out.println("Welcome to Blackjack! Would you like to play? \nEnter 1 for yes, 2 to return to the Casino.");
    	
    	selectPlay = userInput.nextInt();
    	
    	if (selectPlay == 2)
    	{
    		return;
    	}
    	
    	if (selectPlay == 1)
    	{
    		dealer.getDeck().setDeck();
    		dealer.getDeck().shuffleDeck(dealer.getDeck());
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
    		
    		System.out.println(playerHandToString());
    		System.out.println(dealerHandToString());
    		
    		// FIRST ROUND //
    		if (player.getHand().getHandValue(player.getHand().getHandCards()) == 21)
    		{
    			player.payout(pot * 2);
    			System.out.println("Natural! You won " + (pot*2) + "chips. You now have " + player.getChips() + " chips.");
    			pot = 0;
    			
    			return;
    		}
    		
    		if (dealer.getHand().getHandValue(dealer.getHand().getHandCards()) == 21)
    		{
    			pot = 0;
    			System.out.println("House wins!");
    			
    			return;
    		}
    		
    		// ROUND 2+ (will loop until game is over)//
    		
    		 
    		
    		// USER BEHAVIOR //
    		System.out.println("You are at " + player.getHand().getHandValue(player.getHand().getHandCards()) 
    				+ ". Enter 1 to hit, 2 to stand.");
    		
    		selectPlay = userInput.nextInt();
    		if (selectPlay == 1)
    		{
    			System.out.println("You hit.");
    			playerHit();
    			System.out.println(playerHandToString());
    			
    			if (checkPlayerValue(getPlayerValue()) == true)
    			{
    				return;
    			}
    		}
    		if (selectPlay == 2)
    		{
    			System.out.println("You stand.");
    		}
    		
    		// DEALER BEHAVIOR //
    		System.out.println("Dealer is at " + dealer.getHand().getHandValue(dealer.getHand().getHandCards()));
    		if (getDealerValue() > 17)
    		{
    			// Dealer hits, show dealers card, then output if dealer busts, if not output where dealer is at
    			dealerHit();
    			System.out.println("Dealer hits.");
    			System.out.println(dealerHandToString());
    			
    			if (checkDealerValue(getDealerValue()) == true)
    			{
    				return;
    			}
    		}
    		
    		if (getDealerValue() < 17)
    		{
    			System.out.println("Dealer stands.");
    		}
    		
    	}
    }
    
}