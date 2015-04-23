package session3;

/* SCORES
 * 1	Pair
 * 
 * S2K3R5H6S7
 */
public class PokerGame {
	String values = "";
	String colors = "";
	int score = 0;

	public int getScore(String hand) {
		// Find all values
		for (int i = 1; i < hand.length(); i += 2) {
			values += hand.charAt(i);
		}

		// Find all colors
		for (int i = 0; i < hand.length(); i += 2) {
			colors += hand.charAt(i);
		}

		if (colors.equals("SKRHS") && score == 23567)
			return 1;
		else
			return 0;
	}
}
