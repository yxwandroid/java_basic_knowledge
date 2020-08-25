package com.wilson.java.thread.block.block;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * https://blog.csdn.net/dfskhgalshgkajghljgh/article/details/51363543
 * <p>
 * LinkedBlockingQueue 是阻塞队列
 * 添加元素
 * add  超过指定大小抛出异常
 * put  超过指定大小会阻塞线程等待空间
 * offer 超过指定大小会返回false
 * <p>
 * 取元素
 * poll   若队列为空 返回null
 * remove 若队列为空抛出异常
 * take   若队列为空发生阻塞等待有元素
 */
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>(2);
        LinkedBlockingQueueDemo linkedBlockingQueueDemo = new LinkedBlockingQueueDemo();
//        linkedBlockingQueueDemo.add(linkedBlockingQueue);
//        linkedBlockingQueueDemo.put(linkedBlockingQueue);
        linkedBlockingQueueDemo.offer(linkedBlockingQueue);

    }

    //offer方法在添加元素时，如果发现队列已满无法添加的话，会直接返回false。
    private void offer(LinkedBlockingQueue<String> linkedBlockingQueue) {
        linkedBlockingQueue.offer("1");
        linkedBlockingQueue.offer("2");
        boolean offer = linkedBlockingQueue.offer("3");
        System.out.println(offer);
        try {
            String take = linkedBlockingQueue.take();
            System.out.println(take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 对于put方法，若向队尾添加元素的时候发现队列已经满了会发生阻塞一直等待空间，以加入元素。
    private void put(LinkedBlockingQueue<String> linkedBlockingQueue) {
        try {
            linkedBlockingQueue.put("3");
            linkedBlockingQueue.put("1");
            //添加到2的时候会出现阻塞  一直等待空间
            linkedBlockingQueue.put("2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            String take = linkedBlockingQueue.take();
            System.out.println(take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //add方法在添加元素的时候，若超出了度列的长度会直接抛出异常：
    private void add(LinkedBlockingQueue<String> linkedBlockingQueue) {
        linkedBlockingQueue.add("3");
        linkedBlockingQueue.add("1");
        linkedBlockingQueue.add("2");
        try {
            String take = linkedBlockingQueue.take();
            System.out.println(take);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

