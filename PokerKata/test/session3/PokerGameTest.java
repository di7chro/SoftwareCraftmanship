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

	PokerGame myGame = new PokerGame();

	@Test
	public void give_me_five() throws Exception {

		int result = myGame.getHand();

		assertEquals(5, result);
	}

	@Test
	@Ignore
	public void get_color() throws Exception {
		int result = myGame.getHand();
		
		assertEquals("Spades", result);
	}

	@Test
	@Ignore
	public void get_value() throws Exception {
		int result = myGame.getHand();
		
		assertEquals(5, result);
	}

	@Test
	@Ignore
	public void draw_one_card() throws Exception {
		int result = myGame.getHand();

		assertEquals("C7", result);
	}
}
