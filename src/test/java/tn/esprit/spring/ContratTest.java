package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.LogManager;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {
	

	public ContratTest() {
		// TODO Auto-generated constructor stub
	}
@Autowired 
IContratService IC;
@Autowired
IEmployeService iE;


@Test
public void testgetAllContrats() {
	List<Contrat> contrats = (List<Contrat>) IC.getallContrats();
	assertThat(contrats).size().isGreaterThan(0);
}
@Test
public void testajouterContrat() throws ParseException , java.text.ParseException{
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = dateFormat.parse("2021-06-09");
	Contrat u = new Contrat(date,"stage",200);
	iE.ajouterContrat(u);
	
	}

}

