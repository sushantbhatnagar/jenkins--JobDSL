node {
   stage('test') {
     bat '''
     	cucumber -p secure_area -t @login BROWSER=chrome
     '''
   }
   stage('docker build/push') {
     docker.withRegistry('https://index.docker.io/v1/', 'docker-hub') {
     def app = docker.build("sushantbhatnagar/dockerized_quandoo:latest", '--file Dockerfile.chrome .').push()
     }
   }
}
