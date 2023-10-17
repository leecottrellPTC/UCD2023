/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 *
 * @author leecottrell
 */
public class Card {

    private String suit;    //Hearts, Clubs, Spades, Diamonds
    private int value;      //1 -13, today Ace is low

    public Card() {
        suit = "Hearts";
        value = 13;
    }

    public Card(String s, int v) {
        suit = s;
        value = v;
    }

    public void pickCard() {
        //pick two random values
        int s;
        s = ((int) (Math.random() * 4)) + 1;
        value = ((int) (Math.random() * 13)) + 1;

        //pick the suit
        switch (s) {
            case 1:
                suit = "Hearts";
                break;
            case 2:
                suit = "Diamonds";
                break;
            case 3:
                suit = "Clubs";
                break;
            case 4:
                suit = "Spades";
                break;
            default:
                suit = "Bad Suit";
        }


    }
    
    public String showCard(){
        String cardOutput;
        switch(value){
            case 1:
                cardOutput = "Ace of " + this.suit;
                break;
            case 11:
                cardOutput = "Jack of " + this.suit;
                break;
            case 12:
                cardOutput = "Queen of " + this.suit;
                break;
            case 13:
                cardOutput = "King of " + this.suit;
                break;
            default:
                cardOutput = this.value + " of " + this.suit;
        }
        
        return cardOutput;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }
    
     public int getValue(String game) {
         //set k,q,j = 10
         //ace = 11
         switch(value){
             case 13:
             case 12:
             case 11:
                 return 10;
                // break;
             case 1:
                 return 11;
              
         }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.showCard();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.suit != null ? this.suit.hashCode() : 0);
        hash = 79 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if ((this.suit == null) ? (other.suit != null) : !this.suit.equals(other.suit)) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
}
