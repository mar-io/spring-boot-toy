#!groovy

node {
  stage 'Checkout'
    checkout scm

  stage 'Build'
  sh "mvn clean"
  sh "mvn package"

  stage 'Push'
  sh "$(aws ecr get-login --region us-west-2)"
  sh "mvn dockerfile:push"

}
