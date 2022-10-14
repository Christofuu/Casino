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
 *         the BlackjackPlayer object
 * 
 */

// TODO make this a BlackJackPlayer which IS-A Player
public class Player
{
	///// FIELDS /////
	// TODO add implementation for chips I/O
	// for now player will start with default chips for testing
	private int chips = 400;
	// Player HAS-A hand
	private Hand hand = new Hand();

	///// CONSTRUCTORS /////
	public Player()
	{
	}

	public Player(int chips, Hand hand)
	{
		this.chips = chips;
		this.hand = hand;
	}

	///// METHODS /////

	/**
	 * 
	 * @return hand
	 */
	public Hand getHand()
	{
		return hand;
	}

	/**
	 * subtracts given amount of chips from user chips, returns amount
	 * subtracted.
	 * 
	 * @param chips
	 * @return chips
	 */
	public int bet(int chips)
	{
		this.chips -= chips;
		return chips;
	}

	/**
	 * 
	 * @return chips
	 */
	public int getChips()
	{
		return chips;
	}

	/**
	 * gives player specified amount of chips
	 * 
	 * @param value
	 */
	public void payout(int value)
	{
		chips += value;
	}

}
