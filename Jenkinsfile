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
