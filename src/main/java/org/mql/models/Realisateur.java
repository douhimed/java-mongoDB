package org.mql.models;

public class Realisateur {

	private String nom;
	private String prenom;
	
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
	@Override
	public String toString() {
		return "Realisateur [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
}
