node {
   def commit_id
   stage('Preparation') {
     checkout scm
    # sh "git rev-parse --short HEAD > .git/commit-id"
    # commit_id = readFile('.git/commit-id').trim()
   }
   stage('test') {
     batchFile '''
     cucumber -p secure_area features BROWSER=chrome
     '''
   }
   stage('docker build/push') {
     docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
     def app = docker.build("sushantbhatnagar/dockerized_quandoo:latest", '--file Dockerfile.chrome .').push()
     }
   }
}
