package com.practice.program;

/**
 * Created by rsinghal on 11/9/2017.
 */
public class MovingZeroToEnd {
    public static void main(String arr[]){

        moveZero(2307046); //out put should be : 2374600
    }

    public static void moveZero(int z){
        int i = 1;
        int k = z;
       while(z != 0){
           int rem = z%10;
           z=z/10;

           if(rem == 0){
                int o=z*i;
                int p=k%i;
                k=o+p;
                k=k*10;

           }
           i=i*10;

       }

        System.out.println(k);
    }

}
