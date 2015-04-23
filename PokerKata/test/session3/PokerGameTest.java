package session3;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PokerGameTest {
	// FIXME give_me_five
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

}
