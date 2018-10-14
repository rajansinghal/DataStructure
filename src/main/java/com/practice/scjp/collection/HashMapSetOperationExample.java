package com.practice.scjp.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapSetOperationExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String,String> map= new HashMap<String,String>();
		map.put("rajan","BMW");
		map.put("saurabh","Maruti");
		map.put("paras","Audi");
		map.put("rupesh","Tata");
		map.put("himadri","Fiat");
		
	
		for(Map.Entry<String, String> entry: map.entrySet()){
			
			System.out.println("key : "+entry.getKey() +" ,value : "+ entry.getValue());
			
			
		}
		System.out.println("---------------------------------------");
		for(Map.Entry<String, String> entry: map.entrySet()){
			
			
			System.out.println("key : "+entry.getKey() +" ,value : "+ entry.getValue());
			
		}
		
	}

}
