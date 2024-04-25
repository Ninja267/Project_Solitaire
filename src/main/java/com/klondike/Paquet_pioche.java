package com.klondike;
//Le pioche ne fait que perdre des cartes, il n'y a pas de contrainte sur l'ordre des cartes

//On retire les cartes une par une et à un moment donné, une seule carte, celle qui est au sommet de la partie 

public class Paquet_pioche extends Paquet_mere {

    // Le constructuer prend en paramètre le jeu de 52 cartes avec ce qui reste de
    // cartes après avoir initialisé les sept colonnes
    public Paquet_pioche(Paquet_distributeur distributeur) {
        super();
        for (int i = 0; i < distributeur.nombreDeCartes(); i++) {
            ajouterCarte(distributeur.retirerPremiereCarte(), false);
        }
    }

}