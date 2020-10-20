pipeline {
    agent any

    stages {

        stage('Create file') {
                stage('Clean') {
                    steps {
                       sh 'mvn clean package'
                    }
                }
            steps {

                script {
                    def folders =  findFiles(glob: '**/*')
                         .findAll { f -> f.directory }
                 }
            }
        }
    }
}
