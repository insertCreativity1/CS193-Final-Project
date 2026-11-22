import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        deck.add(new Card("Number", String.valueOf(0)));
        deck.add(new Card("Number", String.valueOf(1)));
        for (int i = 2; i < 13; i++) {
            for (int j = i; j > 0; j--) {
                deck.add(new Card("Number", String.valueOf(i)));
            }
        }
    }

    public void shuffle() {
        try {
            Collections.shuffle(deck);
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

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

    public Card deal() {
        if (deck.size() <= 0) {
            this.reset();
        }
        return deck.remove(0);
    }
}