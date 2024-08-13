package view;

import java.util.List;

import model.Card;
import model.Deck;

public interface GameView {
    void displayWelcomeMessage();
    void displayBoard(Deck deck, List<Card> matchedCards);
    void displayCardFlipped(Card card);
    void displayInvalidSelectionMessage();
    void displayGameOverMessage(int score);
    int promptForCardSelection();
}