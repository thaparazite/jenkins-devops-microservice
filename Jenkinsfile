//Scripted
/* node {
	echo "Build"
	echo "Test"
	echo "Integration Test"	
} */

//Declarative
pipeline {
	agent any
	stages {
		stage('Build') {
			steps {
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
}