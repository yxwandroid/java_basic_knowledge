package com.wilson.java.thread.interview;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印0-100  方式三
 * 使用 ReentrantLock的方式进行处理
 */
public class AlternateNumDemo5 {

    private static int count = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    class ThreadA extends Thread {
        @Override
        public void run() {
            while (count <= 100) {
                try {
                    lock.lock();
                    if (count % 3 == 0) {
                        System.out.println(Thread.currentThread().getName() + "----" + count);
                        count++;
                        condition2.signal();
                    } else {
                        condition1.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class ThreadB extends Thread {
        @Override
        public void run() {
            while (count <= 100) {
                try {
                    lock.lock();
                    if (count % 3 == 1) {
                        System.out.println(Thread.currentThread().getName() + "----" + count);
                        count++;
                        condition3.signal();
                    } else {
                        condition2.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    class ThreadC extends Thread {
        @Override
        public void run() {
            while (count <= 100) {
                try {
                    lock.lock();
                    if (count % 3 == 2) {
                        System.out.println(Thread.currentThread().getName() + "----" + count);
                        count++;
                        condition1.signal();
                    } else {
                        condition3.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    public void start() {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    public static void main(String[] args) {
        AlternateNumDemo5 alternateNumDemo5 = new AlternateNumDemo5();
        alternateNumDemo5.start();


    }
}
