pipeline {
    
    agent {
        
        label 'agent1'
    }

    tools { 
      maven 'MAVEN'
     }
     
     triggers {
         
         pollSCM "* * * * *"
}
      
     stages {

           stage("Clone Project") {

             steps {

                 script {
                     
                     git 'https://github.com/Varuun07/springboot-java-open.git';
				 }
			 }
           }

	   stage("Maven Build") {

        steps {

             sh 'mvn clean package'
            
                }
	        } 
         

    stage('Upload Artifacts To Nexus'){
            
        steps{
             nexusArtifactUploader artifacts: [
              [
                  artifactId: 'demo', 
                  classifier: '', 
                  file: 'target/demo-0.0.1-SNAPSHOT.war', 
                  type: 'war'
                    ]
             ], 
                credentialsId: 'nexus-user-credentials', 
                groupId: 'com.example', 
                nexusUrl: '192.168.33.11:8081', 
                nexusVersion: 'nexus3', 
                protocol: 'http', 
                repository: 'java-project', 
                version: '0.0.1-SNAPSHOT'
            }
        } 
        
          stage('Deploy To Tomcat') {
            
            steps{
            
                script {
                
                   deploy adapters: [tomcat9(credentialsId: 'tomcat',
                   path: '',
                   url: 'http://192.168.33.11:8082/')],
                   contextPath: 'springboot-java-open',
                   onFailure: false,
                   war: '**/*.war'
               }
            }
        }
     }
  }
