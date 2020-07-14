package com.wilson.java.thread;

/**
 *
 * 传递数据到线程的方法
 *
 * 1,通过构造方法传递数据
 * 2,通过回调函数传递数据
 * 3,通过变量和方法传递数据
 * Created by yangxuewu on 2018/8/13.
 */
public class ThreadPassParameter {


    public static void main(String[] args) {
        new MyThread("wilson").start();

    }


}

