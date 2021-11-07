pipeline {
    agent any
    stages{
            stage('checkout git'){
                steps {
                    echo 'Pulling...';
                    git branch: 'siwar', url: 'https://github.com/saiddopaminers/timesheet.git';
                    }
               }
               
                stage('Test, build, sonar'){
                    steps{
                        bat "mvn package sonar:sonar "

                            }
                }
                
                
            stage("Lancer les tests unitaires") {
                 steps {
                    script {
                         bat "mvn test "
                            }
                         }
            }  
            
            stage('Créer le livrable sous le dossier target') {
                steps {
                    bat "mvn clean install"
                        }
             }
                          
                          
            stage("publish to nexus") {
                steps {
    
                    bat "mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:9999/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.war"
                
                        }
            }
}
post{
		success{
			emailext body: 'Build success', subject: 'Jenkins', to:'siwar.berzouga@esprit.tn'
		}
		failure{
			emailext body: 'Build failure', subject: 'Jenkins', to:'siwar.berzouga@esprit.tn'
		}
	}
}
