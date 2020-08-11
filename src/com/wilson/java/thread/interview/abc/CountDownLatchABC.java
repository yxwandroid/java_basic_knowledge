package com.wilson.java.thread.interview.abc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchABC {
    public static void main(String[] args) {
        CountDownLatch countDownLatchA = new CountDownLatch(1);
        CountDownLatch countDownLatchB = new CountDownLatch(1);
        CountDownLatch countDownLatchC = new CountDownLatch(1);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatchA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
                countDownLatchB.countDown();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatchB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
                countDownLatchC.countDown();

            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatchC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
                countDownLatchC.countDown();


            }
        });

        threadC.start();
        threadB.start();
        threadA.start();

        countDownLatchA.countDown();


    }

}
