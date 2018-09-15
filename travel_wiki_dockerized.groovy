job('WikiTravel on Docker') {
    scm{
        git('git://github.com/sushantbhatnagar/wikitravel.git') { node -> 
            node /gitConfigName('Sushant Bhatnagar')
            node /gitConfigEmail('sushantbhatnagar91@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
  steps {
        dockerBuildAndPublish {
            repositoryName('sushantbhatnagar/wikitravel')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            createFingerprints(false)
            skipDecorate()
        }
    }
}