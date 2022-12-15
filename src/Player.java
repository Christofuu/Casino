
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
 *         Player class
 * 
 */
public class Player
{
	///// FIELDS /////
	private String username;
	private int money = 1000;
	private int chips = 0;
	private Hand hand = new Hand();
	
	///// CONSTRUCTORS /////
	Player()
	{
	}
	
	Player(String username, int money, int chips, String userName)
	{
		this.username = username;
		this.money = money;
		this.chips = chips;
		this.username = userName;
	}
	
	Player(String userName)
	{
		this.username = userName;
	}

	///// METHODS /////
	
	/**
	 * @return username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return money
	 */
	public int getMoney()
	{
		return money;
	}

	/**
	 * @param money
	 */
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	/**
	 * turns specified amount of money into chips
	 * @param money
	 */
	public void cashIn(int money)
	{
		this.money -= money;
		this.chips += money;
	}
	
	/**
	 * turns player's chips into money
	 * 
	 */
	public void cashOut()
	{
		this.money += this.chips;
		this.chips = 0;
	}
	
	/**
	 * subtracts given amount of chips from user chips, returns amount
	 * subtracted.
	 * 
	 * @param chips
	 * @return chips
	 */
	public int bet(int chips)
	{
		this.chips -= chips;
		return chips;
	}

	/**
	 * 
	 * @return chips
	 */
	public int getChips()
	{
		return chips;
	}

	/**
	 * @param chips
	 */
	public void setChips(int chips)
	{
		this.chips = chips;
	}
	
	/**
	 * gives player specified amount of chips
	 * 
	 * @param value
	 */
	public void payout(int value)
	{
		chips += value;
	}
	
	/**
	 * 
	 * @return hand
	 */
	public Hand getHand()
	{
		return hand;
	}

}
