
import java.util.Scanner;

public class Slots

{
	// FIELD
	private static int playCoin;
	private static int userSelect;

	private static boolean gameState;

	private static Scanner userInput = new Scanner(System.in);

	private static Player slotplayer = Casino.getPlayer();

	public static void slotMachine() {

		Machine slotMachine = new Machine();

		if (userSelect == 1) {

			System.out.println("How much coin do you want to play?");

			//TODO catch if player bets more than they have in chips or a negative number
			slotplayer.getChips();
			playCoin = userInput.nextInt();

			slotplayer.bet(playCoin);
			slotMachine.slotCompute();

			if (slotMachine.getWinOrLose() == true) {

				slotplayer.payout(playCoin * Machine.getWinningMultiplier());
				System.out.println("Your total Chip is now " + slotplayer.getChips());
				System.out.println("------------------------------------------------");

			} else if (slotMachine.getWinOrLose() == false) {

				slotplayer.getChips();
				System.out.println("------------------------------------------------");
				System.out.println("Your total Chip is now " + slotplayer.getChips());
			}
			// System.out.println("Do you want to play Again? \nEnter [ 1 ] for Yes, [ 2 ] to return to the Casino.");
			
			

		}
		if (userSelect == 2) {
			return;
		}

	}

	public static void main(String args[]) {
		do {
			System.out.println("Welcom to Slot Mechine!");
			System.out.println("Would you like to play? \nEnter [ 1 ] for Yes, [ 2 ] to return to the Casino.");
			userSelect = userInput.nextInt();

			if (userSelect == 1) {

				slotMachine();
				gameState = true;

			} else if (userSelect == 2) {
				gameState = false;
				System.out.println("Returning to Casino. Thanks for Playing!");
				//slotplayer.setChips() //probably set userTotal chip into saving file by user.
			}

		} while (gameState);

	}
}
