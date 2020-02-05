package produit;

public class mecanismeDouble extends mecanismeAnalogique implements ReveilDigital {
	
	private String reveil;
	public mecanismeDouble(double valeurDeBase, String uneHeure, int uneDate, String unReveil) {
		super(valeurDeBase, uneHeure, uneDate);
		reveil = unReveil;
	}

	@Override
	protected String toStringType () {
		return "double";
	}	
	
	@Override
	protected String toStringCadran () {
		String result = "sur l'écran : ";
		result += super.toStringCadran();
		result += ", sous les aiguilles : ";
		result += toStringReveil();
		return result;
	}
	
	public String toStringReveil () {
		return " reveil " + reveil;
	}
}
