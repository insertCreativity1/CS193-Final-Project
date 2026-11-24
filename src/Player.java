import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> hand;
    boolean active;
    int numCount;
    int total;

    // Constructor
    public Player (String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.active = true;
        this.numCount = 0;
        this.total = 0;
    }

    // When a player draws a card
    public Card hit(Deck deck) {
        boolean valid = true;
        Card c = deck.deal();
        System.out.println("Your card is " + c.getValue());
        if (c.getType().equals("Number")) {
            for (Card card : hand) {
                if (c.getValue().equals(card.getValue())) {
                    if (!this.secondChance(true)) {
                        active = false;
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                        System.out.println(name + " busted!\nPlay again next round.");
                        hand.clear();
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                hand.add(c);
                numCount++;
            }
        } else if (c.getType().equals("Modify") || c.getValue().equals("Second Chance")) {
            hand.add(c);
        }
        return c;
    }

    // When a player chooses to not draw anymore
    public void stay() {
        active = false;
        System.out.println(name + " is not active for the rest of this round.");
    }

    // Check for Flip 7
    public boolean flippedSeven () {
        return active && numCount >= 7;
    }

    // Returns if a player has a "Second Chance" card
    // If sent with "true" then remove the card from hand
    public boolean secondChance(boolean check) {
        for (Card card : hand) {
            if (card.getValue().equals("Second Chance")) {
                if (check) {
                    Card c = new Card("Action", "Second Chance");
                    hand.remove(hand.indexOf(c));
                }
                return true;
            }
        }
        return false;
    }

    public void flip3(Deck deck) {
        for (int i = 0; i < 3; i++) {
            Card c = deck.deal();
            if (c.getType().equals("Number")) {
                for (Card card : hand) {
                    if (c.getValue().equals(card.getValue())) {
                        if (!this.secondChance(true)) {
                            active = false;
                            System.out.println(name + " busted!\nPlay again next round.");
                        }
                    } else {
                        hand.add(c);
                        numCount++;
                    }
                }
            }
            if (flippedSeven()) {
                break;
            }
        }
    }

    // Clear player's hand when each round ends
    public void endRound() {
        if (hand.size() > 0) {
            ArrayList<String> modifiers = new ArrayList<>();
            for (Card card : hand) {
                if (card.getType().equals("Number")) {
                    total += Integer.parseInt(card.getValue());
                } else if (card.getType().equals("Modify")) {
                    modifiers.add(card.getValue());
                }
            }
        }
        hand.clear();
        active = true;
        numCount = 0;
    }

    // Getters

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    // A player is active per round, inactive when chose to stay or busted
    public boolean isActive() {
        return active;
    }

    public int getTotal() {
        return total;
    }
}