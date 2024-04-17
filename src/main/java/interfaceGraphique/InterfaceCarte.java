package interfaceGraphique;

import javax.swing.*;
import java.net.URL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InterfaceCarte extends JFrame {
	private HashMap<String,ImageIcon> cartes = new HashMap<String,ImageIcon>();
	private JPanel boardPanel = new JPanel(new SpringLayout());
	private JPanel content = new JPanel(new GridBagLayout());
	private JPanel boutons = new JPanel();
	private JTextArea message = new JTextArea(2,34);
	private int nbCols = 7, nbLigs = 2;
	private ButtonListener butlist;
	protected Font font;
	private ClickReporter reporter;

	//initialisation de l'interface graphique pour une carte
	public InterfaceCarte(ClickReporter report) {
		//the reporter used to report the click, when clicking on a card, the click is reported as an object
		this.reporter = report;
		//the listener for the buttons
		butlist = new ButtonListener();

		//initialisation des cartes
		String[] vals = {"as", "2", "3","4", "5", "6","7","8","9",
				"10", "valet", "dame", "roi"};

		//initialisation des couleurs
		String[] couls = {"pique", "coeur", "carreau", "trefle"};

		//Font is used to set the font of the text in the interface
		Font font;

		//Loop through the values and colors to get the images of the cards and add them to the cartes hashmap
		//So all 52 cards icon are added to the hashmap with the name of the card as the key and the image as the value
		for(String val: vals)
			for (String coul: couls) {
				String st = val + "_de_" + coul;
				URL urlCarte = getClass().getResource("/com/klondike/cards/" + st + ".png");
				cartes.put(st+".png", new ImageIcon(urlCarte)); //"cards/" + st + ".png"));
			}

		//Add the back of the card and the jaune is the highlighted filter for the cards
		URL urlDos = getClass().getResource("/com/klondike/cards/dos.png");
		URL urlJaune = getClass().getResource("/com/klondike/cards/jaune.png");
		cartes.put("dos.png",new ImageIcon(urlDos)); //"cards/dos.png"));
		cartes.put("jaune.png",new ImageIcon(urlJaune)); //"cards/jaune.png"));

		//Set the background color of the boardPanel and the buttons
		boardPanel.setBackground(Color.green);
		boutons.setBackground(Color.green);

		//Set the font of the message
		font = boardPanel.getFont();
		//System.out.println(font.getFamily() + " " + font.getFontName() + " "
		//		+ font.getSize());
		boardPanel.setFont(new Font(font.getFontName(),Font.BOLD, //font.getStyle(),
					font.getSize()*2));
		boutons.setFont(new Font(font.getFontName(),Font.BOLD, //font.getStyle(),
				font.getSize()*2));
		message.setFont(new Font(font.getFontName(),Font.PLAIN, 
				font.getSize()*2));
		//this.ajouterBouton("toto");

		//Set the size of the buttons
		boutons.setPreferredSize(new Dimension(boardPanel.getWidth(),50));
		//GridBagConstraints is used to set the constraints of the components in the grid
		GridBagConstraints cons = new GridBagConstraints();

		//Set the constraints of the buttons, the button is placed at the first row and first column
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 0;
		content.add(boutons,cons);

		//Set the constraints of the message, the message is placed at the second row and first column
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 1;
		content.add(message,cons);

		//Set the constraints of the boardPanel, the boardPanel is placed at the third row and first column
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.gridx = 0;
		cons.gridy = 2;
		content.add(boardPanel,cons);
		
		//setContentPane is used to set the content of the frame, this method is herited from JFrame
		this.setContentPane(content);
	}

	//Add a component to the boardPanel
	public void addComponent(JComponent comp) {
		this.boardPanel.add(comp);
	}

	//Get the icon of a card from the hashmap
	public ImageIcon getIconFromCard(ICarte st) {
		return cartes.get(st.getNomDeFichierPNG());
	}

	//Get the icon of a card from the hashmap
	public void makeGrid() {
		SpringUtilities.makeCompactGrid(boardPanel, nbLigs, nbCols, 10,
				10, 10, 10);
	}

	//Set the message of the interface
	public void setMessage(String string) {
		message.setText(string);		
	}

	//Clear the message of the interface
	public void clearMessage() {
		message.setText("");		
	}

	//Add a button to the interface
	public void ajouterBouton(String ident) {
		JButton newbutton = new JButton(ident);
		newbutton.setFont(boardPanel.getFont());
		newbutton.addActionListener(butlist);
		//System.out.println("boutons getsize " + boutons.getSize());
		boutons.add(newbutton);
		boutons.updateUI();
	}

	//Create a listener for the buttons
	protected class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(arg0);
			reporter.buttonPressed(arg0.getActionCommand());
		}

	}

	//Get the jaune filter for the cards
	public ImageIcon getJaune() {
		return cartes.get("jaune.png");
	}
}
