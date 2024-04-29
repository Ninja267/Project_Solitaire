package com.klondike;

//Paquet debut est la classe mère de la hiérarchie des paquets de cartes.
import java.util.Random;
import java.util.ArrayList;

public class Paquet_mere {
    protected ArrayList<Carte> paquet = new ArrayList<Carte>();

    // cette méthode sera redéfinie dans les classes filles
    public void ajouterCarte(Carte carte, boolean enFace) {
        carte.setEnFace(enFace);
        paquet.add(carte);
    }

    public Carte retirerPremiereCarte() {
        return paquet.remove(paquet.size() - 1);
    }

    public Carte premiereCarte() {
        return paquet.get(paquet.size() - 1);
    }

    public int nombreDeCartes() {
        return paquet.size();
    }

    // Méthode pour mélanger le paquet, on utilise la méthode de mélange de Fisher-Yates, on génère un index aléatoire j tel que 0 <= j <= i, puis on ajoute la carte à l'index j dans un paquet temporaire et on retire la carte du paquet, à la fin, on remplace le paquet par le paquet temporaire
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

    public String toString() {
        String resultat = "";
        for (Carte carte : paquet) {
            resultat += carte + "\n";
        }
        return resultat;
    }
}
