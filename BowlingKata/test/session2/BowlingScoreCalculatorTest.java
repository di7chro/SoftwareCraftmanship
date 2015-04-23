package session2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingScoreCalculatorTest {

	// FIXME 10 frames with 9 and a miss = 90
	// FIXME 10 frames with 5 and spare, and a bonus roll of 5 = 150

	// FIXME 5 with spare, strike, rest miss = 30
	// FIXME 2 strikes then rest miss = 30
	// FIXME Last roll is strike

	private BowlingScoreCalculator scoreCalculator = new BowlingScoreCalculator();

	@Test
	public void test_10_frames_of_misses_equals_0() throws Exception {
		String rolls = "--------------------";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(0, result);
	}

	@Test
	public void one_pin_down_rest_is_miss_equals_1() throws Exception {
		String rolls = "1-------------------";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(1, result);
	}

	@Test
	public void one_strike_rest_is_miss_equals_10() throws Exception {
		String rolls = "X-----------------";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(10, result);
	}

	@Test
	public void one_spare_rest_is_miss_equals_10() throws Exception {
		String rolls = "-/------------------";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(10, result);
	}

	@Test
	public void one_spare_with_privious_number_rest_is_miss_equals_10() throws Exception {
		String rolls = "5/------------------";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(10, result);
	}

	@Test
	public void twelve_strikes_two_bonus_equals_300() throws Exception {
		String rolls = "XXXXXXXXXXXX";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(300, result);
	}

	@Test
	public void test_one_spare_five_rest_miss_equals_20() throws Exception {
		String rolls = "-/5-----------------";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(20, result);
	}

	@Test
	public void five_with_spare_then_strike_rest_miss_equals_30() throws Exception {
		String rolls = "5/X----------------";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(30, result);
	}

	@Test
	public void five_with_spare_then_strike_the_five_rest_miss_equals_40() throws Exception {
		String rolls = "5/X5---------------";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(40, result);
	}

	// FIXME Last roll is spare
	@Test
	public void all_miss_last_roll_is_spare_equals_14() throws Exception {
		String rolls = "------------------5/4";

		int result = scoreCalculator.calculateScore(rolls);

		assertEquals(14, result);
	}
}
