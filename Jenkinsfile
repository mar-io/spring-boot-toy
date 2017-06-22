#!groovy
currentBuild.displayName = "${env.BUILD_NUMBER}:mario/gs-spring-boot-docker:"

node('docker') {
  docker.withRegistry('https://903480711441.dkr.ecr.us-west-2.amazonaws.com', 'ecr:us-west-2:ci') {

    stage 'Checkout'
      checkout scm
  
    stage 'Build'
  
    sh "apt-get update && apt-get install -y maven"
    sh "mvn clean package"
  
    stage 'Push'
  
    //sh "mvn dockerfile:push"
    //sh "mvn dockerfile:tag"
    //sh "mvn dockerfile:push"
    sh "docker push 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:0.1.11"
    sh "docker tag 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:0.1.11 903480711441.dkr.ecr.us-west-2.amazonaws.com//mario/gs-spring-boot-docker:latest"
    sh "docker push 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:latest"
  }
}
