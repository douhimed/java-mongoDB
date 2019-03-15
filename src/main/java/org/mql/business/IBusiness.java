package org.mql.business;

import java.util.List;

import org.bson.types.ObjectId;
import org.mql.models.Movie;
import org.mql.models.Realisateur;

public interface IBusiness {

	void save(Movie movie);
	void update(Movie movie);
	List<Movie> find();
	long delete(ObjectId id);
	List<Movie> find(String bson);
	List<Movie> findByRealisateur(Realisateur realisateur);
	List<Movie> findByYear(int year);
	List<Movie> findBeforeYear(int year);
	List<Movie> findByNomRealisateur(String nomRealisateur);
	List<Movie> findByRealisateur(String string, String string2);
	Object findByRealisateurBeforeYear(String nom, int year);
	List<Movie> findMoviesOfLeoDecaprio(String nom, String prenom);
	List<Movie> findMoviesOfDecaprio(String string);
}
