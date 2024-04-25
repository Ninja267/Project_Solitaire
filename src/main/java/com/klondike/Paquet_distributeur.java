package com.klondike;

//Classe filles de Paquet_debut, il représente un paquet de carte complet (52 cartes)
//Constructeur doit construire un paquet de carte complet en garantissant que chaque carte est unique et valide
//Méthode pour mélanger le paquet
//Méthode retirer et renvoyer la carte au sommet du paquet
import java.util.Random;
import java.util.ArrayList;

public class Paquet_distributeur extends Paquet_mere {

    //Le paquet de distribution est un paquet de 52 cartes, on ajoute 13 cartes de chaque couleur et mélange le paquet
    public Paquet_distributeur() {
        super();
        for (int i = 1; i <= 13; i++) {
            ajouterCarte(new Carte(i, "coeur", true), false);
            ajouterCarte(new Carte(i, "carreau", true), false);
            ajouterCarte(new Carte(i, "trefle", true), false);
            ajouterCarte(new Carte(i, "pique", true), false);
        }
        melanger();
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

    // Méthode pour retirer et renvoyer la carte au sommet du paquet de distribution au paquet defausse, quand il n'y a plus de carte dans le paquet de distribution, on ajouter toutes les cartes de la defausse au paquet de distribution et on mélange le paquet et recommence
    public void distribuerDefausse(Paquet_defausse defausse) {
        if (paquet.isEmpty()) {
            for (int i = 0; i < defausse.nombreDeCartes(); i++) {
                ajouterCarte(defausse.retirerPremiereCarte(), false);
            }
            melanger();
        }
        defausse.ajouterCarte(retirerPremiereCarte(), true);
    }
}
