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
            
            sh "mvn test"
                echo """Bravo! tous les tests sont pris en charge"""
                }
            }
        stage('integration testing'){
                steps {
            sh 'mvn verify -DskipUnitTests'
         
}
}

stage("Sonar") {
            steps {
                sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=root"
            }
        }


 
 
stage('upload war file to Nexus') {
            steps {
                script{
def readPomVersion = readMavenPom file: 'pom.xml'
nexusArtifactUploader artifacts: [
[
artifactId: 'achat', 
classifier: '', file: 'target/tpmagasin.jar', 
type: 'jar'
]
],
credentialsId: 'nexus-auth', 
groupId: 'tn.esprit.rh', 
nexusUrl: '192.168.1.192:8081', 
nexusVersion: 'nexus3', 
protocol: 'http', 
 repository: 'devops-releas', 
 version: "${readPomVersion.version}"
 }
            }
        }
        
         stage('Build Docker Image'){
                      steps {
                          script{
          				    sh 'docker image build  -t mohamedchaali/achat .  '
                          }
                      }
          		}
          		stage('Docker login') {
                                steps {
                                    script {
                                        sh 'docker login -u mohamedchaali -p 203JMT1226'}
                                }
                                }
                          stage('Pushing Docker Image') {
                                steps {
                                    script {
                                     sh 'docker push mohamedchaali/achat'
                                    }
                          }
                          }
                          stage('Run Spring && MySQL Containers') {
                                steps {
                                    script {
                                      sh 'docker-compose up -d'
                                    }
                                }
                            }


     }

post {
        success {
             mail to: "mohamed.chaali@esprit.tn",
                    subject: "Build sucess",
                    body: "sucess"
            echo 'successful'
        }
        failure {
             mail to: "mohamed.chaali@esprit.tn",
                    subject: "Build failed",
                    body: "failed"
            echo 'failed'
        }
      }
     }

