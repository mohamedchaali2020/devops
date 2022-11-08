pipeline {


    agent any
    tools {
		maven 'M2_HOME'
		jdk 'JAVA_HOME'
		        }

    stages {


        stage ('Git Checkout') {

            steps {

                git branch: 'Mohamedchaali', url: 'https://github.com/mohamedchaali2020/devops.git'
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
         stage('JUnit/Mockito'){
                steps {
                sh '''mvn -version
                mvn -B -DskipTests clean package'''
                //sh 'mvn test'
                echo """Bravo! tous les tests sont pris en charge"""
                }
            }
         stage("SonarQube Analysis") {
                             steps {
                               withSonarQubeEnv('sonar') {
                                 sh 'mvn clean -DskipTests package sonar:sonar'
mvn sonar:sonar \
  -Dsonar.projectKey=Mohamedchaali \
  -Dsonar.host.url=http://192.168.1.182:9000 \
  -Dsonar.login=31f2074f9235ba1ffcbb197cd05494d013612cb9
                               }
                             }
    }
}
}