package com.klondike;
//Classe repérent les peiux de fondation du jeu solitaire, elle hérite de Paquet_debut
//Chaque pieux est un object instance de Paquet_pieux
//Un pieux est initialiement vide
//Méthode ajout de carte est héritée de Paquet_debut
//Redéfinir ajout de carte pour ajouter des carte dans l'ordre croissant (As, 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi, As) et de même couleur

public class Paquet_pieux extends Paquet_mere {
    public Paquet_pieux() {
        super();
    }
    //Méthode ajout de carte avec l'utilisation du méthode precedeMemeCouleur
    //Commence d'ajouter par l'As, et continue par ordre croissant
    public void ajouterCarte(Carte carte) {
        if (paquet.isEmpty()) {
            if (carte.getValeur() == 14) {
                paquet.add(carte);
            }
        } else {
            Carte derniereCarte = paquet.get(paquet.size() - 1);
            if (carte.precedeMemeCouleur(derniereCarte)) {
                paquet.add(carte);
            } else {
                throw new IllegalArgumentException("La carte ne peut pas être ajoutée au pieu");
            }
        }
    }

    //Méthode pour retourner la carte au sommet du pieu sans la retirer
    public Carte getSommet() {
        return paquet.get(paquet.size() - 1);
    }

    //Méthode pour retirer la carte au sommet du pieu
    public Carte retirerCarte() {
        return paquet.remove(paquet.size() - 1);
    }

    //Méthode pour recycler les cartes piochées et non retirées se trouvant dans la défausse
    public void recycler(Paquet_defausse defausse) {
        while (!defausse.paquet.isEmpty()) {
            ajouterCarte(defausse.retirerCarte());
        }
    }
}