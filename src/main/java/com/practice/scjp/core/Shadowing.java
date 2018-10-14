package com.practice.scjp.core;

public class Shadowing {
	int squares = 81;

	public static void main(String[] args) {
		new Shadowing().go();
	}

	void go() {
		incr(++squares);
		//test(20);
		System.out.println("squares ::" + squares);
		
	}

	void incr(int squares) {
			squares += 10;
		
	}
	
}