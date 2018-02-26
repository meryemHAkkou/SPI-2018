package fr.univbrest.dosi.repositories;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.CandidatRepository;
@RunWith(SpringJUnit4ClassRunner.class)
public class CandidatRepositoryTest {
	@Autowired  
	CandidatRepository candidatRepo;
	
	@Before
	public void setup() {
		
	
		Candidat candidat1 = new Candidat("1","nom1", "prenom1", "UBO");
		Candidat candidat2 = new Candidat("2","nom2", "prenom2", "UBO");
		candidatRepo.save(candidat1);
		candidatRepo.save(candidat2);
	}
	
	
	@Test
	public void doitCompterLesCandidats() {
		long resultat = candidatRepo.count();
		
		assertThat(resultat).isEqualTo(2);
	}
	@Test
	public void doitRechercherParNomFormation() {
		List<Candidat> resultat = candidatRepo.findByNom("nom1");
		
		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getPrenom()).isEqualTo("prenom1");
		assertThat(resultat.get(0).getUniversiteOrigine()).isEqualTo("UBO");
	}
	@Test
	public void doitRechercherParUniversiteOrigine() {
		List<Candidat> resultat = candidatRepo.findByUniversiteOrigine("UBO");
		
		assertThat(resultat).hasSize(2);
		assertThat(resultat.get(0).getPrenom()).isEqualTo("prenom1");
		assertThat(resultat.get(0).getNom()).isEqualTo("nom1");
		assertThat(resultat.get(1).getPrenom()).isEqualTo("prenom2");
		assertThat(resultat.get(1).getNom()).isEqualTo("nom2");
	}
	
}
