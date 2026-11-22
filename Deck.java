import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    // Constructor
    public Deck() {
        this.reset();
    }

    // Shuffles all cards in the deck (Note: only when deck empty, NOT at the end of each round)
    public void shuffle() {
        try {
            Collections.shuffle(deck);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    // Resets deck when empty
    public void reset() {
        deck.clear();
        deck.add(new Card("Number", String.valueOf(0)));
        deck.add(new Card("Number", String.valueOf(1)));
        for (int i = 2; i < 13; i++) {
            for (int j = i; j > 0; j--) {
                deck.add(new Card("Number", String.valueOf(i)));
            }
        }
        for (int i = 0; i < 3; i++) {
            deck.add(new Card("Action", "Freeze"));
            deck.add(new Card("Action", "Second Chance"));
            deck.add(new Card("Action", "Flip 3"));
        }
        deck.add(new Card("Modify", "+2"));
        deck.add(new Card("Modify", "+4"));
        deck.add(new Card("Modify", "+6"));
        deck.add(new Card("Modify", "+8"));
        deck.add(new Card("Modify", "+10"));
        deck.add(new Card("Modify", "x2"));
    }

    // Deals a card from the deck
    public Card deal() {
        if (deck.size() <= 0) {
            this.reset();
        }
        return deck.remove(0);
    }

    public int size() {
        return  this.deck.size();
    }
}