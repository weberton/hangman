pipeline {
    agent any

  environment {
    PATH = "/Users/wfaria/development/apache-maven-3.6.3/bin:$PATH"
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
                    sh 'ls /opt/'
                    def files =  findFiles(glob: "**/*.jar")
                    files.each { item ->
                            echo "Hello ${item}"
                    }
                 }
            }
        }
    }
}
