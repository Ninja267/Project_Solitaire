package testInterfaceGraphique;

import java.util.Scanner;

import javax.swing.JButton;

import interfaceGraphique.InterfaceKlondike;
import com.klondike.Carte;

public class AffichageKlondike {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceKlondike ik;

		Carte as1, as2, as3;
		Scanner scan = new Scanner(System.in);
		int[] tab1 = {12};
		as1 = new Carte(1, "coeur");
		as2 = new Carte(1, "carreau");
		as3 = new Carte(0, "pique");
		ik = new InterfaceKlondike();
		ik.addCard(as3,1);
		ik.setMessage("Pour afficher la suite, tapez " +
				"<return> dans la console d'eclipse");
		scan.nextLine();
		ik.addCard(as1,8);
		ik.addCards(new Carte[] {as3,as3,as2},11);
		scan.nextLine();
		ik.setHighlighted(8, true);
		ik.addCard(new Carte(14, "coeur"),11);
		scan.nextLine();
		ik.clearMessage();
		ik.setCards(new Carte[] {as3,as3,as2},8);
		ik.removeFromPlace(3, 11);
		scan.nextLine();
		System.out.println("Bye");
		ik.close();
	}

}
