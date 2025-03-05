pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/piotrekk10/t-mobile-cucumber'
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
        stage('Report') {
            cucumber buildStatus: 'UNSTABLE',
                            reportTitle: 'Cucumber tests report',
                            fileIncludePattern: 'target/cucumber-reports/*.json',
                            trendsLimit: 10,
                }
        }
    }
}