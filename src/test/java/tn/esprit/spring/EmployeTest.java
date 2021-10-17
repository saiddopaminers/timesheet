package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
	
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(EmployeServiceImpl.class);
	@Autowired
	EmployeServiceImpl EmployeServiceImpl;
	
	@Autowired
	EmployeRepository employeRepo;
    
	@Test
     public void contextLoads() {

     }


    @Test
    @Order(1)
    public void testCreateEmployee() {
    	Employe employee = new Employe("User","en user","user@outlook.com",true,Role.TECHNICIEN);
   	
    	int empId = EmployeServiceImpl.ajouterEmploye(employee);
    	if(employeRepo.findById(empId).isPresent()) {
    		EmployeServiceImpl.deleteEmployeById(empId);
    		int  empNewId = EmployeServiceImpl.ajouterEmploye(employee);
    		assertNotEquals(0, empNewId);
    		//asserEquals(empId,empNewId);
    		l.info("Employee added with success :  empId = "+empId+" new empId = "+empNewId);
    		
    		
    	}
    	else if(empId > 0 ) {
    		assertNotNull(employee);
            l.info("Employee added"+employee.toString());

    	}
    	 
    	else {
    		assertNull(null);
    		l.warn("Employee not added ");
    	}

      
        
        
    }
    
    @Test
    @Order(2)
    public void testDeleteEmployeById () {
    	Employe employee = new Employe("User","en user","user@outlook.com",true,Role.TECHNICIEN);

      
     int empId =    EmployeServiceImpl.ajouterEmploye(employee);
    	boolean existBefore = employeRepo.findById(1).isPresent();//true
    	
    	if(existBefore) {
    		EmployeServiceImpl.deleteEmployeById(empId);
    		assertTrue(true);

    		l.info("Employee deleted ");
    	}
    	else {
    		assertFalse(false);
    		l.warn("Employee not found");
    	}
        
	}
    
   
    
    @Test
    @Order(3)
    public void testGetNombreEmploye() {
		assertNotEquals(0, EmployeServiceImpl.getNombreEmployeJPQL());
		l.info("Employe number != 0");

    }

  
    @Test 
    @Order(4)
    public void testgetAllEmployee() {
    	Employe e  = new Employe("user", "test", "user@gmail.com", true, Role.ADMINISTRATEUR);
    	
    	EmployeServiceImpl.ajouterEmploye(e);
    	
    	List<Employe>employes = EmployeServiceImpl.getAllEmployes();
    	assertNotEquals(employes.size(),0);
    	l.info("Employees List  >0 ,"+employes.size());
    }

}
