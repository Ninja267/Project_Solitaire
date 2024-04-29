package com.klondike;

import java.util.ArrayList;

// Class qui represente l'interface du jeu Klondike en ligne de commande
public class App_CLI {
    // Declaration des attributs
    private Paquet_pioche pioche;
    private Paquet_defausse defausse;
    private ArrayList<Paquet_colonne> colonnes;
    private ArrayList<Paquet_pieux> foundations;

    // Constructeur pour initialiser les attributs
    public App_CLI(Paquet_pioche pioche, Paquet_defausse defausse,
            ArrayList<Paquet_colonne> colonnes, ArrayList<Paquet_pieux> foundations) {
        this.pioche = pioche;
        this.defausse = defausse;
        this.colonnes = colonnes;
        this.foundations = foundations;
    }

    // Méthode pour afficher l'état actuel du jeu
    public void etatDuJeu() {
        // Afficher les paquets
        System.out.print("Pioche(P): ");
        if (pioche.nombreDeCartes() == 0) {
            System.out.print("[Empty]");
            System.out.println();
        } else {
            afficherCarte(pioche.premiereCarte());
            System.out.println();
        }

        // Afficher la defausse
        System.out.print("Defausse(D): ");
        if (defausse.nombreDeCartes() == 0) {
            System.out.print("[Empty]");
            System.out.println();
        } else {
            afficherCarte(defausse.premiereCarte());
            System.out.println();
        }

        // Afficher les fondations
        for (int i = 0; i < foundations.size(); i++) {
            System.out.print("Foundation(F" + (i + 1) + "): ");
            if (foundations.get(i).nombreDeCartes() == 0) {
                System.out.print("[Empty]");
            } else {
                afficherCarte(foundations.get(i).premiereCarte());
            }
            System.out.println();
        }

        // Afficher les colonnes
        for (int i = 0; i < colonnes.size(); i++) {
            System.out.print("Column(C" + (i + 1) + "): ");
            afficherCartes(colonnes.get(i).paquet);
            System.out.println();
        }
    }

    // Methode pour afficher une carte
    private void afficherCarte(Carte carte) {
        if (carte.getEnFace()) {
            System.out.print(" [" + carte + "] ");
        } else {
            System.out.print(" [Hidden] ");
        }
    }

    // Methode pour afficher les cartes
    private void afficherCartes(ArrayList<Carte> cartes) {
        for (Carte carte : cartes) {
            if (carte.getEnFace()) {
                System.out.print(carte + " | ");
            } else {
                System.out.print("[Hidden] ");
            }
        }
    }

    // Methode pour clear le terminal
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}