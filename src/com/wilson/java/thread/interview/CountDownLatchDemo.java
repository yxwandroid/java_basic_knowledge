package com.wilson.java.thread.interview;

import java.util.concurrent.CountDownLatch;


//阿里面试题
//问题：用代码实现：有三个任务A，B，C，需要实现A与B可以并行做，A与B都做完才 能开始C任务，如何实现？思路即
//实现方式 A B 并行  C等待 AB 执行完之后执行
//参考 https://blog.csdn.net/buptwds/article/details/51955890
//https://www.jianshu.com/p/962bc7225ce8

public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(2);
        Thread a = new Thread(new MyRunnable("A", latch));
        Thread b= new Thread(new MyRunnable("B", latch));
        a.start();
        b.start();

        try {
            latch.await();
            Thread c = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("C");
                }
            });
            c.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class MyRunnable implements Runnable {

        private String value;
        private CountDownLatch latch;

        public MyRunnable(String value, CountDownLatch latch) {
            this.value = value;
            this.latch = latch;
        }

        @Override
        public void run() {
            latch.countDown();

            System.out.println(value);

        }
    }

}
