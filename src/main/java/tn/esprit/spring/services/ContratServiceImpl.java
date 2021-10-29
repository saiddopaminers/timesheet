package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;


import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService{

	@Autowired
	ContratRepository contratRepository;
	public ContratServiceImpl() {

	}

	@Override
			
			public  void deleteById(int id) {
				contratRepository.deleteById(id);
			}
		@Override
		

				public Contrat ajouterContrat(Contrat contrat) {
					contratRepository.save(contrat);
					
					return contrat;
				}


		@Override


				public Optional<Contrat> FindContratById(int id) {
		        Optional<Contrat> contrat=contratRepository.findById(id);
					return contrat;
				}

				
				
				@Override
				
				public List<Contrat> getallContrats() {
				
					List<Contrat> contrats =(List<Contrat>) contratRepository.findAll();
					for (Contrat contrat :contrats) {
						
					
					}
					return contrats;
				}

				
			
			
				@Override
				public void deleteContrat(int Id) {
					contratRepository.deleteById(Id);
					
					
				}
				@Override
				public Contrat getContratById(int reference) {
					return contratRepository.findById(reference).get();	}
			
				
				@Override
				public Contrat updateContrat(Contrat contrat) {

					
					return contratRepository.save(contrat);
				}
				
}
