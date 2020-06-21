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
         stage('deploy-to-production'')
        {
            steps
            {
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
			execCommand: 'sudo /usr/bin/systemctl stop tomcat.service && rm -rf /opt/tomcat/tomcat/webapps/sblearning02 && sudo cp /tmp/sblearning02.war /opt/tomcat/tomcat/webapps/ && sudo /usr/bin/systemctl start tomcat.service'
				)
				]
				)
				]
				)
                }
            }
        }
    }
}
