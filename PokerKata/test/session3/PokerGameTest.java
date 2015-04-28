/**
 * PokerGame.java
 * 
 * Course in Software Craftsmenship @ Högskolan Väst
 * Poker game kata for testing TDD, Test Driven Development
 * 
 * 2015-04-27
 */

package session3;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class PokerGameTest {
	PokerGame myGame = new PokerGame();

	@Test
	public void nothing_gives_0() throws Exception {
		String hand = "S2K3R5H6S7";

		int result = myGame.getScore(hand);

		assertEquals(0, result);
	}

	@Test
	public void single_pair_gives_2() throws Exception {
		String hand = "S2K2R5H6S7";

		int result = myGame.getScore(hand);

		assertEquals(2, result);
	}

	@Test
	public void three_of_a_kind_gives_3() throws Exception {
		String hand = "S2K2R2H6S7";

		int result = myGame.getScore(hand);

		assertEquals(3, result);
	}

	@Test
	public void two_pairs_gives_6() throws Exception {
		String hand = "S2K2R5H7S7";

		int result = myGame.getScore(hand);

		assertEquals(6, result);
	}

	@Test
	public void four_of_a_kind_gives_7() throws Exception {
		String hand = "S2K2R2H2S7";

		int result = myGame.getScore(hand);

		assertEquals(7, result);
	}

	@Test
	public void full_house_gives_9() throws Exception {
		String hand = "S2K2R2H7S7";

		int result = myGame.getScore(hand);

		assertEquals(9, result);
	}

	@Test
	public void flush_gives_10() throws Exception {
		String hand = "S2S6S7S8S9";

		int result = myGame.getScore(hand);

		assertEquals(10, result);
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