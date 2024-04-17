package com.klondike;
//class Paquet_colonne est classe fille de Paquet_debut, il représent une colonne de cartes dans le jeu de solitaire
//Méthode pour ajouter une carte au sommet de la colonne en respectant l'ordre des cartes (As, 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi, As) et de couleur alternée

public class Paquet_colonne extends Paquet_mere {
    //Méthode pour initier une colonne avec un nombre de cartes
    //La carte pour ajouter est random et qui est retirée du paquet distributeur
    public Paquet_colonne(Paquet_distributeur distributeur, int nombreDeCartes) {
        for (int i = 0; i < nombreDeCartes; i++) {
            ajouterCarteInit(distributeur.retirerCarte());
        }
    }

    public void ajouterCarteInit(Carte carte) {
        super.ajouterCarte(carte);
    }

    public void ajouterCarteJouer(Carte carte) {
        if (paquet.isEmpty()) {
            if (carte.getValeur() == 13) {
                super.ajouterCarte(carte);
            }
        } else {
            Carte carteSommet = paquet.get(paquet.size() - 1);
            if (carte.getValeur() == 1 && carteSommet.getValeur() == 13) {
                super.ajouterCarte(carte);
            } else if (carte.getValeur() == carteSommet.getValeur() - 1
                    && !carte.getCouleur().equals(carteSommet.getCouleur())) {
                super.ajouterCarte(carte);
            }
        }
    }

    // Méthode pour retirer une carte. Si aucun indice n'est fourni, retire la carte
    // au sommet.
    // L'indice est basé sur la position à partir du sommet (0 étant le sommet).
    public Carte retirerCarte() {
        return retirerCarte(0); // Retire la carte au sommet par défaut
    }

    // Surcharge de la méthode pour permettre le retrait d'une carte à une position
    // spécifique du sommet.
    public Carte retirerCarte(int indiceDuSommet) {
        // Vérifie si l'indice est valide
        if (indiceDuSommet < 0 || indiceDuSommet >= paquet.size()) {
            throw new IllegalArgumentException(
                    "Indice invalide. L'indice doit être entre 0 et " + (paquet.size() - 1) + ".");
        }

        // Calcule l'indice réel dans la liste basée sur l'indice du sommet
        int indiceReel = paquet.size() - 1 - indiceDuSommet;

        // Retire et retourne la carte à l'indice spécifié
        return paquet.remove(indiceReel);
    }
}