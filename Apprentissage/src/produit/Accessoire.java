package produit;

abstract class Accessoire extends Produit {
	
	private final String nom;
	
	public Accessoire (String unNom, double valeurDeBase) {
		super(valeurDeBase);
		nom = unNom;
	}
	
	
	@Override
	public String toString() {
		String result = nom + " coûtant ";
		result += super.toString();
		return result;
	}
		
}		
		
		
		
		
		
	
		


