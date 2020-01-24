public class threads extends Thread{
    private static int x;
    private  int y;
    private static int threadCount = 0;
    private static int remThrd = 0;
    private static int i0 = 0;
    private int id;

    public threads(int x,int y){     
        this.x =x;
        this.y =y;
        id = threadCount;
        threadCount++;
        remThrd++;
        System.out.println("Created thread #" + (threadCount-1));
    }

    @Override
    public void run(){
        System.out.println("Started thread #" + id);
    }


    public void test(int[][]a, int[][]b,int[][]c){
        mtxMult(x,y,a,b,c);
    }
    
    private static void threadCheck(){
        // Makes sure number of threads used at most matches number of row opperations
        if(x<threadCount){            
            threadCount = x;
            remThrd = threadCount;            
        }
    }

    private static void mtxMult(int x, int y,int[][]a, int[][]b,int[][]c){        
        if(remThrd>0){ // Stops extra threads from attempting to multiply finished mtx
            threadCheck();
            int sum;       
            int n; 
            // Check to see if the last thread has been reached
            switch(remThrd){
                case 1:
                    n = x;                    
                    break;
                default:  
                    n = ((x/ threadCount + i0));  
            }        
            
            for(int i = i0; i<n; i++){  
                // Debug          
                // System.out.println("i:" + i );
                // System.out.println("n:" + n);
                for(int j = 0; j<x;j++){ 
                    sum = 0;               
                    for(int k = 0; k<y; k++){
                        sum += (a[i][k] * b[k][j]);
                    }
                    c[i][j] = sum;
                }
            }
            // Increments where the next thread starts from and decrements the number of thread reamaining
            i0++;
            remThrd--;            
            // System.out.println();
        }

    }

}