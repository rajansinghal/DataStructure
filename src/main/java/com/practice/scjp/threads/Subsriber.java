package com.practice.scjp.threads;

import java.util.ArrayList;
import java.util.List;

class Subsriber extends Thread {
	List<String> jobs = new ArrayList<String>();
	Subsriber sub = new Subsriber();
	
	

	public void addJob(String job) {
		synchronized (jobs) {
			jobs.add(job);
			jobs.notify();
		}
	}


	public void run() {
		while (true) {
			String job = onMessage();
			machine.addJob(job);
		}
	}
	
	
}
