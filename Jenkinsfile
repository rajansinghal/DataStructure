pipeline{
    agent any
	environment {
		mavenBuildTool = "maven3.5.0"
		
		
	}
    stages {
        stage("Checkout") {
            steps {
                checkout scm
            }
        }
		stage("Build"){
             steps {
                echo "Building solution"  
                script {
					def mavenbuild = tool name: mavenBuildTool
                    bat "${mavenbuild}/bin/mvn package"
                }                 
             }
        }
		stage("Package & Publish"){
			steps{
				nexusArtifactUploader artifacts: [[artifactId: 'DataStructure', classifier: '', file: 'target/DataStructure-1.0-SNAPSHOT.jar', type: 'jar']], credentialsId: '0a429247-fd8c-4fd9-be2a-e820e4f20587', groupId: 'com.rajan.coding', nexusUrl: 'localhost:8081', nexusVersion: 'nexus2', protocol: 'http', repository: 'https://github.com/rajansinghal/DataStructure.git', version: '1.0-SNAPSHOT'

				
			}
		}
    }
	
}
