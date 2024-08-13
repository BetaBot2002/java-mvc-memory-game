package controller;

import model.Game;
import view.GameView;

public class GameController {
    private Game game;
    private GameView view;

    public GameController(int numberOfUniqueCards, GameView view) {
        this.game = new Game(numberOfUniqueCards);
        this.view = view;
        startGame();
    }

    private void startGame() {
        view.displayWelcomeMessage();
        view.displayBoard(game.getDeck(), game.getMatchedCards());
        while (!game.isGameOver()) {
            int cardIndex = view.promptForCardSelection();

            if (game.selectCard(cardIndex)) {
                view.displayCardFlipped(game.getDeck().getCard(cardIndex));
                view.displayBoard(game.getDeck(), game.getMatchedCards());
                if (game.twoCardsSelected()) {
                    if (game.checkMatch()) {
                        view.displayMatchedMessage();
                    } else {
                        view.displayNotMatchedMessage();
                    }
                }
                view.displayCurrentScoreMessage(game.getScore());
                view.displayBoard(game.getDeck(), game.getMatchedCards());
            } else {
                view.displayInvalidSelectionMessage();
            }

            if (game.isGameOver()) {
                view.displayGameOverMessage(game.getScore());
            }
        }
    }
}
