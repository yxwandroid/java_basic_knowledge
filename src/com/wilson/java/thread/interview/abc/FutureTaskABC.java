package com.wilson.java.thread.interview.abc;

import sun.lwawt.macosx.CSystemTray;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskABC {
    public static void main(String[] args) {
        FutureTask<String> futureTaskA = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "A";
            }
        });

        FutureTask<String> futureTaskB = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "B";
            }
        });

        FutureTask<String> futureTaskC = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "C";
            }
        });

        Thread threadC = new Thread(futureTaskC);
        threadC.start();

        Thread threadB = new Thread(futureTaskB);
        threadB.start()
        ;
        Thread threadA = new Thread(futureTaskA);
        threadA.start();
        try {

            //利用了get方法阻塞的
            String A = futureTaskA.get();
            System.out.println(A);

            String B = futureTaskB.get();
            System.out.println(B);

            String C = futureTaskC.get();
            System.out.println(C);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
