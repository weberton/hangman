pipeline {
    agent any

  environment {
    PATH = "/opt/maven/bin:$PATH"
  }

    stages {


         stage('Clean') {
             steps {
             echo "PATH is: $PATH"
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
