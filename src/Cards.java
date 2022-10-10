public class Cards {
    // Cards have a suit
    protected enum Suits {
        DIAMOND,
        SPADE,
        HEART,
        CLUB
    }
    
    protected enum Ranks {
    	TWO,
    	THREE,
    	FOUR,
    	FIVE,
    	SIX,
    	SEVEN,
    	EIGHT,
    	NINE,
    	TEN,
    	JACK,
    	QUEEN,
    	KING,
    	ACE
    }
    
    private Suits suit;
    private Ranks rank;
    
    public Cards() {}
    
    public Cards(Suits suit, Ranks rank)
    {
    	this.suit = suit;
    	this.rank = rank;
    }
    
    public Cards(Cards card)
    {
    	this.suit = suit;
    	this.rank = rank;
    }

	public Suits getSuit()
	{
		return suit;
	}

	public void setSuit(Suits suit)
	{
		this.suit = suit;
	}

	public Ranks getRank()
	{
		return rank;
	}

	public void setRank(Ranks rank)
	{
		this.rank = rank;
	}
    
}