package com.practice.scjp.core;

 class Hello {
	String title;
	int value;

	public Hello() {
		title += " World";
	}

	public Hello(int value) {
		this.value = value;
		title = "Hello";
		Hello();
		
	}

	
}

public class CunstrocterExample {
	public static void main(String arr[]){
		
		 Hello c = new Hello(5);
		 System.out.println(c.title);
	}
}
