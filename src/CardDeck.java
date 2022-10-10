import java.util.Random;

// import java.util.Arrays;

public class CardDeck extends Cards
	// A card deck IS-many cards
{  
	private final int deckSize = 52;
	private Cards[] deck =  new Cards[deckSize];
	// Might have to make this an array list
	// It being resizable would be useful for
	// dealing out cards w.o replacement
	private Ranks rankArr[] = Ranks.values();
	private Suits suitArr[] = Suits.values();				
	
	public CardDeck() 
	{
		// Constructor creates an array of cards with each possible card
		// in a typical 52 card deck
	}
	
	
	public void setDeck()
	{
	int i = 0;
	int j = 0;
	int k = 0;
	
	while (j < 52)
	{
		for (i = 0; i < 4; ++i)
		{
			deck[j] = new Cards();
			deck[j].setSuit((Suits)suitArr[i]);
			++j;
		}
		
	}
	j = 0;
	while (j < 52)
	{
		for (k = 0; k < 13; ++k)
		{
			deck[j].setRank((Ranks)rankArr[k]);
			++j;
		}
	}
	}
	
	public Cards[] getCardDeck()
	{
		return deck;
	}
	
	public Cards getCard(int i)
	{
		return deck[i];
	}
	
	public void shuffleDeck(CardDeck cardDeck)
	{
		int x = 52;
		
		Random random = new Random();
		
		for (int i = 0; i < x; i++)
		{
			int rd = random.nextInt(x);
			Cards temp = new Cards(cardDeck.deck[rd]);
			cardDeck.deck[rd] = cardDeck.deck[i];
			cardDeck.deck[i] = temp;
		}
	}
}
