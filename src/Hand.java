import java.util.ArrayList;

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
 *         the Hand object
 *         child class of Cards
 */

public class Hand extends Cards
{
	private ArrayList<Cards> handCards = new ArrayList<Cards>();

	public Hand()
	{
	}

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
		int sum = 0;

		for (int i = 0; i < hand.size(); ++i)
		{
			Ranks cardRanks = hand.get(i).getRank();
			switch (cardRanks)
			{
				case TEN, JACK, KING, QUEEN:
					sum += 10;
					break;

				case ACE:
					if (sum <= 10)
					{
						sum += 11;
					}
					else
					{
						sum += 1;
					}
					break;

				case TWO:
					sum += 2;
					break;

				case THREE:
					sum += 3;
					break;

				case FOUR:
					sum += 4;
					break;

				case FIVE:
					sum += 5;
					break;

				case SIX:
					sum += 6;
					break;

				case SEVEN:
					sum += 7;
					break;

				case EIGHT:
					sum += 8;
					break;

				case NINE:
					sum += 9;
					break;
			}
		}
		return sum;
	}
}
