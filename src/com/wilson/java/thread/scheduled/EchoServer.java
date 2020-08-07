package com.wilson.java.thread.scheduled;

public class EchoServer implements Runnable {
    @Override
    public void run() {
        System.out.print("定时执行\n");
    }
}
