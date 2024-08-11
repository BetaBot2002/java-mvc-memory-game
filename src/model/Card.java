package model;

public class Card {
    private int number;
    private boolean isFacedDown;


    public Card() {
    }

    public Card(int number, boolean isFacedDown) {
        this.number = number;
        this.isFacedDown = isFacedDown;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getIsFacedDown() {
        return this.isFacedDown;
    }

    public void setIsFacedDown(boolean isFacedDown) {
        this.isFacedDown = isFacedDown;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return number == card.number && isFacedDown == card.isFacedDown;
    }

    @Override
    public String toString() {
        return "{" +
            " number='" + getNumber() + "'" +
            ", isFacedDown='" + getIsFacedDown() + "'" +
            "}";
    }
    
}