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
	stages {
		stage('Build') {
			steps {
				//sh 'mvn --version'
				echo 'Building...'
				echo 'BUILD_NUMBER - ${env.BUILD_NUMBER}'
				echo 'BUILD_ID - ${env.BUILD_ID}'
				echo 'BUILD_URL - ${env.BUILD_URL}'
				echo 'NODE_NAME - ${env.NODE_NAME}'
				echo 'NODE_LABELS - ${env.NODE_LABELS}'
				echo 'EXECUTOR_NUMBER - ${env.EXECUTOR_NUMBER}'
				echo 'JOB_NAME - ${env.JOB_NAME}'
				echo 'WORKSPACE - ${env.WORKSPACE}'
				echo 'BRANCH_NAME - ${env.BRANCH_NAME}'
				echo 'GIT_COMMIT - ${env.GIT_COMMIT}'
				echo 'GIT_URL - ${env.GIT_URL}'
				echo 'GIT_BRANCH - ${env.GIT_BRANCH}'
				
			}
		}
		stage('Test') {
			steps {
				echo 'Testing...'				
			}
		}
		stage('Integration Test') {
			steps {
				echo 'Integration Testing...'
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