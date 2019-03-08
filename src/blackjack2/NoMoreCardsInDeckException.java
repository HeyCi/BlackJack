package blackjack2;

public class NoMoreCardsInDeckException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NoMoreCardsInDeckException() {
		super();
	}

	public NoMoreCardsInDeckException(String message) {
		System.out.println(message);
	}

}
