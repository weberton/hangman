pipeline {
    agent any

  environment {
    PATH = "/opt/maven/bin:$PATH"
  }

    stages {


         stage('Clean') {
             steps {
             script {
              sh 'ls /opt'
             }
             echo "PATH is: $PATH"
                       sh 'mvn clean package'
              }
         }

        stage('Files') {
            steps {

                script {
                    sh 'ls /opt/'
                    def folders =  findFiles(glob: '**/*')
                         .findAll { f -> f.directory }
                 }
            }
        }
    }
}
