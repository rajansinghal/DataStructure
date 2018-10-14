package com.practice.scjp.threads;

public class WaitException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WaitException().waitForSignal();
	}

	void waitForSignal() {
		Object obj = new Object();
		synchronized (Thread.currentThread()) {
			obj.wait();
			obj.notify();
		}
	}

}
