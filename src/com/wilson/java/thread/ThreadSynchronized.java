package com.wilson.java.thread;

/**
 * Created by yangxuewu on 2018/8/13.
 */
public class ThreadSynchronized {

    public  int inc = 0;

    public  synchronized void increase() {
        synchronized(this){
            inc++;
        }

    }

    public static void main(String[] args) {
        final ThreadSynchronized test = new ThreadSynchronized();
        for(int i=0;i<10000;i++){
            new Thread(() -> {

                System.out.println("-------------------------"+ Thread.currentThread());
                test.increase();
                System.out.println(test.inc);
            }).start();
        }

        while(Thread.activeCount()>1){
            //保证前面的线程都执行完
            Thread.yield(); //将线程变成可运行的状态
        }

    }

}
