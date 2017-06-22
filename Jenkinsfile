#!groovy

docker.withRegistry('https://903480711441.dkr.ecr.us-west-2.amazonaws.com', 'ecr:us-west-2:mario')

node('docker') {
  stage 'Checkout'
    checkout scm

  stage 'Build'

  sh "apt-get update && apt-get install -y maven python3-pip python3-dev python3-yaml libyaml-dev"
  sh "pip3 install --upgrade awscli"
  sh "\$(aws ecr get-login --region us-west-2)"
  sh "mvn clean package"

  stage 'Push'

  sh "docker push 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:${POM_VERSION}"
  sh "docker tag 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:${POM_VERSION} 903480711441.dkr.ecr.us-west-2.amazonaws.com//mario/gs-spring-boot-docker:latest"
  sh "docker push 903480711441.dkr.ecr.us-west-2.amazonaws.com/mario/gs-spring-boot-docker:latest"

}
