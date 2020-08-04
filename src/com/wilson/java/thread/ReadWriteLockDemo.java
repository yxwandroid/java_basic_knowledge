package com.wilson.java.thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * 多个读锁之间不需要互斥
 * 写锁之间是需要互斥的
 */
public class ReadWriteLockDemo {

    private Object object = null;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void get() {
        readWriteLock.readLock().lock();
        try {

            System.out.println(Thread.currentThread().getName() + " 准备读数据");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + " 读取的数据是 " + object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


    public void put(Object object) {

        readWriteLock.writeLock().lock();
        try {

            System.out.println(Thread.currentThread().getName() + " 准备写数据");
            Thread.sleep((long) (Math.random() * 1000));
            this.object = object;

            System.out.println(Thread.currentThread().getName() + " 写的数据是 " + object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }


    public static void main(String[] args) {

        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLockDemo.get();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLockDemo.put(new Random().nextInt(8));
                }
            }).start();
        }
    }
}
