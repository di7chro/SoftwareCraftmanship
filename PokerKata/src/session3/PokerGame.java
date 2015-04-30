package session3;

<<<<<<< HEAD
import java.util.Arrays;

/**
 * Gives you a score with a hand of poker
 * 
 * @author crille
 *
 *         Spades Hearts Clubs Diamonds
 * 
 *         Jack Queen King Ace /* 8. Straight Flush 7. Four of a kind 6. Full
 *         House 5. Flush 4. Straight 3. Three of a Kind 2. Two Pairs 1. Pair 0.
 *         Nothing
 */

public class PokerGame {
	static int NUM_OF_CARDS = 5;

	public int getScore(String hand) {
		int score = 0;
		int[] values = new int[NUM_OF_CARDS];
		char[] colors = getColors(hand);

		values = getValues(hand);

		if (findStraightFlush(values, colors) == true)
			score = 8;
		else if (findFourOfAKind(values) == true)
			score = 7;
		else if (findFullHouse(values) == true)
			score = 6;
		else if (findFlush(colors) == true)
			score = 5;
		else if (findStraight(values) == true)
			score = 4;
		else if (findThreeOfAKind(values) == true)
			score = 3;
		else if (findTwoPairs(values) == true)
			score = 2;
		else if (findPair(values) == true)
			score = 1;
		else
			score = 0;
		return score;
	}

	/**
	 * Finds a pair by looking if two cards next to each other has the same
	 * value
	 * 
	 * @param hand
	 * @return true if there is a pair, otherwise false
	 */
	private boolean findPair(int[] values) {

		// Loop again, find pair
		for (int i = 0; i < NUM_OF_CARDS - 1; i++) {
			if (values[i] == values[i + 1])
				return true;
		}
		return false;
	}

	/**
	 * Finds a pair by looking if three cards next to each other has the same
	 * value
	 * 
	 * @param hand
	 * @return true if there is a Three of a kind, otherwise false
	 */
	private boolean findThreeOfAKind(int[] values) {

		// Loop again, find three of a kind
		for (int i = 0; i < NUM_OF_CARDS - 2; i++) {
			if (values[i] == values[i + 1] && values[i + 1] == values[i + 2])
				return true;
		}
		return false;
	}

	/**
	 * Finds two pairs by looking for a pair, and them look if the remaining
	 * cards is a pair
	 * 
	 * @param hand
	 * @return true if there is two pairs, otherwise false
	 */
	private boolean findTwoPairs(int[] values) {

		try {
			// Loop again, find pair
			for (int i = 0; i < NUM_OF_CARDS - 1; i++) {
				if (values[i] == values[i + 1]) {
					if (values[i + 2] == values[i + 3]
							|| values[i + 3] == values[i + 4]) {
						return true;
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return false;
	}

	/**
	 * Finds Four of a kind by first finding Three of a kind and then looks if
	 * one of the remaining cards matches
	 * 
	 * @param hand
	 * @return true if there is a Four of a kind, otherwise false
	 */
	private boolean findFourOfAKind(int[] values) {

		// Loop again, find three of a kind
		for (int i = 0; i < NUM_OF_CARDS - 2; i++) {
			if (values[i] == values[i + 1] && values[i + 1] == values[i + 2]
					&& values[i + 2] == values[i + 3])
				return true;
		}
		return false;
	}

	/**
	 * Finds a Full house. We have a Full House if the first and last two cards
	 * are a pair, and the middle card has same value as either of them (is
	 * three of a kind)
	 * 
	 * @param hand
	 * @return true if there is a Full House, otherwise false
	 */
	private boolean findFullHouse(int[] values) {

		if (values[0] == values[1] && values[3] == values[4]
				&& (values[0] == values[2] || values[2] == values[3]))
			return true;
		return false;
	}

	/**
	 * Finds a Flush by looking if all cards has the same colors
	 * 
	 * @param hand
	 * @return true if there is a flush, otherwise false
	 */
	private boolean findFlush(char[] colors) {

		// Loop again, find pair
		if (colors[0] == colors[1] && colors[1] == colors[2]
				&& colors[2] == colors[3] && colors[3] == colors[4])
			return true;
		return false;
	}

	/**
	 * Finds a Straight by looking if the value of the next card is 1 higher
	 * throughout all the cards
	 * 
	 * @param values
	 * @return true if there is a straight, otherwise false
	 */
	private boolean findStraight(int[] values) {
		for (int i = 0; i < NUM_OF_CARDS - 1; i++)
			if (values[i + 1] != values[i] + 1)
				return false;
		return true;
	}

	/**
	 * Finds a Straight Flush by first looking for a Straight and then the Flush
	 * 
	 * @param values
	 * @param colors
	 * @return
	 */
	private boolean findStraightFlush(int[] values, char[] colors) {
		for (int i = 0; i < NUM_OF_CARDS - 1; i++)
			if (values[i + 1] != values[i] + 1)
				return false;
		if (colors[0] == colors[4])
			return true;
		else
			return false;
	}

	/**
	 * Extracts all the values from the given String (hand)
	 * 
	 * @param hand
	 * @return The values of all the cards
	 */
	private int[] getValues(String hand) {
		int[] values = new int[NUM_OF_CARDS];

		// Remove all colors
		hand = hand.replace("S", "");
		hand = hand.replace("H", "");
		hand = hand.replace("C", "");
		hand = hand.replace("D", "");

		// J Q K A
		// Find all values
		for (int i = 0; i < NUM_OF_CARDS; i++) {
			if (hand.charAt(i) == '2')
				values[i] = 2;
			else if (hand.charAt(i) == '3')
				values[i] = 3;
			else if (hand.charAt(i) == '4')
				values[i] = 4;
			else if (hand.charAt(i) == '5')
				values[i] = 5;
			else if (hand.charAt(i) == '6')
				values[i] = 6;
			else if (hand.charAt(i) == '7')
				values[i] = 7;
			else if (hand.charAt(i) == '8')
				values[i] = 8;
			else if (hand.charAt(i) == '9')
				values[i] = 9;
			else if (hand.charAt(i) == '1') {
				values[i] = 10;
				i++;
			}
			else if (hand.charAt(i) == 'J')
				values[i] = 11;
			else if (hand.charAt(i) == 'Q')
				values[i] = 12;
			else if (hand.charAt(i) == 'K')
				values[i] = 13;
			else if (hand.charAt(i) == 'A')
				values[i] = 14;
		}
		Arrays.sort(values);
		return values;
	}

	/*
	 * Gammal char-version
	 * 
	 * private char[] getValues(String hand) { char[] values = "".toCharArray();
	 * String temp = "";
	 * 
	 * // Find all values for (int i = 1; i < hand.length(); i += 2) { temp +=
	 * hand.charAt(i); } values = temp.toCharArray(); Arrays.sort(values);
	 * return values; }
	 */
	/**
	 * Extracts all the colors from the given String (hand)
	 * 
	 * @param hand
	 * @return The colors of all the cards
	 */
	private char[] getColors(String hand) {
		char[] colors = "".toCharArray();
		String temp = "";

		// Find all values
		for (int i = 0; i < hand.length() - 1; i += 2) {
			temp += hand.charAt(i);
=======
public class PokerGame {

	public Player calculateWinningPlayer(Player left, Player right) {
		
		Player twoPairResult = TwoPairRule.compare(left, right);
		if(twoPairResult != null){
			return twoPairResult;
		}
		
		Player pairResult = PairRule.compare(left, right);
		if(pairResult != null){
			return pairResult;
>>>>>>> origin/master
		}
		
		return HighCardRule.compare(left, right);
	}

}
