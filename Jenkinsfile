node {
   def commit_id
   stage('Preparation') {
     checkout scm
   }
   stage('test') {
     bat 'cd secure_area'
     bat 'cucumber features BROWSER=chrome'
   }
   stage('docker build/push') {
     docker.withRegistry('https://index.docker.io/v1/', 'docker-hub') {
     def app = docker.build("sushantbhatnagar/dockerized_quandoo:latest", '--file Dockerfile.chrome .').push()
     }
   }
}
