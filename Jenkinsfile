  pipeline {
      environment{
          registry = 'souma0720/timesheet.git'
		registryCredential= 'dockerhub'
		dockerImage = ''
	}
  agent any 

  stages {
        stage("clone code") {
            steps {
                script {
               
                 git branch:'soumaaa' , url :'https://github.com/saiddopaminers/timesheet.git'
                }
            }
          } 
          
             stage("Build et Test") {
            steps {
                script {
                    
                bat 'mvn clean package'
                }
            }
          } 
       stage("SonarQube") {
            steps {
                script {
                    
                bat 'mvn sonar:sonar'
                }
            }
          } 
       stage("DeployNexus") {
            steps {
                script {
       
            bat'mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet -Dversion=1.0 -DgeneratePom=true -Dpackaging=war -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-1.0.war'
                    
                }
            }
          } 
  
             /* stage("EmailNotification") {
            steps {
                script {
                   mail bcc: '', body: '''hello , welcome to jenkins  your build is success
                    thanks''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'noreplyjrl@gmail.com' 
    
                    
                }
            }}*/
 
		stage('Building our image'){
			steps{ 
				script{ 
					dockerImage= docker.build registry + ":$BUILD_NUMBER" 
				}
			}
		}
		stage('Deploy our image'){
			steps{ 
				script{
					docker.withRegistry( '', registryCredential){
						dockerImage.push()
					} 
				} }
}
  }
  
           post {
    always {
       mail to: 'noreplyjrl@gmail.com' ,
          subject: "Status of pipeline: ${currentBuild.fullDisplayName}",
          body: "${env.BUILD_URL} has result ${currentBuild.result}"
   
       }    
        }
          
      
  }
