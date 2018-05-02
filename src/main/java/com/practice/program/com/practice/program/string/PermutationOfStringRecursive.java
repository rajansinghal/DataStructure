package com.practice.program.com.practice.program.string;

import java.util.Date;

public class PermutationOfStringRecursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		permute("","abcd");
		
		

	}
	
	public static void permute(String beginString, String endString){

		System.out.println("beginString :: " + beginString + "  endString :: "+ endString);
		for(int i=0;i<endString.length();i++){
			
			if(endString.length() <= 1)
				System.out.println(beginString+endString);
			else{
				
					String newString=endString.substring(0,i)+endString.substring(i+1);
					permute(beginString+endString.charAt(i), newString);
				
			}
			
			
		}
		
	}

}
