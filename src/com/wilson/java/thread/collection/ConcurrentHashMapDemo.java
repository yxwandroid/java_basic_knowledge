package com.wilson.java.thread.collection;


import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程并发容器  concurrentHashMap
 *concurrentHashMap 使用的是分段锁技术 提高了并发的访问率
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();

        for (int i = 0; i < 5; i++) {
            concurrentHashMap.put(i, i + "");
        }
        Thread putThread= new Thread() {
            @Override
            public void run() {
                concurrentHashMap.put(111, "333");
                System.out.println("----add----");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread putThread2= new Thread() {
            @Override
            public void run() {
                concurrentHashMap.put(222, "444");
                System.out.println("----add----");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread getAllThread = new Thread() {
            @Override
            public void run() {
                for (Iterator<Map.Entry<Integer, String>> iterator = concurrentHashMap.entrySet().iterator(); iterator.hasNext(); ) {
                    Map.Entry<Integer, String> entry = iterator.next();
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };



        try {
            putThread2.start();
            putThread.start();
            getAllThread.start();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----main----");
        for (Map.Entry<Integer, String> entry : concurrentHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
