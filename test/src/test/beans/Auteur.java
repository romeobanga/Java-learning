package test.beans;

public class Auteur {
	
	/* Premier bean :
	 * Est Public
	 * Contient des propriet�s ou encore des champs non publics
	 * Contient des getters/setters public
	 * Contient un constructeur par d�faut sans param�tre (ajout� implicitement par Eclipse)
	 */
	
	private String nom;
	private String prenom;
	private boolean actif;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	

}
