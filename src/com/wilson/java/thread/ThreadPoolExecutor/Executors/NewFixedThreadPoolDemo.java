package com.wilson.java.thread.ThreadPoolExecutor.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 核心线程数即为最大线程数，线程不会被回收，直到调用shutdown方法回收
 */
public class NewFixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = () -> System.out.println("当前线程  " + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            executorService.execute(runnable);
        }
    }
    //注意  调用shutdown 方法的时候会导致线程被回收 出现一只在创建线程
//        executorService.shutdown();

}


