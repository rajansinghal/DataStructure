package com.practice.scjp.overriden;


class Parent{}
class Child extends Parent{}
class A1 {
	Parent foo() {
		System.out.println("A1 ");
		return null;
	}
}

class SubB3 extends A1 {
	Child foo() {
		System.out.println("Sub3 ");
		return null;
	}
}

class Example2 {
	public static void main(String[] args)  {
		A1 a = new SubB3();
		a.foo();
	}
}