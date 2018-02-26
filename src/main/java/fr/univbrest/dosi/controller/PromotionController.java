package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusiness;

@RestController
@CrossOrigin(origins = "http://localhost:5500", maxAge = 3600)
@RequestMapping("/promotions")
public class PromotionController {

	PromotionBusiness business;

	@Autowired
	public PromotionController(PromotionBusiness business) {
		this.business = business;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Promotion creerPromotion(@RequestBody Promotion promotionACreer) {
		return business.creerPromotion(promotionACreer);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{siglePromotion}")
	public List<Promotion> findBySiglePromotion(@PathVariable String siglePromotion) {
		return business.ChercherParSiglePromotion(siglePromotion);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{codeFormation}/{anneeUniversitaire}")
	public Promotion findById(@PathVariable String codeFormation, @PathVariable String anneeUniversitaire) {
		PromotionPK pk = new PromotionPK();
		pk.setAnneeUniversitaire(anneeUniversitaire);
		pk.setCodeFormation(codeFormation);

		return business.findById(pk);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion> recupererToutesLesPromotions() {
		return business.recupererToutesLesPromotions();
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void supprimerPromotion(@RequestBody Promotion promotion) {
		business.supprimerPromotion(promotion);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{codeFormation}/{anneeUniversitaire}")
	public void supprimerPromotionByID(@PathVariable String codeFormation, @PathVariable String anneeUniversitaire) {
		PromotionPK pk = new PromotionPK();
		pk.setAnneeUniversitaire(anneeUniversitaire);
		pk.setCodeFormation(codeFormation);
		business.supprimerPromotionbyId(pk);

	}
}