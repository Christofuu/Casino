public class SlotPlayer {
    // will add implementation to cash in/cash out next week
	// for now player will start with default chips for testing
	private int chips = 1000;
	
	public SlotPlayer() {}
	
	public SlotPlayer(int chips)
	{
		this.chips = chips;
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
	
	public void setChips(int chips) {
		this.chips = chips;
	}
    
}
