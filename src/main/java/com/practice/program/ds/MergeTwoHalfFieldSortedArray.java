package com.practice.program.ds;

public class MergeTwoHalfFieldSortedArray {
    public static void main(String[] args) {
        //calling function
        int[] a = {100,1000,2000,2800,0,0,0,0};
        int[] b = {2,9,12,18,0,0,0,0};
        // System.out.println();
        for(int i :mergeSortedArray(a,b) ){
            System.out.println(i);
        }

    }

    private static int[] mergeSortedArray(int[] a, int[] b){
        //int[] sorted = new int[a.length];
        int i = a.length -1;
        for(int j = 3, k = 3, x=0; ( (j >= 0) && (k >= 0))  ; x++){

            if(a[j] > b[k]){
                a[i] = a[j];
                a[j] = 0;
                --j;
                --i;

            } else{
                a[i] = b[k];
                --k;
                --i;
            }

            if(j == -1 ) // this condition worked
                j = 0;
        }

        return a;

    }

}
