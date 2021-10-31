package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IMissionService;
import tn.esprit.spring.services.MissionService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionTest {
	@Autowired
	IMissionService im;
	@Autowired 
	DepartementRepository departementRepository;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(MissionService.class);

	//Methode sert à tester l'ajout

	@BeforeAll
	
	public  void ajouterMissionTest() throws ParseException {
		Mission m = new Mission();
		m.setId(10);
		m.setName("SagemCom");
		m.setDescription("embarqué");
		im.ajouterMission(m);
		assertThat(m.getName()).isEqualTo("SagemCom");

	}
	//Methode sert à tester l'affichage
	@Test 
	public void testRetrieveAllMissionsTest() {
		try {
			List<Mission> mission=im.getallMissions();
			Assertions.assertThat(mission.size()).isGreaterThan(0);
			l.info("out RetrieveAllMissions () without errors.");
		}
		catch(Exception e) {
			l.error("Erreur dans RetrieveAllMissions()"+e);
		}
	}

	//Methode sert à tester l'update
	@Test
	public void testUpdateMissionTset() throws ParseException {
		try {
			Mission m = im.FindMissionById(2).get();
			m.setName("wevioo");	
			im.updateMission(m);
			assertNotEquals("it" ,im.FindMissionById(2).get().getName());
			l.info("retrievemission: "+ m);}
		catch (Exception e) {
			l.error("id n'esxiste pas"+e);}
	}
	
	/*@Test
	public void affecterMissionADepartementTest()  throws ParseException {
		/*Entreprise e = new Entreprise("orange","telecome");
		entrepriseRepository.save(e);*/
		/*im.affecterMissionADepartement(2,2);
		assertTrue(true);
		l.info("Mission affecté à un departement");


	}*/

	@AfterAll
	public void tearDown() {
		im.deleteById(1);
	}
	//Methode sert à tester la suppression 
	@Ignore	("Do not run always")	
	@Test
	public void DeleteMissionTest() throws Exception {
		Mission mission =im.FindMissionById(5).get();
		im.deleteMission(5);
		Mission mission1=null;
		Optional<Mission> optionalMission=im.FindMissionById(1);
		if(optionalMission.isPresent()) {
			mission1= optionalMission.get();
		}
		Assertions.assertThat(mission1).isNull();

	}}








