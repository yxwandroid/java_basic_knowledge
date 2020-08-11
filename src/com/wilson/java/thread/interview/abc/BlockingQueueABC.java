package com.wilson.java.thread.interview.abc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueABC {
    public static void main(String[] args) {


        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("A");

            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("B");

            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("C");

            }
        });

        BlockingQueue<Thread> threads = new LinkedBlockingQueue<>();
        threads.add(threadA);
        threads.add(threadB);
        threads.add(threadC);


        for (int i = 0; i < 3; i++) {
            Thread t = null;
            try {
                t = threads.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
            //检测线程是否还活着
            while (t.isAlive());
        }
    }
}
