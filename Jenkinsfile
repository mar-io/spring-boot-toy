#!/usr/bin/env groovy
currentBuild.displayName = "${env.BUILD_NUMBER}:mario/gs-spring-boot-docker"

node('docker_java8') {
  docker.withRegistry('https://903480711441.dkr.ecr.us-west-2.amazonaws.com', 'ecr:us-west-2:ci') {
    
    stage('Checkout') {
      checkout scm
      pom = readMavenPom file: 'pom.xml'

    }

    stage('Build') {
  
      sh "mvn clean package"
  
    }
    
    stage('Push') {

      docker.image '903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker'
      docker.image.push pom.version
      docker.image.push 'latest'
    
    }
    // sh "docker push 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:${pom.version}"
    // sh "docker tag 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:${pom.version} 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:latest"
    // sh "docker push 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:latest"
  }
}
