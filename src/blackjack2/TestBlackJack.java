package blackjack2;

public class TestBlackJack {

	public static void main(String[] args) {
		Round partie = new Round();

		partie.setPlayerBase();

		partie.initializeRound();

		partie.playerTurn();

		partie.bankTurn();

		partie.endRound();

	}

}