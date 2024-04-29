package com.klondike;
//Le pioche ne fait que perdre des cartes, il n'y a pas de contrainte sur l'ordre des cartes

//On retire les cartes une par une et à un moment donné, une seule carte, celle qui est au sommet de la partie 

public class Paquet_pioche extends Paquet_mere {

    // Le constructuer prend en paramètre le jeu de 52 cartes avec ce qui reste de
    // cartes après avoir initialisé les sept colonnes
    public Paquet_pioche(Paquet_distributeur distributeur) {
        while (distributeur.nombreDeCartes() > 0) {
            ajouterCarte(distributeur.retirerPremiereCarte(), false);
        }
    }

      // Méthode pour retirer et renvoyer la carte au sommet du paquet de distribution au paquet defausse, quand il n'y a plus de carte dans le paquet de distribution, on ajouter toutes les cartes de la defausse au paquet de distribution et on mélange le paquet et recommence
      public void tirerCarte (Paquet_defausse defausse) {
        if (paquet.isEmpty()) {
            while (defausse.nombreDeCartes() > 0) {
                ajouterCarte(defausse.retirerPremiereCarte(), false);
            }
            //melanger();
        }
        defausse.ajouterCarte(retirerPremiereCarte(), true);
    }

}