pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
       // maven "M3"
       maven "Maven_Home"
    }

    stages {
        stage('Stage 1- Checkout code') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/ndivhomagidi00/InspiredTestingAssessment.git'

            }

           
        }
         stage('Stage 2- Compile code') {
            steps {
                // Get some code from a GitHub repository
               bat "mvn clean compile"

            }

           
        }
         stage('Stage 3- Run Test') {
            steps {
                // Get some code from a GitHub repository
               bat "mvn test"

            }

           
        }
         stage('Stage 4- Deploy') {
            steps {
                // Get some code from a GitHub repository
               //bat "mvn clean pacakage"
               echo 'Done'

            }
   
           
        }
     
    }
}//done
