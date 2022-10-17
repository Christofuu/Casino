import java.util.Scanner; 
import java.io.IOException;
import java.io.FileWriter;

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
 *         casino game
 * 
 */
public class Casino
{
	private static Player player = new Player();
	private static String userName;
	private static int optionSelect;
	private static boolean gameState = true;
	private static Scanner userInput = new Scanner(System.in);
	
	//TODO add cash in/out
	//TODO add leaderboard has to sort by chips earned 
	//TODO add statistics
	
	/**
	 * writes user data to a leaderboard text file
	 * @param username
	 * @param chips
	 * @param money
	 */
	public static void setUserData(String username, int chips, int money)
	{
		try {
		FileWriter myWriter = new FileWriter("leaderboard.txt");
		myWriter.write(username + "\n" + chips + "\n" + money);
		myWriter.close();
		} catch(IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Presents casino menu options for the user to select from. 1 is cash in, 2 is cash out, 3 is play a game, 4 is view stats, 5 is exit.
	 * 
	 * @param args
	 */
	public static void casinoMenu(String args[])
	{
		System.out.println("Welcome to the Casino! You have " + player.getMoney() + "$ and " + player.getChips() + " chips. Enter the number of the option you wish to select.");
		System.out.println("1.) Cash in \n2.) Cash out \n3.) Play a game \n4.) View stats \n5.) Exit the casino");
		
		optionSelect = userInput.nextInt();
		
		switch (optionSelect) {
			
		case 1:

			System.out.println("You have " + player.getMoney() + "$. How many chips would you like? Enter a number between 0 and " + player.getMoney() + ".");
			int requestChips = userInput.nextInt();
			if ((requestChips > 0) && (requestChips <= player.getMoney()))
			{
				player.cashIn(requestChips);
			}
			else
			{
				userInput.close();
				throw new ArithmeticException("Please enter a value between 0 and " + player.getMoney() +".");
			}
			
			break;
			
		case 2:
			
			System.out.print("You cashed out " + player.getChips() + ".");
			player.cashOut();
			System.out.println(" Your total money is now $" + player.getMoney() + ".");
			break;
			
		case 3:
			
			System.out.println("Enter 1 to play blackjack, 2 to play slots, or 3 to return to main menu.");
			
			int gameSelect = userInput.nextInt();
			
			switch (gameSelect)
			{
				case 1:
					Blackjack.main(args);
					break;
					
				case 2:
					Slots.main(args);
					break;
					
				case 3:
					break;
					
				default:
					break;
			}
			
			break;
			
		case 4:
			System.out.println("Adding stats implementation later");
			break;
			
		case 5:
			System.out.println("Enter your username (3 chars max, letters only)");
			userName = userInput.next();
			setUserData(userName, player.getChips(), player.getMoney());
			System.out.println("Thanks for playing!");
			userInput.close();
			gameState = false;
			break;
			
		default:
			System.out.println("Select a menu option by entering a value from 1 to 5.");
			break;
		}
	}

	/**
	 * 
	 * @return player
	 */
	public static Player getPlayer()
	{
		return player;
	}
	
	public static void main(String args[])
	{
		do
		{
			casinoMenu(args);	
		} while (gameState);
	}
}
