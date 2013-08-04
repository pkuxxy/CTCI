class Card {
	public static enum Suit {
		HEARTS, SPADES, CLUBS, DIAMONDS;
	}

	private int value;
	private Suit suit;

	public Card(int v, Suit s) {
		value = v;
		suit = s;
	}

	public int getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}
}

class BlackJackCard extends Card {
	public BlackJackCard(int r, Suit s) {
		super(r, s);
	}

	public int value() {
		int r = super.getValue();
		if (r == 1)
			return 11; // aces are 11
		if (r < 10)
			return r;
		return 10;
	}

	boolean isAce() {
		return super.getValue() == 1;
	}
}

public class C7_1 {

}
