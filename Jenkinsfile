pipeline {
    agent any  // General agent for the pipeline

    stages {
        stage('Build') {
            agent {  // Specify agent for this particular stage
                docker {
                    image 'node:18-alpine'
                    reuseNode true
                }
            }
            steps {
                sh '''
                    ls -la
                    node --version
                    npm --version
                    npm ci
                    npm run build
                    ls -la
                '''
            }
        }
    }
}
