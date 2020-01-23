import java.util.Random;
import java.util.Arrays;

public class main{
    private static int x = 3;
    private static int y = 2;
    private static int[][] mtx  = new int[x][y];
    private static int[][] mtx1 = new int[y][x];
    private static int[][] resultMtx   = new int[x][x];

    public static void main(String[] args) {        
        threads t = new threads(0,0,2,y);    
        threads t2 = new threads(2,y,x,y);          
        fillMtx();      
        t.start();
        t2.start(); 
        t.test(mtx,mtx1,resultMtx); 
        t2.test(mtx,mtx1,resultMtx);
        view();
        view2();
        view3();    
    }    

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