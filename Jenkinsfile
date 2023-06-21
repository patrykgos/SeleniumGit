pipeline {
    agent any
    stages {
        stage('Build test code') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('Execute test') {
            steps {
                bat 'start /B cmd /C your_command' // Uruchomienie procesu w tle w systemie Windows
                sh 'mvn test'
            }
        }
        stage('Generate allure report') {
            steps {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
