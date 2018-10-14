package com.practice.scjp.Recurssion;

public class FactorialByRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new FactorialByRecursion().factorial(5));
		System.out.println(new FactorialByRecursion().recursion(5));
	}
	public int factorial(int fact){
		int s=1;
		int i=1;
		while(i  <= fact){
		
			s= s*i;
			i++;
		}
		return s;
	}		
		
	
	public int recursion( int fact){
		
		if(fact == 1)
			return 1;
		else
			return fact * recursion(fact-1);
		
	}
}
