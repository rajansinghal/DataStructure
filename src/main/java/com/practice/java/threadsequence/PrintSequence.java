package com.practice.java.threadsequence;

public class PrintSequence{
    public static volatile int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();
        PPrinter PPrinter = new PPrinter(monitor);
        Thread thread1 = new Thread(PPrinter, "T1");
        Thread thread2 = new Thread(PPrinter, "T2");
        Thread thread3 = new Thread(PPrinter, "T3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}



class PPrinter implements Runnable {

    private Object monitor = null;
    private static int i = 1;
    private static boolean first = true;
    private static boolean second = false;
    private static boolean third = false;

    public PPrinter(Object objcurr) {
        this.monitor = objcurr;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (monitor) {
                    String Tname = Thread.currentThread().getName();
                    if (first && Tname.equalsIgnoreCase("T1")) {
                        print();
                        first = false;
                        second = true;
                        monitor.notifyAll();
                        monitor.wait();
                    } else if (second && Tname.equalsIgnoreCase("T2")) {
                        print();
                        second = false;
                        third = true;
                        monitor.notifyAll();
                        monitor.wait();
                    } else if (third && Tname.equalsIgnoreCase("T3")) {
                        print();
                        third = false;
                        first = true;
                        monitor.notifyAll();
                        monitor.wait();
                    } else {
                        monitor.wait();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void print() {
        System.out.println(Thread.currentThread().getName() + " - " + PPrinter.i++);
    }
}