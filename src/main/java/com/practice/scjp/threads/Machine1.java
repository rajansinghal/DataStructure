package com.practice.scjp.threads;

import java.util.ArrayList;
import java.util.List;

class Machine1 extends Thread {
	List<MachineInstructions> jobs =new ArrayList<MachineInstructions>();
	
	public void addJob(MachineInstructions job) {
		synchronized (jobs) {
		jobs.add(job);
		jobs.notify();
		}
	}
	/*Machine1(List<String> jobs){
		
		this.jobs=jobs;
	}*/
	public void run() {
		while (true) {
			synchronized (jobs) {
				// wait until at least one job is available
				while (jobs.isEmpty()) {
					try {
						jobs.wait();
					} catch (InterruptedException ie) {
					}
				}
				// If we get here, we know that jobs is not empty
				MachineInstructions instructions = jobs.remove(0);
				// Send machine steps to hardware
			}
		}
	}
}