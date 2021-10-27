package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.services.IEntrepriseService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
 
	@Autowired
	IEntrepriseService es;

	

	@Test
	public void testAjouterEntreprise() {
		Entreprise e = new Entreprise("Esprit","Educational");
		es.ajouterEntreprise(e);
		assertThat(e.getId()).isPositive();
	}

	@Test
	public void testFindEntrepriseById() {
		Entreprise entreprise = es.getEntrepriseById(2);
		assertThat(entreprise.getId()).isEqualTo(2);
	}

	

	@Test
	public void testUpdateEntreprise() {
		Entreprise entreprise = es.getEntrepriseById(1);
		entreprise.setName("Esprit2");
		int entrepriseId = es.ajouterEntreprise(entreprise);
		Entreprise updatedEntreprise = es.getEntrepriseById(entrepriseId);
		assertThat(updatedEntreprise.getName()).isEqualTo(entreprise.getName());
	}

	@Test
	public void testRetriveAllEntreprises() {
		List<Entreprise> Entreprises = (List<Entreprise>) es.getAllEntreprises();
		assertThat(Entreprises).size().isPositive();
	}
	}