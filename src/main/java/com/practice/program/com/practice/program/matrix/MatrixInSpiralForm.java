package com.practice.program.com.practice.program.matrix;

/**
 * Created by rsinghal on 4/22/2018.
 */
public class MatrixInSpiralForm {

    public  static void  main(String arr[]){
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(R,C,a);
    }

    private static void spiralPrint(int m, int n, int[][] a) {

        int k = 0;
        int l = 0;
        for(int i = 0 ; i< n; i++){
            System.out.println(a[k][i]);
        }
        k++;
        for(int i = k ; i<m;i++){
            System.out.println(a[i][n-1]);
        }
        n--;
        if(k < m){
            for(int i =m-1; i > l;i-- ){
                System.out.println(a[m-1][i]);
            }

        }
    }
}
