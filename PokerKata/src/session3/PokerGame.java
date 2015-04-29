package session3;

public class PokerGame {

	public Player calculateWinningPlayer(Player left, Player right) {
		
		Player twoPairResult = TwoPairRule.compare(left, right);
		if(twoPairResult != null){
			return twoPairResult;
		}
		
		Player pairResult = PairRule.compare(left, right);
		if(pairResult != null){
			return pairResult;
		}
		
		return HighCardRule.compare(left, right);
	}

}
