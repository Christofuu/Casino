import java.util.Scanner;

/**
 * Lead Author(s):
 * 
 * @author Christopher Dove
 * @author Jo Kim
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date: 10/17/2022
 * 
 *         Responsibilities of class: To define and implement methods of the
 *         blackjack game
 * 
 */

// TODO Add username search which tracks chips over multiple sessions using I/O
public class Blackjack
{
	///// FIELDS /////

	// Blackjack HAS-A dealer
	private static Dealer dealer = new Dealer();
	// Blackjack HAS-A player
	private static Player player = Casino.getPlayer();
	// Blackjack HAS-A pot
	private static int pot;
	private static int bet = 0;
	// blackjack method will execute while gameState == true
	private static boolean gameState = false;
	// false when user chooses to play/keeps playing blackjack
	// true when user quits, when true program exits
	private static boolean exitState;
	private static boolean playerWin = true;

	public Blackjack()
	{
	}
	
	///// METHODS /////

	/**
	 * gets count of players hand
	 * 
	 * @return int
	 */
	public static int getPlayerValue()
	{
		return player.getHand().getHandValue(player.getHand().getHandCards());
	}

	/**
	 * gets count of dealers hand
	 * 
	 * @return int
	 */
	public static int getDealerValue()
	{
		return dealer.getHand().getHandValue(dealer.getHand().getHandCards());
	}

	/**
	 * 
	 * @return String
	 */
	public static String playerHandToString()
	{
		return player.getHand().getHandCards().toString();
	}

	/**
	 * 
	 * @return String
	 */
	public static String dealerHandToString()
	{
		return dealer.getHand().getHandCards().toString();
	}
	
	public static boolean getPlayerWin() {
		return playerWin;
	}
	
	public static boolean getGameState() {
		return gameState;
	}

	/**
	 * 
	 * Checks type of win condition for the blackjack game
	 * used to determine game state based on if true or false was returned
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

		// case a: user wins with blackjack
		if (playerCount == 21)
		{
			System.out.println("win condition a");
			player.payout(pot);
			return win;
		}
		// case b: user wins with dealer bust
		if (dealerCount > 21 && playerCount < 21)
		{
			System.out.println("win condition b");
			player.payout(pot);
			return win;
		}
		// case c: user wins where 17 < dealerCount < 21 && dealerCount <
		// userCount < 21
		if ((17 <= dealerCount) && (dealerCount < 21)
				&& (dealerCount < playerCount) && (playerCount < 21))
		{
			System.out.println("win condition c");
			player.payout(pot);
			return win;
		}
		// case d: dealer wins with blackjack or player busts
		if (dealerCount == 21 || playerCount > 21)
		{
			System.out.println("win condition d");
			playerWin = false;
			return win;
		}
		// case f: no win condition (dealer under 17, no player blackjack)
		// if the game is not cases a-e, then it's either f or g, which both
		// return true
		System.out.println("no win condition met");
		win = false;

		return win;
	}

	/**
	 * deals a card to the player's hand
	 * 
	 * @return void
	 */
	public static void playerHit()
	{
		dealer.dealCard(player.getHand());
	}

	/**
	 * deals a card to dealer's hand
	 * 
	 * @return void
	 */
	public static void dealerHit()
	{
		dealer.dealCard(dealer.getHand());
	}

	/**
	 * checks if bet is valid, returns true if it is and false otherwise
	 * @param bet
	 * @return boolean
	 */
	public static boolean checkBet(int bet)
	{	
		if ((bet < 2) || (500 < bet))
		{
			return false;
		}
		else if (player.getChips() < bet)
		{
			return false;
		}
		return true;
	}
	
	public static void setBet(int val) {
		bet = val;
	}
	
	public static void setPot() {
		pot = 2 * player.bet(bet);
	}
	
	public static int getPot() {
		return pot;
	}
	///// MAIN METHOD /////

	/**
	 * 
	 * loops blackjack method based on user input before the first game cycle
	 * and after each following
	 * user enters 1, game executes
	 * user enters 2, program exits (eventually to casino main menu)
	 */
	public static void main(String args[])
	{
		do
		{
			blackjack(bet);

		} while (exitState);
	}
	
	public static void resetGameConditions() {
		bet = 0;
		pot = 0;
		player.getHand().getHandCards().clear();
		dealer.getHand().getHandCards().clear();
		dealer.getDeck().setDeck();
		dealer.getDeck().shuffleDeck(dealer.getDeck());
	}
	///// GAME LOGIC /////

	/**
	 * game logic for blackjack
	 * user can bet between 2 and 500
	 * house matches user's bet
	 * if user gets blackjack turn 1 they win twice the pot
	 * dealer always hits under 17 and stands at 17 or over
	 */
	public static void blackjack(int val)
	{
			// Resets any prior game conditions
			gameState = true;

			bet = val;
			setPot();
			
			for (int i = 0; i < 2; i++)
			{
				dealer.dealCard(player.getHand());
				dealer.dealCard(dealer.getHand());
			}

			System.out.println(playerHandToString());
			System.out.println(dealerHandToString());

			// FIRST ROUND //

			// I.) Check for player blackjack
			// if true, then payout double, player wins
			// II.) Check for dealer blackjack
			// if true then dealer wins
			if (getPlayerValue() == 21)
			{
				player.payout(pot * 2);
				pot = 0;

				return;
			}

			if (getDealerValue() == 21)
			{
				pot = 0;
				return;
			}
	}

			// ROUND 2+ (will loop until game is over)//

			// I.) Player hits or stands first
			// II.) checkWin()
			// III.) Dealer hits or stands
			// IV.) checkWin()
	public static boolean blackjackLoop() {
		// USER BEHAVIOR //
		// DEALER BEHAVIOR //
		if (checkWin() == false)
			{
			// Dealer will always hit under 17
			if (getDealerValue() < 17)
				{
					// Dealer hits, show dealers card, then output if dealer
					// busts, if not output where dealer is at
					dealerHit();

					// if player didn't win (checkWin() == false) then
					// gameState is true (game is still going) and vice
					// versa
					
				}
				// Dealer will always stand at 17 or over
			}
		return !checkWin();
	}
}