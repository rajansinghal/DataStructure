package com.practice.scjp.overriden;

class A {
	void foo() throws Exception {
		throw new Exception();
	}
}

class SubB2 extends A {
	void foo() {
		System.out.println("B ");
	}
}

class Tester {
	public static void main(String[] args) {
		A a = new SubB2();
		a.foo();
	}
}