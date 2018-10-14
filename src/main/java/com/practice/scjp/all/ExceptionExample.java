package com.practice.scjp.all;

public class ExceptionExample {
	
	public static void main(String[] args) {
		int x = 6;
		ExceptionExample p = new ExceptionExample();
		p.doStuff(x);
		System.out.print(" main x = " + x);
	}

	void doStuff(int x) {
		System.out.print(" doStuff x = " + x++);
	}
}