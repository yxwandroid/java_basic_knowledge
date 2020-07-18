package com.wilson.java.thread.interview;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new MyThread(i + "", countDownLatch).start();
        }
        countDownLatch.countDown();
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
            try {
                latch.await();
                System.out.println("执行---" + getName());


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
