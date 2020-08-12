package com.wilson.java.thread.ThreadPoolExecutor.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建可变线程池
 * 如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。核心线程池大小为0，最大为Integer.MAX_VALUE，线程空闲存活时间是60秒。
 */
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable runnable = () -> System.out.println("线程名称" + Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
