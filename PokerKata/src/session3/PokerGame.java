package session3;

import java.util.Arrays;

/* SCORES
 * 2	Pair
 * 3	Three Of A Kind
 * 
 * S2K3R5H6S7
 */
public class PokerGame {
	public int getScore(String hand) {
		int score = 0;

		if (findPair(hand) == true)
			score = 2;
		if (findThreeOfAKind(hand) == true)
			score = 3;
		if (findTwoPairs(hand) == true)
			score = 6;
		if (findFourOfAKind(hand) == true)
			score = 7;
		return score;
	}

	private boolean findPair(String hand) {
		char[] values = getValues(hand);

		// Loop again, find pair
		for (int i = 0; i < values.length - 1; i++) {
			if (values[i] == values[i + 1])
				return true;
		}
		return false;
	}

	private boolean findThreeOfAKind(String hand) {
		char[] values = getValues(hand);

		// Loop again, find three of a kind
		for (int i = 0; i < values.length - 2; i++) {
			if (values[i] == values[i + 1] && values[i + 1] == values[i + 2])
				return true;
		}
		return false;
	}

	private boolean findTwoPairs(String hand) {
		char[] values = getValues(hand);

		try {
			// Loop again, find pair
			for (int i = 0; i < values.length - 1; i++) {
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

	private boolean findFourOfAKind(String hand) {
		char[] values = getValues(hand);

		// Loop again, find three of a kind
		for (int i = 0; i < values.length - 2; i++) {
			if (values[i] == values[i + 1] && values[i + 1] == values[i + 2]
					&& values[i + 2] == values[i + 3])
				return true;
		}
		return false;
	}

	private char[] getValues(String hand) {
		char[] values = "".toCharArray();
		String temp = "";

		// Find all values
		for (int i = 1; i < hand.length(); i += 2) {
			temp += hand.charAt(i);
		}
		values = temp.toCharArray();
		Arrays.sort(values);
		return values;
	}

}
