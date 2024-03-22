package com.klondike;
//Classe filles de Paquet_debut, il représente un paquet de carte complet (52 cartes)
//Constructeur doit construire un paquet de carte complet en garantissant que chaque carte est unique et valide
//Méthode pour mélanger le paquet
//Méthode retirer et renvoyer la carte au sommet du paquet

import java.util.Random;
public class Paquet_distributeur extends Paquet_mere {
    public Paquet_distributeur() {
        for (int i = 2; i <= 14; i++) {
            ajouterCarte(new Carte(i, "coeur"));
            ajouterCarte(new Carte(i, "carreau"));
            ajouterCarte(new Carte(i, "trèfle"));
            ajouterCarte(new Carte(i, "pique"));
        }
    }

    public void melanger() {
        Random random = new Random();
        for (int i = 0; i < paquet.size(); i++) {
            int j = random.nextInt(paquet.size());
            Carte temp = paquet.get(i);
            paquet.set(i, paquet.get(j));
            paquet.set(j, temp);
        }
    }

    public Carte retirerCarte() {
        return paquet.remove(paquet.size() - 1);
    }
}
