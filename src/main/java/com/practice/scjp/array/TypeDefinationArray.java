package com.practice.scjp.array;

/*The reason you can get away with compiling this for arrays is because there is a
runtime exception (ArrayStoreException) that will prevent you from putting the
wrong type of object into an array. If you send a Dog array into the method that takes
an Animal array, and you add only Dogs (including Dog subtypes, of course) into the
array now referenced by Animal, no problem. But if you DO try to add a Cat to the
object that is actually a Dog array, you'll get the exception.
*/

/*
But there IS no equivalent exception for generics, because of type erasure!
In other words, at runtime the JVM KNOWS the type of arrays, but does NOT
know the type of a collection. All the generic type information is removed during
compilation, so by the time it gets to the JVM, there is simply no way to recognize
the disaster of putting a Cat into an ArrayList<Dog> and vice versa */


public class TypeDefinationArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog[] dog=new Dog[2];
		dog[0]=new Dog();
		new TypeDefinationArray().take(dog);

	}

	
	public void take(Animal[] animal){
		
		animal[0].print();
		animal[1]=new Cat();
		animal[1].print();
	}
}
class Animal{
	
	public void print(){
		System.out.println("animal");
	}
}
class Dog extends Animal{
	
	public void print(){
		System.out.println("Dog");
	}
}
class Cat extends Animal{
	
	public void print(){
		System.out.println("cat");
	}
}