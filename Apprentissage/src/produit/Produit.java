package produit;

abstract class Produit { //Pour ne pas qu'il soit instanciable
	
	private final double prix; //Une fois le prix attribu� � un produit, il ne doit plus pouvoir etre modifi�
	
	public Produit (double unPrix) { prix = unPrix; }
	
	public Produit() {prix = 0.0;}
	
	/*public Produit(Montre maMontre) {
		// TODO Auto-generated constructor stub
		
	}*/

	double calculPrix() { return prix;	}
	
	public String  toString() {return Double.toString(calculPrix()); }
	//Ram�ne le prix qui est en double sous forme de String
	
	
	

}
