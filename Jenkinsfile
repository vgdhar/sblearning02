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
		    withCredentials([usernamePassword(credentialsId: 'tomcat_login', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
   				 // some block
			    //sh 'chmod 666 target/sblearning02.war'
			    sh 'scp target/sblearning02.war $USER@13.232.233.16:/tmp'
				}
	    }
	}
         
    }
}
