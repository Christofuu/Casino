import java.util.Random;

import java.util.ArrayList;

public class CardDeck extends Cards
	// A card deck IS-many cards
{  
	// private final int deckSize = 52;
	private ArrayList<Cards> deck =  new ArrayList<Cards>();
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
	
	public ArrayList<Cards> getCardDeck()
	{
		return deck;
	}
	
	public Cards get(int i)
	{
		return deck.get(i);
	}
	
	public void shuffleDeck(CardDeck cardDeck)
	{
		int x = 52;
		
		Random random = new Random();
		
		for (int i = 0; i < x; i++)
		{
			int rd = random.nextInt(x);
			Cards temp = new Cards(cardDeck.deck.get(rd));
			cardDeck.deck.get(rd).setCards(cardDeck.deck.get(i).getSuit(), cardDeck.deck.get(i).getRank());
			cardDeck.deck.set(i, temp);
		}
	}
	
//	public int getValue(Cards card) 
//	{
//		int value = 0;
//		Ranks cardRank = card.getRank();
//		switch(cardRank)
//		{
//			case TEN,JACK,KING,QUEEN:
//				value = 10;
//				break;
//				
//			// how to make this 11 if hand is high
//			// and 1 if hand is low?
//			case ACE:
//				value = 11;
//				break;
//				
//			case TWO:
//				value = 2;
//				break;
//				
//			case THREE:
//				value = 3;
//				break;
//				
//			case FOUR:
//				value = 4;
//				break;
//				
//			case FIVE:
//				value = 5;
//				break;
//				
//			case SIX:
//				value = 6;
//				break;
//				
//			case SEVEN:
//				value = 7;
//				break;
//				
//			case EIGHT:
//				value = 8;
//				break;
//				
//			case NINE:
//				value = 9;
//				break;
//		}
//		return value;
//	}
}
