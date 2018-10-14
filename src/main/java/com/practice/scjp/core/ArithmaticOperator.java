package com.practice.scjp.core;

public class ArithmaticOperator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		int x = 5;
		ArithmaticOperator ap = new ArithmaticOperator();
		ap.doStuff(x);
		 System.out.print(" main x = " + x);
	}
	void doStuff(int x) {
		//x++;
		System.out.print(" doStuff x = " + x++ +"-"+ ++x);
	}
}
