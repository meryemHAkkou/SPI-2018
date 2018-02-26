package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.business.CandidatBusinessJPA;
import fr.univbrest.dosi.repositories.CandidatRepository;

public class CandidatBusinessJPATest {
	CandidatBusinessJPA business;

	@Test
	public void doitCreerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidatACreer = new Candidat("1", "nom1", "prenom1", "UBO");
		Candidat resultat = business.creerCandidat(candidatACreer);

		Long res = repos.count();
		assertThat(res).isEqualTo(1);
	}

	@Test
	public void doitSupprimerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidatACreer = new Candidat("1", "nom1", "prenom1", "UBO");
		business.creerCandidat(candidatACreer);
		boolean res = business.supprimerCandidat(candidatACreer);
		assertThat(res).isEqualTo(true);
	}

	@Test
	public void doitChercherUnCandidatParNom() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidatACreer = new Candidat("1", "nom1", "prenom1", "UBO");
		business.creerCandidat(candidatACreer);
		List<Candidat> resultat = business.rechercheCandidatParNom("nom1");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getPrenom()).isEqualTo("prenom1");
	}

	@Test
	public void doitChercherUnCandidatParUniversiteOrigine() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidatACreer = new Candidat("1", "nom1", "prenom1", "UBO");
		business.creerCandidat(candidatACreer);
		List<Candidat> resultat = business.findByUniversiteOrigine("UBO");
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getPrenom()).isEqualTo("prenom1");
	}

}

class CandidatRepositoryList implements CandidatRepository {
	private List<Candidat> data;

	public CandidatRepositoryList() {
		data = Lists.newArrayList();
	}

	@Override
	public <S extends Candidat> S save(S entity) {
		data.add(entity);
		return entity;
	}

	@Override
	public <S extends Candidat> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Candidat findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Candidat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Candidat> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {

		return data.size();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Candidat entity) {
		data.remove(entity);

	}

	@Override
	public void delete(Iterable<? extends Candidat> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Candidat> findByNom(String nom) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getNom() == nom) {
				List<Candidat> data2 = Lists.newArrayList();
				data2.add(data.get(i));
				return data2;
			}
		}

		return null;
	}

	@Override
	public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getUniversiteOrigine() == universiteOrigine) {
				List<Candidat> data2 = Lists.newArrayList();
				data2.add(data.get(i));
				return data2;
			}
		}

		return null;
	}

}
