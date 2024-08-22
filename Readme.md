# Memory Game - following Model-View-Controller approach [⚠️ Under Construction]

## Basic details of the game:
1. User will enter a number of unique cards (n).
2. The system will generate 4*n^2 number of cards where each card will hold a number from 1 to n. The numbers will be hidden.
3. User will choose a card, which then will reveal it's number by flipping.
4. Then the user chooses another card. If both cards have same numbers, it will be counted as a point and the game will continue with remaining cards. Else both cards again hides the number and the game continues.
5. The game is over when either 2 cards or no cards are remaining to choose. (If 2 cards are remaining, they will automatically show their numbers as they must be same).

## Current Working Folder Structure [can be modified]:
```
    ROOT/
    │
    ├── build/  //For classes after build
    ├── src/
    │   ├── model/
    │   │   ├── Card.java
    │   │   ├── Deck.java
    │   │   └── Game.java
    │   │
    │   ├── view/
    │   │   ├── GameView.java
    │   │   ├── CLIView.java
    │   │   └── GUIView.java
    │   │
    │   ├── controller/
    │   │   └── GameController.java
    │   │
    │   ├── utilities/
    │   │   └── UserInputGUI.java
    │   │
    │   └── Main.java
    │
    ├── .gitignore
    └── Readme.md/
```
