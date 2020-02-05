package produit;

public class mecanismeDigital extends Mecanisme implements ReveilDigital {
	
	private String reveil;
	public mecanismeDigital(double valeurDeBase, String uneHeure, String unReveil) {
		super(valeurDeBase, uneHeure);
		reveil = unReveil;
	}

	@Override
	protected String toStringType () {
		return "digital";
	}	
	
	@Override
	protected String toStringCadran () {
		return super.toStringCadran() + ", " + toStringReveil();
	}
	

	public String toStringReveil () {
		return " reveil " + reveil;
	}

}

