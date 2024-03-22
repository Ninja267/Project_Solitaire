package com.klondike;
public class Paquet_defausse extends Paquet_mere {


    private Paquet_distributeur distributeur;

    //Le paquet de défausse est initialiement vide
    public Paquet_defausse() {
        super();
        distributeur = new Paquet_distributeur();
    }
    
    //Méthode pour retourner la carte au sommet du paquet sans la retirer
    public Carte getSommet() {
        return paquet.get(paquet.size() - 1);
    }

    //Méthode pour retirer la carte au sommet du paquet
    public Carte retirerCarte() {
        return paquet.remove(paquet.size() - 1);
    }

    //Méthode pour rendre tout les cartes du paquet de défausse au paquet de pioche en mélangeant
    public void recycler(Paquet_pioche pioche) {
        while (!paquet.isEmpty()) {
            pioche.ajouterCarte(paquet.remove(paquet.size() - 1));
        }
        //Mélanger le paquet de pioche en utilisant la méthode melanger de la classe Paquet_distributeur
        distributeur.melanger();
    }
}
