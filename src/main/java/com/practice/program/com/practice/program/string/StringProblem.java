package com.practice.program.com.practice.program.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Created by rsinghal on 2/10/2018.
 */
public class StringProblem {

    public static void main(String[] args) {

        /*StringProblem.findAllSubString("abcd");
        StringProblem.findAllUniqueSubString("aaa");*/
        // StringProblem.findAllSubset("abc");
        // StringProblem.findAllPermutationOfString("abc");
        StringProblem.reverseWordsInSentence("geeks quiz practice code");
       /* StringProblem.reverseCharsOfWordsInSentence("skeeg ziuq ecitcarp edoc ");
        */
        StringProblem.isBalancedBracket();

    }

    // input abc
    //output a b c ab bc abc
    private static void findAllSubString(String str) {

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            //String s = "";
            for (int k = i; k < ch.length; k++) {

                //s = s + String.valueOf(ch[k]);
                System.out.println(str.substring(i, k + 1));
            }

        }
    }


    // input aaa
    //output a aa aaa
    private static void findAllUniqueSubString(String str) {

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            String s = "";
            for (int k = i; k < ch.length; k++) {

                s = s + String.valueOf(ch[k]);
                System.out.println(s);
            }
        }
    }


    //input {a,b,c}
    //output {} {a} {b} {c} {a,b} {b,c} {c,a} {a,b,c}
    // output = 2^input
    private static void findAllSubset(String str) {

        int size = (int) Math.pow(2, str.length());
        String arr[] = new String[size];
        for (int i = 0; i < size; i++) {

            int j = i;
            int b = 1;
            int z = 0;
            while (j >= 1) {

                if (j % 2 != 0)
                    z = b + z;

                b = b * 10;
                j = j / 2;

            }

            String s = "";
            char ch[] = str.toCharArray();
            for (int m = 0, n = (int) Math.pow(10, str.length() - 1); m < ch.length; m++) {

                if (z / n == 1) {
                    z = z % n;
                    s = s + ch[m];
                }

                n = n / 10;

            }
            arr[i] = s;
            System.out.println(s);
        }


    }

    //input abc
    //output abc acb bac bca cab cba
    // output = Factorial(Input)
    private static void findAllPermutationOfString(String str) {
        permute("", str);
    }


    private static void permute(String start, String end) {

        for (int i = 0; i < end.length(); i++) {
            if (end.length() == 1) {
                System.out.println(start + end);
            } else {
                String newEndString = end.substring(0, i) + end.substring(i + 1);
                permute(start + end.charAt(i), newEndString);
            }


        }
    }

    //Input  : s = "geeks quiz practice code"
    // Output : s = "code practice quiz geeks"
    private static void reverseWordsInSentence(String input) {

        int m = input.length();
        int n = input.length();
        String[] str_arr = new String[m];
        int temp = 0;
        String str = "";
        for (int i = 0; i < m; i++) {

            if (input.charAt(i) == ' ') {
                str_arr[temp] = str;
                str = "";
                temp++;
            } else if (i == input.length() - 1) {
                str = str + input.charAt(i);
                str_arr[temp] = str;

            } else {
                str = str + input.charAt(i);//[i];
            }


        }

        String output = "";
        for (int i = str_arr.length - 1; i >= 0; i--) {
            if (null != str_arr[i])
                output = output + str_arr[i] + " ";
        }
        System.out.println(output);
    }


    //Input  : s = "skeeg ziuq ecitcarp edoc "
    //Output  : s = "geeks quiz practice code"
    private static void reverseCharsOfWordsInSentence(String input) {

        int m = 0;
        int n = 0;
        char[] ch = input.toCharArray();
        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == ' ') {

                n = i - 1;
                for (int j = m, k = n; j < m + ((n - m) + 1) / 2; j++, k--) {
                    char temp = ch[j];
                    ch[j] = ch[k];
                    ch[k] = temp;
                }

                m = i + 1;
                System.out.println(new String(ch));
            }

        }
        System.out.println(new String(ch));
    }

    //Input  : s = "hello "
    //Input  : s = "rajan hepp hellk hellok"
    //Output : true
    private static void findSubstring() {
        String pattern = "aaba";
        String matcher = "rajan hepp hellk helaalk aabaa";
        char[] patterArr = pattern.toCharArray();
        char[] matcherArr = matcher.toCharArray();
        boolean flag = false;
        int j = 0;
        for (int i = 0; i < matcherArr.length; i++) {
            if (matcherArr[i] == patterArr[j]) {
                if (j == patterArr.length - 1) {
                    flag = true;
                    break;
                }
                j++;
            } else {
                j = 0;
            }

        }
        System.out.println(flag);
    }

    //Input  : s = "(()[]{})"
    //Output : true
    private static void isBalancedBracket() {
        String input = "(()[][[{})";
        List<Character> chars = new ArrayList<>();
        int i = 0;
        while (i <= input.length() - 1) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                chars.add(ch);
            } else {
                switch (ch) {
                    case ')':
                        if ('(' == chars.get(chars.size() - 1)) {
                            chars.remove(chars.size() - 1);
                        }
                        break;
                    case ']':
                        if ('[' == chars.get(chars.size() - 1)) {
                            chars.remove(chars.size() - 1);
                        }
                        break;
                    case '}':
                        if ('{' == chars.get(chars.size() - 1)) {
                            chars.remove(chars.size() - 1);
                        }
                        break;
                    default:
                        break;
                }
            }
            i++;
        }
       System.out.println(chars.size() == 0 ? "is balanced":"not balanced");

    }

}
