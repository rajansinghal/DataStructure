package com.practice.program.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class AllPermutationOfString {
    public static void main(String arr[]) {

        AllPermutationOfString.permute("123");
    }

    public static void permute(String s) {
        if (null == s || s.isEmpty()) {
            return;
        }

        // List containing words formed in each iteration
        List<String> strings = new LinkedList<String>();
        strings.add(String.valueOf(s.charAt(0))); // add the first element to the list

        // Temp list that holds the set of strings for
        // appending the current character to all position in each word in the
        // original list
        List<String> tempList = new LinkedList<String>();

        for (int i = 1; i < s.length(); i++) {
            System.out.println(" i :: " + i + "-------------------------------------------");
            for (int j = 0; j < strings.size(); j++) {
                System.out.println("size :: "+strings.size() + " ,j :: "+j +" s.charAt(i) :: " + s.charAt(i) + " strings.get(j) :: " +strings.get(j) );
                tempList.addAll(merge(s.charAt(i), strings.get(j)));
            }
            strings.removeAll(strings);
            strings.addAll(tempList);

            tempList.removeAll(tempList);

        }

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

    /**
     * helper method that appends the given character at each position in the
     * given string and returns a set of such modified strings - set removes
     * duplicates if any(in case a character is repeated)
     */
    private static Set<String> merge(Character c, String s) {
        System.out.println("c :: "+ c + " s :: "+ s);
        if (s == null || s.isEmpty()) {
            return null;
        }

        int len = s.length();
        StringBuilder sb ;
        Set<String> set = new HashSet<String>();

        for (int i = 0; i <= len; i++) {
            sb = new StringBuilder();
            sb.append(s.substring(0, i) + c + s.substring(i, len));
            System.out.println("this string to be appended  :: " + sb.toString());
            set.add(sb.toString());

        }
        System.out.println("set.size() :: " +set.size());
        return set;
    }

}