package fr.univbrest.dosi.business;

import java.util.List;


import fr.univbrest.dosi.bean.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Service
public  class EnseignantBusinessJPA implements EnseignantBusiness {
	EnseignantRepository repos;

	@Autowired
	public EnseignantBusinessJPA(EnseignantRepository repos) {
		this.repos = repos;
	}

	@Override
	public Enseignant creerEnseignant(Enseignant enseignantACreer) {
		
		return repos.save(enseignantACreer);
	}

	@Override
	public Enseignant updateEnseignant(Enseignant enseignantToUpdate) {
		Enseignant f = repos.findOne(enseignantToUpdate.getNoEnseignant());
		if(f == null){
			return null;
		}
		return repos.save(enseignantToUpdate);
	}

	@Override
	public List<Enseignant> RechercherParNomEnseignant(String nom) {
		
		return repos.findByNom(nom);
	}

	@Override
	public Enseignant RechercherParNoEnseignant(long noEnseignant) {
		
		return repos.findByNoEnseignant(noEnseignant);
	}

	@Override
	public List<Enseignant> RechercherParEmailUbo(String emailUbo) {
	
		return repos.findByEmailUbo(emailUbo);
	}

	
	@Override
	public boolean supprimerEnseignantById(Long id) {
		repos.delete(id);
		return true;
	}

	@Override
	public boolean supprimerEnseignant(Enseignant enseignant) {
		
		repos.delete(enseignant);
		return true;
	}


	@Override
	public List<Enseignant> recupererToutsLesEnseignant() {
		return (List<Enseignant>) repos.findAll();
	}
	

}
