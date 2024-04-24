package com.klondike;

import java.util.Scanner;
import javax.swing.JButton;
import java.util.Random;
import interfaceGraphique.InterfaceKlondike;
import javafx.scene.input.MouseEvent;
import interfaceGraphique.ClickReporter;

public class App implements ClickReporter {

    private InterfaceKlondike interfaceKlondike;

    public static void main(String[] args) {
        new App();
    }

    public App() {
        Paquet_distributeur paquet_distributeur = new Paquet_distributeur();
        Paquet_colonne paquet_colonne[] = new Paquet_colonne[7];
        interfaceKlondike = new InterfaceKlondike(this);

        // ajouter le dos de carte dans la position de paquet pioche
        Carte dos = new Carte(0, "pique", false);
        interfaceKlondike.addCard(dos, 0);

        // ajouter les cartes dans les colonnes consécutifs de l'interfaces graphique,
        // en ajoutant simultanément les cartes dans les paquet colonnes correspondent
        for (int i = 6; i <= 12; i++) {
            for (int j = 0; j < i - 6; j++) {
                interfaceKlondike.addCard(dos, i);
            }
            paquet_colonne[i - 6] = new Paquet_colonne(paquet_distributeur, i - 5);
            interfaceKlondike.addCard(paquet_colonne[i - 6].premiereCarte(), i);
        }
        System.out.println("done");
    }

    @Override
    public void reportClick(int ident, java.awt.event.MouseEvent e) {
        // System.out.println("click reported: " + ident);
        // System.out.println("Mouse event Y: " + e.getY());
        int numberOfCardsInColumn = interfaceKlondike.getNbCartes(ident);
        int cardClickPosition = handleCardClick(e.getY(), numberOfCardsInColumn);

        // Verifier s'il y a une carte qui est surlignée
        for (int i = 2; i <= 12; i++) {
            for (int j = 1; j <= interfaceKlondike.getNbCartes(i); j++) {
                if (interfaceKlondike.isHighlighted(i, j)) {
                    System.out.println("Card highlighted: " + j + " in column " + i);
                    interfaceKlondike.setHighlighted(i, j, false);
                    interfaceKlondike.setHighlighted(ident, cardClickPosition, true);
                }
                // else {
                // interfaceKlondike.setHighlighted(ident, cardClickPosition, true);
                // }
            }
        }
        // Verifier si il y a une colonne qui est surlignée
        /*
         * for (int i = 2; i <= 12; i++) {
         * // Si oui, déplacer la carte du colonne surlignée vers la colonne cliquée
         * if (interfaceKlondike.isHighlighted(i) && i != ident) {
         * try {
         * //move(i, ident);
         * System.out.println("Card moved from " + i + " to " + ident);
         * interfaceKlondike.setHighlighted(i, false);
         * interfaceKlondike.setHighlighted(ident, false);
         * System.out.println("done");
         * } catch (Exception exception) {
         * System.out.println("Invalid move");
         * interfaceKlondike.setHighlighted(ident, true);
         * }
         * } else {
         * interfaceKlondike.setHighlighted(ident, true);
         * }
         * }
         */
    }

    // Methode pour identifier la position du clic
    private int handleCardClick(int yCoordinate, int numberOfCardsInColumn) {
        int cardHeightBehind = 25;
        int cardHeightFace = 120;
        int clickPosition = -1;
        yCoordinate = yCoordinate - 30;
        // System.out.println("Y coordinate: " + yCoordinate);
        // System.out.println("Offset Y coordinate: " + offSetYCoordinate);
        // System.out.println("number of cards in column: " + numberOfCardsInColumn);

        if (numberOfCardsInColumn <= 1) {
            if (yCoordinate > 0 && yCoordinate <= cardHeightFace) {
                System.out.println("Clicked on the card number 1");
                clickPosition = 1;
            } else {
                System.out.println("Clicked on the empty space");
            }
        } else {
            if (yCoordinate > 0 && yCoordinate <= (numberOfCardsInColumn - 1) * cardHeightBehind) {
                System.out.println("Clicked on the hidden card");
                // condition to find the position of the clicked card
                for (int j = 1; j <= (numberOfCardsInColumn - 1); j++) {
                    if (yCoordinate < j * cardHeightBehind) {
                        System.out.println("Clicked on the card number " + j);
                        clickPosition = j;
                        break;
                    }
                }
            } else if (yCoordinate > (numberOfCardsInColumn - 1) * cardHeightBehind
                    && yCoordinate <= (numberOfCardsInColumn - 1) * cardHeightBehind + cardHeightFace) {
                System.out.println("Clicked on the card number " + numberOfCardsInColumn);
                clickPosition = numberOfCardsInColumn;
            } else {
                System.out.println("Clicked on the empty space");
            }
        }
        return clickPosition;
    }

    @Override
    public void buttonPressed(String identifier) {
        System.out.println("button pressed: " + identifier);
        interfaceKlondike.setMessage("button pressed: " + identifier);
    }

    public void move(int from, int to) {
        if (isValidMove(from, to)) {
            moveCard(from, to);
        } else {
            throw new IllegalArgumentException("Invalid move");
        }
    }

    private boolean isValidMove(int from, int to) {
        // Implement the logic to check if a move is valid according to Klondike rules
        // This might involve checking the cards involved and their positions
        return true; // Placeholder: You should replace this with actual logic
    }

    private void moveCard(int from, int to) {
        // Implement the logic to move a card from one pile to another
        // This might involve updating your model and then updating the view accordingly
    }
}