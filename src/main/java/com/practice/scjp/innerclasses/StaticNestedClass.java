package com.practice.scjp.innerclasses;

class TestClass{
	
	static class StaticNestedTestClass{
		public void display(){
			
			System.out.println("StaticNestedTestClass");
		}
		
	}
}


public class StaticNestedClass {
	
	static class NestedStaticNestedClass{
		
		public void displayMethod(){
			
			System.out.println("display method...");
		}
	}
	public static void main(String arr[]){
		
		TestClass.StaticNestedTestClass var= new TestClass.StaticNestedTestClass();
		var.display();
		NestedStaticNestedClass var1= new NestedStaticNestedClass();
		var1.displayMethod();
	}
}
