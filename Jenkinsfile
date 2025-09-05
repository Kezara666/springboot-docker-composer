pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Kezara666/springboot-docker-composer.git'
            }
        }

        stage('Login to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    bat """
                    echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
                    """
                }
            }
        }
        
        stage('Clean Existing Containers') {
            steps {
                bat '''
                    docker stop demo-app || exit 0
                    
                    docker rm demo-app || exit 0
                    docker stop demo-mysql || exit 0
                    docker rm demo-mysql || exit 0
                '''
            }
        }

        stage('Build & Push with Docker Compose') {
            steps {
                bat '''
                docker-compose down || exit 0
                docker-compose build
                docker-compose push
                docker-compose up -d
                '''
            }
        }
    }

    post {
        always {
            bat 'docker logout'
        }
    }
}