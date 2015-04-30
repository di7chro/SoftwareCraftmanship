package session3;

import java.util.Comparator;

public class PokerGameComparator implements Comparator<Card> {

	@Override
	public int compare(Card arg0, Card arg1) {
		return arg1.getValue() - arg0.getValue();
	}

}
