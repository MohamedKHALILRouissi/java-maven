def test () {
echo ' maven testing ... '
sh 'mvn test'
}

def packing () {
echo ' maven packaging ... '
sh 'mvn package'
}

def buildocker () {
echo 'buidling docker ... ' 
sh 'docker build -t 192.168.1.18:${PORT}/${DOCKER_NAME}:{$DOCKER_TAG} .' 
}


def pushdocker () {
echo 'loging to nexus as ${USER}'
sh 'echo ${NEXUS_CREDS_PSW} | docker login -u ${NEXUS_CREDS_USR} --password-stdin 192.168.1.18:${PORT}'
echo 'pushing docker image to nexus3 at 192.168.1.18 server'
sh 'docker push 192.168.1.18:${PORT}/${DOCKER_NAME}:{$DOCKER_TAG}'
}

return this 
