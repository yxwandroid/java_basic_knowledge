package com.wilson.java.thread.block.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 非阻塞队列
 * 添加方法
 * add
 * offer
 * 移出方法
 * remove
 * poll
 * peek
 *
 */
public class ConcurrentLinkedQueueDemo {
    public static void main(final String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<Integer> arrQueue = new ConcurrentLinkedQueue<>();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    arrQueue.add(11);
                    Thread.sleep(1000);
                    arrQueue.add(22);
                    arrQueue.add(33);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread producer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    arrQueue.add(1);
                    arrQueue.add(2);
                    Thread.sleep(1000);
                    arrQueue.add(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("consumer  start ");
                while (!arrQueue.isEmpty()) {
                    Integer take = arrQueue.remove();
                    System.out.println(take);
                    if (arrQueue.isEmpty())
                        break;

                }
                System.out.println("consumer  end ");
            }
        });

        producer.start();
        producer2.start();
        Thread.sleep(2200);
        consumer.start();

    }
}
