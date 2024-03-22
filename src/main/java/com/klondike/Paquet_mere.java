package com.klondike;
//Paquet debut est la classe mère de la hiérarchie des paquets de cartes.
//Comporter un attribut ArrayList de Carte
//Méthode pour ajouter une carte au sommet du paquet
//Méthode pour retirer une carte du sommet du paquet
//Méthode pour renvoyer la carte du sommet du paquet sans la retirer
//Méthode pour renvoyer le nombre de cartes présentes dans le paquet
//Méthode toString
//ArrayList doit être protégé, encapsulé dans la classe Paquet_debut et jamais divulgué à l'extérieur de la classe

import java.util.ArrayList;
public class Paquet_mere {
    protected ArrayList<Carte> paquet = new ArrayList<Carte>();

    //cette méthode sera redéfinie dans les classes filles
    public void ajouterCarte(Carte carte) {
        paquet.add(carte);
    }

    public Carte retirerCarte() {
        return paquet.remove(paquet.size() - 1);
    }

    public Carte premiereCarte() {
        return paquet.get(paquet.size() - 1);
    }

    public int nombreDeCartes() {
        return paquet.size();
    }

    public String toString() {
        String resultat = "";
        for (Carte carte : paquet) {
            resultat += carte + "\n";
        }
        return resultat;
    }
}
