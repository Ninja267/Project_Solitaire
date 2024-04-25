package com.klondike;
public class Paquet_defausse extends Paquet_mere {

    //Le paquet de défausse est initialiement vide
    public Paquet_defausse() {
        super();
    }

    //Pas besoin de redéfinir la méthode ajouterCarte, car on peut ajouter une carte dans le paquet de défausse sans contrainte
    //Pas besoin de redéfinir la méthode retirerCarte, car on juste retire la carte du sommet du paquet de défausse un par un
}
