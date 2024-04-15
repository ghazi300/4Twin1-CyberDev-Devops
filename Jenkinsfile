pipeline {
    agent any
    
    tools {
        // Define the Maven tool installation
        maven 'maven_3.8.7'
        // Add any other tools you need here
    }
    
    stages {
        stage('Checkout git') {
            steps {
                // Checkout the code from the GitHub repository
                git branch: 'mohamedyassine', url: 'https://github.com/ghazi300/4Twin1-CyberDev-Devops.git'
            }
        }
        
        stage('Build & JUnit Test') {
            steps {
                dir('DevOps_Project') {
                    // Build the project and run JUnit tests
                     sh 'mvn install'
                }    
                
            }
            post {
                success {
                    // Archive JUnit test results
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
        
        stage('Maven Build') {
            steps {
                // Build the project with Maven, skipping tests
                sh 'mvn package -DskipTests=true'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Define the SonarQube scanner tool
                    def scannerHome = tool 'scanner'
                    // Execute SonarQube analysis
                    withSonarQubeEnv {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }
}
