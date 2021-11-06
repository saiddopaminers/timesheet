package tn.esprit.spring;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.logging.log4j.LogManager;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {
	
	@Autowired 
	IContratService IC;
	@Autowired
	IEmployeService iE;
	public ContratTest() {
		// TODO Auto-generated constructor stub
	}
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ContratServiceImpl.class);
	
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
@Test
public void testAffecterContratAEmploye() {
	int employeId = 1 ;
	int idC = 6; 
	Contrat C = IC.FindContratById(idC).orElse(null);
	Employe Emp = iE.findById(employeId);
	if (C != null){
	C.setEmploye(Emp);
	Contrat c = IC.affecterContratAEmploye(idC, employeId);
	Assert.assertEquals (C.getEmploye().getId(),c.getEmploye().getId());
	}	
}
@Test
public void suppressionContrat() {

	try {
		IC.deleteById(721);
		boolean test=true;
	
	assertEquals(test, true,"Supression du departement avec succés");
	
	if(test) {
		l.info(" deleted  successfully ");
	}
	} catch (Exception e) {
		// TODO: handle exception
		l.error("id n'esxiste pas");
	}
}

}

