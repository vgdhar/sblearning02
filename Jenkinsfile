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
		   // withCredentials([usernamePassword(credentialsId: 'tomcat_login', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
   				 // some block
			    //sh 'chmod 666 target/sblearning02.war'
			   // sh 'scp target/sblearning02.war $USER@52.66.190.19:/tmp'
				//}
		sh 'ssh -tt -o StrictHostKeyChecking=no cloud_user@52.66.190.19'
		sh'scp -o StrictHostKeyChecking=no sblearning02.war cloud_user@52.66.190.19:/tmp'
		sh 'sudo /usr/bin/systemctl stop tomcat.service && rm -rf /opt/tomcat/tomcat/webapps/sblearning02 && sudo cp /tmp/sblearning02.war /opt/tomcat/tomcat/webapps/ && sudo /usr/bin/systemctl start tomcat.service'

	    }
	}
         
    }
}
