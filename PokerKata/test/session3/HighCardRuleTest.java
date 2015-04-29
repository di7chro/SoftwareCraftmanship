package session3;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class HighCardRuleTest {

	@Test
	public void check_High_Card_one_card_per_hand() {
		Player player1 = new Player("Anna", "9H");
		Player player2 = new Player("Kalle", "4H");

		Player winner = HighCardRule.compare(player1, player2);

		assertEquals("Anna", winner.getPlayerName());
	}

	@Test
	public void same_cards_returns_tie() throws Exception {
		Player player1 = new Player("1", "2H");
		Player player2 = new Player("2", "2C");

		Player winner = HighCardRule.compare(player1, player2);

		assertNull(winner);
	}

	@Test
	public void check_high_card_multiple_cards_per_hand() throws Exception {
		Player player1 = new Player("Anna", "4H 4D");
		Player player2 = new Player("Kalle", "4C 5C");

		Player winner = HighCardRule.compare(player1, player2);

		assertEquals("Kalle", winner.getPlayerName());
	}

	@Test
	public void check_high_card_multiple_cards_per_hand_one_differs() throws Exception {
		Player player1 = new Player("Anna", "3H 5D 6H 8D 9C");
		Player player2 = new Player("Kalle", "4C 5C 6D 9D 8H");

		Player winner = HighCardRule.compare(player1, player2);

		assertEquals("Kalle", winner.getPlayerName());
	}

}
