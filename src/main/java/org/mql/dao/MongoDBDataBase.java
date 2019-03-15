package org.mql.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;

import java.util.List;
import java.util.Vector;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.mql.models.Movie;
import org.mql.models.Realisateur;
import org.mql.utilities.IConstants;
import org.springframework.stereotype.Repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

@Repository
public class MongoDBDataBase implements IDataBase {

	private MongoDatabase database;
	private MongoCollection<Movie> collection;
	
	private ConnectMongo cnx;

	public MongoDBDataBase() {
		cnx = ConnectMongo.getCnx("localhost", 27017);
		database = cnx.getDatabase("cinema");
		collection = database.getCollection("movies", Movie.class);
	}

	@Override
	public void save(Movie movie) {
		collection.insertOne(movie);
	}

	@Override
	public void update(Movie movie) {
		collection.replaceOne(Filters.eq(IConstants.ID, movie.getId()), movie);
	}

	@Override
	public List<Movie> getAll() {
		FindIterable<Movie> data = collection.find();
		return getListMovies(data);
	}

	@Override
	public long delete(ObjectId id) {
		DeleteResult dr = collection.deleteOne(Filters.eq(IConstants.ID, id));
		return dr.getDeletedCount();
	}

	@Override
	public List<Movie> getAll(String nom) {
		FindIterable<Movie> data = collection.find(Filters.eq(IConstants.NOM, nom));
		return getListMovies(data);
	}

	private List<Movie> getListMovies(FindIterable<Movie> data) {
		List<Movie> movies = new Vector<>();
		for (Movie movie : data) {
			movies.add(movie);
		}
		return movies;
	}
	
	
	/* TP 1 */

	@Override
	public List<Movie> getByRealisateur(Realisateur realisateur){
		Bson filter = and(eq(IConstants.REALISATEUR_NOM, realisateur.getNom()), eq(IConstants.REALISATEUR_PRENOM, realisateur.getPrenom()));
		FindIterable<Movie> data = collection.find(Filters.elemMatch(IConstants.REALISATEUR, filter));
		return getListMovies(data);
	}

	@Override
	public List<Movie> getByYear(int year) {
		FindIterable<Movie> data = collection.find(Filters.eq(IConstants.ANNEE, year));
		return getListMovies(data);
	}
	
	@Override
	public List<Movie> getBeforeYear(int year) {
		FindIterable<Movie> data = collection.find(Filters.lt(IConstants.ANNEE, year));
		return getListMovies(data);
	}

	@Override
	public List<Movie> getByNomRealisateur(String nomRealisateur) {
		FindIterable<Movie> data = collection.find(Filters.eq(IConstants.REALISATEUR_NOM, nomRealisateur));
		return getListMovies(data);
	}

	@Override
	public List<Movie> getByRealisateur(String nom, String prenom) {
		FindIterable<Movie> data = collection.find(Filters.and(eq(IConstants.REALISATEUR_NOM, nom), eq(IConstants.REALISATEUR_PRENOM, prenom)));
		return getListMovies(data);
	}

	@Override
	public List<Movie> getByRealisateurBeforeYear(String nom, int annee) {
		FindIterable<Movie> data = collection.find(Filters.and(eq(IConstants.REALISATEUR_NOM, nom), lt(IConstants.ANNEE, annee)));
		return getListMovies(data);
	}

	@Override
	public List<Movie> getOfleonardoDecaprio(String nom, String prenom) {
		FindIterable<Movie> data = collection.find(Filters.and(eq(IConstants.ACTEUR_NOM, nom), eq(IConstants.ACTEUR_PRENOM, prenom)));
		return getListMovies(data);
	}

	@Override
	public List<Movie> getOfDecaprio(String nom) {
		FindIterable<Movie> data = collection.find(Filters.eq(IConstants.ACTEUR_NOM, nom));
		return getListMovies(data);
	}

}
