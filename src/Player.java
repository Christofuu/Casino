
	// TODO  make this a BlackJackPlayer which IS-A Player
public class Player
{
	///// FIELDS /////
	// TODO add implementation for chips I/O
	// for now player will start with default chips for testing
	private int chips = 1000;
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
	// TODO write method headers
	public Hand getHand()
	{
		return hand;
	}
	
	public int bet(int chips)
	{
		this.chips -= chips;
		return chips;
	}
	
	public int getChips()
	{
		return chips;
	}
	
	public void payout(int value)
	{
		chips += value;
	}
	
}
