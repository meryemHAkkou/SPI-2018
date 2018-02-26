package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Formation;

@Service
public interface FormationBusiness {

	Formation creerFormation(Formation formationACreer);

	boolean supprimerFormationById(String codeFormation);

	boolean supprimerFormation(Formation formationASuprimer);

	Formation chercherFormationParId(String codeFormation);

	List<Formation> recupererToutesLesFormationsFormation();

	List<Formation> findByNomFormation(String nomFormation);

	Formation updateFormation(Formation formtionToUpdate);
}
