package fr.univbrest.dosi.controller;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge = 3600)
@RequestMapping("/enseignants")
public class EnseignantController {
	EnseignantBusiness business;
	@Autowired
	public EnseignantController(EnseignantBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Enseignant> recupererToutsLesEnseignant() {
		return business.recupererToutsLesEnseignant();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant enseignantACreer) {
		return business.creerEnseignant(enseignantACreer);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public Enseignant updateEnseignant(@RequestBody Enseignant enseignantACreer) {
		return business.updateEnseignant(enseignantACreer);
	}
	@RequestMapping(method=RequestMethod.DELETE  ,value="/{id}")
	public boolean supprimerEnseignantById(@PathVariable Long id) {
		return business.supprimerEnseignantById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/nom/{nom}")
	public List<Enseignant> findByNomEnseignant(@PathVariable String nom) {
		return business.RechercherParNomEnseignant(nom);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{noEnseignant}")
	public Enseignant findByNoEnseignant(@PathVariable long noEnseignant) {
		return business.RechercherParNoEnseignant(noEnseignant);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/email/{emailUbo:.+}")
	public List<Enseignant> findByEmailUBO(@PathVariable String emailUbo) {
		return business.RechercherParEmailUbo(emailUbo);
	}
	
	
	
	@RequestMapping(method=RequestMethod.DELETE)
	public boolean supprimerEnseignant(Enseignant enseignant) {
		return business.supprimerEnseignant(enseignant);
	}
	
}
