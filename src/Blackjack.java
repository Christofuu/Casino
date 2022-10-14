import java.util.Scanner;
// import java.io.*;

/**
 * Lead Author(s):
 * 
 * @author Christopher Dove
 * @author
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
 *         Version/date: 10/14/2022
 * 
 *         Responsibilities of class: To define and implement methods of the
 *         blackjack game
 *         child class of Game
 * 
 */

// TODO Add username search which tracks chips over multiple sessions using I/O
// TODO Make player a BlackjackPlayer, player will be parent class for slots and
// blackjack
// TODO Update UML, Make week 1 video
public class Blackjack extends Game
// Blackjack IS-A Game
{
	///// FIELDS /////

	// Blackjack HAS-A dealer
	private static Dealer dealer = new Dealer();
	// Blackjack HAS-A player
	private static BlackjackPlayer player = new BlackjackPlayer();
	// Blackjack HAS-A pot
	private static int pot;
	// selectPlay dictates initially if the user plays,
	// and if the user keeps playing after each game ends
	private static int selectPlay;
	// Blackjack HAS user input
	private static Scanner userInput = new Scanner(System.in);
	// true when no win conditions have been met, else false
	// blackjack method will execute while gameState == true
	private static boolean gameState = true;
	// false when user chooses to play/keeps playing blackjack
	// true when user quits, when true program exits
	private static boolean exitState;

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
		return "Your hand: " + player.getHand().getHandCards().toString();
	}

	/**
	 * 
	 * @return String
	 */
	public static String dealerHandToString()
	{
		return "Dealers hand: " + dealer.getHand().getHandCards().toString();
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
			player.payout(pot);
			System.out.println("Blackjack! You won " + pot
					+ " chips and now have " + player.getChips() + " chips!");
		}
		// case b: user wins with dealer bust
		else if (dealerCount > 21)
		{
			player.payout(pot);
			System.out.println("Dealer busts! You won " + pot
					+ " chips and now have " + player.getChips() + " chips!");
		}
		// case c: user wins where 17 < dealerCount < 21 && dealerCount <
		// userCount < 21
		else if ((17 < dealerCount) && (dealerCount < 21)
				&& (dealerCount < playerCount) && (playerCount < 21))
		{
			player.payout(pot);
			System.out.println("You win (dealer can't hit past 17)! You won "
					+ pot + " chips and now have " + player.getChips()
					+ " chips!");
		}
		// case d: dealer wins with blackjack
		else if (dealerCount == 21)
		{
			System.out.println("Dealer blackjack! You have " + player.getChips()
					+ " left.");
		}
		// case e: dealer wins with user bus
		else if (playerCount > 21)
		{
			System.out.println("Bust! You have " + player.getChips() + " left");
		}
		// case f: no win condition (dealer under 17, no player blackjack)
		// if the game is not cases a-e, then it's either f or g, which both
		// return true
		else win = false;

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

	///// MAIN METHOD /////

	// TODO Make this exit to Casino main menu

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
			blackjack();
			System.out.println(
					"Do you want to play again? \nEnter 1 for yes, 2 to return to the Casino.");
			selectPlay = userInput.nextInt();

			if (selectPlay == 1)
			{
				exitState = true;
			}
			else
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
		System.out.println(
				"Welcome to Blackjack! Would you like to play? \nEnter 1 for yes, 2 to return to the Casino.");

		selectPlay = userInput.nextInt();

		if (selectPlay == 2)
		{
			return;
		}

		// input of 1 initializes game
		if (selectPlay == 1)
		{
			// Resets any prior game conditions
			pot = 0;
			player.getHand().getHandCards().clear();
			dealer.getHand().getHandCards().clear();
			dealer.getDeck().setDeck();
			dealer.getDeck().shuffleDeck(dealer.getDeck());

			System.out.println("Perfect, lets begin! You have "
					+ player.getChips()
					+ " chips. The house will match your bet. How much would you like to bet?"
					+ "\nEnter a number between 2 and 500.");

			int bet = 0;
			bet = userInput.nextInt();

			// it'd be nice if these two if statements could jump back up to
			// entering a bet if they catch the error
			if ((bet < 2) || (500 < bet))
			{
				throw new ArithmeticException(
						"Please enter a value between 2 and 500");
			}

			if (player.getChips() < bet)
			{
				throw new ArithmeticException(
						"Not enough chips! Please enter a value between 2 and "
								+ player.getChips() + ".");
			}

			pot = 2 * player.bet(bet);

			System.out.println("You bet: " + (pot / 2) + " chips and have: "
					+ player.getChips() + " chips remaining. "
					+ "\nThe pot is: " + pot + "\nLet's begin.");

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
				System.out.println("Natural! You won " + (pot * 2)
						+ " chips. You now have " + player.getChips()
						+ " chips.");
				pot = 0;

				return;
			}

			if (getDealerValue() == 21)
			{
				pot = 0;
				System.out.println("House wins! You have " + player.getChips()
						+ " chips.");

				return;
			}

			// ROUND 2+ (will loop until game is over)//

			// I.) Player hits or stands first
			// II.) checkWin()
			// III.) Dealer hits or stands
			// IV.) checkWin()

			do
			{
				// USER BEHAVIOR //
				System.out.println("You are at " + getPlayerValue()
						+ ". Dealer is at " + getDealerValue()
						+ ". Enter 1 to hit, 2 to stand.");

				selectPlay = userInput.nextInt();
				if (selectPlay == 1)
				{
					System.out.println("You hit.");
					playerHit();
					System.out.println(playerHandToString());
					System.out.println("You are at " + getPlayerValue() + ".");

					gameState = !checkWin();
				}
				// FIXED(?) Standing sometimes ends the game with no
				// explanation. Figure out why, fix issue
				if (selectPlay == 2)
				{
					System.out.println("You stand.");
				}

				// DEALER BEHAVIOR //
				if (gameState == true)
				{

					System.out
							.println("Dealer is at "
									+ dealer.getHand().getHandValue(
											dealer.getHand().getHandCards())
									+ ".");

					// Dealer will always hit under 17
					if (getDealerValue() < 17)
					{
						// Dealer hits, show dealers card, then output if dealer
						// busts, if not output where dealer is at
						dealerHit();
						System.out.println("Dealer hits.");
						System.out.println(dealerHandToString());

						// if player didn't win (checkWin() == false) then
						// gameState is true (game is still going) and vice
						// versa
						gameState = !checkWin();
					}

					// Dealer will always stand at 17 or over
					else if (getDealerValue() >= 17)
					{
						System.out.println("Dealer stands.");
					}

				}

			} while (gameState);
		}
	}
}