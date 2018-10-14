package com.practice.scjp.all;

public class StringSplitExample {

	public static void main(String arr[]){
		
		String test = "This is a test";
		String[] tokens = test.split("\s");
		System.out.println(tokens.length);
	}
}
