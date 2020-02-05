
public class FigureGeometrique {
	
	protected double position; //protected = pour qu'il soit visible des autres sous-classes et classes
	static double constante; //
	
	public FigureGeometrique (double p) //Le constructeur de la classe
	{
		position = p;	
	}
	
	public double positionCarre()
	 {
		 return position*position;
	 }
	 
	 double surface () //Method
		{
			return position*2;
		}
	 
	 static void Afficher() //methode statique
	 {
		 System.out.println("Fin du programme...");
	 }
}
