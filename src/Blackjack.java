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
    private static boolean gameState = true;
    private static boolean exitState;
    
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
    
//    public static boolean checkPlayerValue(int value)
//    {
//    	boolean exitState = true;
//    	
//    	if (value == 21)
//    	{
//    		player.payout(pot);
//    		pot = 0;
//    		System.out.println("You won! You now have " + player.getChips() + " chips.");
//    		
//    		exitState = true;
//    	}
//    	if (value < 21)
//    	{
//    		System.out.println("You're at " + getPlayerValue());
//    		exitState = false;
//    	}
//    	
//    	if (value > 21)
//    	{
//    		System.out.println("Bust! House wins. You know have " + player.getChips() + " chips.");
//    		exitState = true;
//    	}
//    	return exitState;
//    }
    
    public static String playerHandToString()
    {
    	return "Your hand: " + player.getHand().getHandCards().toString();
    }
    
    public static String dealerHandToString()
    {
    	return "Dealers hand: " + dealer.getHand().getHandCards().toString();
    }
    
    /*
     * Checks type of win condition for the blackjack game
     * 
     * @param
     * @return boolean
     * 
     */
    public static boolean checkWin()
    {		
    	boolean win = true;
    	int playerCount = getPlayerValue();
    	int dealerCount = getDealerValue();
    	
    		// TODO make sure order is correct on these
    		// this could probably be a void switch statement? 
    		// all I want to return are side effects not actual return types
    	
    		// case a: user wins with blackjack
			if (playerCount == 21)
			{
				player.payout(pot);
				System.out.println("Blackjack! You won " + pot + " chips and now have " + player.getChips() + " chips!");
				pot = 0;
			}
			// case b: user wins with dealer bust
			else if (dealerCount > 21)
			{
				player.payout(pot);
				System.out.println("Dealer busts! You won " + pot + " chips and now have " + player.getChips() + " chips!");
			}
    		// case c: user wins where 17 < dealerCount < 21 && dealerCount < userCount < 21
			else if ((17 < dealerCount) && (dealerCount < 21) && (dealerCount < playerCount) && (playerCount < 21))
			{
				player.payout(pot);
				System.out.println("You win (dealer can't hit past 17)! You won " 
									+ pot + " chips and now have " + player.getChips() + " chips!");
			}
			// case d: dealer wins with blackjack
			else if (dealerCount == 21)
			{
				pot = 0;
				System.out.println("Dealer blackjack! You have " + player.getChips() + " left.");
			}
			// case e: dealer wins with user bus
			else if (playerCount > 21)
			{
				pot = 0;
				System.out.println("Bust! You have " + player.getChips() + " left");
			}
			// TODO case f & g, figure out how to make this restart the round 2+ gameplay cycle
			// case f: no win condition (dealer under 17, no player blackjack)
//			else if ((dealerCount < 17) && (17 < playerCount) && (playerCount < 21))
//			{
//				gameState = true;
//			}
//			// case g: no win condition (playerCount < dealerCount < 21)
//			else if ((playerCount < dealerCount) && (dealerCount < 21))
//			{
//				gameState = true;
//			}
			// if the game is not cases a-e, then it's either f or g, which both return true
			else win = false;
			
			return win;
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
    			exitState = true;
    		} else 
    		{
    			exitState = false;
    			System.out.println("Returning to Casino. Thanks for Playing!");
    			userInput.close();
    		}
    		
    	} while (exitState);
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
    		player.getHand().getHandCards().clear();
    		dealer.getHand().getHandCards().clear();
    		dealer.getDeck().setDeck();
    		dealer.getDeck().shuffleDeck(dealer.getDeck());
    		
    		// TODO Exception handling: Catch when player bets more than 500 OR more than they currently have
    		System.out.println("Perfect, lets begin! You have " + player.getChips() 
    				+ " chips. The house will match your bet. How much would you like to bet?"
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
    			System.out.println("Natural! You won " + (pot*2) + " chips. You now have " + player.getChips() + " chips.");
    			pot = 0;
    			
    			return;
    		}
    		
    		if (dealer.getHand().getHandValue(dealer.getHand().getHandCards()) == 21)
    		{
    			pot = 0;
    			System.out.println("House wins! You have " + player.getChips() + " chips.");
    			
    			return;
    		}
    		
    		// TODO Finish Round 2+ gameplay cycle
    		// TODO Round 2+ loop, 
    		
    		// ROUND 2+ (will loop until game is over)//
    		
    		// I.) Player hits or stands first
    		// II.) checkWin()
    		// III.) Dealer hits or stands
    		// IV.) checkWin()
    		 
    		do
    		{
    		// USER BEHAVIOR //
    		System.out.println("You are at " + player.getHand().getHandValue(player.getHand().getHandCards()) 
    				+ ". Enter 1 to hit, 2 to stand.");
    		
    		selectPlay = userInput.nextInt();
    		if (selectPlay == 1)
    		{
    			System.out.println("You hit.");
    			playerHit();
    			System.out.println(playerHandToString());
    			
    			gameState = !checkWin();
    		}
    		// TODO Standing sometimes ends the game with no explanation. Figure out why, fix issue
    		if (selectPlay == 2)
    		{
    			System.out.println("You stand.");
    		}
    		
    		// DEALER BEHAVIOR //
    		if (gameState == true)
    		{
    		System.out.println("Dealer is at " + dealer.getHand().getHandValue(dealer.getHand().getHandCards()));
    		if (getDealerValue() < 17)
    		{
    			// Dealer hits, show dealers card, then output if dealer busts, if not output where dealer is at
    			dealerHit();
    			System.out.println("Dealer hits.");
    			System.out.println(dealerHandToString());
    			
    			gameState = !checkWin();
    		}
    		
    		if (getDealerValue() > 17)
    		{
    			System.out.println("Dealer stands.");
    		}
    		}
    		} while (gameState);
    	}
    }
    
}