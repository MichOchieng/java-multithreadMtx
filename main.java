import java.util.Random;
import java.util.Arrays;

public class main{
    private static int x = 3;
    private static int y = 2;
    private static int[][] mtx  = new int[x][y];
    private static int[][] mtx1 = new int[y][x];
    private static int[][] resultMtx   = new int[3][3];

    public static void main(String[] args) {
        threads t = new threads();
        fillMtx();     
        mtxMult();
       
        
    }    

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

    private static void mtxMult(){
        int sum;
        for(int i = 0; i<x;i++){
            for(int j = 0; j<x;j++){ 
                sum = 0;               
                for(int k = 0; k<y; k++){
                    sum += (mtx[i][k] * mtx1[k][j]);
                }
                resultMtx[i][j] = sum;
            }
        }

    }

    // private static void view(){
    //     int n = mtx.length;
    //     for(int i = 0;i<x;i++){
    //         for(int j = 0; j<y; j++){
    //             System.out.print(mtx[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }

    // private static void view2(){
    //     int n = mtx.length;
    //     for(int i = 0;i<y;i++){
    //         for(int j = 0; j<x; j++){
    //             System.out.print(mtx1[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
    
    // private static void view3(){        
    //     for(int i = 0;i<resultMtx.length;i++){
    //         for(int j = 0; j<resultMtx.length; j++){
    //             System.out.print(resultMtx[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }


    
}