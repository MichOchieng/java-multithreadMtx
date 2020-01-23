public class threads extends Thread{
    private int i0;
    private int i1;
    private int x;
    private int y;
    private static int threadCount = 0;

    public threads(int i0,int i1,int x, int y){      
        this.i0 = i0;
        this.i1 = i1;
        this.x  = x;
        this.y  = y;
        threadCount++;
        System.out.println("Started thread #" + threadCount);
    }

    @Override
    public void run(){
        System.out.println("Running thread");
    }

    public void test(int[][]a, int[][]b,int[][]c){
        mtxMult(i0,i1,x,y,a,b,c);
    }

    private static void mtxMult(int i0,int i1,int x, int y,int[][]a, int[][]b,int[][]c){
        int sum;
        for(int i = i0; i<x;i++){
            for(int j = i1; j<x;j++){ 
                sum = 0;               
                for(int k = 0; k<y; k++){
                    sum += (a[i][k] * b[k][j]);
                }
                c[i][j] = sum;
            }
        }

    }

}