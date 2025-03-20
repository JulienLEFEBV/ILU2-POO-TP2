package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nomVendeur,int quantite) {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int quantiteAchete=0;
		if(etal!=null) {
			quantiteAchete=etal.acheterProduit(quantite);
		}
		return quantiteAchete;
	}
	
	public boolean verifierIdentite(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public String[] trouverProduit(String nomProduit) {
		String[] stringVendeurs=null;
		Gaulois[] vendeurs = village.rechercherVendeursProduit(nomProduit);
		if (vendeurs != null) {
			stringVendeurs = new String[vendeurs.length];
			for (int i = 0; i < vendeurs.length; i++) {
				stringVendeurs[i] = vendeurs[i].getNom();
			}
		}
		return stringVendeurs;
	}
}
