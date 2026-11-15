public class Player {
    String name;
    Deck hand;
    boolean active;

    public Player (String name) {
        this.name = name;
        hand = new Deck();
        active = true;
    }

}