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
    private boolean enFace;

    public Carte(int valeur, String couleur, boolean enFace) {
        // vérifier le valeur pour interdire les valeurs non valides (1 à 14)
        if (valeur < 1 || valeur > 14) {
            throw new IllegalArgumentException("La valeur doit être entre 1 et 14");
        } else {
            this.valeur = valeur;
        }

        // vérifier la couleur pour interdire les couleurs non valides (coeur, carreau,
        // trefle, pique)
        if (couleur.equals("coeur") || couleur.equals("carreau") || couleur.equals("trefle")
                || couleur.equals("pique")) {
            this.couleur = couleur;
        } else {
            throw new IllegalArgumentException("La couleur doit être coeur, carreau, trefle ou pique");
        }

        this.enFace = enFace;
    }

    @Override
    public String getNomDeFichierPNG() {
        if (!this.enFace) {
            return "dos.png";
        } else if (this.valeur == 1) {
            return "as_de_" + this.couleur + ".png";
        } else if (this.valeur == 14) {
            return "roi_de_" + this.couleur + ".png";
        } else if (this.valeur == 13) {
            return "dame_de_" + this.couleur + ".png";
        } else if (this.valeur == 12) {
            return "valet_de_" + this.couleur + ".png";
        } else {
            return this.valeur + "_de_" + this.couleur + ".png";
        }
    }

    public int getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public String toString() {
        String valeur = "";
        if (!this.enFace) {
            valeur = "Dos";
        } else {
            switch (this.valeur) {
                case 11:
                    valeur = "Valet de " + this.couleur;
                    break;
                case 12:
                    valeur = "Dame de " + this.couleur;
                    break;
                case 13:
                    valeur = "Roi de " + this.couleur;
                    break;
                case 1:
                    valeur = "As de " + this.couleur;
                    break;
                default:
                    valeur = String.valueOf(this.valeur) + " de " + this.couleur;
                    break;
            }
        }
        return valeur;
    }

    // methode precedeMemeCouleut, prend en paramètre un objet Carte et retourne true si la carte .this est bien la suivante de la carte passée en paramètre
    public boolean precedeMemeCouleur(Carte autre) {
        if (this.valeur == autre.valeur - 1 && this.couleur.equals(autre.couleur)) {
            return true;
        } else {
            return false;
        }
    }

    // methode precedeGeneral, prend en paramètre un objet Carte et retourne true si la carte .this est bien la suivante de la carte passée en paramètre
    public boolean precedeGeneral(Carte autre) {
        if (this.valeur == autre.valeur - 1) {
            return true;
        } else {
            return false;
        }
    }

    // methode compareMemeCouleur, prend en paramètre un objet Carte et retourne 1 si la carte .this est plus grande, -1 si elle est plus petite, 0 si elles sont égales, la comparaison se fait entre les cartes de même couleur
    public int compareMemeCouleur(Carte autre) {
        if (this.valeur > autre.valeur && this.couleur.equals(autre.couleur)) {
            return 1;
        } else if (this.valeur < autre.valeur && this.couleur.equals(autre.couleur)) {
            return -1;
        } else {
            return 0;
        }
    }

    // methode compareGeneral, prend en paramètre un objet Carte et retourne 1 si la carte .this est plus grande, -1 si elle est plus petite, 0 si elles sont égales, la comparaison se fait entre toutes les cartes
    public int compareGeneral(Carte autre) {
        if (this.valeur > autre.valeur) {
            return 1;
        } else if (this.valeur < autre.valeur) {
            return -1;
        } else {
            return 0;
        }
    }

    // methode setEnFace, prend en paramètre un boolean et change la valeur de l'attribut enFace, si true la carte est en face sinon elle est cachée
    public void setEnFace(boolean enFace) {
        this.enFace = enFace;
    }

    // methode getEnFace, retourne la valeur de l'attribut enFace
    public boolean getEnFace() {
        return this.enFace;
    }
}
