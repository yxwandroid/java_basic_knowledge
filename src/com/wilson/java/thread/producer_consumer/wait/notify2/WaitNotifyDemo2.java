package com.wilson.java.thread.producer_consumer.wait.notify2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 生产者消费者模式
 */
public class WaitNotifyDemo2 {
    public static void main(String[] args) {

        final Queue sharedQ = new LinkedList();
        Producer producer = new Producer(sharedQ);
        Consumer consumer = new Consumer(sharedQ);
        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {

    private final Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            synchronized (queue) {
                while (queue.size() >= 1) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("producer---"+i);
                queue.add(i);
                queue.notify();
            }

        }
    }
}

class Consumer extends Thread {

    private final Queue queue;


    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Object poll = queue.poll();
                System.out.println("---consumer---"+poll);
                queue.notify();
            }
        }


    }
}