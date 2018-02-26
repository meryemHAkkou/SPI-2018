package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.repositories.PromotionRepository;



@Component
public class PromotionBusinessJPA implements PromotionBusiness {
	@Autowired
	public PromotionBusinessJPA(PromotionRepository repos) {
		this.repos = repos;
	}

	PromotionRepository repos;

	@Override
	public Promotion creerPromotion(Promotion promotionACreer) {	
		return repos.save(promotionACreer);
	}

	@Override
	public boolean supprimerPromotion(Promotion promotion) {
		repos.delete(promotion);
		return true;
	}

	@Override
	public List<Promotion> ChercherParSiglePromotion(String siglePromotion) {
		
		return repos.findBySiglePromotion(siglePromotion);
	}

	@Override
	public Promotion findById(PromotionPK id) {
		
		return  repos.findOne(id);
	}

	@Override
	public List<Promotion> recupererToutesLesPromotions() {
		
		return (List<Promotion>) repos.findAll();
	}

	@Override
	public void supprimerPromotionbyId(PromotionPK id) {
		repos.delete(id);
		
	}

	

}
