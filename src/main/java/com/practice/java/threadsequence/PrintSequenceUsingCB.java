package com.practice.java.threadsequence;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


class CyclicBarrierFinishEvent implements Runnable{

    public void run() {
            System.out.println("As 3 threads have reached common barrier point "
                    + ", CyclicBarrrierFinishEvent has been triggered");
            System.out.println("You can update shared variables if any");
    }

}

class RunnableTaskOne implements Runnable {

    int i=1;
    CyclicBarrier cyclicBarrier;
    long sleepTime;

    RunnableTaskOne(CyclicBarrier cyclicBarrier, long sleepTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(sleepTime);
                System.out.println(i + "," + Thread.currentThread().getName());
               /*System.out.println(Thread.currentThread().getName() +
                    " is waiting for " + (cyclicBarrier.getParties() - cyclicBarrier.getNumberWaiting() - 1) +
                    " other threads to reach common barrier point");*/
                /*
                 * when  3 parties will call await() method (i.e. common barrier point)
                 * CyclicBarrrierEvent will be triggered and all waiting threads will be released.
                 */
                cyclicBarrier.await();
                i = i + 3;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
      /*  System.out.println("As " + cyclicBarrier.getParties() + " threads have reached common barrier point "
                + Thread.currentThread().getName() +
                " has been released");*/
    }

}

class RunnableTaskTwo implements Runnable {

    int i=2;
    CyclicBarrier cyclicBarrier;
    long sleepTime;

    RunnableTaskTwo(CyclicBarrier cyclicBarrier, long sleepTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while(true) {
            try {

                Thread.sleep(sleepTime);
                System.out.println(i + "," + Thread.currentThread().getName());
            /*System.out.println(Thread.currentThread().getName() +
                    " is waiting for " + (cyclicBarrier.getParties() - cyclicBarrier.getNumberWaiting() - 1) +
                    " other threads to reach common barrier point");*/
                /*
                 * when  3 parties will call await() method (i.e. common barrier point)
                 * CyclicBarrrierEvent will be triggered and all waiting threads will be released.
                 */
                cyclicBarrier.await();
                i = i + 3;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

      /*  System.out.println("As " + cyclicBarrier.getParties() + " threads have reached common barrier point "
                + Thread.currentThread().getName() +
                " has been released");*/
        }
    }

}

class RunnableTaskThree implements Runnable {

    int i=3;
    CyclicBarrier cyclicBarrier;
    long sleepTime;

    RunnableTaskThree(CyclicBarrier cyclicBarrier, long sleepTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(sleepTime);
                System.out.println(i + "," + Thread.currentThread().getName());
            /*System.out.println(Thread.currentThread().getName() +
                    " is waiting for " + (cyclicBarrier.getParties() - cyclicBarrier.getNumberWaiting() - 1) +
                    " other threads to reach common barrier point");*/
                /*
                 * when  3 parties will call await() method (i.e. common barrier point)
                 * CyclicBarrrierEvent will be triggered and all waiting threads will be released.
                 */
                cyclicBarrier.await();
                i = i + 3;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

      /*  System.out.println("As " + cyclicBarrier.getParties() + " threads have reached common barrier point "
                + Thread.currentThread().getName() +
                " has been released");*/
        }
    }

}

class IrisMain1 {
    public static void main(String[] args) {
        /*
         * Create CountDownLatch with 3 parties, when all 3 parties
         * will reach common barrier point CyclicBarrrierFinishEvent will be
         * triggered
         */
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3 ,new CyclicBarrierFinishEvent());

        RunnableTaskOne runnableTask1=new RunnableTaskOne(cyclicBarrier,1000);
        RunnableTaskTwo runnableTask2=new RunnableTaskTwo(cyclicBarrier,2000);
        RunnableTaskThree runnableTask3=new RunnableTaskThree(cyclicBarrier,3000);
        //RunnableTaskThree runnableTask4=new RunnableTaskThree(cyclicBarrier,4000);

        //Create and start 3 threads
        new Thread(runnableTask1,"Thread-1").start();
        new Thread(runnableTask2,"Thread-2").start();
        new Thread(runnableTask3,"Thread-3").start();
        //new Thread(runnableTask3,"Thread-4").start();

        /*
         * We are reusing cyclic barrier using below threads
         * */
      /*  RunnableTask runnableTask4=new RunnableTask(cyclicBarrier,4000);
        RunnableTask runnableTask5=new RunnableTask(cyclicBarrier,5000);
        RunnableTask runnableTask6=new RunnableTask(cyclicBarrier,6000);

        // Create and start 3 more threads
        new Thread(runnableTask4,"Thread-4").start();
        new Thread(runnableTask5,"Thread-5").start();
        new Thread(runnableTask6,"Thread-6").start();*/

    }
}