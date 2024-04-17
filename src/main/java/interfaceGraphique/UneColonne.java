package interfaceGraphique;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

class UneColonne extends EnsembleCarte {
	private ArrayList<ImageIcon> tab;

	// Constructor for the UneColonne class, qui représente une colonne
	public UneColonne(String aff, int ref, ClickReporter reporter,
			InterfaceCarte ic) {
		super(aff, ref, reporter, ic);
		tab = new ArrayList<ImageIcon>();
		this.setPreferredSize(new Dimension(86, 120 + (25 * 20)));
		Font font = this.getFont();
		this.setFont(new Font(font.getFontName(), Font.BOLD, // font.getStyle(),
				font.getSize() * 2));
	}

	// Overriden method add of EmsembleCarte, which gets the icon of the card and
	// adds it to the tab
	// The getIconFromCard method is defined in the InterfaceCarte class
	@Override
	public void add(ICarte st) {
		System.out.println(st.getNomDeFichierPNG());
		tab.add(0, ic.getIconFromCard(st));
		this.repaint();
	}

	@Override
	public int getNbCartes() {
		return tab.size();
	}

	/* @Override
	public void setHighlighted(boolean highlighted, int position) {
		for (int i = 0; i < tab.size(); i++) {
			if (i == position - 1) {
				this.highlighted = highlighted;
				this.repaint();
			}
		}
	}

	@Override
	public boolean isHighlighted(int position) {
		for (int i = 0; i < tab.size(); i++) {
			if (i == position - 1) {
				return this.highlighted;
			}
		}
		return false;
	} */

	// Overriden method set of EmsembleCarte, which clears the tab and adds the icon
	// of the card to the tab
	// So we have add to add a card to the tab and set to clear the tab and add a
	// card to the tab
	@Override
	public void set(ICarte st) {
		tab.clear();
		tab.add(ic.getIconFromCard(st));
		this.repaint();
	}

	// Overriden the method add of EmsembleCarte, but it's to add an array of cards
	@Override
	public void add(ICarte[] strings) {
		for (int i = 0; i < strings.length; i++)
			tab.add(i, ic.getIconFromCard(strings[i]));
		this.repaint();
	}

	// Overriden the method set of EmsembleCarte, but it's to set an array of cards
	@Override
	public void set(ICarte[] strings) {
		tab.clear();
		for (ICarte st : strings)
			tab.add(ic.getIconFromCard(st));
		this.repaint();
	}

	// Overriden the method removeCards of EmsembleCarte, which removes the first nb
	// cards of the tab
	@Override
	public void removeCards(int nb) {
		for (int i = 0; i < nb; i++) {
			tab.remove(0);
		}
		this.repaint();
	}

	// Overriden the method paintComponent of JPanel, which paints the tab of cards
	@Override
	public void paintComponent(Graphics g) {
		// super.paintComponent(g);
		// g.setFont(ic.font);
		int y;
		if (tab.isEmpty())
			y = 30;
		else
			y = 30 + tab.size() * 25 + 95;
		g.drawString("" + this.aff, 35, 20);
		for (int i = tab.size() - 1, j = 0; i >= 0; i--, j++) {
			// System.out.println("icon "+tab.get(i));
			tab.get(i).paintIcon(this, g, 0, 30 + j * 25);
			if (highlightedCards.contains(i))
				
				jaune.paintIcon(this, g, 0, 30 + j * 25);
		}
		g.setColor(Color.GREEN);
		g.fillRect(0, y, 86, 120 + (25 * 20) - y);
	}

	// Example modification in UneColonne's paintComponent method
	/* @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Consider calling the parent class's paintComponent if needed
		for (int i = 0; i < tab.size(); i++) {
			int y = 30 + i * 25; // Calculate Y position based on card index
			if (highlightedCards.contains(i)) {
				g.setColor(Color.YELLOW); // Highlight color
				g.drawRect(0, y, 86, 120); // Draw rectangle around the card
			}
			// Drawing the card itself
			tab.get(i).paintIcon(this, g, 0, y);
		}
	} */
}
