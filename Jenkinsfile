node{

  stage('SCM checkout')
    {
      git 'https://github.com/vgdhar/sblearning02'
    }
  stage('compile-package')
    {
    sh 'mvn package'
    }

}
