package session3;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void give_me_a_card() {
		Card card = new Card("4H");
		assertEquals(4, card.getValue());
	}
	
	@Test
	public void test_suited_values() throws Exception {
		assertEquals(10, new Card("TD").getValue());
		assertEquals(11, new Card("JD").getValue());
		assertEquals(12, new Card("QD").getValue());
		assertEquals(13, new Card("KD").getValue());
		assertEquals(14, new Card("AD").getValue());
	}
	
}
