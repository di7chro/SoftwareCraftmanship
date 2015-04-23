package session3;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

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
	public void give_me_five() throws Exception {
		String hand = "S2K3R5H6S7";
		
		int result = myGame.getHand();

		assertEquals(5, result);
	}

}
