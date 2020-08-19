package com.wilson.java.thread.interview;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印0-100  方式三
 * 使用reentrantLock 进行处理
 */
public class AlternateNumDemo3 {

    private static int count = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();


    class ThreadA extends Thread {
        @Override
        public void run() {
            while (count<100) {
                try {
                    lock.lock();
                    while ((count&1)!= 0) {
                        condition1.await();
                    }
                    System.out.println("偶数--"+count);
                    count++;
                    condition2.signal();
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
            while (count < 100) {
                try {
                    lock.lock();
                    while ((count & 1) != 1) {
                        condition2.await();
                    }
                    System.out.println("奇数--" + count);
                    count++;
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }

    }



    public  void start(){
        try {
            new ThreadA().start();
            Thread.sleep(10);
            new ThreadB().start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        AlternateNumDemo3 alternateNumDemo3 = new AlternateNumDemo3();
        alternateNumDemo3.start();

    }
}
