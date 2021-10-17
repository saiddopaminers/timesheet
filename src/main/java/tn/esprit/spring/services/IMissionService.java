package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {

	Mission ajouterMission(Mission mission);

	List<Mission> getallMissions();

	void deleteMission(int Id);

	Mission updateMission(Mission mission);

	Optional<Mission> FindMissionById(int id);

	void affecterMissionADepartement(int i, int j);
	void deleteById(int id);
	

}
