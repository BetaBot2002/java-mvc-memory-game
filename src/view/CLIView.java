package view;

import model.Card;
import model.Deck;

import java.util.List;
import java.util.Scanner;

public class CLIView implements GameView {
    private Scanner scanner;

    public CLIView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Memory Game!");
        System.out.println("Try to match all the pairs of cards.");
    }

    @Override
    public void displayBoard(Deck deck, List<Card> matchedCards) {
        System.out.println("Current Board:");
        List<Card> cards = deck.getCards();
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (matchedCards.contains(card) || !card.isFacedDown()) {
                System.out.print("[" + card.getNumber()  +"] ");
                // System.out.print("[" + card.getNumber()  +"] "+(!card.isFacedDown() ? "nfd" : "matchhed"));
            } else {
                System.out.print("[X] ");
            }
            
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    @Override
    public void displayCardFlipped(Card card) {
        System.out.println("Card flipped: " + card.getNumber());
    }

    @Override
    public void displayInvalidSelectionMessage() {
        System.out.println("Invalid selection. Please try again.");
    }

    @Override
    public void displayGameOverMessage(int score) {
        System.out.println("Game Over! Your score is: " + score);
        System.out.println("Thanks for playing!");
    }

    @Override
    public int promptForCardSelection() {
        System.out.print("Select a card to flip (enter the card number): ");
        return scanner.nextInt() - 1; // Subtract 1 to convert to 0-based index
    }
}
