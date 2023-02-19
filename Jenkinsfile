def EXTsc = [:]
pipeline {
    agent any 
    
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
            steps {
                script {
                    EXTsc.test()
                }
            }
        }
        stage("package") {
            steps {
                script {
                    EXTsc.package()
                }
            }
        }
        stage("build docker artifact") {
            steps {
                script {
                    EXTsc.buildocker()
                }
            }
        }
        stage("push docker artifact"){
            input {
                message "name of the image , tag and repository port "
                ok "Done"
                parameters {
                    string(name:'DOCKER_NAME', defaultValue: '', description: 'name of the image')
                    string(name:'PORT', defaultValue: '', description: 'port of the nexus repo')
                    string(name:'DOCKER_TAG', defaultValue: '', description: 'tag of the image')
                }
            }
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
