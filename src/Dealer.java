/**
 * Lead Author(s):
 * 
 * @author Christopher Dove
 * @author
 *         <<add additional lead authors here, with a full first and last name>>
 * 
 *         Other contributors:
 *         <<add additional contributors (mentors, tutors, friends) here, with
 *         contact information>>
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         <<add more references here>>
 * 
 *         Version/date: 10/14/2022
 * 
 *         Responsibilities of class: To define, modify, and access fields of
 *         the Dealer object
 *
 */

public class Dealer
{
	///// FIELDS /////
	// Dealer HAS a deck of cards to deal from //
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

	/**
	 * 
	 * @return deck
	 */
	public CardDeck getDeck()
	{
		return deck;
	}

	/**
	 * 
	 * @return hand
	 */
	public Hand getHand()
	{
		return hand;
	}

	/**
	 * 
	 * @param hand
	 *             Gives card from top of dealers deck
	 *             Removes card from deck
	 */
	public void dealCard(Hand hand)
	{
		// Assume deck is already shuffled.
		hand.getHandCards().add(deck.get(deck.getCardDeck().size() - 1));

		// remove card from top of deck
		deck.getCardDeck().remove(deck.get(deck.getCardDeck().size() - 1));
	}

}
