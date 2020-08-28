package com.wilson.java.thread.interrupt;


/**
 * 退出方式3
 * 双重保险
 *  中断标识+interrupt
 */
public class ThreadInterruptDemo3 {
    public static void main(String[] args) {

        Thread3 thread3 = new Thread3();
        thread3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.on=true;
        thread3.interrupt();
    }
}

class Thread3 extends Thread {

    public volatile boolean on = false;

    @Override
    public void run() {
        while (!on) {
            try {
                System.out.println("线程运行!");
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                System.out.println("caught exception: " + e);
            }
        }
    }

}
