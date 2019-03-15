package org.mql.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.mql.models.Movie;
import org.mql.models.Realisateur;

public interface IDataBase {

	void save(Movie movie);
	void update(Movie movie);
	List<Movie> getAll();
	long delete(ObjectId id);
	List<Movie> getAll(String bson);
	
	List<Movie> getByRealisateur(Realisateur realisateur);
	List<Movie> getByYear(int year);
	List<Movie> getBeforeYear(int year);
	List<Movie> getByNomRealisateur(String nomRealisateur);
	List<Movie> getByRealisateur(String nom, String prenom);
	List<Movie> getByRealisateurBeforeYear(String nom, int year);
	List<Movie> getOfleonardoDecaprio(String nom, String prenom);
	List<Movie> getOfDecaprio(String nom);
}
