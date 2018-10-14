package com.practice.scjp.Recurssion;

public class FabonacciByRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FabonacciByRecursion().recursion(10));
	}

	
	public int recursion(int fab){
		
		if(fab ==1 )
			return 1;
		else{
			//don't try recursion(fab--)
			return fab + recursion(fab-1);
		}
	}
}
