package produit;

public class Montres {

	public static void main(String[] args) {
		
		
		mecanismeAnalogique v1 = new mecanismeAnalogique(312.0,"12:30",20200121);
		mecanismeDigital    v2 = new mecanismeDigital(32.00, "11:45", "7:00");
		mecanismeDouble     v3 = new mecanismeDouble(543.00, "8:20", 20140328, "6:30");
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		
		
		Montre m = new Montre( new mecanismeDouble(468.00, "9:15", 20140401, "7:00"));
		m.ajouter(new Bracelet("cuir",54.0));
		m.ajouter(new Fermoir("acier",12.5));
		m.ajouter(new Boitier("acier",36.6));
		m.ajouter(new Vitre("quartz",44.8));
		
		System.out.println('\n' + "Montre m : ");
		m.Afficher();
		
	
		

	}

}
