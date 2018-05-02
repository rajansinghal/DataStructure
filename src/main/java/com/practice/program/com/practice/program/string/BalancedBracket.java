package com.practice.program.com.practice.program.string;

/**
 * Created by rsinghal on 11/9/2017.
 */
public class BalancedBracket {


    public static void main(String arr[]) {

        String[] str_arr = new String[15];

        BalancedBracket b = new BalancedBracket();
        System.out.println(b.isBalanced("(([)])"));


    }

    public boolean isBalanced(String value) {

        boolean flag = false;
        if (value.length() % 2 == 0) {
            String newValue = new String();
            char[] ch = value.toCharArray();
            if(value.length() > 0 && value.startsWith("}") || value.startsWith("]") || value.startsWith(")")){
                return false;
            }
            if (value.length() == 0) {
                flag = true;
                return flag;
            } else {
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] == ')') {
                        if (ch[i - 1] == '(') {
                            newValue = value.substring(0, i-1) + value.substring(i+1);
                            flag = isBalanced(newValue);
                            break;
                        } else
                            flag = false;
                        return flag;

                    } else if (ch[i] == ']') {
                        if (ch[i - 1] == '[') {
                            newValue = value.substring(0, i-1) + value.substring(i+1);
                           flag = isBalanced(newValue);
                            break;
                        } else
                            flag = false;
                        return flag;
                    } else if (ch[i] == '}') {
                        if (ch[i - 1] == '{') {
                            newValue = value.substring(0, i-1) + value.substring(i+1);
                            flag=  isBalanced(newValue);
                            break;
                        } else
                            flag = false;
                        return flag;
                    }
                }

            }


        }
        return flag;
    }

}



