import java.util.ArrayList;

public class Dealer
{
	// FIELDS //
	// Dealer HAS a deck of cards to deal from //
	private CardDeck dealersDeck = new CardDeck();
	// Dealer HAS a set of cards in the game;
	private ArrayList<Cards> dealersHand = new ArrayList<Cards>(2);
	
	// CONSTRUCTORS //
	public Dealer() {}
	
	public Dealer(CardDeck cardDeck, ArrayList<Cards> hand)
	{
		dealersDeck = cardDeck;
		dealersDeck.setDeck();
		dealersDeck.shuffleDeck(dealersDeck);
		dealersHand = hand;
	}
	
	// METHODS //
	public void dealCards() 
	{
		// Assume deck is already shuffled.
		
	}
	
	
}
