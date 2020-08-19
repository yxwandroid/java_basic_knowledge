package com.wilson.java.thread.interview;


/**
 * 两个线程交替打印0-100  方式二
 * 两个线程交替获取锁
 *
 */
public class AlternateNumDemo2 {

    private static Object object = new Object();

    private static int count = 0;

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (count < 100) {
                synchronized (object) {
                    //打印偶数
                    System.out.println(Thread.currentThread().getName() + "--打印偶数-" + count);
                    count++;


                    object.notifyAll();

                    if (count < 100) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        });
        Thread b = new Thread(() -> {
            while (count < 100) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "--打印奇数-" + count);
                    count++;
                    object.notifyAll();
                    if (count < 100) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        a.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
