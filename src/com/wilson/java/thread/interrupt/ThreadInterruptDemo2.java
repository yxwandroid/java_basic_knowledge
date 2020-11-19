package com.wilson.java.thread.interrupt;

public class ThreadInterruptDemo2 {
    public static void main(String[] args) {

        Thread2 thread2 = new Thread2();
        thread2.start();


        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.on=true;
    }
}

class Thread2 extends Thread {
    public volatile boolean on = false;

    @Override
    public void run() {
        while (!on) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Yes,I am interruted,but I am still running");
            } else {
                System.out.println("not yet interrupted");
            }
        }
    }
}