package tn.esprit.spring.services;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import javax.transaction.Transactional;

	import org.apache.logging.log4j.LogManager;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;



	import tn.esprit.spring.entities.Departement;
	import tn.esprit.spring.entities.Mission;
	import tn.esprit.spring.repository.DepartementRepository;
	import tn.esprit.spring.repository.MissionRepository;

	@Service
	public class MissionService  implements IMissionService{
		
		
		@Autowired
		MissionRepository missionRepository;
		@Autowired
		DepartementRepository deptRepoistory;
			
		public MissionService() {
			super();
			// TODO Auto-generated constructor stub
		}




		private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(MissionService.class);
@Override
		
		public  void deleteById(int id) {
			missionRepository.deleteById(id);
		}
	@Override

			public Mission ajouterMission(Mission mission) {
				missionRepository.save(mission);
				
				return mission;
			}


	@Override


			public Optional<Mission> FindMissionById(int id) {
	        Optional<Mission> mission=missionRepository.findById(id);
				return mission;
			}

			
			
			@Override
			public List<Mission> getallMissions() {
			
				List<Mission> missions =(List<Mission>) missionRepository.findAll();
				for (Mission mission : missions) {
					
					l.info("missions :" +mission);
				}
				return missions;
			}

			
		
			
			@Override
			public void deleteMission(int Id) {
				missionRepository.deleteById(Id);
				System.out.println("********************");
				l.info("Service: Fetching mission with id", Id);
				
			}
		
			@Override
			public Mission updateMission(Mission mission) {
				// TODO Auto-generated method stub
				
				return missionRepository.save(mission);
			}
			@Override
			public void affecterMissionADepartement(int missionId, int depId) {
				Mission mission = missionRepository.findById(missionId).get();
				Departement dep = deptRepoistory.findById(depId).get();
				mission.setDepartement(dep);
				missionRepository.save(mission);
				
			}
		}


