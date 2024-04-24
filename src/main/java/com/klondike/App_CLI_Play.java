import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

// Main class to interact with the player through CLI
public class App_CLI_Play {
    public static void main(String[] args) {
        // Create the game components
        Paquet_distributeur distributeur = new Paquet_distributeur();
        List<Paquet_colonne> colonnes = new ArrayList<>(); // Initialize columns
        List<Paquet_pieux> foundations = new ArrayList<>(); // Initialize foundations
        Paquet_pioche pioche = new Paquet_pioche();
        Paquet_defausse defausse = new Paquet_defausse();

        // Create the CLI interface
        App_CLI cli = new App_CLI(distributeur, pioche, defausse, colonnes, foundations);

        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);
        String command;

        // Game loop
        while (true) {
            cli.displayGameState(); // Display current game state

            System.out.print("Enter command: ");
            command = scanner.nextLine();

            // Process commands
            switch (command.toLowerCase()) {
                case "quit":
                    System.out.println("Thanks for playing!");
                    return; // Exit the game loop

                case "draw":
                    // Logic to draw a card from pioche
                    pioche.drawCard(defausse);
                    break;

                case "move":
                    // Example: "move C1 F1" - move the top card from Column 1 to Foundation 1
                    String[] parts = command.split(" ");
                    if (parts.length == 3) {
                        String source = parts[1];
                        String target = parts[2];
                        moveCard(source, target); // Implement this method
                    }
                    break;

                default:
                    System.out.println("Invalid command. Available commands: draw, move, quit.");
                    break;
            }
        }

        scanner.close();
    }

    // Placeholder for move logic
    private static void moveCard(String source, String target) {
        // Implement logic to move a card from one component to another
    }
}
