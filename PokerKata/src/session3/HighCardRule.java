package session3;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HighCardRule {

	public static Player compare(Player player1, Player player2) {
		// Hands to lists
		List<Card> playerHand1 = player1.getPlayerHand();
		List<Card> playerHand2 = player2.getPlayerHand();

		PokerGameComparator comparator = new PokerGameComparator();
		Collections.sort(playerHand1, comparator);
		Collections.sort(playerHand2, comparator);

		for (int i = 0; i < playerHand1.size(); i++) {
			int p1Value = playerHand1.get(i).getValue();
			int p2Value = playerHand2.get(i).getValue();
			if (p1Value > p2Value) {
				return player1;
			}
			if (p2Value > p1Value) {
				return player2;
			}
		}
		return null;
	}

}
