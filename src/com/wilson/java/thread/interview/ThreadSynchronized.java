package com.wilson.java.thread.interview;

public class ThreadSynchronized {

    public static int inc = 0;

    public synchronized void increase() {
        synchronized (ThreadSynchronized.class) {
            inc++;
        }

    }

    public static void main(String[] args) {
        ThreadSynchronized test = new ThreadSynchronized();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {

                    if (inc >= 1000)
                        return;

                    test.increase();
                    System.out.println(test.inc);
                }

            }).start();
        }

        while (Thread.activeCount() > 1) {
            //保证前面的线程都执行完
            Thread.yield(); //将线程变成可运行的状态
        }

    }

}
