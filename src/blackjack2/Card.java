package blackjack2;

public class Card {
	private CardFace cardFace;
	private CardColor cardColor;
//	private int value;

	public Card(CardFace cardFace, CardColor cardColor) {
		this.cardFace = cardFace;
		this.cardColor = cardColor;
	}

	public String getCardName() {
		return (cardFace + " de " + cardColor);
	}

//	public int getValue() {
//		return value;
//	}

	public CardFace getCardFace() {
		return cardFace;
	}
}
