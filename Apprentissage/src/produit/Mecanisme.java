package produit;

public abstract  class Mecanisme extends Produit {
	
	private String heure;
	
	public Mecanisme (double valeurDeBase, String uneHeure) {
		super(valeurDeBase);
		heure = uneHeure;
	}
	
	public Mecanisme (double valeurDeBase) {
		super(valeurDeBase);
		heure = "12:00";
	}

//Tous les mecanismes doivent s'afficher comme ceci
		public final String toString() {
			String result = "Mécanisme ";
			result += toStringType();
			result += " affichage : ";
			result += toStringCadran();
			result += "), prix : ";
			result += result.toString();
			return result;
		}
		
		protected String toStringCadran() {
			return heure;
		}
		
		protected abstract String toStringType();
}				

		