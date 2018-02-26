package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Candidat;

@Service
public interface CandidatBusiness {

	Candidat creerCandidat(Candidat candidatACreer);

	boolean supprimerCandidatParId(String id);

	Candidat findByNoCandidat(String noCandidat);

	List<Candidat> recupererToutsLesCandidats();

	List<Candidat> findByUniversiteOrigine(String universiteOrigine);

	List<Candidat> rechercheCandidatParNom(String nom);

	boolean supprimerCandidat(Candidat candidat);

}
