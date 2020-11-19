package com.wilson.java.thread.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicDemo {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        new Thread(new MyRunnable(atomicBoolean, "thread1")).start();
        new Thread(new MyRunnable(atomicBoolean, "thread2")).start();
        new Thread(new MyRunnable(atomicBoolean, "thread3")).start();
    }
}

class MyRunnable implements Runnable {
    private AtomicBoolean atomicBoolean;
    String name;


    public MyRunnable(AtomicBoolean atomicBoolean, String name) {
        this.atomicBoolean = atomicBoolean;
        this.name = name;
    }

    @Override
    public void run() {

        if (atomicBoolean.compareAndSet(false, true)) {
            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }

            System.out.println(name + " leave");
            atomicBoolean.set(false);
        } else {
            System.out.println(name + " give up");
        }

    }
}