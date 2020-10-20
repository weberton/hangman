pipeline {
    agent any

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
