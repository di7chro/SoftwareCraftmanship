package session3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PokerGameTest {
	// FIXME get_color
	// FIXME get_value
	// FIXME draw_one_card
	// FIXME draw_five_cards
	// FIXME draw_one_hand
	// FIXME compare_two_hands
	// FIXME find_highest_score

	// Spader 
	// Hjärter
	// Ruter
	// Klöver
	
	// K
	PokerGame myGame = new PokerGame();

	@Test
	public void find_all_values() throws Exception {
		String hand = "S2K3R5H6S7";
		
		int result = myGame.getScore(hand);

		assertEquals(0, result);
	}

	@Test
	public void find_all_values_and_colors_gives_1() throws Exception {
		String hand = "S2K3R5H6S7";
		
		int result = myGame.getScore(hand);

		assertEquals(1, result);
	}

}
