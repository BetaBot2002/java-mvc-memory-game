package view;

import model.Card;
import model.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUIView extends JFrame implements GameView {
    private JPanel boardPanel;
    private JLabel messageLabel;
    private JButton[] cardButtons;
    private int selectedCardIndex;
    private boolean cardSelected;

    public GUIView(int n) {
        setTitle("Memory Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        messageLabel = new JLabel("Welcome to the Memory Game!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(messageLabel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(0, 2*n)); // 4 cards per row
        add(boardPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void displayWelcomeMessage() {
        messageLabel.setText("Welcome to the Memory Game! Try to match all the pairs of cards.");
    }

    @Override
    public void displayBoard(Deck deck, List<Card> matchedCards) {
        boardPanel.removeAll();
        List<Card> cards = deck.getCards();
        cardButtons = new JButton[cards.size()];

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            JButton button;
            
            if (matchedCards.contains(card)) {
                button = new JButton("");
                button.setEnabled(true); 
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "This card is already matched.", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                });
            } else {
                button = new JButton(card.isFacedDown() ? "X" : String.valueOf(card.getNumber()));
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setFocusPainted(false);
                button.setActionCommand(String.valueOf(i));

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectedCardIndex = Integer.parseInt(e.getActionCommand());
                        cardSelected = true;
                    }
                });
            }

            cardButtons[i] = button;
            boardPanel.add(button);
        }

        boardPanel.revalidate();
        boardPanel.repaint();
    }

    @Override
    public void displayCardFlipped(Card card) {
        messageLabel.setText("Card flipped: " + card.getNumber());
    }

    @Override
    public void displayInvalidSelectionMessage() {
        JOptionPane.showMessageDialog(null, "Invalid selection. Please try again.", "Warning", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void displayMatchedMessage() {
        messageLabel.setText("Pair matched!");
    }

    @Override
    public void displayNotMatchedMessage() {
        messageLabel.setText("Pair not matched.");
    }

    @Override
    public void displayCurrentScoreMessage(int score) {
        messageLabel.setText("Current Score: " + score);
    }

    @Override
    public void displayGameOverMessage(int score) {
        messageLabel.setText("Game Over! Your score is: " + score);
    }

    @Override
    public int promptForCardSelection() {
        cardSelected = false;
        while (!cardSelected) {
            try {
                Thread.sleep(100); // Wait for the user to select a card
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return selectedCardIndex;
    }
}
