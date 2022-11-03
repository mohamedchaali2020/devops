pipeline {


    agent any
    tools {
		maven 'M2_HOME'
		        }

    stages {


        stage ('Git Checkout') {

            steps {

                git branch: 'main', url: 'https://github.com/mohamedchaali2020/devops.git'
            }
        }
        
        stage('Cleaning the project') {
                 steps{
                    sh "mvn -B -DskipTests clean  "
                    }
                }


	    stage('Build') {
      		    steps {
       		sh 'mvn -B -DskipTests clean package'
      	          }
           	}
        
        
    }
}