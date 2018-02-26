package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.EnseignantBusinessJPA;
import fr.univbrest.dosi.repositories.EnseignantRepository;

public class EnseignantBusinessJPATest {

	EnseignantBusinessJPA business;

	@Test
	public void doitCreerUnEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant1ACreer = new Enseignant(7,"hakkou.mer@gmail.com", "HAKKOU", "Meryem") ;
		Enseignant enseignant2ACreer = new Enseignant(8,"aline.hakkou@gmail.com", "HAKK", "Aline") ;

		 business.creerEnseignant(enseignant1ACreer);
		 business.creerEnseignant(enseignant2ACreer);
		 long resultat = repos.count();
			assertThat(resultat).isEqualTo(2);
	}
	@Test
	public void doitSupprimerUnEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant1ACreer = new Enseignant(7,"hakkou.mer@gmail.com", "HAKKOU", "Meryem") ;
		 business.creerEnseignant(enseignant1ACreer);
		 business.supprimerEnseignant(enseignant1ACreer);
		 long resultat = repos.count();
			assertThat(resultat).isEqualTo(0);
	}
	@Test
	public void doitChercherUnEnseignantParNom() {
		EnseignantRepository repos = new EnseignantRepositoryList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant enseignant1ACreer = new Enseignant(7,"hakkou.mer@gmail.com", "HAKKOU", "Meryem") ;
		Enseignant enseignant2ACreer = new Enseignant(8,"aline.hakkou@gmail.com", "HAKK", "Aline") ;
		 business.creerEnseignant(enseignant1ACreer);
		 business.creerEnseignant(enseignant2ACreer);
		 List<Enseignant> resultat= business.RechercherParNomEnseignant("HAKKOU");
			assertThat(resultat.get(0).getPrenom()).isEqualTo("Meryem");
	}
}
class EnseignantRepositoryList implements EnseignantRepository {
	private List<Enseignant> data;

	public EnseignantRepositoryList() {
		data = Lists.newArrayList();
	}
	@Override
	public <S extends Enseignant> S save(S entity) {
	data.add(entity);
		return entity;
	}

	@Override
	public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enseignant findOne(Long id) {
		
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Enseignant> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		
		return data.size();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Enseignant entity) {
		data.remove(entity);
		
	}

	@Override
	public void delete(Iterable<? extends Enseignant> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public Enseignant findByNoEnseignant(long noEnseignant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enseignant> findByNom(String  nom) {
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).getNom() == nom) {
				List<Enseignant> data2 = Lists.newArrayList();
				data2.add(data.get(i));
				return data2;
			}
		}
		return null;
	}
	@Override
	public List<Enseignant> findByEmailUbo(String emailUbo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}