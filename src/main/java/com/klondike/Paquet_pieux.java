package com.klondike;
//Classe repérent les peiux de fondation du jeu solitaire, elle hérite de Paquet_debut
//Chaque pieux est un object instance de Paquet_pieux
//Un pieux est initialiement vide
//Méthode ajout de carte est héritée de Paquet_debut
//Redéfinir ajout de carte pour ajouter des carte dans l'ordre croissant (As, 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi, As) et de même couleur

public class Paquet_pieux extends Paquet_mere {

    //Les pieux de fondation sont initialiement vide
    public Paquet_pieux() {
        super();
    }

    //Méthode ajout de carte avec l'utilisation du méthode precedeMemeCouleur, commence d'ajouter par l'As, et continue par ordre croissant
    @Override
    public void ajouterCarte(Carte carte, boolean enFace) {
        if (paquet.isEmpty()) {
            if (carte.getValeur() == 1) {
                super.ajouterCarte(carte, true);
            }
        } else {
            Carte derniereCarte = paquet.get(paquet.size() - 1);
            if (derniereCarte.precedeMemeCouleur(carte)) {
                super.ajouterCarte(carte, true);
            } else {
                throw new IllegalArgumentException("La carte ne peut pas être ajoutée au pieu");
            }
        }
    }
}