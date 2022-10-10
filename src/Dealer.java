
public class Dealer
{
	// FIELDS //
	// Dealer HAS a deck of cards to deal from //
	private CardDeck dealersDeck = new CardDeck();
	// Dealer HAS a set of cards in the game;
	private Cards[] dealersHand = new Cards[2];
	
	// CONSTRUCTORS //
	public Dealer() {}
	
	public Dealer(CardDeck cardDeck, Cards[] hand)
	{
		dealersDeck = cardDeck;
		dealersDeck.setDeck();
		dealersHand = hand;
	}
	
	// METHODS //
	public void dealCards() {}
	
	
}
