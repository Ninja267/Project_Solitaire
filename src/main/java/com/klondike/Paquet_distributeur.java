package com.klondike;

//Classe filles de Paquet_debut, il représente un paquet de carte complet (52 cartes)
//Constructeur doit construire un paquet de carte complet en garantissant que chaque carte est unique et valide
//Méthode pour mélanger le paquet
//Méthode retirer et renvoyer la carte au sommet du paquet

public class Paquet_distributeur extends Paquet_mere {

    //Le paquet de distribution est un paquet de 52 cartes, on ajoute 13 cartes de chaque couleur et mélange le paquet
    public Paquet_distributeur() {
        super();
        for (int i = 1; i <= 13; i++) {
            ajouterCarte(new Carte(i, "coeur", true), true);
            ajouterCarte(new Carte(i, "carreau", true), true);
            ajouterCarte(new Carte(i, "trefle", true), true);
            ajouterCarte(new Carte(i, "pique", true), true);
        }
        //melanger();
    }
}
