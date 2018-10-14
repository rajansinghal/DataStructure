package com.practice.scjp.collection;

import java.util.Arrays;

public class Quest1 {
	public static void main(String[] args) {
		String[] colors = { "b", "d", "f", "h", "j" };
						//	0     1    2    3    4
		Arrays.sort(colors);
		int s2 = Arrays.binarySearch(colors, "a");
		int s3 = Arrays.binarySearch(colors, "c");
		System.out.println(s2 + " " + s3);
	}
}
