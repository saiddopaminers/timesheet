package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

public class DepartementServiceImpl implements IDepartementService {
	@Autowired
	DepartementRepository departementRepository;

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
	
	
	
	
	
}
