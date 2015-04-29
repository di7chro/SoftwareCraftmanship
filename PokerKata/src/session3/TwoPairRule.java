package session3;

import java.util.Collections;

public class TwoPairRule {

	private static final int[] noPairs = { 0, 0 };

	public static Player compare(Player left, Player right) {
		int[] pairsLeft = getValuesForTwoPair(left);
		int[] pairsRight = getValuesForTwoPair(right);

		for (int i = 0; i < 2; i++) {
			int pairValueLeft = pairsLeft[i];
			int pairValueRight = pairsRight[i];

			if (pairValueLeft > pairValueRight) {
				return left;
			}
			if (pairValueRight > pairValueLeft) {
				return right;
			}
		}

		return null;
	}

	private static int[] getValuesForTwoPair(Player player) {
		if (!playerHasTwoPair(player)) {
			return noPairs;
		}
		PokerGameComparator comparator = new PokerGameComparator();
		Collections.sort(player.getPlayerHand(), comparator);
		int[] cardValues = new int[2];
		int pairCount = 0;

		for (Card card : player.getPlayerHand()) {
			if (card.getValue() == cardValues[pairCount]) {
				cardValues[pairCount++] = card.getValue();
			} else {
				cardValues[pairCount] = card.getValue();
			}
		}
		return cardValues;
	}

	private static boolean playerHasTwoPair(Player player) {
		PokerGameComparator comparator = new PokerGameComparator();
		Collections.sort(player.getPlayerHand(), comparator);
		int cardValue = 0;
		int pairCount = 0;

		for (Card card : player.getPlayerHand()) {
			if (card.getValue() == cardValue) {
				pairCount++;
			} else {
				cardValue = card.getValue();
			}
		}

		if (pairCount == 2) {
			return true;
		}
		return false;
	}

}
