package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.PromotionBusinessJPA;
import fr.univbrest.dosi.repositories.PromotionRepository;

public class PromotionBusinessJPATest {
	PromotionBusinessJPA business;


	
	@Test
	public void doitCreerUnePromotion() {
		PromotionRepository repos = new PromotionRepositoryList();

		business = new PromotionBusinessJPA(repos);
		PromotionPK pk = new PromotionPK();
		pk.setAnneeUniversitaire("2014-2015  ");
		pk.setCodeFormation("M2DOSI");
		int i = 24;
		BigDecimal bD = new BigDecimal(i);
		Promotion promotionACreer = new Promotion(pk, bD, "DOSI4");
		//Promotion p =business.creerPromotion(promotionACreer);
		repos.save(promotionACreer);
		long resultat = repos.count();
		assertThat(resultat).isEqualTo(1);
	}
	@Test
	public void doitSupprimerUnePromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK pk = new PromotionPK();
		pk.setAnneeUniversitaire("2014-2015  ");
		pk.setCodeFormation("M2DOSI");
		int i = 24;
		BigDecimal bD = new BigDecimal(i);
		Promotion promotionACreer = new Promotion(pk, bD, "DOSI4");
		repos.save(promotionACreer);
		boolean res = business.supprimerPromotion(promotionACreer);

		assertThat(res).isEqualTo(true);
	}
	 
	@Test
	
	public void doitChercherUnePromotionParNom() {
		PromotionRepository repos = new  PromotionRepositoryList();
		 
		 PromotionPK pk = new PromotionPK();
			pk.setAnneeUniversitaire("2014-2015");
			pk.setCodeFormation("M2DOSI");
			int i = 24;
			BigDecimal bD = new BigDecimal(i);
			Promotion promotionACreer = new Promotion(pk, bD, "DOSI4");
			repos.save(promotionACreer);
			business = new PromotionBusinessJPA(repos);
		 List<Promotion> resultat = business.ChercherParSiglePromotion("DOSI4");
		  assertThat(resultat).hasSize(1);
		 assertThat(resultat.get(0).getId().getCodeFormation()).isEqualTo("M2DOSI");
	}
	
}

class PromotionRepositoryList implements PromotionRepository {
	private List<Promotion> data;

	public PromotionRepositoryList() {
		data = Lists.newArrayList();
	}
	@Override
	public <S extends Promotion> S save(S entity) {
		data.add(entity);
		return entity;
	}

	@Override
	public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findOne(PromotionPK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(PromotionPK id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Promotion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		return data.size();
	}

	@Override
	public void delete(PromotionPK id) {

	}

	@Override
	public void delete(Promotion entity) {
data.remove(entity);
	}

	@Override
	public void delete(Iterable<? extends Promotion> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Promotion> findBySiglePromotion(String siglePromotion) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getSiglePromotion() == siglePromotion) {
				List<Promotion> data2 = Lists.newArrayList();
				data2.add(data.get(i));
				return data2;
			}
		}

		return null;
	
	}

	@Override
	public List<Promotion> findById(PromotionPK id) {
		// TODO Auto-generated method stub
		return null;
	}

}