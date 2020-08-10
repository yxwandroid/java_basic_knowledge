package com.wilson.java.thread;

import java.util.concurrent.*;

/**
 * Callable
 * Future
 * FutureTask
 * https://www.cnblogs.com/dolphin0520/p/3949310.html
 */
public class CallableDemo {

    public static void main(String[] args) {
//        //方式1
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Task task = new Task();
//        Future<Integer> submit = executorService.submit(task);
//        executorService.shutdown();

        //方式2
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(task);
        executorService.submit(integerFutureTask);
        executorService.shutdown();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
//            System.out.println("task运行结果" + submit.get());
            System.out.println("task运行结果" + integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");

    }
}


class Task implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    }
}