package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;
import tn.esprit.spring.services.MissionService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionTest {
	@Autowired
	IMissionService im;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(MissionService.class);
@Test

	public void testDeleteMission()  throws Exception {
		Mission mission =im.FindMissionById(2).get();
		
		im.deleteMission(2);
		Mission mission1=null;
		Optional<Mission> optionalMission=im.FindMissionById(1);
		if(optionalMission.isPresent()) {
		mission1= optionalMission.get();
		}
		Assertions.assertThat(mission1).isNull();
		
	//	fail("Une exception de type IllegalStateException aurait du etre levee");
		}
		
	
	@Test 
	public void testRetrieveAllMissions() {

		List<Mission> mission=im.getallMissions();
		Assertions.assertThat(mission.size()).isGreaterThan(0);

	}
	@Test
	public  void ajouterMission() throws ParseException {
		Mission m = new Mission("wevioo","it");
		//Assertions.assertEquals("wevio",im.ajouterMission(m),"ajout du société wevioo failed");

		im.ajouterMission(m);
		assertThat(m.getName()).isEqualTo("sagem");

		 	}
	@Test
	public void testUpdateMission() throws ParseException {

		Mission m = im.FindMissionById(3).get();
				//new Mission ("WEVIOO","IT");
		m.setDescription("wevioo");	
		im.updateMission(m);
		assertNotEquals("It", im.FindMissionById(3).get().getDescription());
		l.info("retrievemission: "+ m);
		l.error("mission n'existe pas");
	}
	@Test
	public void affecterMissionADepartement()  throws ParseException {
		im.affecterMissionADepartement(3, 2);
	}

}

