package session3;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private ArrayList<Card> cards;

	public Player(String name, String cards) {
		this.name = name;
		this.cards = new ArrayList<Card>();
		String[] split = cards.split(" ");
		for (String val : split) {
			this.cards.add(new Card(val));
		}
	}

	public String getPlayerName() {
		return name;
	}

	public List<Card> getPlayerHand() {
		return this.cards;
	}

}
