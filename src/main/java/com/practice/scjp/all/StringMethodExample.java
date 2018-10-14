package com.practice.scjp.all;

public class StringMethodExample {

	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("123456789");
		s=s.delete(0, 3);
		System.out.println(s + "\n");
		s=s.replace(1, 3, "24");
		System.out.println(s + "\n");
		s.delete(4, 6);
		System.out.println(s);
	}

}
