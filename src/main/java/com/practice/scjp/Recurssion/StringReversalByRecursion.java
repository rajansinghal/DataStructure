package com.practice.scjp.Recurssion;

public class StringReversalByRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="najar";
		new StringReversalByRecursion().reverse(s.toCharArray(), 0, s.length()-1);
	}
	
	
	public void reverse(char[] str, int begin, int end){
		
		if(begin==end || (begin-end)==1){
			
			System.out.println(new String(str));
		}
		else{
			char ch=str[begin];
			str[begin]=str[end];
			str[end]=ch;
			begin=begin+1;
			end=end-1;
			reverse(str, begin, end);
		
		}
		
	}

}
