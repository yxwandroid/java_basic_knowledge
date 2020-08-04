package com.wilson.java.thread.interview;

//死锁的场景
// 当两个线程同时拥有一定的资源，但是都缺少对方手上的资源才能进行下一步动作，而去竞争对方的资源，从而都陷入等待的一种场景，这种场景被称为死锁。
//例如：A、B线程在运行开始时分别持有a、b对象，A拥有a，对象a被A上锁了，B拥有b，对象b被B上锁了，此时，线程A在要往后运行需要对象b，而线程B要往后运行需要对象a，此时A、B线程都希望获得对方的资源，但是手上的资源都不愿拿出来，这个时候就形成了“僵局”，进入了死锁。
// https://blog.csdn.net/u014039577/article/details/48808323
// https://blog.csdn.net/xiao_ma_CSDN/article/details/78753242

public class DeadLockDemo {
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (o1) {
                System.out.println("线程1锁o1");
                try {
                    Thread.sleep(1000);
                    synchronized (o2) {
                        System.out.println("线程1锁o2");
                    }
                } catch (Exception e) {

                }
            }
        }).start();
        new Thread(() -> {
            synchronized (o2) {
                System.out.println("线程2锁o2");
                try {
                    synchronized (o1) {
                        System.out.println("线程2锁o1");
                    }
                } catch (Exception e) {

                }
            }
        }).start();

    }

}
