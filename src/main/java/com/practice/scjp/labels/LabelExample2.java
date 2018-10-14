package com.practice.scjp.labels;

public class LabelExample2 {
	static String o = "";

	public static void main(String[] args) {
		z: for (int x = 2; x < 7; x++) {
			/*if (x == 3)
				continue;*/
			
			for (int y = 2; y < 7; y++) {
				if (x == 4)
					break z;
				o = o + x+y+",";
			}
			
		}
		System.out.println(o);
	}
}
