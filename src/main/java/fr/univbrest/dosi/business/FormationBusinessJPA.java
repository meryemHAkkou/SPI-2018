package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.FormationRepository;
@Component
public class FormationBusinessJPA  implements FormationBusiness{
 
	private FormationRepository repos;
	
	
	@Autowired
	public FormationBusinessJPA(FormationRepository repos) {
		this.repos=repos;
	}
	@Override
	public Formation creerFormation(Formation formationACreer) {
		formationACreer.setDebutAccreditation(new Date());
		return repos.save(formationACreer);
	}
	@Override
	public boolean supprimerFormation(Formation formationASuprimer) {
		repos.delete(formationASuprimer);
		return true;
	}
	@Override
	public List<Formation> findByNomFormation(String nomFormation) {
		
		return repos.findByNomFormation(nomFormation);
	}

    @Override
    public Formation updateFormation(Formation formationToUpdate) {
        Formation f = repos.findOne(formationToUpdate.getCodeFormation());
        if(f == null){
            return null;
        }
        return repos.save(formationToUpdate);
    }

    @Override
	public List<Formation> recupererToutesLesFormationsFormation() {
		return (List<Formation>) repos.findAll();
				
	}
	@Override
	public boolean supprimerFormationById(String codeFormation) {
		repos.delete(codeFormation);
		return true;
	}
	@Override
	public Formation chercherFormationParId(String codeFormation) {
		return repos.findOne(codeFormation);
	}
	

}
