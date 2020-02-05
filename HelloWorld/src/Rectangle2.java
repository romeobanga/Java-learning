
public class Rectangle2 extends FigureGeometrique { //Rectangle2 herite de FigureGeometrique
	
	private double hauteur;//Attribute 
	private double largeur;
	
	
	public Rectangle2 (double hauteur, double largeur, double p) //Constructeur
	{
		super(p); //Constructeur de la super-classe - doit être appele en 1er
		this.hauteur = hauteur;
		this.largeur = largeur;
		//position = pos;
		
	}
	
	public Rectangle2 (Rectangle2 autreRectangle)
	{
		super(autreRectangle.position);
		hauteur = autreRectangle.hauteur;
		largeur = autreRectangle.largeur;
		//position = autreRectangle.position;
	}



	double surface () //Methode surface redefinie 
	{
		//double surface = super.surface(); //Appel de la methode surface de la superclasse
		return hauteur*largeur*constante;
	}
	
	public String toString() //Methode utilisée pour l'affichage, c'est une methode deja existante dans la super-classe Object qu'on redefinie
	{
		return "Rectangle: "+hauteur+" x "+largeur+" x "+position;
	}
	
	public boolean equals (Object autreObjet) //Redefinition de la methode equals -- Comparaison de 2 objets
	{
		if (autreObjet == null)
			return false;
		else {
			if (autreObjet.getClass() != getClass() ) //compare la classe autreObjet à la classe courante
				return false;
			else {
				Rectangle2 r = (Rectangle2)autreObjet;
				return (largeur == r.largeur && hauteur == r.hauteur  );
			}
				
		}
	}
	


}
