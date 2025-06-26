//Scripted
/* node {
	echo "Build"
	echo "Test"
	echo "Integration Test"	
} */

//Declarative
pipeline {
	//agent any
	agent{
		Docker{
			{
				image 'maven:3.9.10'
			}// end of image
		}// end of Docker
	}// end of agent 
	stages {
		stage('Build') {
			steps {
				sh 'mvn --version'
				echo 'Building...'
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