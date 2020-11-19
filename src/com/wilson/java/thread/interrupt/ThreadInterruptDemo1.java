package com.wilson.java.thread.interrupt;

/**
 * 使用Interrupt 退出 但是不能退出正在运行的线程
 */
public class ThreadInterruptDemo1 {
    // 退出方式1 不能退出正在运行的线程
    public static void main(String[] args) {
        Thread1 thread = new Thread1();
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("线程退出!");

    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Yes,I am interruted,but I am still running");
                return;
            } else {
                System.out.println("not yet interrupted");
            }
        }

    }

}