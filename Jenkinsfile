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
                            def fileName = "${item}"
                            def (name, extension) =  fileName.split('.')

                            echo name
                            echo extension
                            //assert v == '1128'
                            //assert z == '2'
                           // fileOperations([fileCopyOperation(excludes: '', flattenFiles: false, includes: '${item}', targetLocation: 'F:\Test\Sample')])
                    }
                    //fileOperations([fileCopyOperation(excludes: '', flattenFiles: false, includes: 'C:\workspace\Hello\**', targetLocation: 'F:\Test\Sample')])
                 }
            }
        }
    }
}
