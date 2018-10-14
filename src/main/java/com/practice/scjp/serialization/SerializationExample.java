package com.practice.scjp.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Animal { // not serializable !
	int weight = 42;
}

class Dog extends Animal implements Serializable {
	static int number_of_legs=4;
	String name;
	transient int age = 10;
	Dog(int w, String n) {
		weight = w; // inherited
		name = n; // not inherited
	}
}

public class SerializationExample {
	public static void main(String[] args) {
		Dog d = new Dog(35, "Fido");
		System.out.println("before: " + d.name + " | " + d.weight +" | " + d.age + " | " + d.number_of_legs);
		try {
			FileOutputStream fs = new FileOutputStream("C:\\ZIPTEST\\testSer.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("C:\\ZIPTEST\\testSer.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (Dog) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after: " + d.name + " | " + d.weight + " | " + d.age + " | " + d.number_of_legs);
	}
}