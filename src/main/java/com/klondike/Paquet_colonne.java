package com.klondike;
import java.util.ArrayList;
import java.util.List;
//class Paquet_colonne est classe fille de Paquet_debut, il représent une colonne de cartes dans le jeu de solitaire

//Méthode pour ajouter une carte au sommet de la colonne en respectant l'ordre des cartes (As, 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi, As) et de couleur alternée

public class Paquet_colonne extends Paquet_mere {
    // Méthode pour initier une colonne avec un nombre de cartes
    // La carte pour ajouter est random et qui est retirée du paquet distributeur

    public Paquet_colonne(Paquet_distributeur distributeur, int nombreDeCartes) {
        super();
        if (nombreDeCartes < 1 || nombreDeCartes > 13) {
            throw new IllegalArgumentException("Le nombre de cartes doit être entre 1 et 13.");
        } else {
            if (nombreDeCartes == 1) {
                ajouterCarte(distributeur.retirerPremiereCarte(), true);
            } else {
                for (int i = 0; i < nombreDeCartes - 1; i++) {
                    ajouterCarte(distributeur.retirerPremiereCarte(), false);
                }
                ajouterCarte(distributeur.retirerPremiereCarte(), true);
            }
        }
    }

    // Méthode pour ajouter une carte à la colonne, il vérifie si la carte est plus grande 1 valeur que la carte au sommet de la colonne, si oui, il ajoute la carte en face sur le sommet de la colonne
    @Override
    public void ajouterCarte(Carte carte, boolean enFace) {
        if (paquet.isEmpty()) {
            if (carte.getValeur() == 13) {
                ajouterCarte(carte, true);
            }
        } else {
            Carte carteSommet = paquet.get(paquet.size() - 1);
            if (carte.precedeGeneral(carteSommet)) {
                ajouterCarte(carte, true);
            } else {
                throw new IllegalArgumentException("La carte ne peut pas être ajoutée à la colonne.");
            }
        }
    }

    // Méthode pour retirer une carte. Si la carte n'est pas en face, c'est une exception, sinon, examiner la position de la carte dans la colonne, si la carte n'est pas la carte au sommet, retirer toutes les cartes au-dessus de la carte, sinon, retirer la carte au sommet
    public ArrayList<Carte> retirerCarteDepuis(Carte carte) {
        boolean trouve = false;
        ArrayList<Carte> temp = new ArrayList<Carte>();

        if (paquet.isEmpty()) {
            throw new IllegalArgumentException("La colonne est vide.");
        } else {
            for (int i = 0; i < paquet.size(); i++) {
                if (paquet.get(i).compareMemeCouleur(carte) == 0 && paquet.get(i).getEnFace()) {
                    for (int j = i + 1; j < paquet.size(); j++) {
                        temp.add(paquet.remove(j));
                    }
                    trouve = true;
                    break;
                }
            }

            if (!trouve) {
                throw new IllegalArgumentException("La carte n'est pas en face et ne peut pas être retirée.");
            }
        }
        return temp;
    }
}