package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

@Service
public interface PromotionBusiness {
	Promotion creerPromotion(Promotion promotionACreer);

	void supprimerPromotionbyId(PromotionPK id);

	boolean supprimerPromotion(Promotion promotion);

	Promotion findById(PromotionPK id);

	List<Promotion> recupererToutesLesPromotions();

	List<Promotion> ChercherParSiglePromotion(String siglePromotion);

}
