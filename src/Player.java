import java.util.ArrayList;

public class Player
{
	private int chips;
	private ArrayList<Cards> playersHand = new ArrayList<Cards>(2);
	
	public Player() {}
	
	public Player(int chips, ArrayList<Cards> hand)
	{
		this.chips = chips;
		playersHand = hand;
	}
	
	public void bet()
	{
		
	}
	
	public void hit()
	{
		
	}
	
	public void stand()
	{
		
	}
}
