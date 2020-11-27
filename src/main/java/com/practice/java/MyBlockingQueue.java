package com.practice.java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {

    private Queue<T> queue;
    private AtomicInteger limit = new AtomicInteger(10);
    private Lock put_lock = new ReentrantLock();
    private Lock take_lock = new ReentrantLock();
    private Condition put_condition = put_lock.newCondition();
    private Condition take_condition = take_lock.newCondition();

    public MyBlockingQueue(AtomicInteger limit) {
        queue = new LinkedList<T>();
        this.limit = limit;
    }

    public boolean put(T item) throws InterruptedException {
        put_lock.lockInterruptibly();
        try {
            while (queue.size() == limit.get()) {
                put_condition.await();
            }
            put_condition.signal();
            queue.add(item);
        } finally {
            put_lock.unlock();
        }

        return true;
    }

    public T take() throws InterruptedException {
        take_lock.lockInterruptibly();
        try {
            while (queue.size() == 0) {
                take_condition.await();
            }
            take_condition.signal();
            return queue.poll();
        } finally {
            take_lock.unlock();
        }
    }
}