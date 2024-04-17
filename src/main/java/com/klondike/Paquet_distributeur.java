package com.klondike;
//Classe filles de Paquet_debut, il représente un paquet de carte complet (52 cartes)
//Constructeur doit construire un paquet de carte complet en garantissant que chaque carte est unique et valide
//Méthode pour mélanger le paquet
//Méthode retirer et renvoyer la carte au sommet du paquet
import java.util.Random;
import java.util.ArrayList;
public class Paquet_distributeur extends Paquet_mere {
    public Paquet_distributeur() {
        for (int i = 1; i <= 13; i++) {
            ajouterCarte(new Carte(i, "coeur"));
            ajouterCarte(new Carte(i, "carreau"));
            ajouterCarte(new Carte(i, "trefle"));
            ajouterCarte(new Carte(i, "pique"));
        }
        melanger();
    }

    public void melanger() {
        Random random = new Random();
        ArrayList <Carte> temp = new ArrayList<Carte>();
        for (int i = paquet.size(); i > 0; i--) {
            // Generate a random index j such that 0 <= j <= i
            int j = random.nextInt(paquet.size());
            temp.add(paquet.get(j));
            paquet.remove(j);
        }
        paquet = temp;
    }    
}
