
public class Dealer
{
	// FIELDS //
	// Dealer HAS a deck of cards to deal from //
//	private int cardsInDeck = 51;
	private CardDeck deck = new CardDeck();
	// Dealer HAS a hand in the game;
	private Hand hand = new Hand();
	
	///// CONSTRUCTORS /////
	public Dealer() 
	{
		deck.setDeck();
		deck.shuffleDeck(deck);
	}
	
	public Dealer(CardDeck cardDeck, Hand hand)
	{
		deck = cardDeck;
		deck.setDeck();
		deck.shuffleDeck(deck);
		this.hand = hand;
	}
	
	///// METHODS /////
	// TODO write all method headers //
	public CardDeck getDeck()
	{
		return deck;
	}
	
	public Hand getHand()
	{
		return hand;
	}
	
	/*
	 * @param hand
	 * Gives card from top of dealers deck
	 * Removes card from deck
	 */
	public void dealCard(Hand hand) 
	{
		// Assume deck is already shuffled.
		hand.getHandCards().add(deck.get(deck.getCardDeck().size() - 1));
		
		// remove card from top of deck
		deck.getCardDeck().remove(deck.get(deck.getCardDeck().size() - 1));
	}
	
	
}
