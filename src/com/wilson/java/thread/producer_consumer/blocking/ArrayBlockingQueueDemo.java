package com.wilson.java.thread.producer_consumer.blocking;


import java.util.concurrent.ArrayBlockingQueue;
/**
 * 使用阻塞队列实现生产者和消费者相对比非阻塞队列更简洁  避免使用了wait 和notify
 * https://blog.csdn.net/basycia/article/details/52061904
 */
public class ArrayBlockingQueueDemo {
    private ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(2);

    public static void main(String[] args) {


        ArrayBlockingQueueDemo arrayBlockingQueueDemo = new ArrayBlockingQueueDemo();
        Producer producer = arrayBlockingQueueDemo.new Producer();
        Consumer consumer = arrayBlockingQueueDemo.new Consumer();
        producer.start();
        consumer.start();

    }


    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    arrayBlockingQueue.put("");
                    System.out.println("进行消息的生成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {

            while (true) {
                try {
                    String take = arrayBlockingQueue.take();
                    System.out.println("进行消息的消费");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
