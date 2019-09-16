package com.wilson.java.wilson.thread;

/**
 * Created by yangxuewu on 2018/8/13.
 */
class MyThread extends Thread {

    private String Name;

    public MyThread(String name) {
        Name = name;
    }


    @Override
    public void run() {
        super.run();
        System.out.print("hello   " + Name);

    }
}
