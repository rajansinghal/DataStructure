package com.practice.program.string;

/**
 * Created by rsinghal on 12/4/2017.
 */
public class PalindromPartition {


    public static void main(String[] args) {

        String s1 = "HELLO ALL TODAY";
        // TODAY ALL HELLO

        char[] ch = s1.toCharArray();
        char[] rev = reverse(0,ch.length-1,ch);

        int startIndex=0;
        int endIndex = 0;
        for(int m = 0; m < rev.length;m++){
            if(rev[m] == ' ' || m == rev.length -1) {
                if (m == rev.length - 1)
                    endIndex = m;
                else
                    endIndex = m - 1;

                rev = reverse(startIndex, endIndex, rev);

            }
            startIndex = m+1;

        }
    }

    public static char[] reverse(int startIndex,int endIndex, char[] input){
        for(int s=startIndex, e=endIndex; s< startIndex + (endIndex - startIndex )/2 ; s++,e--){

            char c = input[s];
            input[s] = input[e];
            input[e] = c;

        }
        return input;
    }



}
