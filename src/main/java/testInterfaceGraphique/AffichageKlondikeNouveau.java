package testInterfaceGraphique;
import com.klondike.Carte;
import java.util.Scanner;

import javax.swing.JButton;

import interfaceGraphique.InterfaceKlondike;
public class AffichageKlondikeNouveau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceKlondike interfaceKlondike;
		Carte carte1, carte2, carte3, carte4, carte5, dos;
		Scanner scan = new Scanner(System.in);
		//int[] tab1 = {12};
		carte1 = new Carte(14, "coeur");
		carte2 = new Carte(1, "trefle");
		carte3 = new Carte(3, "pique");
		carte4 = new Carte(4, "pique");
		carte5 = new Carte(5, "pique");
		dos = new Carte(0, "pique");
		interfaceKlondike = new InterfaceKlondike();
		interfaceKlondike.addCard(dos, 0);
		interfaceKlondike.addCard(carte1, 1);
		interfaceKlondike.addCard(carte2, 4);
		//trois carte de dos dans l'emplacement 9
		interfaceKlondike.addCards(new Carte[] {dos, dos, dos}, 9);
		//les 3, 4 et 5 de pique visibles dans l’emplacement numéro 10
		interfaceKlondike.addCards(new Carte[] {carte3, carte4, carte5}, 10);
		//surlignez les emplacements 1 et 10.
		interfaceKlondike.setHighlighted(1, true);
		interfaceKlondike.setHighlighted(10, true);


		/* ik.addCard(as3,1);
		ik.setMessage("Pour afficher la suite, tapez " +
				"<return> dans la console d'eclipse");
		scan.nextLine();
		ik.addCard(as1,3);
		ik.addCards(new Carte[] {as3,as3,as2},4);
		scan.nextLine();
		ik.setHighlighted(8, true);
		ik.addCard(new Carte(14, "coeur"),4);
		scan.nextLine();
		ik.clearMessage();
		ik.setCards(new Carte[] {as3,as3,as2},8);
		ik.removeFromPlace(3, 11);
		scan.nextLine();
		System.out.println("Bye");
		ik.close(); */
	}
}

//They never can know how I was suffering, but what I do will change the world.

