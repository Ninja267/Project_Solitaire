package com.klondike;
import java.util.ArrayList;

public class Test {
    // Test de la classe Carte
    /* public static void main(String[] args) {
    Carte carte1 = new Carte(1, "coeur", true);
    Carte carte2 = new Carte(1, "coeur", true);
    Carte carte3 = new Carte(2, "coeur", true);
    Carte carte4 = new Carte(1, "carreau", true);
    Carte carte5 = new Carte(1, "coeur", false);
    Carte carte6 = new Carte(1, "coeur", true);
    System.out.println("Carte 1: " + carte1);
    System.out.println("Carte 2: " + carte2);
    System.out.println("Carte 3: " + carte3);
    System.out.println("Carte 4: " + carte4);
    System.out.println("Carte 5: " + carte5);
    System.out.println("Carte 6: " + carte6);
    System.out.println("Carte 1 equals Carte 2: " + carte1.compareGeneral(carte2));
    System.out.println("Carte 1 equals Carte 2: " + carte1.compareMemeCouleur(carte2));
    System.out.println("Carte 1 equals Carte 3: " + carte1.compareGeneral(carte3));
    System.out.println("Carte 1 equals Carte 3: " + carte1.compareMemeCouleur(carte3));
    System.out.println("Carte 1 equals Carte 4: " + carte1.compareMemeCouleur(carte4));
    System.out.println("Carte 1 equals Carte 4: " + carte1.compareGeneral(carte4));
    System.out.println("Carte 1 equals Carte 5: " + carte1.compareMemeCouleur(carte5));
    System.out.println("Carte 1 equals Carte 5: " + carte1.compareGeneral(carte5));
    System.out.println("Carte 1 equals Carte 6: " + carte1.compareMemeCouleur(carte6));
    System.out.println("Carte 1 equals Carte 6: " + carte1.compareGeneral(carte6));
    } */
    

    // Test de la classe Paquet_distributeur
   /*  public static void main(String[] args) {
        Paquet_distributeur paquet_distributeur = new Paquet_distributeur();
            System.out.println(paquet_distributeur);
    } */

    //Test de la classe Paquet_colonne
    /* public static void main(String[] args) {
        Paquet_distributeur paquet_distributeur = new Paquet_distributeur();
        ArrayList<Paquet_colonne> paquet_colonnes = new ArrayList<Paquet_colonne>();
        for (int i = 0; i < 7; i++) {
            paquet_colonnes.add(new Paquet_colonne(paquet_distributeur, i + 1));
            //display all the cards in the column
            System.out.println("Column " + (i + 1) + ": ");
            for (int j = 0; j < i + 1; j++) {
                System.out.println(paquet_colonnes.get(i).retirerPremiereCarte());
            }
        }
    } */
}
