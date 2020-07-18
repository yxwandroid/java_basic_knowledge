package com.wilson.java.thread.interview;

import java.util.concurrent.locks.ReentrantLock;

//多线程交替打印ABC的多种实现方法
class ReentrantLockDemo {

    private static ReentrantLock lock = new ReentrantLock();
    private static int state = 0;


    static  class ThreadA extends  Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                while (state%3==0){
                    System.out.println("A");
                    state++;

                }
            }

        }
    }

    public static void main(String[] args) {


    }
}
