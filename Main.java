public static void main(String[] args) {
    System.out.println("Welcome to Flip 7!");
    Deck deck = new Deck();
    int n = 0;
    deck.shuffle();
    System.out.println("Testing deck");
    System.out.println("Deck size: " + deck.size());
    for (int j = 0; j < 94; j++) {
        Card card = deck.deal();
        if (card.getType().equals("Number")) {
            n++;
            System.out.println("Total Cards: " + n + ", Type: " + card.getType() + ", Value: " + card.getValue());
        }
        else if (card.getType().equals("Action")) {
            n++;
            System.out.println("Total Cards: " + n + ", Type: " + card.getType() + ", Value: " + card.getValue());
        }
        else if (card.getType().equals("Modify")) {
            n++;
            System.out.println("Total Cards: " + n + ", Type: " + card.getType() + ", Value: " + card.getValue());
        }
        else {
            System.out.println(card.getType() + " " + card.getValue());
        }
        //System.out.println("Type: " + card.type + ", Value: " + card.value);
    }
    System.out.println();
}