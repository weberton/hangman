pipeline {
    agent any

    stages {

        stage('Create file') {
            steps {
                script {

                    def folders =  findFiles(glob: '**/*')
                        .findAll { f -> f.directory }
                        .collect{ f -> f.path.replace('/', '\\') - ~/\\[^\\]+$/ }

              for file in folders:
                echo """
                ${files[0].name} ${files[0].path} ${files[0].directory}
                ${fil
                 }
            }
        }
    }
}
