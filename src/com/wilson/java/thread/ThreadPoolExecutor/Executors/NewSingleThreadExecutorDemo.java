package com.wilson.java.thread.ThreadPoolExecutor.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 仅有一个线程执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class NewSingleThreadExecutorDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程---"+Thread.currentThread().getName());
            }
        };
        for (int i = 0; i < 100; i++) {
            executorService.execute(runnable);
        }

    }
}
