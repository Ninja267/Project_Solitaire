import java.util.ArrayListList;

// Class to represent the game state and the CLI interface
public class App_CLI {
    // The components of the game
    private Paquet_distributeur paquetDistributeur;
    private Paquet_pioche pioche;
    private Paquet_defausse defausse;
    private ArrayList<Paquet_colonne> colonnes;
    private List<Paquet_pieux> foundations;

    // Constructor to initialize the game with the existing classes
    public App_CLI(Paquet_distributeur distributeur, Paquet_pioche pioche, Paquet_defausse defausse,
            List<Paquet_colonne> colonnes, List<Paquet_pieux> foundations) {
        this.paquetDistributeur = distributeur;
        this.pioche = pioche;
        this.defausse = defausse;
        this.colonnes = colonnes;
        this.foundations = foundations;
    }

    // Method to display the current game state
    public void displayGameState() {
        // Display Pioche and Defausse
        System.out.print("Pioche: ");
        displayCards(pioche);
        System.out.print(" | Defausse: ");
        displayCards(defausse.getCards());
        System.out.println();

        // Display Foundations
        for (int i = 0; i < foundations.size(); i++) {
            System.out.print("Foundation " + (i + 1) + ": ");
            displayCards(foundations.get(i).getCards());
            System.out.println();
        }

        // Display Columns
        for (int i = 0; i < colonnes.size(); i++) {
            System.out.print("Column " + (i + 1) + ": ");
            displayCards(colonnes.get(i).getCards());
            System.out.println();
        }
    }

    // Utility method to display a list of cards
    private void displayCards(ArrayList<Carte> cards) {
        for (Carte card : cards) {
            if (card.getEnFace()) {
                System.out.print(card); // Assuming Carte has a getName() method
            } else {
                System.out.print("[Hidden] ");
            }
        }
    }
}