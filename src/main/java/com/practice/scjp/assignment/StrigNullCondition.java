package com.practice.scjp.assignment;


public class StrigNullCondition {
	String str1 ;
	public void stringNullCheck(){
		
		if(str1 == null){
			System.out.println("here 1..");
		}
		else if(str1.equalsIgnoreCase("null")){
			System.out.println("here ");
		}
		 
		else
		System.out.println("here 2..");
	}
	public static void main(String arr[]){
		
		StrigNullCondition str = new StrigNullCondition();
		str.stringNullCheck();
		
	}
}
