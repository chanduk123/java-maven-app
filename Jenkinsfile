#!/usr/bin/env groovy
def gv

pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('jarbuild') {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage('buildImage') {
            steps {
                script {
                    gv.pushImage()
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    gv.deploy()
                }
            }
        }
    }
}
