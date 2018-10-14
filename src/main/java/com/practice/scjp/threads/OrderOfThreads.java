package com.practice.scjp.threads;


//Objective: You have thread T1, T2 and T3, how will you ensure that thread T2 run after T1 and thread T3 run after T2?
class Job implements Runnable{
	
	public void run(){
		System.out.println("current thread :: " + Thread.currentThread().getName());
	}
}

public class OrderOfThreads {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1=new Thread(new Job());
		Thread t2=new Thread(new Job());
		Thread t3=new Thread(new Job());
		Thread t4=new Thread(new Job());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("main thhead.");
		//Thread t3=new Thread(new Job());
	}

}
