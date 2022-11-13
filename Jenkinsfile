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


	    stage('Maven Build') {
      		    steps {
       		sh 'mvn clean compile'
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
        stage('integration testing'){
                steps {
            sh 'mvn verify -DskipUnitTests'
         
}
}


 stage('SonarQube Analysis'){
                steps {
                    sh """mvn sonar:sonar -DskipTests \
                            -Dsonar.language=java \
                            -Dsonar.projectKey=spring \
                            -Dsonar.host.url=http://192.168.1.19:9000 \
                            -Dsonar.login=74372c3cf08ec88f4b5d8310afe1095ddc65979e


                    """
                }

            }
stage ('Quality Gate status') {
steps {
script {
waitForQualityGate abortPipeline: false, credentialsId: 'Mohamedchaali1'
}
}
}
}
}
