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
                sh '$MAVEN_HOME/bin mvn package'
            }
        }
    }
}
