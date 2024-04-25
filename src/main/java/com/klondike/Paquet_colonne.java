package com.klondike;
import java.util.ArrayList;

public class Paquet_colonne extends Paquet_mere {

    //Les paquets colonnes initalement dépend au nombre de cartes qu'on veut ajouter, la carte au sommet de la colonne doit être en face, les autres cartes doivent être en dos 
    public Paquet_colonne(Paquet_distributeur distributeur, int nombreDeCartes) {
        super();
        if (nombreDeCartes < 1 || nombreDeCartes > 13) {
            throw new IllegalArgumentException("Le nombre de cartes doit être entre 1 et 13.");
        } else {
            if (nombreDeCartes == 1) {
                super.ajouterCarte(distributeur.retirerPremiereCarte(), true);
            } else {
                for (int i = 0; i < nombreDeCartes - 1; i++) {
                    super.ajouterCarte(distributeur.retirerPremiereCarte(), false);
                }
                super.ajouterCarte(distributeur.retirerPremiereCarte(), true);
            }
        }
    }

    // Méthode pour ajouter une carte à la colonne, il vérifie si la carte est plus grande 1 valeur que la carte au sommet de la colonne, si oui, il ajoute la carte en face sur le sommet de la colonne
    @Override
    public void ajouterCarte(Carte carte, boolean enFace) {
        if (paquet.isEmpty()) {
            if (carte.getValeur() == 13) {
                super.ajouterCarte(carte, true);
            }
        } else {
            Carte carteSommet = paquet.get(paquet.size() - 1);
            if (carte.precedeGeneral(carteSommet)) {
                super.ajouterCarte(carte, true);
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
                        temp.add(super.retirerPremiereCarte());
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