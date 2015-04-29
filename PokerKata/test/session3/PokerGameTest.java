package session3;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class PokerGameTest {

	@Test
	public void green_wins_with_highest_card() {
		Player green = new Player("Green", "2S 3C 4D 7H AH");
		Player white = new Player("White", "3S 4C 5D 6H KH");
		PokerGame game = new PokerGame();

		Player winningPlayer = game.calculateWinningPlayer(green, white);

		assertEquals("Green", winningPlayer.getPlayerName());
	}

	@Test
	public void one_pair_beats_highest_card() throws Exception {
		Player green = new Player("Green", "2S 3C 4D 7H AH");
		Player white = new Player("White", "3S 3C 5D 6H KH");
		PokerGame game = new PokerGame();

		Player winningPlayer = game.calculateWinningPlayer(green, white);
		
		assertEquals("White", winningPlayer.getPlayerName());
	}
	
	@Test
	public void two_pair_beats_one_pair() throws Exception {
		Player green = new Player("Green", "6S 6C 4D 7H AH");
		Player white = new Player("White", "3S 3C 5D 5H KH");
		PokerGame game = new PokerGame();

		Player winningPlayer = game.calculateWinningPlayer(green, white);		
		
		assertEquals("White", winningPlayer.getPlayerName());
	}

	@Test
	public void straight_gives_12() throws Exception {
		String hand = "K2S3H4R5R6";

		int result = myGame.getScore(hand);

		assertEquals(12, result);
	}

	@Test
	public void straight_flush_gives_14() throws Exception {
		String hand = "K2K3K4K5K6";

		int result = myGame.getScore(hand);

		assertEquals(14, result);
	}

	@Test
	@Ignore
	public void royal_straight_flush_gives_16() throws Exception {
		String hand = "R10RKRDRKRE";

		int result = myGame.getScore(hand);

		assertEquals(16, result);
	}
}
