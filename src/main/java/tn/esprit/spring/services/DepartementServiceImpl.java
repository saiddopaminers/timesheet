package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {
	@Autowired
	DepartementRepository departementRepository;
	private static final Logger L = LogManager.getLogger(DepartementServiceImpl.class);
	
	@Override
	public int ajouterDepartement(Departement departement) {
		departementRepository.save(departement);
		return departement.getId();
	}

	@Override
	public String getDepartementNameById(int departementId) {
		Departement dep = departementRepository.findById(departementId).get();
		return dep.getName();
	}

	@Override
	public List<Departement> getAllDepartement() {
		return (List<Departement>) departementRepository.findAll();
	}

	@Override
	public void deleteDepartementById(int departementId) {
		Departement departement= departementRepository.findById(departementId).get();
		departementRepository.delete(departement);
		
	}

	@Override
	public void deleteAllDepartements() {
		departementRepository.deleteAll();
		
	}

	@Override
	public String addDepartement(Departement d) {
		departementRepository.save(d);
		return"done";
	}

	@Override
	public List<Departement> retrieveAllDepartement() {
		List<Departement> departement = (List<Departement>) departementRepository.findAll();

		for (Departement d : departement){
			L.info("d +++ :" + d);
		}
		return departement;

	}
	
	
	
	
	
}
