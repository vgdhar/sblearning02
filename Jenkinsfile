pipeline{
	agent any
	stages{
    stage('SCM checkout')
    {
	    steps{git 'https://github.com/vgdhar/sblearning02'}
    }
	stage('compile-package')
    {
	    steps{def mavenhome=tool name: 'MAVEN_HOME', type: 'maven'
		  sh "${mavenhome}/bin/mvn package"}
    }
    

    stage('deploy-to-production')
    {
	    steps{
		when
		{
		branch 'master'
		}
        steps
        {
	withCredentials([usernamePassword(credentialsId: 'tomcat_login', passwordVariable: 'USERPASS', usernameVariable: 'USERNAME')]) {
            sshPublisher (
            failOnError: true, 
            continueOnError: false,
            publishers: [
				sshPublisherDesc(
		        configName: 'production', 
		        sshCredentials: [
		        username: '$USERNAME',
		        encryptedPassphrase: '$USERPASS'],
		        transfers: [
			    sshTransfer(
			    cleanRemote: false,
			    excludes: '', 
			    execCommand: 'sudo /usr/bin/systemctl stop tomcat.service && rm -rf /opt/tomcat/tomcat/webapps/sblearning02 && cp /tmp/sblearning02.war /opt/tomcat/tomcat/webapps/ && sudo /usr/bin/systemctl start tomcat.service', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/tmp', remoteDirectorySDF: false, removePrefix: 'target/', sourceFiles: 'target/sblearning02.war')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                }
                }
	}
	}
	}
}
