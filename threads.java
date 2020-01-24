public class threads extends Thread{
    private  int x;
    private  int y;
    private static int threadCount = 0;
    private static int remThrd = 0;
    private static int i0 = 0;

    public threads(int x,int y){     
        this.x =x;
        this.y =y;
        threadCount++;
        remThrd++;
        System.out.println("Started thread #" + threadCount);
    }

    @Override
    public void run(){}

    
    public void test(int[][]a, int[][]b,int[][]c){
        mtxMult(x,y,a,b,c);
    }

    private static void mtxMult(int x, int y,int[][]a, int[][]b,int[][]c){
        int sum;       
        int n; 
        // Check for to see if the last thread has been reached
        if(remThrd == 1){
            n = x;
        }else{
            n = ((x/ threadCount + i0));
        }        
        
        for(int i = i0; i<n; i++){  
            // Debug          
            System.out.println("i:" + i );
            System.out.println("x:" + n);
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
        System.out.println();

    }

}