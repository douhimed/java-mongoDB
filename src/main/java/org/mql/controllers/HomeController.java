package org.mql.controllers;

import org.bson.types.ObjectId;
import org.mql.business.IBusiness;
import org.mql.models.Acteur;
import org.mql.models.Address;
import org.mql.models.Movie;
import org.mql.models.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@Autowired
	private IBusiness business;
	
	@GetMapping(path = { "/", "/home", "/index" })
	public String index(Model model) {
		model.addAttribute("movies", business.find());
		model.addAttribute("realisateur", new Realisateur());
		return "home";
	}
	
	@GetMapping("/add")
	public String add() {
		Movie movie = buildMovie();
		business.save(movie);
		return "redirect:/home";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable String id) {
		ObjectId idMovie = new ObjectId(id);
		business.delete(idMovie);
		return "redirect:/home";
	}
	
	@GetMapping("/update")
	public String update() {
		
		Movie movie = buildMovie();
		ObjectId id = new ObjectId("5c7f9a65a290c4627a6104c0");
		movie.setId(id);
		business.update(movie);		
		return "redirect:/home";
	}
	
	@GetMapping("/question/{qst}")
	public String qst_1(Model model,@PathVariable int qst) {
		if(qst == 1)
			model.addAttribute("movies", business.findByYear(2010));
		else if(qst == 2)
			model.addAttribute("movies", business.findBeforeYear(2011));
		else if(qst == 3)
			model.addAttribute("movies", business.findByRealisateur("Christopher", "nolan"));
		else if(qst == 4)
			model.addAttribute("movies", business.findByNomRealisateur("Clint"));
		else if(qst == 5)
			model.addAttribute("movies", business.findByRealisateurBeforeYear("Christopher", 2013));
		else if(qst == 6)
			model.addAttribute("movies", business.findMoviesOfLeoDecaprio("Leonardo", "decaprio"));
		else if(qst == 7)
			model.addAttribute("movies", business.findMoviesOfDecaprio("decaprio"));
		else 
			model.addAttribute("movies", business.find());
		
		model.addAttribute("realisateur", new Realisateur());
		return "home";
	}
	
	@PostMapping("/search")
	public String search(Model model, Realisateur realisateur) {
		model.addAttribute("movies", business.findByRealisateur(realisateur.getNom(), realisateur.getPrenom()));
		model.addAttribute("realisateur", realisateur);
		return "home";
	}

	private Movie buildMovie() {
		Movie movie = new Movie();
		movie.setNom("AVATAR");
		movie.setAnnee(2013);
		movie.setImage("default.jpg");

		
		Acteur acteur = new Acteur();
		acteur.setNom("Michael");
		acteur.setPrenom("Brad");
		movie.addActeur(acteur);
		
		acteur = new Acteur();
		acteur.setNom("Emily");
		acteur.setPrenom("Kardi");
		movie.addActeur(acteur);
		
		Realisateur realisateur = new Realisateur();
		realisateur.setNom("James");;
		realisateur.setPrenom("Cameroon");;
		movie.setRealisateur(realisateur);
		
		movie.addrea_Place("USA");
		
		Address address = new Address();
		address.setVille("New york");
		address.setRue("Linkon");
		address.setPostal(12050);
		
		return movie;
	}
	
}
