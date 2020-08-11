package com.wilson.java.thread;


/***
 * volatile 保证了可见性和有序性  不保证原子性
 */
public class VolatileDemo {
    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileDemo test = new VolatileDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    test.increase();
                }

            }).start();
        }


        System.out.println(test.inc);
        System.out.println("----");
    }
}
