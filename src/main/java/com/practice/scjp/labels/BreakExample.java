package com.practice.scjp.labels;

public class BreakExample {

	
	public static void main(String arr[]){
		
		//this tells break lets exit from the current loop only.
		/*for(int i=0;i<3;i++){
			System.out.println(" outer i :" + i);
			for (int j=0;j<3;j++){
				System.out.println(" inner j :" + j);
				if(i==1 && j==1)
					break;
			}
		}*/
		for(int i=0;i<3;i++){
			System.out.println(" outer i :" + i);
			for (int j=0;j<3;j++){
				System.out.println(" inner j :" + j);
				if(i==1 && j==1)
					continue;
				System.out.println("-------");
			}
		}
	}
}
