job('TraveWiki') {
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
        batchFile '''
            cucumber -p wiki_profile -t @suggestion
        '''
    }
}