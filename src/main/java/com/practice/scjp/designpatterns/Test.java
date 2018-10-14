package com.practice.scjp.designpatterns;

public class Test {
	String name;
	Test(String name){
		this.name=name;
	}

	public static void main(String arr[]){
		
		Test test = new Test("rajan");
		System.out.println("name :" + test.name);
	}
}
