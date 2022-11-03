pipeline {


    agent any
    stages {


        stage ('Git Checkout') {

            steps {

                git branch: 'main', url: 'https://github.com/mohamedchaali2020/devops.git'
            }
        }
        stage ('UNIT testing') {

            steps {

                sh 'nvm test'
            }
        }
        
        
    }
}