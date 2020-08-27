package com.wilson.java.thread.interview.alternatenum;


/**
 * 两个线程交替打印0-100  方式一
 * 两个线程争抢锁
 */
public class AlternateNumDemo {

    private static  Object object=new Object();

    private static int count=0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (count<100){
                synchronized (object){
                    //打印偶数
                    if ((count&1)==0){
                        System.out.println(Thread.currentThread().getName()+"--打印偶数-"+count);
                        count++;
                    }
                }

            }
        }).start();
        new Thread(() -> {
            while (count<100){
                synchronized (object){
                    if ((count&1)==1){
                        System.out.println(Thread.currentThread().getName()+"--打印奇数-"+count);
                        count++;
                    }
                }

            }
        }).start();
    }
}
