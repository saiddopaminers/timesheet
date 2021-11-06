package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartementService {

	public int ajouterDepartement(Departement departement);
	public String getDepartementNameById(int departementId);
	public List<Departement> getAllDepartement();
	public void deleteDepartementById(int departementId);
	public void deleteAllDepartements();
	
	public String addDepartement(Departement d);
	public List<Departement> retrieveAllDepartement();
	
	
	
}
