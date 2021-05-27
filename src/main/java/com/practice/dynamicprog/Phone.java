package com.practice.program.optimization;

/**
 * Created by rsinghal on 4/26/2018.
 */
public class Phone {
    public static void printAllCombinations(String[][] list, String res, int n) {
        if (n == list.length) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < list[n].length; i++) {
            String out = res + " " + list[n][i];
            printAllCombinations(list, out, n + 1);
        }
    }

    public static void main(String[] args) {

        String[][] input = {{"John", "Emma"},
                {"Plays", "Hates", "Watches"},
                {"Cricket", "Soccer", "Chess"}};

        printAllCombinations(input, "", 0);
        //output
       /* John plays cricket
        John plays soccer
        John plays chess
        John hates cricket
        John hates soccer
        John hates chess
        John Watches cricket
        John Watches soccer
        John Watches chess
        Emma plays cricket
        Emma plays soccer
        Emma plays chess
        Emma hates cricket
        Emma hates soccer
        Emma hates chess
        Emma Watches cricket
        Emma Watches soccer
        Emma Watches chess*/
    }

}
