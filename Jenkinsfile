pipeline {
    agent any

    stages {

        stage('Create file') {
            steps {
                script {

                    def folders =  findFiles(glob: '**/*')
                        .findAll { f -> f.directory }
                        .collect{ f -> f.path.replace('/', '\\') - ~/\\[^\\]+$/ }

                    packageDir.each { d ->
                        dir(d) {
                            // Process each package here
                            echo e;
                        }
                    }
                 }
            }
        }
    }
}
