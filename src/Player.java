
	// TODO  make this a BlackJackPlayer which IS-A Player
public class Player
{
	///// FIELDS /////
	// TODO add implementation for chips I/O
	// for now player will start with default chips for testing
	private int chips = 400;
	// Player HAS-A hand
	private Hand hand = new Hand();
	
	///// CONSTRUCTORS /////
	public Player() {}
	
	public Player(int chips, Hand hand)
	{
		this.chips = chips;
		this.hand = hand;
	}
	
	///// METHODS /////
	
	/**
	 * 
	 * @return hand
	 */
	public Hand getHand()
	{
		return hand;
	}
	
	/** subtracts given amount of chips from user chips, returns amount subtracted.
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
	
	/** gives player specified amount of chips
	 * 
	 * @param value
	 */
	public void payout(int value)
	{
		chips += value;
	}
	
}
