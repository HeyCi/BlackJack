package blackjack2;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cardList;

	public Deck() {
		cardList = new ArrayList<>();
		for (CardColor color : CardColor.values()) {
			for (CardFace face : CardFace.values()) {
				Card card = new Card(face, color);
				cardList.add(card);
			}
		}
	}

	public Card removeCard(int index) throws NoMoreCardsInDeckException {
		try {
			return cardList.remove(index);
		} catch (Exception e) {
			throw new NoMoreCardsInDeckException("Zut le paquet est vide");
		}
	}

	public Card drawRandomly() {
		int drawnCardIndex = (int) Math.floor((Math.random() * cardList.size()));
		Card pickedUpCard;
		try {
			pickedUpCard = removeCard(drawnCardIndex);
			System.out.println("Carte tirée : " + pickedUpCard.getCardName());
			return pickedUpCard;
		} catch (NoMoreCardsInDeckException e) {
			System.out.println("Tu ne peux plus prendre de carte");
			return null;
		}
	}
}
