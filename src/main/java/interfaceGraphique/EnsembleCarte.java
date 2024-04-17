package interfaceGraphique;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javafx.scene.input.MouseButton;

abstract class EnsembleCarte extends JPanel {
	protected int ref;
	protected String aff;
	protected ClickReporter reporter;
	protected ImageIcon jaune;
	protected InterfaceCarte ic;
	protected boolean highlighted = false;

	// Set of highlighted cards
	protected Set<Integer> highlightedCards = new HashSet<>();

	// Inside EnsembleCarte class
	// Constructor for the EnsembleCarte class, qui représente un tas de cartes
	// aff is the name of the card, ref is the reference of the card, reporter is
	// the object that will be informed of the clicks and button presses in the
	// window, ic is the interface of the card
	// A pile of cards is identified by a name and a reference number, the object
	// that will be informed of the clicks and button presses in the window is the
	// reporter object, the interface of the card and the jaune image in case the
	// pile is highlighted
	public EnsembleCarte(String aff, int ref, ClickReporter reporter,
			InterfaceCarte ic) {
		this.reporter = reporter;
		this.ref = ref;
		this.aff = aff;
		this.addMouseListener(new LaSouris());
		this.jaune = ic.getJaune();
		this.ic = ic;
	}

	/* // Method to set the highlighted attribute of the pile, if the card is
	// highlighted, it is repainted
	public void setHighlighted(boolean highlighted) {
		if (highlighted != this.highlighted) {
			this.highlighted = highlighted;
			this.repaint();
		}
	}

	public boolean isHighlighted() {
		return highlighted;
	} */

	public void setHighlighted(boolean highlighted, int position) {
		if (highlighted) {
			highlightedCards.add(position);
		} else {
			highlightedCards.remove(position);
		}
		this.repaint();
	}
	
	public boolean isHighlighted(int position) {
		return highlightedCards.contains(position);
	}

	// Class that represents the mouse adapter for the EnsembleCarte class
	class LaSouris extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("click reporté ==" + e + "==");
			if (reporter != null)
				reporter.reportClick(ref, e);
		}
	}

	// Methode pour récupérer le nombre de cartes dans le tas
	public int getNbCartes() {
		throw new UIKlondikeException("not implemented");
	}

	// Method to add a card to the pile
	public void add(ICarte[] strings) {
		throw new UIKlondikeException("not implemented");
	}

	// Method to set a card to the pile
	public void set(ICarte[] strings) {
		throw new UIKlondikeException("not implemented");
	}

	// Method to remove a card from the pile
	public void removeCards(int nb) {
		throw new UIKlondikeException("not implemented");
	}

	public abstract void add(ICarte strings);

	public abstract void set(ICarte strings);
}
