public class SlotPlayer {
	
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
