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
 * 非阻塞队列无法实现线程等待 这样会导致消费者线程直接执行结束
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


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("consumer  start ");
                while (true){
                    Integer take = arrQueue.peek();
                    System.out.println(take);
                    if (arrQueue.isEmpty())
                        break;
                }
                System.out.println("consumer  end ");
            }
        });



        consumer.start();
        Thread.sleep(2200);
        producer.start();

    }
}
