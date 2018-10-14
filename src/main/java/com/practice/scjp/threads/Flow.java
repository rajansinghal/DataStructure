package com.practice.scjp.threads;

public class Flow {

	public static void main(String arr[]) throws InterruptedException{
		
		
		Runnable r = new Runnable(){
			public void run(){
				
				try{
					System.out.println("thread name : " + Thread.currentThread().getName() + "   before 1000");
					Thread.sleep(9000);
					System.out.println("thread name : " + Thread.currentThread().getName() + "   after 1000");
				}catch(InterruptedException iex){
					System.out.println("thread name : " + Thread.currentThread().getName() +"    interrupted ....");
				}
				System.out.println("thread name : " + Thread.currentThread().getName()+"   ran..");
			}
		};
		Thread t = new Thread(r);
		System.out.println("thread name : " + Thread.currentThread().getName() +"  before started...");
		t.start();
		System.out.println("thread name : " + t.getName() +"   started...");
		t.sleep(4000);
		System.out.println("thread name : " + t.getName() + "   interrupting...");
		t.interrupt();
		System.out.println("thread name : " + t.getName() +"   ended..");
	}
	
}
