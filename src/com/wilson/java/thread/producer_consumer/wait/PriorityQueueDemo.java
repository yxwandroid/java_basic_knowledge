package com.wilson.java.thread.producer_consumer.wait;

import java.util.PriorityQueue;

/**
 *  非阻塞队列生产者消费者
 *
 *  使用wait notify
 *  注意使用线程同步锁  synchronized
 */
public class PriorityQueueDemo {

    private  int queueSize=10;
    private PriorityQueue priorityQueue=new PriorityQueue(queueSize);
    public static void main(String[] args) {
        PriorityQueueDemo priorityQueueDemo = new PriorityQueueDemo();
        Producer producer = priorityQueueDemo.new Producer();
        Consumer consumer= priorityQueueDemo.new Consumer();
        producer.start();
        consumer.start();
    }



    class Producer extends  Thread{
        @Override
        public void run() {
            while (true){
                synchronized (priorityQueue){
                    while (priorityQueue.size()==queueSize){
                        try {
                            priorityQueue.wait();
                            System.out.println("队列满的时候进行生产等待");

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            priorityQueue.notify();
                        }
                    }
                    priorityQueue.offer(1);
                    priorityQueue.notify();
                    System.out.println("队列不满的时候进行生成任务");
                }

            }
        }
    }


    class Consumer extends Thread{
        @Override
        public void run() {
            while (true){

                synchronized (priorityQueue){
                    while (priorityQueue.size()==0){
                        try {
                            priorityQueue.wait();
                            System.out.println("队列空的时候消费等待");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            priorityQueue.notify();
                        }
                    }
                    System.out.println("队列不为空的时候消费进行消费");
                    priorityQueue.poll();
                    priorityQueue.notify();
                }

            }

        }
    }

}

