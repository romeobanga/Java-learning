package tp.beans;

import org.joda.time.DateTime;

import tp.servlets.Client;

public class Commandes {
	
	private Clients client;
	private String dateCommande;
	private double montantCommande;
	private String modePaiementCommande;
	private String statusPaiementCommande;
	private String modeLivraisonCommande;
	private String statusLivraisonCommande;
	
	
	public void setClient(Clients client) {
		this.client = client;
	}
	
	public Clients getClient() {
		return client;
	}
	
	public String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
	public double getMontantCommande() {
		return montantCommande;
	}
	public void setMontantCommande(double montantCommande) {
		this.montantCommande = montantCommande;
	}
	public String getModePaiementCommande() {
		return modePaiementCommande;
	}
	public void setModePaiementCommande(String modePaiementCommande) {
		this.modePaiementCommande = modePaiementCommande;
	}
	public String getStatusPaiementCommande() {
		return statusPaiementCommande;
	}
	public void setStatusPaiementCommande(String statusPaiementCommande) {
		this.statusPaiementCommande = statusPaiementCommande;
	}
	public String getModeLivraisonCommande() {
		return modeLivraisonCommande;
	}
	public void setModeLivraisonCommande(String modeLivraisonCommande) {
		this.modeLivraisonCommande = modeLivraisonCommande;
	}
	public String getStatusLivraisonCommande() {
		return statusLivraisonCommande;
	}
	public void setStatusLivraisonCommande(String statusLivraisonCommande) {
		this.statusLivraisonCommande = statusLivraisonCommande;
	}
	
	
	
	
	
	

}
