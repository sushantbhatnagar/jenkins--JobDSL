node {
   def commit_id
   stage('Preparation') {
     checkout scm
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
