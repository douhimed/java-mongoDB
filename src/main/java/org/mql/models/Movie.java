package org.mql.models;

import java.util.List;
import java.util.Vector;

import org.bson.types.ObjectId;

public class Movie {

	private ObjectId id;
	private String nom;
	private Realisateur realisateur;
	private int annee;
	private List<Acteur> acteurs;
	private List<String> Rea_places;
	private Address address;
	private String image = "default.jpg";

	{
		acteurs = new Vector<Acteur>();
		Rea_places = new Vector<>();
	}

	public Movie() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public List<String> getRea_places() {
		return Rea_places;
	}

	public void setRea_places(List<String> rea_places) {
		Rea_places = rea_places;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void addActeur(Acteur acteur) {
		acteurs.add(acteur);
	}

	public void addrea_Place(String place) {
		Rea_places.add(place);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", nom=" + nom + ", realisateur=" + realisateur + ", annee=" + annee + ", acteurs="
				+ acteurs + ", Rea_places=" + Rea_places + ", address=" + address + "]";
	}

}
