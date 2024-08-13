import controller.GameController;
import view.CLIView;
import view.GameView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of unique cards (n): ");
        int numberOfUniqueCards = scanner.nextInt();

        while (numberOfUniqueCards <= 0) {
            System.out.print("Please enter a positive number: ");
            numberOfUniqueCards = scanner.nextInt();
        }

        GameView view = new CLIView(); 
        new GameController(numberOfUniqueCards, view); 
        scanner.close();
    }
}
