/*
 * PokerGame.java
 * 
 * Course in Software Craftsmenship @ Högskolan Väst
 * Poker game kata for testing TDD, Test Driven Development
 * 
 * 2015-04-27
 */

package session3;

import java.util.Arrays;

public class PokerGame {
	public int getScore(String hand) {
		int score = 0;

		if (findPrison(hand) == true)
			score = 9;
		else if (findFourOfAKind(hand) == true)
			score = 7;
		else if (findTwoPairs(hand) == true)
			score = 6;
		else if (findThreeOfAKind(hand) == true)
			score = 3;
		else if (findPair(hand) == true)
			score = 2;
		else
			score = 0;
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

	private boolean findPrison(String hand) {
		char[] values = getValues(hand);

		// We have a prison if the first and last two cards are a pair, and the
		// middle card has same value as either of them (is three of a kind)
		if (values[0] == values[1] && values[3] == values[4]
				&& (values[0] == values[2] || values[2] == values[3]))
			return true;
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
