package session3;

import java.util.Collections;

public class PairRule {

	public static Player compare(Player left, Player right) {
//		if (playerHasPair(left)) {
//			return left;
//		}
//		if (playerHasPair(right)) {
//			return right;
//		}
		
		int pairValueLeft = getValueOfPairForPlayer(left);
		int pairValueRight = getValueOfPairForPlayer(right);
		
		if (pairValueLeft > pairValueRight) {
			return left;
		}
		
		if (pairValueRight  > pairValueLeft) {
			return right;
		}
		
		return null;
	}

	private static int getValueOfPairForPlayer(Player left) {
		PokerGameComparator comparator = new PokerGameComparator();
		Collections.sort(left.getPlayerHand(), comparator);
		int cardValue=0;
		
		for (Card card : left.getPlayerHand()) {
			if (card.getValue() == cardValue){
				return card.getValue();
			}
			else{
				cardValue= card.getValue();
			}
				
		}
		return 0;
	}

}
