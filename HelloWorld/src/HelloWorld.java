
import java.util.InputMismatchException;
import java.util.Scanner;


public class HelloWorld {

	public static void main(String[] args) throws Exception {
		
		Scanner clavier = new Scanner(System.in); //Recuperer la valeur saisie au clavier
		double nombre, nombre2;
		
		Rectangle Rect = new Rectangle();
		
		System.out.println("1er Rectangle - Hauteur: "); 
		nombre = clavier.nextDouble();
		Rect.SetHauteur(nombre); //Appel du manipulateur ou Setter
		System.out.println("1er Rectangle - Largeur: "); 
		nombre = clavier.nextDouble();
		Rect.SetLargeur(nombre);
	//	Rect.hauteur = 5;
	//	Rect.largeur = 2;
		
		
		
		System.out.println("2e Rectangle - Hauteur: "); 
		nombre = clavier.nextDouble();
		//Rect1.SetHauteur(nombre); //Appel du manipulateur
		System.out.println("2e Rectangle - Largeur: "); 
		nombre2 = clavier.nextDouble();
		Rectangle2 Rect1 = new Rectangle2(nombre,nombre2,nombre2);//instanciation avec un constructeur
		
		FigureGeometrique Rect2 = new Rectangle2(nombre,nombre2,nombre2);
		Rectangle2 Rect3 = new Rectangle2(Rect1); //Consructeur de copie
		Rect1.constante = 10; //variable static ou variable de classe
		System.out.println("Hauteur Rect: "+ Rect.getHauteur()); //Appel de l'accesseur
		System.out.println("Largeur Rect: "+ Rect.getLargeur());
		System.out.println("Surface Rect: "+ Rect.surface());
		System.out.println("Position au Carre: "+ Rect1.positionCarre());
		System.out.println("Surface Rect2: "+ Rect2.surface());
		System.out.println("Comparaison des 2 rectangles: "+ Rect2.equals(Rect1));
		
		//Rect1 = Rect;
	
		//System.out.println("Hauteur Rect1: "+ Rect1.getHauteur());
		//System.out.println("Largeur Rect1: "+ Rect1.getLargeur());
		System.out.println("Surface Rect1: "+ Rect1.surface());
		System.out.println("Surface Rect2: "+ Rect2.toString());
		
		
		//Gestion des exceptions
		int nbEssai = 1;
		do {
			System.out.println("Entrez la Base du Triangle: "); 
		try { //zone susceptible de générer des erreurs
		double nb = clavier.nextDouble();
		if (nombre == 0)  {throw new ArithmeticException("Valeur nulle");/*Lance l'exception en créant l'objet*/}
		if (nombre >= 50) {throw new Exception("Valeur trop grande !!!");}
		}
		catch (InputMismatchException i)
		{
			System.out.println("Il faut un nombre !!!");
			clavier.nextLine();
			nbEssai++;
		}
		catch (ArithmeticException a) //Attrape l'objet créé et le traite
		{
			System.out.println(a.getMessage());
			a.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		} while (nbEssai <= 3);
		
		FigureGeometrique Tri = new Triangle(nombre, nombre);
		
		System.out.println("Surface Triangle: "+ Tri.surface());
		
		
		Rect.rotation();
		FigureGeometrique.Afficher();
		
		
	}

	

}
