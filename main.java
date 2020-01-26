import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class main{
    private static int x = 3;
    private static int y = 2;
    private static int[][] mtx                = new int[x][y];
    private static int[][] mtx1               = new int[y][x];
    private static int[][] resultMtx          = new int[x][x];
    private static ArrayList<threads> thrdLst = new ArrayList<threads>();

    public static void main(String[] args) {        
        fillMtx();       
        long start = System.currentTimeMillis();
        createThreads(1);
        long end = System.currentTimeMillis();
        long totalTime = end-start;
        System.out.println("Total time: " + totalTime + "ms."); 
        view();
        view2();
        view3();    
    }    

    // Creates n # of threads and starts multiplying
    private static void createThreads(int n){
        for(int i = 0; i<n;i++){
            thrdLst.add(new threads(x, y,mtx,mtx1,resultMtx));
            thrdLst.get(i).start();
        }        
        for(int i=0; i<n; i++){           
            try{            
                thrdLst.get(i).join();            
             }catch (InterruptedException e){           
               System.out.println("Error: Thread Interupted");            
             }
        }  
    }
    
    // Creates test matricies mtx and mtx1
    private static void fillMtx(){
        Random r = new Random();        
        for(int i = 0;i<y;i++){
            for(int j = 0; j<x; j++){                
                mtx1[i][j] = r.nextInt(100);                
            }
        }
        for(int i = 0;i<x;i++){
            for(int j = 0; j<y; j++){                
                mtx[i][j] = r.nextInt(100);             
            }
        }
    }    

    // For viewing matrix after initialization / multiplication
    private static void view(){
        int n = mtx.length;
        for(int i = 0;i<x;i++){
            for(int j = 0; j<y; j++){
                System.out.print(mtx[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void view2(){
        int n = mtx.length;
        for(int i = 0;i<y;i++){
            for(int j = 0; j<x; j++){
                System.out.print(mtx1[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static void view3(){        
        for(int i = 0;i<resultMtx.length;i++){
            for(int j = 0; j<resultMtx.length; j++){
                System.out.print(resultMtx[i][j] + " ");
            }
            System.out.println();
        }
    }


    
}