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
                sh 'nohup your_command' // Dodany krok uruchamiający nohup
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
