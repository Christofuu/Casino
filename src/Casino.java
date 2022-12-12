import java.util.Scanner; 

public class Casino
{
	private static Player player = new Player();
	private static int optionSelect;
	private static boolean gameState = true;
	private static Scanner userInput = new Scanner(System.in);
	
	/**
	 * used to reference current player data
	 * @return
	 */
	public static Player getPlayer()
	{
		return player;
	}
	
	public static int getPlayerScore() {
		return player.getChips() + player.getMoney();
	}
	
	/**
	 * main menu for casino
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String args[])
	{
		do
		{
		//TODO make this starting window in GUI
		if (player.getUsername() == (null)) {
			System.out.println("Welcome to the casino! Please enter your username.");
			String username = userInput.next();
			Casino.getPlayer().setUsername(username);
		}
		//TODO Display this after player enters username
		System.out.println("Hi " + player.getUsername());
		//TODO use these methods to display player chips and money in GUI
		System.out.println("Welcome to the Casino! You have " + player.getMoney() + "$ and " + player.getChips() + " chips. Enter the number of the option you wish to select.");
		System.out.println("1.) Cash in \n2.) Cash out \n3.) Play a game \n4.) Leaderboard \n5.) Exit the casino");
		
			optionSelect = userInput.nextInt();
			
				
			switch (optionSelect) {
				
			case 1:

				System.out.println("You have " + player.getMoney() + "$. How many chips would you like? Enter a number between 0 and " + player.getMoney() + ".");
				int requestChips = userInput.nextInt();
				//TODO add this logic to cashing in
				if ((requestChips > 0) && (requestChips <= player.getMoney()))
				{
					player.cashIn(requestChips);
				}
				else
				{
					userInput.close();
					throw new ArithmeticException("Please enter a value between 0 and " + player.getMoney() +".");
				}
				///
				break;
				
			case 2:
				
				System.out.print("You cashed out " + player.getChips() + ".");
				//TODO add this to cash out button in GUI
				player.cashOut();
				///
				System.out.println(" Your total money is now $" + player.getMoney() + ".");
				break;
				
			case 3:
				
				System.out.println("Enter 1 to play blackjack, 2 to play slots, or 3 to return to main menu.");
				
				int gameSelect = userInput.nextInt();
				
				switch (gameSelect)
				{
					case 1:
						//TODO add to GUI
						Blackjack.main(args);
						///
						break;
						
					case 2:
						//TODO add to GUI
						Slots.main(args);
						///
						break;
						
					case 3:
						break;
						
					default:
						break;
				}
				
				break;
				
			case 4:
				System.out.println("LEADERBOARD WIP");
				//TODO add to GUI
				Leaderboard.main(args);
				///
				break;
				
			case 5:			
				System.out.println("Thanks for playing!");
				//TODO add to GUI
				Leaderboard.updateLeaderboard();
				///
				userInput.close();
				gameState = false;
				break;
				
			default:
				System.out.println("Select a menu option by entering a value from 1 to 5.");
				break;
			}	
		} while (gameState);
	}
}
