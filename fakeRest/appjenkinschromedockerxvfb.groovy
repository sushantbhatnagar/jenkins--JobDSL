job('Build jenkinsDockerChromeXvfB Image') {
    scm {
        git('https://github.com/sushantbhatnagar/Docker_Images.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('sushantbhatnagar')
            node / gitConfigEmail('sushantbhatnagar91@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('sushantbhatnagar/appjenkinschromedockerxvfb')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('docker-hub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
