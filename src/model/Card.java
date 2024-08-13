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

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", facedDown=" + facedDown +
                '}';
    }
}
