package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée "+nomAcheteur+" mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] vendeurs=controlAcheterProduit.trouverProduit(produit);
			if(vendeurs==null) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			}
			else {
				System.out.println("Chez quel commerçant voulez-vous acheter des "+produit+" ?");
				for(int i=0;i<vendeurs.length;i++) {
					System.out.println((i+1)+" - "+vendeurs[i]);
				}
				int idVendeur=-1;
				do{
					if(idVendeur!=-1) {
						System.out.println("Veuillez entre un entier entre 1 et "+vendeurs.length);
					}
					idVendeur=Clavier.entrerEntier("")-1;
				}while(idVendeur>vendeurs.length-1);
				String nomVendeur=vendeurs[idVendeur];
				if(!controlAcheterProduit.verifierIdentite(nomVendeur)) {
					System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici.");
				}
				else {
					System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+nomVendeur);
					System.out.println("Bonjour "+nomVendeur);
					int quantiteVoulue=Clavier.entrerEntier("Combien de "+produit+" voulez-vous acheter ?");
					int quantiteAchetee=controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulue);
					if(quantiteAchetee==quantiteVoulue) {
						System.out.println(nomAcheteur+" achète "+quantiteAchetee+" "+produit+" à "+ nomVendeur);
					}
					else if(quantiteAchetee==0) {
						System.out.println(nomAcheteur+" veut acheter "+quantiteVoulue+" "+produit+", malheureusement il n’y en a plus !");
					}
					else {
						System.out.println(nomAcheteur+" veut acheter "+quantiteVoulue+" "+produit+", malheureusement "+ nomVendeur + " n'en a plus que "+quantiteAchetee+". "+nomAcheteur
								+" achète tout le stock de "+nomVendeur+".");
					}
				}
			}
		}
	}
}
