package com.practice.scjp.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IterationOverObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Object> l= new ArrayList<Object>();
		l.add(new Object());
		l.add(new Object());
		l.add(new Object());
		Collections.sort(l);
/*
 * Bound mismatch: The generic method sort(List<T>) of type Collections is not applicable for the arguments (List<Object>).
 * The inferred type Object is not a valid substitute for the bounded parameter <T extends Comparable<? super T>>
 * 
 * 
 * */
	}

}
