import java.util.ArrayList;


public class Hand extends Cards
{
	private ArrayList<Cards> handCards = new ArrayList<Cards>();
	
	public Hand() {}
	
	public Hand(ArrayList<Cards> handCards)
	{
		this.handCards = handCards;
	}
	
	public ArrayList<Cards> getHandCards()
	{
		return handCards;
	}
	
	public void addCard(Cards card)
	{
		handCards.add(card);
	}
	
	public int getHandValue(ArrayList<Cards> hand) 
	{
		int value1 = 0;
		int value2 = 0;
		int sum;
		Ranks cardRank1 = hand.get(0).getRank();
		switch(cardRank1)
		{
			case TEN,JACK,KING,QUEEN:
				value1 = 10;
				break;
				
			case ACE:
				value1 = 11;
				break;
				
			case TWO:
				value1 = 2;
				break;
				
			case THREE:
				value1 = 3;
				break;
				
			case FOUR:
				value1 = 4;
				break;
				
			case FIVE:
				value1 = 5;
				break;
				
			case SIX:
				value1 = 6;
				break;
				
			case SEVEN:
				value1 = 7;
				break;
				
			case EIGHT:
				value1 = 8;
				break;
				
			case NINE:
				value1 = 9;
				break;
		}
		
		Ranks cardRank2 = hand.get(1).getRank();
		switch(cardRank2)
		{
			case TEN,JACK,KING,QUEEN:
				value1 = 10;
				break;
				
			case ACE:
				if (value1 <= 10)
				{
					value2 = 11;
				}
				else
				{
					value2 = 1;
				}
				break;
				
			case TWO:
				value2 = 2;
				break;
				
			case THREE:
				value2 = 3;
				break;
				
			case FOUR:
				value2 = 4;
				break;
				
			case FIVE:
				value2 = 5;
				break;
				
			case SIX:
				value2 = 6;
				break;
				
			case SEVEN:
				value2 = 7;
				break;
				
			case EIGHT:
				value2 = 8;
				break;
				
			case NINE:
				value2 = 9;
				break;
		}
		sum = value1 + value2;
		return sum;
	}
}
