package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
 
	@Autowired
	IEntrepriseService enterpriseRepository;

	@Autowired
	IEmployeService iemployeservice;

	@Test
	public void testAjouterEntreprise() {
		Entreprise e = new Entreprise("Esprit","Educational");
		enterpriseRepository.ajouterEntreprise(e);
		assertThat(e.getId()).isGreaterThan(0);
	}

	@Test
	public void testFindEntrepriseById() {
		Entreprise entreprise = enterpriseRepository.getEntrepriseById(2);
		assertThat(entreprise.getId()).isEqualTo(2);
	}

	

	@Test
	public void tesUpdateEntreprise() {
		Entreprise entreprise = enterpriseRepository.getEntrepriseById(1);
		entreprise.setName("Esprit2");
		int entrepriseId = enterpriseRepository.ajouterEntreprise(entreprise);
		Entreprise updatedEntreprise = enterpriseRepository.getEntrepriseById(entrepriseId);
		assertThat(updatedEntreprise.getName()).isEqualTo(entreprise.getName());
	}


	}