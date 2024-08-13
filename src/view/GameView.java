package view;

import java.util.List;

import model.Card;
import model.Deck;

public interface GameView {
    void displayWelcomeMessage();
    void displayBoard(Deck deck, List<Card> matchedCards);
    void displayCardFlipped(Card card);
    void displayInvalidSelectionMessage();
    void displayMatchedMessage();
    void displayNotMatchedMessage();
    void displayCurrentScoreMessage(int score);
    void displayGameOverMessage(int score);
    int promptForCardSelection();
}