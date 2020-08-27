package com.wilson.java.thread.interview.abc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//串行打印abc
public class NewSingleThreadExecutorABC {

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> System.out.println("A"));
        Thread threadB = new Thread(() -> System.out.println("B"));
        Thread threadC = new Thread(() -> System.out.println("C"));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(threadA);
        executorService.submit(threadB);
        executorService.submit(threadC);
        executorService.shutdown();

    }
}
