package com.wilson.java.thread.interview;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * https://www.cnblogs.com/dolphin0520/p/3920397.html
 * CyclicBarrier  使用
 * 字面意思是 回环栅栏
 * 可以实现一组线程等待到某个状态之后再全部同步执行
 * 回环的意思是 当等待线程都被释放之后 CyclicBarrie 可以被重用 这种状态就是barrier
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        int N = 4;
//        CyclicBarrier barrier = new CyclicBarrier(N);

        //若是想在所有线程写入操作执行完成之后 进行额外的操作的时候可以使用CyclicBarrier提供的Runnable进行操作
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程" + Thread.currentThread().getName());
            }
        });

        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CyclicBarrier重用");
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + " 正在写入数据");
            try {
                Thread.sleep(1000);
                System.out.println("线程" + Thread.currentThread().getName() + " 写入数据完成");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 所有线程写入数据完成 继续处理其他任务");

        }
    }
}
