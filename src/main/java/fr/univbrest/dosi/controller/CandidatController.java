package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusiness;


@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge = 3600)
@RequestMapping("/candidats")
public class CandidatController {
		
		private CandidatBusiness business;
		
		
		@Autowired
		public CandidatController(CandidatBusiness business) {
			this.business=business;
		}
		@RequestMapping(method=RequestMethod.POST)
		public Candidat saveCandidat(@RequestBody Candidat candidat) {
			return business.creerCandidat(candidat);
		}
		@RequestMapping(method=RequestMethod.DELETE,  value="/{id}")
		public boolean supprimerCandidat(@PathVariable String id) {
			return business.supprimerCandidatParId(id);
		}
		@RequestMapping(method=RequestMethod.DELETE)
		public boolean supprimerCandidat(@RequestBody Candidat candidat) {
			return business.supprimerCandidat(candidat);
		}
		@RequestMapping(method=RequestMethod.GET)
		public List<Candidat> recupererCandidats() {
			return business.recupererToutsLesCandidats();
		}
		
		@RequestMapping(value="/nom/{nom}", method=RequestMethod.GET)
		public List<Candidat> recupererCandidatParNom(@PathVariable String nom) {
			
			return business.rechercheCandidatParNom(nom);
		}
		
		@RequestMapping(value="/{nomUniversite}", method=RequestMethod.GET)
		public List<Candidat> recupererCandidatParNomUniversite(@PathVariable String nomUniversite) {
			
			return business.findByUniversiteOrigine(nomUniversite);
		}
		@RequestMapping(value="/id/{id}", method=RequestMethod.GET)
		public Candidat recupererCandidatParId(@PathVariable String id) {
			
			return business.findByNoCandidat(id);
		}
}
