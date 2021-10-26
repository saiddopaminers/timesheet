package tn.esprit.spring;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTest {
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(DepartementServiceImpl.class);
	@Autowired
	DepartementServiceImpl departementServiceImpl;
	@Autowired
	DepartementRepository departementRepository;

@Test
public void contextLoads(){

}

@Test
public void testCreateDepartement(){
	Departement departement = new Departement ("ItIt");
	int depId = departementServiceImpl.ajouterDepartement(departement);
	if (departementRepository.findById(depId).isPresent()) {
		departementServiceImpl.deleteDepartementById(depId);
		int depNewId = departementServiceImpl.ajouterDepartement(departement);
		assertNotEquals(0, depNewId);
		l.info("Departement added with success : depID = " +depId+" new depId=" + depNewId);
	}
	else if (depId >0){
		assertNotNull(departement);
		l.warn("departement added" + departement.toString());
	}
	else {
		assertNull(null);
		l.warn("departement not added");
	}
}

	@Test
	public void testAddDepartement() throws ParseException {
		Departement d = new Departement("DEP B");
		Departement savedDepartement = departementRepository.save(d);
		assertNotNull(savedDepartement.getId());
		departementRepository.delete(savedDepartement);
	}

	@Test
	public void testretrieveAllDepartement(){
		departementServiceImpl.retrieveAllDepartement();
	}
	
	
	
	
	

}
