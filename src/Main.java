import java.util.Scanner;

public static void main(String[] args) {
    // Game Setup
    Scanner scanner = new Scanner(System.in);
    boolean running = true;
    System.out.println("Welcome to Flip 7!");
    int playerCount = 0;
    boolean valid = false;
    do {
        System.out.print("Please enter the number of players. (3-18)\n");
        if (scanner.hasNextInt()) {
            playerCount = scanner.nextInt();
            valid = (playerCount >= 3 && playerCount <= 18);
            if (!valid) {
                System.out.println("Out of range. Please try again.");
            }
        } else {
            System.out.println("That's not a valid number. Please try again.");
            scanner.next();
            playerCount = 0;
            valid = false;
        }
    } while (!valid);

    // Setting Players and deck
    Player[] players = new Player[playerCount];
    for (int i = 0; i < playerCount; i++) {
        System.out.println("Enter the name of the player " + (i + 1) + ": ");
        String name = scanner.next();
        players[i] = new Player(name);
    }
    Deck deck = new Deck();

    while (running) {
        ;
    }
}