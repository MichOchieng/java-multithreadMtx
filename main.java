import java.util.Random;
import java.util.Arrays;

public class main{
    private static int x = 3;
    private static int y = 2;
    private static int[][] mtx  = new int[x][y];
    private static int[][] mtx1 = new int[y][x];
    private static int[][] resultMtx   = new int[x][x];

    public static void main(String[] args) {        
        threads t = new threads(x,y);    
        threads t2 = new threads(x,y);    
        // threads t3 = new threads(x,y);  
        // threads t4 = new threads(x,y);       
        // threads t5 = new threads(x,y);    
        // threads t6 = new threads(x,y);    
        // threads t7 = new threads(x,y);  
        // threads t8 = new threads(x,y);  
        fillMtx();      
        t.start();
        t2.start(); 
        // t3.start(); 
        // t4.start(); 
        // t5.start(); 
        // t6.start(); 
        // t7.start(); 
        // t8.start();        
        t.test(mtx,mtx1,resultMtx); 
        t2.test(mtx,mtx1,resultMtx);
        // t3.test(mtx,mtx1,resultMtx);
        // t4.test(mtx,mtx1,resultMtx);
        // t5.test(mtx,mtx1,resultMtx); 
        // t6.test(mtx,mtx1,resultMtx);
        // t7.test(mtx,mtx1,resultMtx);
        // t8.test(mtx,mtx1,resultMtx);
        view();
        view2();
        view3();    
    }    

    // Creates test matricies mtx and mtx1
    private static void fillMtx(){
        Random r = new Random();        
        for(int i = 0;i<y;i++){
            for(int j = 0; j<x; j++){
                // Change to random int
                mtx1[i][j] = 1;                
            }
        }

        for(int i = 0;i<x;i++){
            for(int j = 0; j<y; j++){
                // Change to random int
                mtx[i][j] = 1;                
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