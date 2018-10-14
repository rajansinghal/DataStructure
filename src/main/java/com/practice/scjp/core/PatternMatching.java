package com.practice.scjp.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "my name is rajan. rajan is a good boy.";
		Pattern ptr= Pattern.compile("rajan");
		Matcher mtr= ptr.matcher(str);
		while(mtr.find()){
			System.out.println(mtr.pattern());
		}
	}

}
