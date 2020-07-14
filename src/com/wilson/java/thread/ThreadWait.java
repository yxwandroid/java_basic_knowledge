package com.wilson.java.thread;

/**
 * Created by yangxuewu on 2018/8/13.
 *
 *  安全的终止线程的方法
 *  1,使用interrupt 终止线程
 *  2,使用标识符终止线程
 */
public class ThreadWait {


    public static void main(String[] args){
        MyThreadA wilson = new MyThreadA("wilson");

        MyThreadB myThreadB = new MyThreadB();
        try {
            wilson.start();
            Thread.sleep(600);
            wilson.interrupt();

            myThreadB.start();
            Thread.sleep(600);
            myThreadB.cancel();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}

//1,使用interrupt 终止线程
class MyThreadA extends Thread {

    private String Name;

    public MyThreadA(String name) {
        Name = name;
    }


    @Override
    public void run() {
        super.run();


        while (!Thread.currentThread().isInterrupted()){
            System.out.println("run");

        }
        System.out.println("stop");

    }
}


class MyThreadB extends Thread {

//volatile 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
    private  volatile  boolean on = true ;

    @Override
    public void run() {
        super.run();

        while (on){
            System.out.println("run -------B");

        }
        System.out.println("stop----------B");

    }


    public void cancel(){
        on = false;
    }
}

