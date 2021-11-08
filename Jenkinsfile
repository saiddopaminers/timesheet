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
          
  }}
