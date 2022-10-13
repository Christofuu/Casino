public class Cards {
	///// FIELDS /////
	
    // Cards have a suit
    protected enum Suits {
        DIAMOND,
        SPADE,
        HEART,
        CLUB
    }
    
    // Cards have a rank
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
    
    ///// CONSTRUCTORS /////
    public Cards() {}
    
    public Cards(Suits suit, Ranks rank)
    {
    	this.suit = suit;
    	this.rank = rank;
    }
    
    public Cards(Cards card)
    {
    	this.suit = card.getSuit();
    	this.rank = card.getRank();
    }
    
    ///// METHODS /////
    
    /**
     *  gets a card
     * @param Cards card
     * @return card
     */
    public Cards getCards(Cards card)
    {
    	return card;
    }
    
    /**
     * sets a card's suit and rank
     * @param Suits suit, Ranks rank
     * @return void
     */
    public void setCards(Suits suit, Ranks rank)
    {
    	this.suit = suit;
    	this.rank = rank;
    }

    /**
     * @return suit
     */
	public Suits getSuit()
	{
		return suit;
	}

	/**
	 * @param Suits suit
	 * @return void
	 */
	public void setSuit(Suits suit)
	{
		this.suit = suit;
	}

	/**
	 * @return rank
	 */
	public Ranks getRank()
	{
		return rank;
	}

	/**
	 * @param rank
	 * @return void
	 */
	public void setRank(Ranks rank)
	{
		this.rank = rank;
	}

	/**
	 * returns unicode suit of card
	 * @return String
	 */
	@Override public String toString()
	{
		String returnString = new String();
		
		if (this.suit.toString() == "DIAMOND")
		{
			returnString = "\u2666";
		}
		
		if (this.suit.toString() == "HEART")
		{
			returnString = "\u2665";
		}
		
		if (this.suit.toString() == "SPADE")
		{
			returnString = "\u2660";
		}
		
		if (this.suit.toString() == "CLUB")
		{
			returnString = "\u2663";
		}
		
		return this.rank.toString() + " " + returnString;
	}
}