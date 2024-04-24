package com.klondike;

//Classe filles de Paquet_debut, il représente un paquet de carte complet (52 cartes)
//Constructeur doit construire un paquet de carte complet en garantissant que chaque carte est unique et valide
//Méthode pour mélanger le paquet
//Méthode retirer et renvoyer la carte au sommet du paquet
import java.util.Random;
import java.util.ArrayList;

public class Paquet_distributeur extends Paquet_mere {
    public Paquet_distributeur() {
        super();
        for (int i = 1; i <= 13; i++) {
            ajouterCarte(new Carte(i, "coeur", true), false);
            ajouterCarte(new Carte(i, "carreau", true), false);
            ajouterCarte(new Carte(i, "trefle", true), false);
            ajouterCarte(new Carte(i, "pique", true), false);
        }
        melanger();
    }

    public void melanger() {
        Random random = new Random();
        ArrayList<Carte> temp = new ArrayList<Carte>();
        for (int i = paquet.size(); i > 0; i--) {
            // Generate a random index j such that 0 <= j <= i
            int j = random.nextInt(paquet.size());
            temp.add(paquet.get(j));
            paquet.remove(j);
        }
        paquet = temp;
    }

    /* public void distribuer(int nombreDeCartes) {
        for (int i = 0; i < nombreDeCartes; i++) {
            retirerCarte();
        }
    } */
}
