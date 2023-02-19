df gv
pipeline {
    agent any 
    
    tools {
        maven 'maven3.6'
    }
    
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("test") {
            when {
                expression {
                    BRANCH_NAME == 'jenkins-pipeline'
                }
            }
            steps {
                script {
                    gv.test()
                }
            }
        }
        stage("package") {
            steps {
                script {
                    gv.package()
                }
            }
        }
        stage("build docker artifact") {
            steps {
                script {
                    gv.buildocker()
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
                    gv.pushdocker()
                }
            }
        }
    }
}
