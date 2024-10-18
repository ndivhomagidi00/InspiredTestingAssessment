pipeline {
    agent any

    stages {
        stage('Build') {
            agent { 
                docker {
                    image 'node:18-alpine'
                    reuseNode true
                }
            }
            steps {
                script {
                    // Adjust the workspace path if running on Windows
                    def workspace = isUnix() ? pwd() : pwd().replaceAll('C:', '/c').replaceAll('\\\\', '/')
                    echo "Using workspace: ${workspace}"
                    
                    // Run the steps inside the Docker container
                    docker.image('node:18-alpine').inside("-w ${workspace}") {
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
    }
}
