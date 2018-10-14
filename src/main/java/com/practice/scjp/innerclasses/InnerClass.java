package com.practice.scjp.innerclasses;

class BigOuter{
	
	static class Nest{void go(){System.out.println("Nest ::");}}
}
public class InnerClass {
	
	class InnerClassRegularNest{
		
		void go1(){System.out.println("InnerClassRegularNest ::");}
	}
	static class InnerClassNest{
		void go(){System.out.println("InnerClassNest ::");}
	}
	public static void main(String arr[]){
		
		BigOuter.Nest bn= new BigOuter.Nest();
		bn.go();
		InnerClassNest in = new InnerClassNest();
		in.go();
		InnerClass.InnerClassRegularNest inr= new InnerClass().new InnerClassRegularNest();
		inr.go1();
		//InnerClassRegularNest inr1=new InnerClassRegularNest();
	}
}
