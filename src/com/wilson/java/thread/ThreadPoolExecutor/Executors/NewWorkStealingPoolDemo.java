package com.wilson.java.thread.ThreadPoolExecutor.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个拥有多个任务队列（以便减少连接数）的线程池
 */
public class NewWorkStealingPoolDemo {
    public static void main(String[] args) {
        System.out.println("---- start ----");
        ExecutorService executorService = Executors.newWorkStealingPool(2);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
        System.out.println("---- end ----");

    }
}
