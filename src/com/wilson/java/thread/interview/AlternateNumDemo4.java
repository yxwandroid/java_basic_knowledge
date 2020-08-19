package com.wilson.java.thread.interview;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印0-100  方式三
 * 使用notify wait 进行处理
 */
public class AlternateNumDemo4 {

    private static int count = 0;
    static final Object obj = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            while (count <=100) {
                synchronized (obj) {
                    if (count % 3 == 0) {
                        System.out.println(Thread.currentThread().getName() + "--" + count);
                        count++;
                        obj.notifyAll();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();

        new Thread(() -> {
            while (count <=100) {
                synchronized (obj) {
                    if (count % 3 == 1) {
                        System.out.println(Thread.currentThread().getName() + "--" + count);
                        count++;
                        obj.notifyAll();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
        new Thread(() -> {
            while (count <=100) {
                synchronized (obj) {
                    if (count % 3 == 2) {
                        System.out.println(Thread.currentThread().getName() + "--" + count);
                        count++;
                        obj.notifyAll();
                    } else {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();

    }
}
