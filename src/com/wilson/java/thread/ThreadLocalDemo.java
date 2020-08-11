package com.wilson.java.thread;


/**
 * ThreadLocal 线程的局部变量 属于线程自身 不在多线程内共享
 * 把数据进行隔离，数据不共享，自然就没有线程安全方面的问题了.
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}


class MyThread extends Thread {

    public ThreadLocal<Integer> threadLocal = new ThreadLocal();

    @Override
    public void run() {
        threadLocal.set(11);

        System.out.println(threadLocal.get());
    }
}
