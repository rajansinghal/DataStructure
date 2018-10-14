package com.practice.scjp.threads;

class Machine extends Thread {
	public static void main(String arr[]) {
		Operator operator = new Operator(); // assume this gets initialized
		operator.start();
		while (true) {
			synchronized (operator) {
				try {
					System.out.println("Waiting for operator to complete...");
					operator.wait();
				} catch (InterruptedException ie) {
					System.out.println("Total is: " + operator.total);
				}
				// Send machine steps to hardware
			}
		}

	}
}

class Operator extends Thread {
	int total;

	public void run() {
		while (true) {
			// Get shape from user
			synchronized (this) {
				// Calculate new machine steps from shape
				for (int i = 0; i < 100; i++) {
					System.out.println("i  =>" + i);
					total += i;
				}
				notify();
			}
		}
	}
}