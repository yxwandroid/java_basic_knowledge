package com.wilson.java.thread.semaphore;

import java.util.concurrent.Semaphore;

/**
 * https://www.cnblogs.com/dolphin0520/p/3920397.html
 * 假若一个工厂有5台机器，但是有8个工人，一台机器同时只能被一个工人使用，只有使用完了，其他工人才能继续使用。那么我们就可以通过Semaphore来实现：
 */
public class SemaphoreDemo {
    public static void main(String[] args) {

        int N = 8;  //八个工人
        Semaphore semaphore = new Semaphore(5); //5台机器

        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
//                acquire() 表示阻塞并获取许可
                semaphore.acquire();
                System.out.println("工人" + this.num + "   占用了一个机器");
                Thread.sleep(1000);
                System.out.println("工人" + this.num + "   释放了一个机器");
//                release() 表示释放许可
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

