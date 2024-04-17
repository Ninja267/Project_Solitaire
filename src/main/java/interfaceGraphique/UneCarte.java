package interfaceGraphique;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

class UneCarte extends EnsembleCarte{
	private ImageIcon image;

	//Constructor for the UneCarte class, qui représente une carte
	public UneCarte(String aff,int ref, ClickReporter reporter,
			InterfaceCarte ic) {
		super(aff,ref,reporter,ic);
		//System.out.println("ic "+ic);
		this.setPreferredSize(new Dimension(86,150));
		Font font = this.getFont();
		this.setFont(new Font(font.getFontName(),Font.BOLD, //font.getStyle(),
					font.getSize()*2));
	}

	//Method add here's to get the image of the card and repaint the component with the card
	public void add(ICarte st) {
		System.out.println("st "+st+" "+ic);
		if (st == null)
			image = null;
		else
			image = ic.getIconFromCard(st);
		//repaint is a method of the JComponent class, it used to repaint the component
		this.repaint();		
	}
	
	//Method to set a card to the pile, it's the same as add
	public void set(ICarte st) {
		this.add(st);
	}

	//Method to highlight the card, it sets the highlighted attribute to true
	public void setHighlighted(boolean highlighted, int position) {
		this.highlighted = highlighted;
		this.repaint();
	}

	public boolean isHighlighted(int position) {
		return this.highlighted;
	}

	//Method to get the number of cards in the pile
	public int getNbCartes() {
		return image == null ? 0 : 1;
	}

	//Method to paint the component, it paints the card and the name of the card
	public void paintComponent(Graphics g) {
		//g.setFont(ic.font);
		g.drawString(""+this.aff, 35, 20);	
		if (image == null) {
			g.setColor(Color.GREEN);
			g.fillRect(0, 30, 86, 120);
		}else {
			image.paintIcon(this,g,0,30);
			if (this.highlighted)
				jaune.paintIcon(this,g,0,30);
		}
	}

	//Class that represents the mouse adapter for the UneCarte class, it reports the click on the card
	class LaSouris extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if (reporter != null )
				reporter.reportClick(ref, e);
		}	
	}
}
