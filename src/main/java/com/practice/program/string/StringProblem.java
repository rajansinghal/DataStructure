package com.practice.program.string;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsinghal on 2/10/2018.
 */
public class StringProblem {

    public static void main(String[] args) {

        /*StringProblem.findAllSubString("abcd");
        StringProblem.findAllUniqueSubString("aaa");*/
        // StringProblem.findAllSubset("abc");
        // StringProblem.findAllPermutationOfString("abc");
        //StringProblem.reverseWordsInSentence("geeks quiz practice code");
       /* StringProblem.reverseCharsOfWordsInSentence("skeeg ziuq ecitcarp edoc ");
        */
        //StringProblem.isBalancedBracket();
        commonSuffix("abcddd","xyzddd");

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


    //Input  : s = "geeks quiz practice code"
    // Output : s = "code practice quiz geeks"
    private static void reverseWordsInSentenceImproved(String input) {

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


    //Input  : s = "skeeg ziuq ecitcarp edoc "
    //Output  : s = "geeks quiz practice code"
    private static void reverseCharsOfWordsInSentence(String input) {

        int startIndex = 0;
        int endIndex = 0;
        char[] ch = input.toCharArray();
        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == ' ') {

                endIndex = i - 1;
                for (int s = startIndex, e = endIndex; s < startIndex + ((endIndex - startIndex) + 1) / 2; s++, e--) {
                    char temp = ch[s];
                    ch[s] = ch[e];
                    ch[e] = temp;
                }

                startIndex = i + 1;
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
    //inut ABBCCCHGFDDDD
    //output  A2B3CHGF4D

    private static void encodingOfString(String s){
        String finalString = "";
        char[] ch = s.toCharArray();
        int occurence = 1;
        for(int i=1;i<s.length();i++){

            if(s.charAt(i) == s.charAt(i-1)){
                if(i == s.length()-1){
                    if(occurence > 1  && occurence < 9){
                        finalString = finalString + occurence + s.charAt(i - 1);
                    }else if(occurence > 9){
                        finalString = finalString + 9 + s.charAt(i - 1) + (occurence - 9) +s.charAt(i - 1);
                    }
                }
                ++occurence;
            }else{
                if(occurence > 1 && occurence < 9){
                    finalString = finalString + occurence + s.charAt(i - 1);
                }else if(occurence > 9){
                    finalString = finalString + 9 + s.charAt(i - 1) + (occurence - 9) +s.charAt(i - 1);
                }
                occurence = 1;
            }

        }
        System.out.println(finalString);

    }

    //inut abcddd xyzddd
    //output  ram
    private static String commonSuffix(String s1, String s2){

        s1= "Java2blog";
        s2= "CoreJavaTut";
        char[] inp1 = s1.toCharArray();
        char[] inp2=  s2.toCharArray();


        String finalCommonSubString = "";
        for(int i=0; i < inp1.length ; i++){

            int k = i;
            String subString = "";
            for(int j=0; j < inp2.length ; j++){
                if(inp2[j] == inp1[k]){
                    subString = subString + inp1[k];
                    // if its the last element than cant increment
                    if(k == inp1.length -1)
                        break;
                    k++;
                }else{
                    k = i;
                    subString = "";
                }

            }
            if(finalCommonSubString.length() < subString.length())
                finalCommonSubString = subString;
        }
        System.out.println(finalCommonSubString );
        return  finalCommonSubString;
    }

    private static String swapString(String input){
        //String swappedString= "";  "Hello@WOR#D"; // DROWO@lle#H
        char[] input_arr = input.toCharArray();
        for (int i=0, j=input_arr.length -1; i < j ; i++, j--){

            char char_i = input_arr[i];
            char char_j = input_arr[j];

            if(char_i == '@' || char_i == '#'){
                i++;
            }
            if(char_j == '@' || char_j == '#'){
                j--;
            }

            char temp = input_arr[i];
            input_arr[i] = input_arr[j];
            input_arr[j] = temp;

        }
        return new String(input_arr);
    }


}
