import java.util.Random;

import java.util.ArrayList;

	// A card deck IS-many cards
public class CardDeck extends Cards
{  
	///// FIELDS /////
	private ArrayList<Cards> deck =  new ArrayList<Cards>();
	private Ranks rankArr[] = Ranks.values();
	private Suits suitArr[] = Suits.values();				
	
	///// CONSTRUCTORS /////
	public CardDeck() 
	{
		// Constructor creates an array of cards with each possible card
		// in a typical 52 card deck
	}
	
	///// METHODS /////
	/**
	 * 
	 * initializes deck as a typical 52 card deck.
	 * i counts 13 cards of each rank, 4 times.
	 * k counts 4 suits, 13 times.
	 * j counts 52 cards in the deck.
	 * O(n) complexity since j increments inside the nested loop (I think).
	 * 
	 * @return void
	 */
	public void setDeck()
	{
	int i = 0;
	int j = 0;
	int k = 0;
	
	while (j < 52)
	{
		for (i = 0; i < 4; ++i)
		{
			deck.add(j, new Cards());
			deck.get(j).setSuit((Suits)suitArr[i]);
			++j;
		}
		
	}
	j = 0;
	while (j < 52)
	{
		for (k = 0; k < 13; ++k)
		{
			deck.get(j).setRank((Ranks)rankArr[k]);
			++j;
		}
	}
	}
	
	/**
	 * gets deck from CardDeck
	 * @return deck
	 */
	public ArrayList<Cards> getCardDeck()
	{
		return deck;
	}
	
	/**
	 * gets a card from deck at a specified index
	 * @param int i
	 * @return deck.get(i)
	 */
	public Cards get(int i)
	{
		return deck.get(i);
	}
	
	/**
	 * shuffles a 52 card deck
	 * @param CardDeck cardDeck
	 * @return void
	 */
	public void shuffleDeck(CardDeck cardDeck)
	{
		// cards in blackjack deck
		int x = 52;
		
		// random object for number gen
		Random random = new Random();
		
		for (int i = 0; i < x; i++)
		{
			// generates random number [0, 52)
			int rd = random.nextInt(x);
			
			// generic swap method but with randomly picked card
			Cards temp = new Cards(cardDeck.deck.get(rd));
			cardDeck.deck.get(rd).setCards(cardDeck.deck.get(i).getSuit(), cardDeck.deck.get(i).getRank());
			cardDeck.deck.set(i, temp);
		}
	}
}
