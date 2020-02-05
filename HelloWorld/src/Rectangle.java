
public class Rectangle implements MouvementFigure {
	
	private double hauteur;//Attribute 
	private double largeur;
	
	
	

	public void SetHauteur(double hauteur) //Manipulateur Set == permet d'initialiser une variable d'instance/attribut 
	{
		this.hauteur  = hauteur;
	}
	
	public void SetLargeur(double largeur) //Manipulateur Set 
	{
		this.largeur  = largeur;
	}
	
	public double getHauteur(){return hauteur;} //Accesseur
	public double getLargeur(){return largeur;}
	
	double surface () //Method
	{
		return hauteur*largeur;
	}
	
	public void rotation()
	{
		 System.out.println("Je tourne à 90° vers la gauche...");
	}
	
	

}
