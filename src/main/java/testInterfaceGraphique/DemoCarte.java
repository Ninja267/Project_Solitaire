package testInterfaceGraphique;

import interfaceGraphique.ICarte;

public class DemoCarte implements ICarte {

	private String nomFichier;
	
	public DemoCarte(String nf) {
		nomFichier = nf;
	}

	@Override
	public String getNomDeFichierPNG() {
		return nomFichier;
	}
	
}
