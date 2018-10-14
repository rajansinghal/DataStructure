package com.practice.scjp.all;

public class StringExample {
	
	public static void main(String arr[]){
		
		StringBuilder s = new StringBuilder("123456789");
		//s.delete(0,3).delete(1,3));
		System.out.println(s.delete(0,3).delete(1,3).delete(2,5).insert(1, "24"));
	}

}
