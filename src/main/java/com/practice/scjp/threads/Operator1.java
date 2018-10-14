package com.practice.scjp.threads;

class Operator1 extends Thread {
	Machine1 machine= new Machine1(); // assume this gets initialized

	public void run() {
		while (true) {
			Shape shape = getShapeFromUser();
			MachineInstructions job = calculateNewInstructionsFor(shape);
			machine.addJob(job);
		}
	}
}