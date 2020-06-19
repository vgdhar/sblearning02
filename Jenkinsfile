node{
    stage('SCM checkout')
    {
		    git 'https://github.com/vgdhar/sblearning02'
    }
	stage('compile-package')
    {
		    def mavenhome=tool name: 'MAVEN_HOME', type: 'maven'
		  sh "${mavenhome}/bin/mvn package"
    }
    

	stage('deploy-to-production'){
	withCredentials([usernamePassword(credentialsId: 'tomcat_login', passwordVariable: 'USERPASS', usernameVariable: 'USERNAME')]){
            sshPublisher (
            failOnError: true, 
            continueOnError: false,
            publishers: [
				sshPublisherDesc(
		        configName: 'production', 
		        sshCredentials: [
		        username: "$USERNAME",
		        encryptedPassphrase: "$USERPASS"
				],
		        transfers: [
			sshTransfer(
			sourceFiles: 'target/sblearning02.war',
			removePrefix: 'target',
			remoteDirectory: '/tmp',
			execCommand: 'touch test.txt'
				)
				]
				)
				]
				)
                }      
	}
	}
