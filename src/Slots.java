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
 *         slots game
 * 
 */
public class Slots

{
	// FIELD
	private static int playCoin;
	private static int userSelect;

	private static boolean gameState;

	private static Scanner userInput = new Scanner(System.in);

	private static Player slotplayer = Casino.getPlayer();
	
	/**
	 * takes bet from user and checks it's validity. bets between 2 and 500 are valid, user can't bet more than they have
	 */
	public static void checkBet()
	{
		boolean validBet = false;
		
		do
		{
			System.out.println("How many chips do you want to bet?");
			
			playCoin = userInput.nextInt();
			if (playCoin > slotplayer.getChips())
			{
				System.out.println("Not enough chips! Enter a number between 2 and " + slotplayer.getChips() + ".");
			}
			else if ((playCoin < 2) || (500 < playCoin))
			{
				System.out.println(
						"Please enter a value between 2 and 500");
			}
			else validBet = true;
			
		} while (validBet == false);
	}

	public static void slotMachine() {

		Machine slotMachine = new Machine();

		if (userSelect == 1) {

			checkBet();

			slotplayer.bet(playCoin);
			slotMachine.slotCompute();

			if (slotMachine.getWinOrLose() == true) {

				slotplayer.payout(playCoin * Machine.getWinningMultiplier());
				System.out.println("You now have " + slotplayer.getChips() + " chips.");
				System.out.println("------------------------------------------------");

			} else if (slotMachine.getWinOrLose() == false) {

				slotplayer.getChips();
				System.out.println("------------------------------------------------");
				System.out.println("You now have " + slotplayer.getChips() + " chips.");
			}
			// System.out.println("Do you want to play Again? \nEnter [ 1 ] for Yes, [ 2 ] to return to the Casino.");
			
			

		}
		if (userSelect == 2) {
			return;
		}

	}

	public static void main(String args[]) {
		do {
			System.out.println("Welcome to Slot Machine!");
			System.out.println("Would you like to play? \nEnter [ 1 ] for Yes, [ 2 ] to return to the Casino.");
			userSelect = userInput.nextInt();

			if (userSelect == 1) {

				slotMachine();
				gameState = true;

			} else if (userSelect == 2) {
				gameState = false;
				System.out.println("Returning to Casino. Thanks for playing!");
				//slotplayer.setChips() //probably set userTotal chip into saving file by user.
			}

		} while (gameState);

	}
}
