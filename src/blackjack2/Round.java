package blackjack2;

import java.util.ArrayList;
import java.util.Scanner;

public class Round {
	private Deck deck;
	private Hand bank;
	private ArrayList<Hand> playerList;
	public Scanner scanner;
	private final int SCORE_MAX = 21;

	public Round() {
		deck = new Deck();
		bank = new Hand();
		playerList = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void setPlayerBase() {
		System.out.println(" -- MISE EN PLACE -- ");
		System.out.println("Combien de joueurs y a-t-il ? ");
		int nbPlayer = scanner.nextInt();
		for (int i = 0; i < nbPlayer; i++) {
			Hand player = new Hand();
			playerList.add(player);
		}
	}

	public void initializeRound() {
		System.out.println(" -- DISTRIBUTION DES CARTES -- ");

		System.out.println("Cartes de la banque :");
		bank.addCard(deck.drawRandomly());
		bank.addCard(deck.drawRandomly());
		System.out.println("Somme de départ de la banque : " + bank.calculateHandValue());

		System.out.println(" -- ");

		for (Hand playerHand : playerList) {
			System.out.println("Cartes du joueur :");
			playerHand.addCard(deck.drawRandomly());
			playerHand.addCard(deck.drawRandomly());
			System.out.println("Somme de départ du joueur : " + playerHand.calculateHandValue());
		}
	}

	public void playerTurn() {

		for (Hand player : playerList) {
			System.out.println(" -- TOUR DU JOUEUR -- ");

			Boolean drawAgain = true;

			while (drawAgain) {
				System.out.println("Voulez-vous tirer une autre carte ? yes/no : ");
				String another = scanner.nextLine();
				if ("yes".equals(another)) {
					player.addCard(deck.drawRandomly());
				} else {
					System.out.println("Score final du joueur : " + player.calculateHandValue());
					if (player.calculateHandValue() > SCORE_MAX) {
						System.out.println("Perdu !");
					}
					System.out.println("Ok on passe au suivant");
					drawAgain = false;
				}
			}
		}
	}

	public void bankTurn() {
		System.out.println(" -- TOUR DE LA BANQUE -- ");
		while (bank.calculateHandValue() < 17) {
			bank.addCard(deck.drawRandomly());
		}
		System.out.println("score final de la banque : " + bank.calculateHandValue());
	}

	public void endRound() {
		System.out.println(" -- FIN DE PARTIE -- ");
		int endScoreBank = bank.calculateHandValue();
		for (Hand player : playerList) {
			int endScorePlayer = player.calculateHandValue();
			if (endScoreBank > SCORE_MAX && endScorePlayer < 21) {
				System.out.println("La banque a perdu !");
			} else if (endScorePlayer <= SCORE_MAX && endScorePlayer > endScoreBank) {
				System.out.println("Bravo vous avez gagné !");
			} else if (endScorePlayer <= SCORE_MAX && endScorePlayer < endScoreBank) {
				System.out.println("Perdu, c'est la banque qui gagne !");
			} else if (endScorePlayer > SCORE_MAX && endScoreBank > SCORE_MAX) {
				System.out.println("La banque et vous avez perdu !");
			} else {
				System.out.println("La banque a gagné !");
			}
		}
		scanner.close();
	}
}
