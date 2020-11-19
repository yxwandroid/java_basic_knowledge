package com.wilson.java.hander;


import java.util.concurrent.DelayQueue;

public class MessageQueue {

    Message mMessages;

    DelayQueue<Message> queue = new DelayQueue<>();

    public void enqueue(Message msg) {
        queue.offer(msg);
        System.out.println("enqueue msg: what = " + msg.what);
    }

    public Message next() {
        Message msg = null;
        try {
            msg = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println("next msg: what = " + msg.what);
        return msg;
    }

}