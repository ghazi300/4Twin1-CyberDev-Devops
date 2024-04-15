pipeline {
    agent any
    tools { 
        maven 'maven_3.8.7'
    }
    
    stages {
        stage('Checkout git') {
            steps {
               git branch: 'mohamedyassine', url: 'https://github.com/ghazi300/4Twin1-CyberDev-Devops.git'
            }
        }
        
        stage ('Build & JUnit Test') {
            steps {
                sh 'mvn install' 
            }
            post {
               success {
                    junit 'target/surefire-reports/**/*.xml'
                }   
            }
        }
          
        
        
        stage("Maven Build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
                }
            }
        }

        
        
        
        
   

       
    

    }

}