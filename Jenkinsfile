pipeline {
  agent any 

  stages {
  
   stage("build") {
     
    when {
      
      expression {
        
        env.BRANCH_NAME == 'main'
      }
      
    }
     
    steps {
    
    echo "installing"
    echo 'building'
    
    }
    
   }
    
   stage("test") {
   
    steps {
    
    sh 'ls'
    echo 'testing'
    
    }
    
   }
   
  }
  
}
post {
  always {
    echo ' this will be executed always '
  }
  succes {
    echo ' this will be executed on success '
  }
  failure { 
    echo ' this will be executed on failure '
  }
}
