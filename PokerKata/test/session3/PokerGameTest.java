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
		String hand = "S2H3C4D5S7";

		int result = myGame.getScore(hand);

		assertEquals(0, result);
	}

	@Test
	public void pair_gives_1() throws Exception {
		String hand = "S3H3C4D5S8";

		int result = myGame.getScore(hand);

		assertEquals(1, result);
	}

	@Test
	public void two_pairs_gives_2() throws Exception {
		String hand = "S3H3C9D5S5";

		int result = myGame.getScore(hand);

		assertEquals(2, result);
	}

	@Test
	public void three_of_a_kind_gives_3() throws Exception {
		String hand = "S8H8C8D3S4";

		int result = myGame.getScore(hand);

		assertEquals(3, result);
	}

	@Test
	@Ignore
	public void straight_gives_4() throws Exception {
		String hand = "K2S3H4R5R6";

		int result = myGame.getScore(hand);

		assertEquals(4, result);
	}

	@Test
	@Ignore
	public void flush_gives_5() throws Exception {
		String hand = "S2S6S7S8S9";

		int result = myGame.getScore(hand);

		assertEquals(5, result);
	}

	@Test
	@Ignore
	public void full_house_gives_6() throws Exception {
		String hand = "S2K2R2H7S7";

		int result = myGame.getScore(hand);

		assertEquals(6, result);
	}

	@Test
	@Ignore
	public void four_of_a_kind_gives_7() throws Exception {
		String hand = "S2K2R2H2S7";

		int result = myGame.getScore(hand);

		assertEquals(7, result);
	}

	@Test
	@Ignore
	public void straight_flush_gives_8() throws Exception {
		String hand = "K2K3K4K5K6";

		int result = myGame.getScore(hand);

		assertEquals(8, result);
	}

	@Test
	@Ignore
	public void royal_straight_flush_gives_9() throws Exception {
		String hand = "R10RKRDRKRE";

		int result = myGame.getScore(hand);

		assertEquals(9, result);
	}
}