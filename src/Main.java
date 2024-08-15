import controller.GameController;
import model.Game;
import utilities.UserInputGUI;
import view.CLIView;
import view.GUIView;
import view.GameView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameView view = null;
        Game game = null;
        int numberOfUniqueCards = 0;

        while (true) {
            System.out.println("=== Memory Game Menu ===");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Select View:");
                    System.out.println("1. Command Line Interface (CLI)");
                    System.out.println("2. Graphical User Interface (GUI)");
                    System.out.print("Enter your choice: ");
                    int viewChoice = scanner.nextInt();

                    if (viewChoice == 1) {
                        view = new CLIView();
                        System.out.println("CLI View selected.");
                        System.out.print("Enter the number of unique cards (n): ");
                        numberOfUniqueCards = scanner.nextInt();
                    } else if (viewChoice == 2) {
                        view = new GUIView();
                        System.out.println("GUI View selected.");
                        UserInputGUI inputGUI = new UserInputGUI();
                        inputGUI.setVisible(true);
                        numberOfUniqueCards = inputGUI.getNumberOfUniqueCards();
                        System.out.println(numberOfUniqueCards);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                    }

                    while (numberOfUniqueCards <= 0) {
                        System.out.print("Please enter a positive number: ");
                        numberOfUniqueCards = scanner.nextInt();
                    }

                    // Initialize the game and start the game using the selected view
                    game = new Game(numberOfUniqueCards);
                    GameController controller = new GameController(game, view);
                    controller.startGame();
                    break;

                case 2:
                    System.out.println("Exiting the game. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
