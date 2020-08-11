package com.wilson.java.thread;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ThreadLocal 线程的局部变量 属于线程自身 不在多线程内共享
 * 把数据进行隔离，数据不共享，自然就没有线程安全方面的问题了.
 */
class ThreadLocalDemo {

    public static void main(String args[]) throws IOException {
        Thread t1 = new Thread(new MyTask());
        Thread t2 = new Thread(new MyTask());

        t1.start();
        t2.start();

    }

    /*
     * Thread safe format method because every thread will use its own DateFormat
     */
    public static String threadSafeFormat(Date date) {
        DateFormat formatter = PerThreadFormatter.getDateFormatter();
        return formatter.format(date);
    }

}


/*
 * Thread Safe implementation of SimpleDateFormat
 * Each Thread will get its own instance of SimpleDateFormat which will not be shared between other threads. *
 */
class PerThreadFormatter {

    private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>() {

        /*
         * initialValue() is called
         */
        @Override
        protected SimpleDateFormat initialValue() {
            System.out.println("Creating SimpleDateFormat for Thread : " + Thread.currentThread().getName());
            return new SimpleDateFormat("dd/MM/yyyy");
        }
    };

    /*
     * Every time there is a call for DateFormat, ThreadLocal will return calling
     * Thread's copy of SimpleDateFormat
     */
    public static DateFormat getDateFormatter() {
        return dateFormatHolder.get();
    }
}

class MyTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("Thread: " + Thread.currentThread().getName() + " Formatted Date: " + ThreadLocalDemo.threadSafeFormat(new Date()));
        }
    }
}


