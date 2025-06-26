//Scripted
/* node {
	echo "Build"
	echo "Test"
	echo "Integration Test"	
} */

//Declarative
pipeline {
	agent any
	//agent{ docker{ image 'maven:3.9.10' } }// end of agent 

	environment {
		dockerHome = tool 'myDocker'
		mavenHome = tool 'myMaven'
		PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
	}

	stages {
		stage('Checkout') {
			steps {
				sh 'mvn --version'
				sh 'docker version'
				echo 'Building...'
				echo "BUILD_NUMBER - ${env.BUILD_NUMBER}"
				echo "BUILD_ID - ${env.BUILD_ID}"
				echo "JOB_NAME - ${env.JOB_NAME}"
				echo "WORKSPACE - ${env.WORKSPACE}"
				echo "BUILD_URL - ${env.BUILD_URL}"
				echo "NODE_NAME - ${env.NODE_NAME}"
				echo "NODE_LABELS - ${env.NODE_LABELS}"
				echo "EXECUTOR_NUMBER - ${env.EXECUTOR_NUMBER}"
				echo "JENKINS_HOME - ${env.JENKINS_HOME}"
				echo "JENKINS_URL - ${env.JENKINS_URL}"
				echo "JOB_URL - ${env.JOB_URL}"
				echo "JOB_BASE_NAME - ${env.JOB_BASE_NAME}"
				echo "JOB_DISPLAY_URL - ${env.JOB_DISPLAY_URL}"
				echo "JOB_FULL_NAME - ${env.JOB_FULL_NAME}"
				echo "GIT_COMMIT - ${env.GIT_COMMIT}"
				echo "GIT_BRANCH - ${env.GIT_BRANCH}"
				echo "GIT_URL - ${env.GIT_URL}"
				echo "GIT_PREVIOUS_COMMIT - ${env.GIT_PREVIOUS_COMMIT}"
				echo "GIT_PREVIOUS_SUCCESSFUL_COMMIT - ${env.GIT_PREVIOUS_SUCCESSFUL_COMMIT}"
				
				
			}
		}
		stage('Compile') {
			steps {
				echo 'mvn clean compile...'
				sh 'mvn clean compile'
			}
		}
		stage('Test') {
			steps {
				echo 'mvn testing...'		
				sh 'mvn test'		
			}
		}
		stage('Integration Test') {
			steps {
				echo 'Failsafe: Integration Testing...'
				sh 'mvn failsafe:integration-test failsafe:verify'
			}
		}
	}
	post {
		success {
			echo 'Pipeline completed successfully!'
		}
		failure {
			echo 'Pipeline failed!'
		}
		always {
			echo 'This will always run, regardless of the pipeline result.'
		}
	}
}