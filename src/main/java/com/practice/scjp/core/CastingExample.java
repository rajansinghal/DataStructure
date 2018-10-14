package com.practice.scjp.core;

class Building {
}

public class CastingExample extends Building {
	public static void main(String[] args) {
		Building build1 = new Building();
		CastingExample barn1 = new CastingExample();
		CastingExample barn2 = (CastingExample) build1;
		Object obj1 = (Object) build1;
		//String str1 = (String) build1;
		Building build2 = (Building) barn1;
	}
}