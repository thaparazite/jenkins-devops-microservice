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
				echo "BUILD_TAG - ${env.BUILD_TAG}"
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
		}// end of checkout stage

		/*
		 Create a stage to compile the project using Maven.
		 This stage will run after the checkout stage, and will compile the project.
		 The Maven tool is used for building and managing Java projects.
		*/
		stage('Compile') {
			steps {
				echo 'mvn clean compile...'
				sh 'mvn clean compile'
			}
		}// end of compile stage

		/*
		 Create a stage to run the unit tests using Maven Surefire plugin.
		 This stage will run after the compile stage, and will execute the unit tests.
		 The Surefire plugin is used for running unit tests in Maven projects.
		*/
		stage('Test') {
			steps {
				echo 'mvn testing...'		
				sh 'mvn test'		
			}
		}// end of test stage

	    /*
		 Create a stage to run the integration tests using Maven Failsafe plugin.
		 This stage will run after the test stage, and will execute the integration tests.
		 The Failsafe plugin is used for running integration tests in Maven projects.
		*/
		stage('Integration Test') {
			steps {
				echo 'Failsafe: Integration Testing...'
				sh 'mvn failsafe:integration-test failsafe:verify'
			}
		}// end of integration test stage

		/*
		 Create a stage to package the project using Maven.
		 This stage will skip the tests and package the project.
		 */
	    stage('Package'){
			steps {
				echo 'Packaging...'
				sh 'mvn package - DskipTests'	
			}
		}// end of package stage		

		/*
		 Create a stage to build the docker image. 
		 This stage will run after the integration test stage, 
		 and will build the docker image using the Dockerfile in the root of the project.
		*/
		stage('Build Docker Image') {
			steps {
				echo 'Building Docker Image...'
				// "docker build -t flaviuvanca/currency-exchange-devops:${env.BUILD_TAG}"
				script {
					docker.build("docker build -t flaviuvanca/currency-exchange-devops:${env.BUILD_TAG}")
				}
			}
		}// end of build docker image stage

		/*
		 Create a stage to push the docker image to Docker Hub.
		 This stage will run after the build docker image stage, 
		 and will push the docker image to Docker Hub.
		*/
		stage('Push Docker Image') {
			steps {
				echo 'Pushing Docker Image to Docker Hub...'
				// sh 'docker push flaviuvanca/currency-exchange-devops:${env.BUILD_TAG}'
				script {
					docker.withRegistry('', 'docker-hub-credentials') {
						dockerImage.push()
						//dockerImage.push("${env.BUILD_TAG}")
						dockerImage.push("latest")
						echo "Docker image pushed successfully!"
					}
				}
			}
		}// end of push docker image stage


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
	}// end of post
	
}// end of pipeline 