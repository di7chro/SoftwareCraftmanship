package session3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void getPlayerName() {
		assertEquals("Christian", new Player("Christian", "5H").getPlayerName());
	}

	@Test
	public void getPlayerHand() throws Exception {
		List<Card> listCard = new ArrayList<Card>();
		listCard.add(new Card("5H"));
		Player player = new Player("bob", "5H");

		List<Card> result = player.getPlayerHand();

		assertEquals(listCard.get(0).getValue(), result.get(0).getValue());
	}

	@Test
	public void constructor_handles_multiple_cards() throws Exception {
		List<Card> listCard = new ArrayList<Card>();
		listCard.add(new Card("5H"));
		listCard.add(new Card("3H"));
		Player player = new Player("bob", "5H 3H");

		List<Card> result = player.getPlayerHand();

		assertEquals(listCard.size(), result.size());
	}
	
	@Test
	public void constructor_handles_multiple_cards_suit_cards() throws Exception {
		List<Card> listCard = new ArrayList<Card>();
		listCard.add(new Card("5H"));
		listCard.add(new Card("3H"));
		Player player = new Player("bob", "5H 3H");

		List<Card> result = player.getPlayerHand();

		assertEquals(listCard.size(), result.size());
	}	
}
