package com.practice.scjp.all;

import java.io.Console;

public class ConsoleClassExample {
	public static void main(String[] args) {
		 Console c = new Console();
		 String pw;
		 System.out.print("password: ");
		 pw = c.readLine();
		 System.out.println("got " + pw);
		 }
}
 