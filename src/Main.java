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

    // Setting Players and Deck
    Player[] players = new Player[playerCount];
    for (int i = 0; i < playerCount; i++) {
        System.out.println("Enter the name of the player " + (i + 1) + ": ");
        String name = scanner.next();
        players[i] = new Player(name);
    }
    Deck deck = new Deck();
    deck.shuffle();

    // Main game loop
    String input = "";
    while (running) {
        // Draw cards for active players
        for (int i = 0; i < playerCount; i++) {
            System.out.println("\nIt is " + players[i].getName() + "'s turn.");
            if (players[i].isActive()) {
                valid = false;
                if (players[i].getHand().size() > 0) {
                    System.out.print("Current hand: ");
                    for (Card card : players[i].getHand()) {
                        System.out.print(card.getValue() + " ");
                    }
                    System.out.println();
                }
                do {
                    System.out.println("Would you like to hit or stay?\n1: Hit\n2: Stay");
                    input = scanner.next();
                    if (input.equals("1")) {
                        valid = true;
                        players[i].hit(deck);
                    } else if (input.equals("2")) {
                        valid = true;
                        players[i].stay();
                    } else {
                        System.out.println("Invalid input. Please try again.");
                    }
                } while (!valid);
            } else {
                System.out.println(players[i].getName() + " is inactive.");
            }
        }

        // Check if the round or the game ended
        int inactivePlayers = 0;
        for (int i = 0; i < playerCount; i++) {
            // Entire game over
            if (players[i].getTotal() >= 200) {
                running = false;
                break;
            }

            // Flip 7 ends round
            if (players[i].flippedSeven()) {
                System.out.println("This round has ended. Counting totals...");
                for (int j = 0; j < playerCount; j++) {
                    players[j].endRound();
                    System.out.println(players[j].getName() + "'s total is " + players[j].getTotal());
                }
            } else if (!players[i].isActive()) {
                inactivePlayers++;
            }
        }

        // If all players are inactive, end round
        if (inactivePlayers == playerCount) {
            System.out.println("This round has ended. Counting totals...");
            for (int j = 0; j < playerCount; j++) {
                players[j].endRound();
                System.out.println(players[j].getName() + "'s total is " + players[j].getTotal());
            }
        }
    }
}