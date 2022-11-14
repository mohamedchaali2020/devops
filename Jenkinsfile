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
        
        
       stage('Maven version'){
            steps{
                echo "Mavin version ...";
                sh "mvn -version"
            }
        }
         stage('Clean Maven install'){
            steps {
                sh 'mvn clean install'
            }

        }
         stage('Compile Project'){
            steps {
                sh 'mvn compile  -DskipTests'
            }
        }
         stage ('Mockito/Junit') {
             steps {
            sh 'mvn test -Dtest="FactureServiceImplMockito" '
            sh 'mvn test -Dtest="ReglementServiceImpTest" '
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
                    script{
withSonarQubeEnv(credentialsId: 'spring') {
    sh 'mvn clean package sonar:sonar'
}


}
                }

            }
stage ('Quality Gate status') {
steps {
script {
waitForQualityGate abortPipeline: false, credentialsId: 'spring'
}
}
}
stage('Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }
}
}
