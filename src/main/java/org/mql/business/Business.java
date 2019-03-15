package org.mql.business;

import java.util.List;

import org.bson.types.ObjectId;
import org.mql.dao.IDataBase;
import org.mql.models.Movie;
import org.mql.models.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business implements IBusiness {

	@Autowired
	private IDataBase mongoDB;

	public Business() {
	}

	@Override
	public void save(Movie movie) {
		mongoDB.save(movie);
	}

	@Override
	public void update(Movie movie) {
		mongoDB.update(movie);
	}

	@Override
	public List<Movie> find() {
		return mongoDB.getAll();
	}

	@Override
	public long delete(ObjectId id) {
		return mongoDB.delete(id);
	}

	@Override
	public List<Movie> find(String bson) {
		return mongoDB.getAll(bson);
	}

	@Override
	public List<Movie> findByRealisateur(Realisateur realisateur) {
		return mongoDB.getByRealisateur(realisateur);
	}

	@Override
	public List<Movie> findByYear(int year) {
		return mongoDB.getByYear(year);
	}
	
	@Override
	public List<Movie> findBeforeYear(int year) {
		return mongoDB.getBeforeYear(year);
	}

	@Override
	public List<Movie> findByNomRealisateur(String nomRealisateur) {
		return mongoDB.getByNomRealisateur(nomRealisateur);
	}

	@Override
	public List<Movie> findByRealisateur(String nom, String prenom) {
		return mongoDB.getByRealisateur(nom, prenom);
	}

	@Override
	public Object findByRealisateurBeforeYear(String nom, int year) {
		return mongoDB.getByRealisateurBeforeYear(nom, year);
	}

	@Override
	public List<Movie> findMoviesOfLeoDecaprio(String nom, String prenom) {
		return mongoDB.getOfleonardoDecaprio(nom, prenom);
	}

	@Override
	public List<Movie> findMoviesOfDecaprio(String nom) {
		return mongoDB.getOfDecaprio(nom);
	}

}
