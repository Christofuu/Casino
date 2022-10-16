
public class Player
{
	private String username;
	private int money = 1000;
	private int chips = 0;
	private Hand hand = new Hand();
	
	Player()
	{
	}
	
	Player(String username, int money, int chips)
	{
		this.username = username;
		this.money = money;
		this.chips = chips;
	}
	
	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getMoney()
	{
		return money;
	}

	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public void cashIn(int money)
	{
		this.money -= money;
		this.chips += money;
	}
	
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
