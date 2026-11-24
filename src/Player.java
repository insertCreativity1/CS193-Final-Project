import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> hand;
    boolean active;
    int numCount;

    // Constructor
    public Player (String name) {
        this.name = name;
        active = true;
        numCount = 0;
    }

    // When a player draws a card
    public Card hit(Deck deck) {
        Card c = deck.deal();
        if (c.getType().equals("Number")) {
            for (Card card : hand) {
                if (c.getValue().equals(card.getValue())) {
                    if (!this.secondChance(true)) {
                        active = false;
                        System.out.println(name + " busted!\nPlay again next round.");
                        hand.clear();
                    }
                } else {
                    hand.add(c);
                    numCount++;
                }
            }
        } /*else if (c.getType().equals("Action")) {
            if (c.getValue().equals("Freeze")) {
                ;
            }
        } */else if (c.getType().equals("Modify")) {
            hand.add(c);
        }
        return c;
    }

    // When a player chooses to not draw anymore
    public void stay() {
        active = false;
        System.out.println(name + " is not active for the rest of this round.");
    }

    // A player is active per round, inactive when chose to stay or busted
    public boolean isActive() {
        return active;
    }

    // Check for Flip 7
    public boolean flippedSeven () {
        return numCount >= 7;
    }

    // Returns if a player has a "Second Chance" card
    // If sent with "true" then remove the card from hand
    public boolean secondChance(boolean check) {
        for (Card card : hand) {
            if (card.getValue().equals("Second Chance")) {
                if (check) {
                    hand.remove(hand.indexOf(new Card("Action", "Second Chance")));
                }
                return true;
            }
        }
        return false;
    }
}