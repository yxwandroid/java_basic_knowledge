package com.wilson.java.thread.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//多线程交替打印ABC十次的实现方法
class ReentrantLockDemo {

    public ReentrantLock lock = new ReentrantLock();
    public Condition condition1 = lock.newCondition();
    public Condition condition2 = lock.newCondition();
    public Condition condition3 = lock.newCondition();
    private int state = 0;

    public void start() {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();

    }

    class ThreadA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 0) {
                        condition1.await();
                    }
                    System.out.println("A");
                    state++;
                    condition2.signal();
                    ;
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
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 1) {
                        condition2.await();
                    }
                    System.out.println("B");
                    state++;
                    condition3.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class ThreadC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 2) {
                        condition3.await();
                    }
                    System.out.println("C");
                    state++;
                    condition1.signal();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }

        }
    }

    public static void main(String[] args) {

        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        reentrantLockDemo.start();


    }
}
