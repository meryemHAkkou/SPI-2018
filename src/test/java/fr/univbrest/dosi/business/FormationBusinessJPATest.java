package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.FormationBusinessJPA;
import fr.univbrest.dosi.repositories.FormationRepository;

public class FormationBusinessJPATest {

	FormationBusinessJPA business;

	@Test
	public void doitCreerUneFomation() {
		FormationRepository repos = new FormationRepositoryList();
		business = new FormationBusinessJPA(repos);
		Formation formationACreer = new Formation("33", null, "M2", "O", new Date(), BigDecimal.valueOf(2.0), "DOSI");
		Formation resultat = business.creerFormation(formationACreer);
		assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date(), 500);
	}

	@Test
	public void doitSupprimerUneFomation() {
		FormationRepository repos = new FormationRepositoryList();
		business = new FormationBusinessJPA(repos);
		Formation formationACreer = new Formation("33", null, "M2", "O", new Date(), BigDecimal.valueOf(2.0), "DOSI");
		business.creerFormation(formationACreer);
		boolean res = business.supprimerFormation(formationACreer);

		assertThat(res).isEqualTo(true);
	}

	@Test
	 
	public void doitChercherUneFomationParNom() {
		FormationRepository repos = new  FormationRepositoryList();
		 business = new FormationBusinessJPA(repos);
		 Formation formationACreer = new Formation("33", null, "M2", "O", new Date(), BigDecimal.valueOf(2.0), "DOSI");
		 business.creerFormation(formationACreer);
		 
		 List<Formation> resultat =  business.findByNomFormation("DOSI");
		 System.out.println(resultat.get(0).getNomFormation());
		 assertThat(resultat).hasSize(1);
		 assertThat(resultat.get(0).getNomFormation()).isEqualTo("DOSI");
	}

	class FormationRepositoryList implements FormationRepository {

		private List<Formation> data;

		public FormationRepositoryList() {
			data = Lists.newArrayList();
		}

		@Override
		public long count() {

			return data.size();
		}

		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void delete(Formation entity) {
			data.remove(entity);

		}

		@Override
		public void delete(Iterable<? extends Formation> arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Formation> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Formation> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Formation findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Formation> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Formation> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Formation> findByNomFormation(String nomFormation) {
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).getNomFormation() == nomFormation) {
					List<Formation> data2 = Lists.newArrayList();
					data2.add(data.get(i));
					return data2;
				}
			}

			return null;
		}

	}

}
