package com.klondike;
//Créer une classe pour les cartes de poker
//Chaque carte a une valeur et une couleur
//Les valeurs sont de 1 à 14 (11=Valet, 12=Dame, 13=Roi, 14=As)
//Les couleurs sont : coeur, carreau, trèfle, pique
//Méthode compareTo pour comparer deux cartes , retourne 1 si la carte courante est plus grande, -1 si elle est plus petite, 0 si elles sont égales, l'ordre des carte selon le jeu de bataille dont as est plus fort que roi

import interfaceGraphique.ICarte;

public class Carte implements ICarte {
    private int valeur;
    private String couleur;

    public Carte(int valeur, String couleur) {
        //vérifier le valeur pour interdire les valeurs non valides (1 à 14)
        if (valeur < 0 || valeur > 14) {
            throw new IllegalArgumentException("La valeur doit être entre 0 et 14");
        } else {
            this.valeur = valeur;
        }

        //vérifier la couleur pour interdire les couleurs non valides (coeur, carreau, trèfle, pique)
        if (couleur.equals("coeur") || couleur.equals("carreau") || couleur.equals("trèfle") || couleur.equals("pique")) {
            this.couleur = couleur;
        } else {
            throw new IllegalArgumentException("La couleur doit être coeur, carreau, trèfle ou pique");
        }
    }
    
    @Override
    public String getNomDeFichierPNG() {
        if (this.valeur == 0) {
            return "dos_carte.png";
        }
        return this.valeur + "_de_" + this.couleur + ".png";
    }

    public int getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String toString() {
        String valeur = "";
        switch (this.valeur) {
            case 11:
                valeur = "Valet";
                break;
            case 12:
                valeur = "Dame";
                break;
            case 13:
                valeur = "Roi";
                break;
            case 14:
                valeur = "As";
                break;
            default:
                valeur = String.valueOf(this.valeur);
                break;
        }
        return valeur + " de " + this.couleur;
    }
    
    //methode precedeMemeCouleut, prend en paramètre un objet Carte et retourne true si la carte .this est bien la suivante de la carte passée en paramètre
    public boolean precedeMemeCouleur(Carte autre) {
        if (this.valeur == autre.valeur - 1 && this.couleur.equals(autre.couleur)) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Carte autre) {
        if (this.valeur > autre.valeur) {
            return 1;
        } else if (this.valeur < autre.valeur) {
            return -1;
        } else {
            return 0;
        }
    }
}

