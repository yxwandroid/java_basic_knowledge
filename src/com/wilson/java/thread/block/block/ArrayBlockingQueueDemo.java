package com.wilson.java.thread.block.block;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列 当消费者消费的时候若是没有消息 就会进入阻塞状态
 */
public class ArrayBlockingQueueDemo {
    public static void main(final String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrQueue = new ArrayBlockingQueue<Integer>(2);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    arrQueue.put(11);
                    Thread.sleep(100);
                    arrQueue.put(22);
                    Thread.sleep(100);
                    arrQueue.put(33);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread producer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    arrQueue.put(1);
                    Thread.sleep(200);
                    arrQueue.put(2);
                    Thread.sleep(200);
                    arrQueue.put(3);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Integer take = arrQueue.take();
                        System.out.println(take);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    //若是注释掉消费线程会处于阻塞状态
//                    if (arrQueue.isEmpty()){
//                        break;
//                    }

                    System.out.println("--run--");
                }

            }
        });
        consumer.start();
        Thread.sleep(3000);
        producer.start();
        Thread.sleep(3000);
        producer2.start();

    }
}
