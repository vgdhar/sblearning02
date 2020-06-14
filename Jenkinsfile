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

}
