package produit;

import java.util.ArrayList;

public class Montre extends Produit {
	
	private Mecanisme coeur; //Les montres ont un mecanisme
	private ArrayList<Accessoire> accessoires; //Les montres sont constitu�es de diff�rents accessoires
	
	public Montre () { accessoires = new ArrayList<Accessoire>(); }
	
	public Montre(Mecanisme depart)
	{
		coeur = depart;
		accessoires = new ArrayList<Accessoire>();
	}
	
	public Montre(Montre maMontre)
	{
		super(maMontre);
		accessoires = new ArrayList<Accessoire>();
	}

	public void ajouter(Accessoire accessoire) { accessoires.add(accessoire); }
	
	@Override
	public double calculPrix() { //Le prix d'une montre est la somme des prix de tous ses accessoires
		
		double prixFinal = super.calculPrix();
		for (Accessoire acc : accessoires) {
			prixFinal += acc.calculPrix();
		}	
		return prixFinal;
	}
	
	public void Afficher ()  {
		System.out.println("Une montre compos�e de :");
		for (Accessoire acc : accessoires) {
			System.out.println(" * " + acc.toString());
		}
		System.out.print("==> Produit total:");
		System.out.println(calculPrix());
		
	}

}
