package com.practice.scjp.core;

class XOROperator2 {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		System.out.print(!false ^ false);
		System.out.print(" " + (!b1 & (b2 = true)));
		System.out.println(" " + b2 +"-" + b1);
		System.out.println(" " + (b2 ^ b1));
	}
}