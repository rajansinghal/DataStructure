package com.practice.scjp.all;

 class Foo  {

	private int x;

	public Foo(int x) {
		
		this.x = x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}
}

public class Gamma {

	static Foo fooBar(Foo foo) {

		//foo = new Foo(100);
		foo.setX(400);
		//System.out.println(foo.getX() + "--");
		return foo;
	}

	public static void main(String arr[]) {

		Foo foo = new Foo(300);
		System.out.println(foo.getX() + "-");
		
		Foo fooFoo = fooBar(foo);
		System.out.println(foo.getX() + "-");
		System.out.println(fooFoo.getX() + "-");
		
		foo = fooBar(fooFoo);
		System.out.println(foo.getX() + "-");
		System.out.println(fooFoo.getX());
	}

}
