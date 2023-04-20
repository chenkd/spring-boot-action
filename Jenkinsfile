pipeline {
    agent any
    environment {
        jar_version = '0.0.1-SNAPSHOT'
    }

    parameters {
            string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
    }

    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.9.0-eclipse-temurin-11'
                    args '-v /var/jenkins_home/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn install -Dmaven.test.skip=true'
            }
        }

        stage('Deploy') {
            steps {
                sh "scp ~/workspace/jenkins-pipeline@2/?/.m2/repository/com/example/spring-boot-action/${env.jar_version}/spring-boot-action-${env.jar_version}.jar root@ljh:/root/test/jenkins/"
                sh "ssh root@ljh java -jar /root/test/jenkins/spring-boot-action-${env.jar_version}.jar > /root/test/jenkins/stdout.log 2>&1 &"
            }
        }

        stage('Test params') {
            steps {
                echo "Hello ${params.PERSON}"
            }

        }
    }
}
