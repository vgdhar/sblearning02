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
		        encryptedPassphrase: "$USERPASS"],
		        transfers: [
			    sshTransfer(
			sourceFiles: 'target/sblearning02.war',
			removePrefix: 'target/',
			remoteDirectory: '/tmp',
			    cleanRemote: false,
			    excludes: '', 
			    execCommand: 'sudo /usr/bin/systemctl stop tomcat.service && rm -rf /opt/tomcat/tomcat/webapps/sblearning02 && cp /tmp/sblearning02.war /opt/tomcat/tomcat/webapps/ && sudo /usr/bin/systemctl start tomcat.service')])
                }         
	}
	}
