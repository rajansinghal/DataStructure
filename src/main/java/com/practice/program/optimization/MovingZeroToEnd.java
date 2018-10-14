package com.practice.program.optimization;

/**
 * Created by rsinghal on 11/9/2017.
 */
public class MovingZeroToEnd {
    public static void main(String arr[]){
        /*int i = 832324;
        System.out.println(i/1);
        System.out.println(i%1);*/
        moveZeroImproved(2307006); //out put should be : 2374600
    }

    /*public static void moveZero(int z){
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
    }*/

    public static void moveZeroImproved(int z){
        int i =1;
        while(z / i != 0){
            int q= z/i;
            int r=z%i;

           if(q %10 == 0)
            z = q*i + r*10;

            i=i*10;
        }
        System.out.println(z);
    }
}

