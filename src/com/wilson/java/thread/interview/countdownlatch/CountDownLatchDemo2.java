package com.wilson.java.thread.interview.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new MyThread(i + "", countDownLatch).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main run");

    }


    static class MyThread extends Thread {


        CountDownLatch latch;

        public MyThread(String name, CountDownLatch latch) {
            super(name);
            this.latch = latch;
        }


        @Override
        public void run() {
            latch.countDown();
            System.out.println("执行---" + getName());


        }
    }
}
