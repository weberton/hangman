pipeline {
        agent {
            docker {
                image 'maven:3-alpine'
                args '-v /root/.m2:/root/.m2'
            }
        }

    stages {


         stage('Clean') {
             steps {
                       sh 'mvn clean package'
              }
         }

        stage('Files') {
            steps {

                script {
                    def folders =  findFiles(glob: '**/*')
                         .findAll { f -> f.directory }
                 }
            }
        }
    }
}
