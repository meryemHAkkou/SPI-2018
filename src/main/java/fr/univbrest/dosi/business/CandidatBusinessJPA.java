package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;
@Component
public class CandidatBusinessJPA  implements CandidatBusiness{

	private CandidatRepository repos;

	@Autowired
	public CandidatBusinessJPA(CandidatRepository repos) {
		this.repos=repos;
	}
	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		
		return repos.save(candidatACreer);
	}
	@Override
	public boolean supprimerCandidatParId(String id) {
		
		 repos.delete(id);
		 return true;
	}

	@Override
	public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
		
		return  repos.findByUniversiteOrigine(universiteOrigine);
	}
	@Override
	public List<Candidat> recupererToutsLesCandidats() {
		
		return (List<Candidat>) repos.findAll();
	}
	@Override
	public List<Candidat> rechercheCandidatParNom(String nom) {
		return  repos.findByNom(nom);
	}
	@Override
	public Candidat findByNoCandidat(String noCandidat) {
		return repos.findOne(noCandidat);
	}
	@Override
	public boolean supprimerCandidat(Candidat candidat) {
		
		 repos.delete(candidat);
		 return true;
	}
	

}
