package com.practice.scjp.core;

interface DeclareStuff {
	public static final int EASY = 3;

	void doStuff(int t);
}

public class Final_InterfaceExample implements DeclareStuff {
	public static void main(String[] args) {
		int x = 5;
		new Final_InterfaceExample().doStuff(++x);
	}

	public void doStuff(int s) {
		s += EASY + ++s;
		System.out.println("s " + s);
	}
}