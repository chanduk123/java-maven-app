def buildJar() {
    echo 'Creating Jar file using Maven tool'
    sh 'mvn package'
}

def pushImage() {
    echo 'building docker image and pushing it private repo'
    withCredentials([usernamePassword(credentialsId:'docker-cred', usernameVariable:'USER', passwordVariable:'pass')])
    sh 'docker build -t chandukanuri/demo-app:jma-lts .'
    sh "echo $pass | docker login -u $USER --password-stdin"
    sh 'docker push chandukanuri/demo-app:jma-lts'
}

def deploy() {
    echo 'deploying application using pipline'
}
return this
