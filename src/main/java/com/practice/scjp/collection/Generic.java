package com.practice.scjp.collection;

import java.util.ArrayList;
import java.util.List;

class Animal{}
class Dog extends Animal{}
class Beagel extends Dog{}

public class Generic {

	private void genericMethod(){
		
		List<? extends Dog> li = new ArrayList<Beagel>();
		List<? super Dog> li1 = new ArrayList<Dog>();
		//li.add(new Beagel());
		
		
	}
	public static void main(String arr[]){
		
		new Generic().genericMethod();
	}
}
