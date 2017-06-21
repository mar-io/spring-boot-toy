#!groovy

node('docker') {
  stage 'Checkout'
    checkout scm

  stage 'Build'
  sh "apt-get update && apt-get install -y maven python3-pip python3-dev python3-yaml libyaml-dev"
  sh "pip3 install --upgrade awscli"
  sh "\$(aws ecr get-login --region us-west-2)"
  sh "mvn clean package -Dapi.version=0.1.10 -Decr.repository=903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker"

  stage 'Push'
  sh "mvn dockerfile:push -Dapi.version=0.1.10 -Decr.repository=903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker"

}
