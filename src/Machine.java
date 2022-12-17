import java.util.Random;

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
public class Machine
{
	//Machine HAS-A Lever

	//FEILD
	private int slot1;
	private static int slot2;
	private static int slot3;
	private static int userCoin;
	private static int winningMultiplier;
	private static int loseMultiplier;; 
	private static boolean winOrLose;
	private static String[] slotElements = {"Cherry", "Orange", "Plum", "Apple", "Bell", "Melon", "Bar", "Seven"};
	private static String slot1Element = null, slot2Element = null, slot3Element = null;
	private Random randomeNumber = new Random();
	
	public Machine()
	{
		// set user coin and multiplier
		winningMultiplier = 0;
	}
	
	public void slotCompute()
	{
		//generate randomNumber for 
		slot1 = randomeNumber.nextInt(8);
		slot2 = randomeNumber.nextInt(8);
		slot3 = randomeNumber.nextInt(8);
		
		slot1Element = slotElements[slot1];
		slot2Element = slotElements[slot2];
		slot3Element = slotElements[slot3];
			
		System.out.println("------------------");
		System.out.println(slot1Element + " || " + slot2Element + " || " + slot3Element);
		System.out.println("------------------");

		if (slot1 == slot2 || slot2 == slot3 || slot1 == slot3)
		{
			winningMultiplier = 2;
			winOrLose = true;
			System.out.println("You Win Two Pair!");
		}
		
		else if (slot1 == slot2 && slot2 == slot3) 
		{
			winningMultiplier = 4;
			winOrLose = true;
			System.out.println("You Win Triple Pair!");
		}
		
		else if (slot1Element == "Seven"  && slot2Element == "Seven" && slot3Element == "Seven") 
		{
			winningMultiplier = 50;
			winOrLose = true;
			System.out.println("JACKPOT!!!!!");
			
		}
		
		else if(slot1 != slot2 && slot1 != slot3 && slot2 != slot3)
		{
			
			System.out.println("You lose!");
			winOrLose = false;
			loseMultiplier = 0;
		}
		
	}
	
	//Setter
	
	public void setUserCoin(int userCoin)
	{
		Machine.userCoin = userCoin;
	}
	
	public void setSlot1(int slot1)
	{
		this.slot1 = slot1;
	}
	
	public void setSlot2(int slot2)
	{
		Machine.slot2 = slot2;
	}
	
	public void setSlot3(int slot3)
	{
		Machine.slot3 = slot3;
	}
	
	public void setWinningMuliplier(int winningMuliplier)
	{
		Machine.winningMultiplier = winningMuliplier;
	}
	
	//Getter
	
	public int getUserCoin() {
		return userCoin;
	}
	public boolean getWinOrLose()
	{
		return winOrLose;
	}
	
	public static int getWinningMultiplier() {
		return winningMultiplier;
	}
	
	public int getLoseMultiplier()
	{
		return loseMultiplier;
	}
	
	public String getSlot1Element() {
		return slot1Element;
	}
	
	public String getSlot2Element() {
		return slot2Element;
	}
	public String getSlot3Element() {
		return slot3Element;
	}
	
	public int getSlot1() {
		return slot1;
	}
	
	public int getSlot2() {
		return slot2;
	}
	
	public int getslot3() { 
		return slot3;
	}
	
}
