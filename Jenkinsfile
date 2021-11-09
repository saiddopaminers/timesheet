pipeline {
agent any
environment { 

        registry = "saidali12/Timesheet" 

        registryCredential = 'dockerHub' 

        dockerImage = '' 
        PATH = "D:\\Program Files\\Git\\usr\\bin;D:\\Program Files\\Git\\bin;${env.PATH}"

    }
stages{
stage('checkout git'){
steps {
    echo 'Pulling...';
    git branch: 'main', url: 'https://github.com/saiddopaminers/Timesheet';
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
              
    
       bat "mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo  -Durl=http://localhost:8083/repository/maven-releases/  -Dfile=target/Timesheet-1.0.war"
                
            }
        }
stage('Build Docker Image') {

			steps {
				bat 'docker build -t saidali12/timesheet:latest .'
			}
		}

		stage('Push') {

			steps {
			    bat'docker login -u "saidali12" -p "said121212" docker.io '
			    bat 'docker push saidali12/timesheet:latest'
			}
			
		}
		stage('Cleaning up'){
			steps{
			    bat'docker login -u "saidali12" -p "said121212" docker.io '
				bat "docker rmi saidali12/timesheet:latest" 
			}
		}  
}
post {
         failure {  
             mail bcc: '', body: 'error text', cc: '', from: '', replyTo: '', subject: 'error', to: 'saidsaidsaid123456789012@gmail.com'         
         }
         success{  
             mail bcc: '', body: 'success text', cc: '', from: '', replyTo: '', subject: 'success', to: 'saidsaidsaid123456789012@gmail.com'         
         }
     }
}