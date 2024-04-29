package com.klondike;

import java.util.Scanner;
import java.util.ArrayList;

// Class pour jouer au jeu Klondike en ligne de commande
public class App_CLI_Play {
    public static void main(String[] args) {
        // Creer les paquets
        Paquet_distributeur distributeur = new Paquet_distributeur();
        ArrayList<Paquet_colonne> colonnes = new ArrayList<Paquet_colonne>();
        ArrayList<Paquet_pieux> foundations = new ArrayList<Paquet_pieux>();
        Paquet_defausse defausse = new Paquet_defausse();

        // Creer 4 pieux de fondation
        for (int i = 0; i < 4; i++) {
            foundations.add(new Paquet_pieux());
        }

        // Creer 7 colonnes
        for (int i = 0; i < 7; i++) {
            colonnes.add(new Paquet_colonne(distributeur, i + 1));
        }

        // Creer une instance de Paquet_pioche
        Paquet_pioche pioche = new Paquet_pioche(distributeur);

        // Creer une instance de App_CLI
        App_CLI cli = new App_CLI(pioche, defausse, colonnes, foundations);

        // Scanner pour lire l'entree de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        String command;

        cli.etatDuJeu(); // Display current game state

        // Commencer le jeu en lançant une boucle
        while (foundations.get(0).nombreDeCartes() + foundations.get(1).nombreDeCartes()
                + foundations.get(2).nombreDeCartes() + foundations.get(3).nombreDeCartes() < 52) {
            System.out.print("Entrez une commande (t pour tirer, d pour deplacer, q pour quitter): ");
            command = scanner.nextLine();

            // Traiter la commande
            switch (command.toLowerCase()) {
                // Quitter le jeu
                case "q":
                    System.out.println("Merci d'avoir joué!");
                    return; // Quitter le jeu

                // Tirer une carte de la pioche
                case "t":
                    pioche.tirerCarte(defausse);
                    cli.clearScreen();// Cleaner l'ecran du terminal
                    cli.etatDuJeu(); // Afficher l'etat actuel du jeu
                    break;

                // Deplacer une carte
                case "d":
                    Paquet_mere objectSource = null;
                    Paquet_mere objectTarget = null;
                    System.out.println("Saissisez la source et la cible (D pour defausse, C1-C7 pour colonnes, F1-F4 pour fondations) séparées par un espace, ex: C1 F2");
                    String[] parts = scanner.nextLine().split(" ");
                    if (parts.length > 2 || parts.length < 2 || parts[0].equals(parts[1])) {
                        System.out.println("Commande invalide, veuillez saisir une source et une cible valides");
                        break;
                    } else {
                        String source = parts[0];
                        if (source.equals("D")) {
                            objectSource = defausse;
                        } else if (source.charAt(0) == 'C') {
                            if (source.length() > 1) {
                                String nombreDePaquet = source.substring(1);
                                int index = Integer.parseInt(nombreDePaquet) - 1;
                                objectSource = colonnes.get(index);
                            }
                        } else if (source.charAt(0) == 'F') {
                            if (source.length() > 1) {
                                String nombreDePaquet = source.substring(1);
                                int index = Integer.parseInt(nombreDePaquet) - 1;
                                objectSource = foundations.get(index);
                            }
                        }

                        String target = parts[1];
                        if (target.equals("D")) {
                            objectTarget = defausse;
                        } else if (target.charAt(0) == 'C') {
                            if (target.length() > 1) {
                                String nombreDePaquet = target.substring(1);
                                int index = Integer.parseInt(nombreDePaquet) - 1;
                                objectTarget = colonnes.get(index);
                            }
                        } else if (target.charAt(0) == 'F') {
                            if (target.length() > 1) {
                                String nombreDePaquet = target.substring(1);
                                int index = Integer.parseInt(nombreDePaquet) - 1;
                                objectTarget = foundations.get(index);
                            }
                        }

                        // Deplacer la carte
                        try {
                            moveCard(objectSource, objectTarget);
                            cli.clearScreen();// Cleaner l'ecran du terminal
                            cli.etatDuJeu(); // Afficher l'etat actuel du jeu
                        } catch (Exception e) {
                            System.out.println("Deplacement invalide: " + e.getMessage());
                        }
                    }

                    // Commande invalide
                default:
                    break;
            }
        }

        // Fin du jeu
        System.out.println("Félicitations! Vous avez gagné!");
        scanner.close();
    }

    private static void moveCard(Paquet_mere source, Paquet_mere target) {
        if (source instanceof Paquet_colonne && target instanceof Paquet_colonne) {
            // try to move the last faceup card from the coluns source to the target column,
            // if the move is not possible, move the next faceup card until the move is
            // possible, if none of the faceup cards can be moved, return an exception
            

            //Downcast source and target 
            Paquet_colonne sourceColonne = (Paquet_colonne) source;
            Paquet_colonne targetColonne = (Paquet_colonne) target;

            for (int i = 0 ; i < sourceColonne.nombreDeCartes(); i++) {
                Carte carte = sourceColonne.paquet.get(i);
                if (carte.getEnFace()) {
                    try {
                        for (int j = i; j < sourceColonne.nombreDeCartes(); j++) {
                            Carte carteTemp = sourceColonne.paquet.get(j);
                            targetColonne.ajouterCarte(carteTemp, true);
                        }
                        sourceColonne.paquet = sourceColonne.retirerCarteDepuis(carte);
                        sourceColonne.premiereCarte().setEnFace(true);
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                }
            }
        } else {
            target.ajouterCarte(source.retirerPremiereCarte(), true);
            if (source instanceof Paquet_colonne) {
                source.premiereCarte().setEnFace(true);
            }
        }
    }
}