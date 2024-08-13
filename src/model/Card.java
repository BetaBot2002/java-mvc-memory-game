package model;
public class Card {
    private int number;
    private boolean facedDown;

    public Card(int number) {
        this.number = number;
        this.facedDown = true;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isFacedDown() {
        return this.facedDown;
    }

    public void flip() {
        this.facedDown = !this.facedDown; 
    }

    // @Override
    // public boolean equals(Object o) {
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Card card = (Card) o;
    //     return number == card.number;
    // }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", facedDown=" + facedDown +
                '}';
    }
}
