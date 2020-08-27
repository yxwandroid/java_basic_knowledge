package com.wilson.java.thread.interview.addnum;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * // 原文链接：https://blog.csdn.net/wzmde007/article/details/79641084
 * //使用三种方式进行多线程的累加
 *
 * 对象锁
 * 类锁
 * 多线程安全类 AtomicInteger
 *
 */
public class MultiThreadAddNum {

    static int count = 0;

    public static void main(String[] args) {
//        method1();
//        method2();
//        method3();

    }


    //创建五个个线程和五个任务进行操作
    static public void method1() {
        //new一个实现Runnable的类
        MultiThreadAddNum test = new MultiThreadAddNum();
        //创建5个任务
        MyRunnable myRunnable1 = test.new MyRunnable();
        MyRunnable myRunnable2 = test.new MyRunnable();
        MyRunnable myRunnable3 = test.new MyRunnable();
        MyRunnable myRunnable4 = test.new MyRunnable();
        MyRunnable myRunnable5 = test.new MyRunnable();
        //创建5个线程
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
        new Thread(myRunnable3).start();
        new Thread(myRunnable4).start();
        new Thread(myRunnable5).start();
    }

    //使用类锁
    class MyRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (MyRunnable.class) {
                    if (count >= 1000) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ":count:" + (++count));
                    //测试时，线程更容易切换
                    Thread.yield();
                    //使当前线程从运行状态转为就绪状态。CPU
                }

            }

        }
    }


    //使用对象锁
    static public void method2() {
        MultiThreadAddNum test = new MultiThreadAddNum();
        //创建5个任务
        MyRunnable2 myRunnable2 = test.new MyRunnable2();
        for (int i = 0; i < 5; i++) {
            //创建5个线程
            new Thread(myRunnable2).start();
        }

    }


    class MyRunnable2 implements Runnable {

        @Override
        public void run() {
            while (true) {

                synchronized (this) {
                    if (count >= 1000) {
                        break;
                    }

                    System.out.println(Thread.currentThread().getName() + ":count:" + (++count));
                    //测试时，线程更容易切换
                    Thread.yield();
                    //使当前线程从运行状态转为就绪状态。CPU
                }

            }

        }
    }


    static public void method3() {
        for (int i = 0; i < 20; i++) {
            new Thread(new CountRunnable()).start();

        }
    }


    //多线程安全的类
    static AtomicInteger counter = new AtomicInteger(0);

    public static int add() {
        int andAdd = counter.getAndAdd(1);
        return andAdd;
    }


    static class CountRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (counter.get() > 1000) {
                    break;
                }
                System.out.println(MultiThreadAddNum.add());
                Thread.yield();
            }

        }
    }




}
