node('java') {
    stage 'Checkout'
        checkout scm

    stage 'Build'
        env.JAVA_HOME = tool 'openjdk8'
        sh 'gradle build'

    stage 'Archive'
        junit 'build/test-results/test/*.xml'
} 
