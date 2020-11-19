package com.wilson.java.thread.threadlocal;

public class ThreadLocalDemo2 {

    public static void main(String[] args) {
        MyThreadLocalRunnable myThreadLocalRunnable = new MyThreadLocalRunnable();
        new Thread(myThreadLocalRunnable, "线程1").start();
        new Thread(myThreadLocalRunnable, "线程2").start();
        new Thread(myThreadLocalRunnable, "线程3").start();
    }

    static class MyThreadLocalRunnable implements Runnable {

        private ThreadLocal<String> myThreadLocal = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return "初始化值";
            }
        };

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            myThreadLocal.set(name + "的ThreadLocal");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ":" + myThreadLocal.get());
        }
    }
}


