package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {

	public void deleteById(int id);

	public Contrat ajouterContrat(Contrat contrat);

	public Optional<Contrat> FindContratById(int id);

	public List<Contrat> getallContrats();

	public Contrat updateContrat(Contrat contrat);

	public void deleteContrat(int Id);

	public Contrat getContratById(int reference);

	public Contrat affecterContratAEmploye(int idC, int employeId);

}
