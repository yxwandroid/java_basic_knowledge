package com.wilson.java.thread.block;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        try {
            arrayBlockingQueue.put("22");

            String take = arrayBlockingQueue.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
