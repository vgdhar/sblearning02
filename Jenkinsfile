def mavenhome=tool name: 'MAVEN_HOME', type: 'maven'
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
                sh '${mavenhome}/bin/mvn package'
            }
        }
    }
}
