package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {

	void deleteById(int id);

	Contrat ajouterContrat(Contrat contrat);

	Optional<Contrat> FindContratById(int id);

	List<Contrat> getallContrats();

	Contrat updateContrat(Contrat contrat);

	void deleteContrat(int Id);

	Contrat getContratById(int reference);

}
