package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Deck deck;
    private Card firstSelectedCard;
    private Card secondSelectedCard;
    private int score;
    private List<Card> matchedCards;

    public Game(int numberOfUniqueCards) {
        this.deck = new Deck(numberOfUniqueCards);
        this.matchedCards = new ArrayList<>();
        this.score = 0;
    }

    public boolean selectCard(int index) {
        Card selectedCard = deck.getCard(index);

        if (selectedCard == null || !selectedCard.isFacedDown() || matchedCards.contains(selectedCard)) {
            return false;
        }

        selectedCard.flip();

        if (firstSelectedCard == null) {
            firstSelectedCard = selectedCard;
        } else {
            secondSelectedCard = selectedCard;
            score++;
        }
        return true;
    }

    public boolean twoCardsSelected() {
        return firstSelectedCard != null && secondSelectedCard != null;
    }

    public boolean checkMatch() {
        boolean matched = false;
        if (firstSelectedCard != null && secondSelectedCard != null) {
            if (firstSelectedCard.getNumber() == secondSelectedCard.getNumber()) {
                matchedCards.add(firstSelectedCard);
                matchedCards.add(secondSelectedCard);
                matched = true;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                firstSelectedCard.flip();
                secondSelectedCard.flip();
            }

            firstSelectedCard = null;
            secondSelectedCard = null;
        }
        return matched;
    }

    public boolean isGameOver() {
        return deck.remainingCards() <= 2;
    }

    public int getScore() {
        return score;
    }

    public List<Card> getMatchedCards() {
        return matchedCards;
    }

    public Deck getDeck() {
        return deck;
    }
}