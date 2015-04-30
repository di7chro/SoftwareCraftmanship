package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairRuleTest {

	@Test
	public void pair_wins_over_high_card() {
		Player green = new Player("Green", "2S 3C 4D 7H AH");
		Player white = new Player("White", "3S 3C 5D 6H KH");

		Player winningPlayer = PairRule.compare(green, white);
		
		assertEquals("White", winningPlayer.getPlayerName());
	}
	@Test
	public void higher_pair_wins_over_lower_pair() throws Exception {
		
		Player white = new Player("White", "2S 3C 7D 7H AH");
		Player green = new Player("Green", "3S 3C 5D 6H KH");

		Player winningPlayer = PairRule.compare(green, white);
		
		assertEquals("White", winningPlayer.getPlayerName());
		
	}
	
	@Test
	public void test_if_pair_is_tie() throws Exception {
		Player white = new Player("White", "2S 3C 7D 7H AH");
		Player green = new Player("Green", "7S 7C 5D 6H KH");

		Player winningPlayer = PairRule.compare(green, white);
		
		assertNull(winningPlayer);
	}

}
