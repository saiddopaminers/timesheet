  pipeline {
      environment{
        
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
          
  }}
