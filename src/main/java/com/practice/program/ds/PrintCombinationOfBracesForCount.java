package com.practice.program.ds;

import java.util.Set;
import java.util.TreeSet;

//Asked in Mobikiwik
/*problem is writa a function which accept a int and then print all the permutation of curly braces i.e
1 = {}
2 = {}{} , {{}}
3 = {}{}{}, {{{}}}, {}{{}}, {{}}{}, {{}{}}
ans ===
1# my solution print binary equvivalent of  count for ex
    1 = 0
    2 = 00, 01
    3= 0000, 0001, 0010, 0011, 0100, 0101, 0110 , 0111
2# replace 0 = {}, and 1 = {
3# remove duplicate string
4# at last put remaining closing bracket
*/
public class PrintCombinationOfBracesForCount {

    public static void main(String[] args) {
        print(3);
    }

    public  static void print(int count){

        int size = (int)Math.pow(2,count);
        String arr[] = new String[size];
        for(int i=0; i <size; i++){

            int j = i;
            int b= 1;
            int z = 0;
            while(j >= 1){

                if(j % 2 != 0) {
                    z = b + z;
                    //System.out.println("z:" + z);
                    String zString = String.valueOf(z);
                    Set<String> uniqueRec = new TreeSet<>();
                    if(zString.length() < count){
                        int diff = count - zString.length();
                        String zeroExp= "0";
                        for(int x = 0 ; x< diff-1; x++){

                            zeroExp = zeroExp + "0";
                        }
                        zString =  zeroExp + zString;
                        uniqueRec.add(zString);
                        // System.out.println("z: with zeros: " + zString);
                    }
                    //System.out.println("z: without zeros: " + zString);

                    uniqueRec.add(zString);
                    uniqueRec.stream().forEach(s -> System.out.println(s));
                }
                b = b* 10;
                j = j/2;

            }
        }


    }
}
