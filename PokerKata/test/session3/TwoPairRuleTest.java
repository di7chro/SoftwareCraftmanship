package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoPairRuleTest {

	@Test
	public void two_pair_wins_over_pair() {
		Player green = new Player("Green", "6S 6C 4D 7H AH");
		Player white = new Player("White", "3S 3C 5D 5H KH");

		Player winningPlayer = TwoPairRule.compare(green, white);

		assertEquals("White", winningPlayer.getPlayerName());
	}

	@Test
	public void higher_two_pair_wins_over_lower_two_pair() throws Exception {

		Player green = new Player("Green", "4S 4C 6D 6H AH");
		Player white = new Player("White", "3S 3C 5D 5H KH");

		Player winningPlayer = TwoPairRule.compare(white, green);

		assertEquals("Green", winningPlayer.getPlayerName());

	}
	
	@Test
	public void first_pair_tie_second_pair_highest_wins() throws Exception {
		Player green = new Player("Green", "9S 9C 6D 6H AH");
		Player white = new Player("White", "9H 9D 5D 5H KH");

		Player winningPlayer = TwoPairRule.compare(white, green);

		assertEquals("Green", winningPlayer.getPlayerName());		
	}
}
