package com.wilson.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 乐观锁悲观锁
 */
public class OptimismAndPessimismLock {

    // 线程不安全
    private static int value1 = 0;

    //线程安全  使用乐观锁
    private static AtomicInteger value2 = new AtomicInteger(0);

    //线程安全  使用悲观锁
    private static int value3 = 0;
    private static synchronized void addValue3() {
        value3++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        value1++;
                        value2.getAndIncrement();

                        addValue3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
            System.out.println(value1);
            System.out.println(value2);
            System.out.println(value3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
