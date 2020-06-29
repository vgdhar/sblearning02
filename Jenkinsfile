pipeline
{
    agent any
    stages
    {
        stage('SCM Checkout')
        {
            steps
            {
              git 'https://github.com/vgdhar/sblearning02'  
            }
        }
        stage('compile-package')
        {
            steps
            {
                sh '/opt/maven/bin/mvn package'
            }
        }
         stage('deploy-to-production')
        {
            steps
            {
		 withCredentials([usernamePassword(credentialsId: 'tomcat', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
		  sshPublisher(
			  publishers: [
				  sshPublisherDesc(
					  configName: 'production',
					  sshCredentials: [
                                    		username: "$USER",
                                   		 encryptedPassphrase: "$PASS"
                               				 ], 
					  transfers: [
						  sshTransfer(
							  cleanRemote: false, excludes: '', execCommand: 'sudo /usr/bin/systemctl stop tomcat.service && rm -rf /opt/tomcat/tomcat/webapps/sblearning02 && sudo cp /tmp/sblearning02.war /opt/tomcat/tomcat/webapps/ && sudo /usr/bin/systemctl start tomcat.service', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/tmp', remoteDirectorySDF: false, removePrefix: 'target/', sourceFiles: 'target/sblearning02.war')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

	    }
	    }
	}
         
    }
}
