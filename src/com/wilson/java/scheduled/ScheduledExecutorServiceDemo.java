package com.wilson.java.scheduled;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
	// write your code here
        System.out.print("用print输出i:");
        executeFixedRate();

    }


    /**
     * 以固定周期频率执行任务
     */
    public static void executeFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(
                new EchoServer(),
                0,
                100,
                TimeUnit.MILLISECONDS);
    }

}
