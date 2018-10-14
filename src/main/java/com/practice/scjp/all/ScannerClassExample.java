package com.practice.scjp.all;

import java.util.Scanner;

public class ScannerClassExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	// String csv = "Sue,5,true,3";
		 Scanner scanner = new Scanner( System.in );
		 scanner.useDelimiter(",");
		 int age = scanner.nextInt();
		 System.out.println("age :: " + age);	}

}
