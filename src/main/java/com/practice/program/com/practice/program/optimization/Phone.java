package com.practice.program.com.practice.program.optimization;

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
    }

}
