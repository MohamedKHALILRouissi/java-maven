def EXTsc = [:]
pipeline {
    agent any 
    parameters {
        string(name:'DOCKER_NAME', defaultValue: '', description: 'name of the image')
        string(name:'PORT_REPO', defaultValue: '', description: 'port of the nexus repo')
        string(name:'DOCKER_TAG', defaultValue: '', description: 'tag of the image')
    }
    tools {
        maven 'maven3.6'
    }
    
    stages {
        stage("init") {
            steps {
                script {
                    EXTsc = load "script.groovy"
                }
            }
        }
        stage("test") {
            when {
                expression {
                    env.BRANCH_NAME == 'jenkins-pipeline'
                }
            }
            steps {
                script {
                    EXTsc.test()
                }
            }
        }
        stage("packing") {
            steps {
                script {
                    EXTsc.packing()
                }
            }
        }
        stage("build docker artifact") {
            input {
                message "name of the image , tag and repository port "
                ok "Done"
               
            }
            steps {
                script {
                    EXTsc.buildocker()
                }
            }
        }
        stage("push docker artifact"){
            
            environment {
                NEXUS_CREDS = credentials('nexuskhalil')
            }
            steps {
                script {
                    EXTsc.pushdocker()
                }
            }
        }
    }
}
