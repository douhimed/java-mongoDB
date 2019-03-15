package org.mql.dao;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.mql.models.Movie;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectMongo {

	private MongoClient mongo;
	private MongoDatabase database;
	private MongoCollection<Movie> collection;

	private String databaseName;
	private String host = "localhost";
	private int port = 27017;

	private static ConnectMongo cnx;

	CodecRegistry pojoCodecRegistry;

	{
		pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	}

	private ConnectMongo() {
		mongo = new MongoClient(host, port);
	}

	private ConnectMongo(String host, int port) {
		mongo = new MongoClient(host, port);
	}

	public static ConnectMongo getCnx(String host, int port) {
		if (cnx == null)
			cnx = new ConnectMongo(host, port);
		return cnx;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public MongoDatabase getDatabase(String databaseName) {
		if (cnx == null)
			cnx = new ConnectMongo();
		database = mongo.getDatabase(databaseName);
		database = database.withCodecRegistry(pojoCodecRegistry);
		return database;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("you cannot clone the cnx object");
	}
	
}
