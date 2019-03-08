package blackjack2;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cardList = new ArrayList<>();

	public void addCard(Card card) {
		cardList.add(card);
	}

	public int calculateHandValue() {
		int totalValue = 0;
		int asOccurence = 0;
		for (Card currentCard : cardList) {
			switch (currentCard.getCardFace()) {
			case DEUX:
				totalValue += 2;
				break;
			case TROIS:
				totalValue += 3;
				break;
			case QUATRE:
				totalValue += 4;
				break;
			case CINQ:
				totalValue += 5;
				break;
			case SIX:
				totalValue += 6;
				break;
			case SEPT:
				totalValue += 7;
				break;
			case HUIT:
				totalValue += 8;
				break;
			case NEUF:
				totalValue += 9;
				break;
			case DIX:
			case VALET:
			case DAME:
			case ROI:
				totalValue += 10;
				break;
			case AS:
				totalValue += 11;
				asOccurence++;
			}
		}
		while (totalValue > 21 && asOccurence != 0) {
			totalValue -= 10;
			asOccurence--;
		}
		return totalValue;
	}
}
