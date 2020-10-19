pipeline {
    agent any

    stages {

        stage('Create file') {
            steps {

                script {
                    def folders =  findFiles(glob: '**/*')
                         .findAll { f -> f.directory }
                 }
            }
        }
    }
}
