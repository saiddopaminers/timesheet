package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;

import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class ContratServiceImpl implements IContratService{

	@Autowired
	ContratRepository contratRepository;
	@Autowired
	EmployeRepository employeRepository;
	public ContratServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ContratServiceImpl.class);
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
						
						l.info("contrats :" +contrat);
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
					// TODO Auto-generated method stub
					
					return contratRepository.save(contrat);
				}
				
				public Contrat affecterContratAEmploye(int contratId, int employeId) {
					try {
						l.info("In affecterContratAEmploye : ");
						Contrat contratManagedEntity = contratRepository.findById(contratId).orElse(null);
						l.debug("Contrat par identifiant");
						Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);
						l.debug("Employe par identifiant");

						if (contratManagedEntity != null) {
							l.debug("In If ");
							contratManagedEntity.setEmploye(employeManagedEntity);
							l.info("L'affectation a été faite");
							Contrat c = contratRepository.save(contratManagedEntity);
							l.info("Out of affecterContratAEmploye ");
							return c;
						}
						return null;
					} catch (Exception e) {
						l.error("erreur In affecterContratAEmploye() : Failed to affect " + e);
						return null;
					}

				}
}
