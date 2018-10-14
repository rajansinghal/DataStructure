package com.practice.scjp.threads;

class ThreadA implements Runnable {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " ,count :" + i);
		}
	}

}

class ThreadB implements Runnable {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " ,count :" + i);
		}
	}

}
public class ThreadTesting {

	public static void main(String arr[]){
		
		Thread th = new Thread(new ThreadA());
		Thread thb = new Thread(new ThreadB());
		th.setName("ThreadA");
		thb.setName("ThreadB");
		th.start();
		thb.start();
		try {
			th.join();
			thb.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " ,count-" + i);
		} 
		
	}
}
