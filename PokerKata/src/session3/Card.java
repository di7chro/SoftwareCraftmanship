package session3;

public class Card {

	private int value;
	private String card;

	public Card(String cardAsString) {
		this.card = cardAsString;
		this.value = "23456789TJQKA".indexOf(cardAsString.substring(0,1)) + 2;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return card;
	}
	
}
