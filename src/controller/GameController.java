package controller;

import model.Card;
import model.Game;
import view.GameView;

public class GameController {
    private Game game;
    private GameView view;

    public GameController(Game game, GameView view) {
        this.game = game;
        this.view = view;
    }

    public void startGame() {
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
                for (Card card : game.getDeck().getCards()) {
                    if(card.isFacedDown()) card.flip();
                }
                view.displayGameOverMessage(game.getScore());
                view.displayBoard(game.getDeck(), game.getMatchedCards());
            }
        }
    }
}
