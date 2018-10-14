package com.practice.scjp.core;

public class ArithmaticOperator2 {
	
	public static void main(String[] args) {
		int x = 6;
		ArithmaticOperator2 p = new ArithmaticOperator2();
		p.doStuff(x);
		System.out.print(" main x = " + x);
	}

	void doStuff(int x) {
		System.out.print(x +" doStuff x = " + x++);
	}
}