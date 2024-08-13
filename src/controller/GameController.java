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
        while (!game.isGameOver()) {
            view.displayBoard(game.getDeck(), game.getMatchedCards());
            int cardIndex = view.promptForCardSelection();

            if (game.selectCard(cardIndex)) {
                view.displayCardFlipped(game.getDeck().getCard(cardIndex));
                // if (game.getMatchedCards().size() % 2 == 0) {
                //     view.displayBoard(game.getDeck(), game.getMatchedCards());
                // }
            } else {
                view.displayInvalidSelectionMessage();
            }

            if (game.isGameOver()) {
                view.displayGameOverMessage(game.getScore());
            }
        }
    }
}
