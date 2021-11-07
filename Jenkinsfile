pipeline {
    environment { 

        registry = "siwar/Timesheet" 

        registryCredential = 'dockerHub' 

        dockerImage = '' 

    }
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
    
                    bat "mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:9999/repository/maven-releases/ -Dfile=target/Timesheet-1.0.war"
                
                        }
            }
            
            
		
}

post {
         failure {  
             mail bcc: '', body: 'error text', cc: '', from: '', replyTo: '', subject: 'error', to: 'berzougasiwar20@gmail.com'         
         }
         success{  
             mail bcc: '', body: 'success text', cc: '', from: '', replyTo: '', subject: 'success', to: 'berzougasiwar20@gmail.com'         
         }
     }
}
