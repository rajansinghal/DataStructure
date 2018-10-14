package com.practice.scjp.collection;

import java.util.*;

public class HashSetExample {
	private String s;

	public HashSetExample(String s) {
		this.s = s;
	}

	public static void main(String[] args) {
		HashSet<Object> hs = new HashSet<Object>();
		//HashSetExample ws1 = new HashSetExample("aardvark");
		//HashSetExample ws2 = new HashSetExample("aardvark");
		String s1 = new String("aardvark");
		String s2 = new String("aardvark");
		//hs.add(ws1);
		//hs.add(ws2);
		hs.add(s1);
		hs.add(s2);
		System.out.println(hs.size());
	}
}