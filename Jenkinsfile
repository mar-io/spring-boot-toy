#!groovy

node('docker') {
  pom = readMavenPom file: 'pom.xml'
  currentBuild.displayName = "${env.BUILD_NUMBER}:mario/gs-spring-boot-docker:${pom.version}"
  docker.withRegistry('https://903480711441.dkr.ecr.us-west-2.amazonaws.com', 'ecr:us-west-2:ci') {
    
    stage 'Checkout'
      checkout scm
  
    stage 'Build'
  
    sh "apt-get update && apt-get install -y maven"
    sh "mvn clean package"
  
    stage 'Push'

    sh "docker push 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:${pom.version}"
    sh "docker tag 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:${pom.version} 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:latest"
    sh "docker push 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:latest"
  }
}
