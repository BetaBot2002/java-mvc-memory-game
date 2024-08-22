package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck(int numberOfUniqueCards) {
        this.cards = new ArrayList<>();
        generateDeck(numberOfUniqueCards);
        shuffle();
    }

    private void generateDeck(int numberOfUniqueCards) {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= numberOfUniqueCards * numberOfUniqueCards; j++) {
                cards.add(new Card(j));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getCard(int index) {
        if (index < 0 || index >= cards.size()) {
            return null;
        }
        return cards.get(index);
    }

    public boolean isEmpty() {
        return cards.stream().allMatch(card -> !card.isFacedDown());
    }

    public int remainingCards() {
        return (int) cards.stream().filter(Card::isFacedDown).count();
    }
}
