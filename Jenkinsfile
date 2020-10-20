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
                    sh 'rm -r dist'
                    sh 'mkdir -p dist'
                    def files =  findFiles(glob: "**/*.jar")
                    files.each { item ->

                            echo "Hello ${item}"
                            def fileName = "${item}"
                            def (name, extension) =  fileName.split('\\.')


                            echo name
                            echo extension

                            def test = name.replace('/', '\\') - ~/\\[^\\]+$/
                            echo 'Test ' + test

                            def newName = name + '-latest.jar';
                             sh 'mv '+ fileName + ' dist/' + newName
                            echo 'New name:' + newName
                            //fileOperations([fileCopyOperation(excludes: '', flattenFiles: false, includes: fileName, targetLocation: 'dist/'+ newName)])
                            sh 'ls dist'
                    }
                    //fileOperations([fileCopyOperation(excludes: '', flattenFiles: false, includes: 'C:\workspace\Hello\**', targetLocation: 'F:\Test\Sample')])
                 }
            }
        }
    }
}
