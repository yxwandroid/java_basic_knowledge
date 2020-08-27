package com.wilson.java.thread.interview.addnum;


/**
 * 使用10个线程累加到10000
 *  思路
 *    使用synchronized同步锁进行多线程累加保证线程安全
 *    使用两种类型的锁
 *       对象锁
 *       类锁
 */
public class ThreadSynchronized {
    public int inc = 0;

    //添加同步锁
    public synchronized void increase() {
        synchronized (ThreadSynchronized.class) {
            inc++;
        }
    }

    public static void main(String[] args) {
        ThreadSynchronized test = new ThreadSynchronized();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    if (test.inc >= 1000)
                        return;
                    test.increase();
                    System.out.println(test.inc);
                }

            }).start();
        }

//        while (Thread.activeCount() > 1) {
//            //保证前面的线程都执行完
//            Thread.yield(); //将线程变成可运行的状态
//        }

    }

}

/**
 * 使用方式是对象锁
 */
class addNum {
    public static void main(String[] args) {

        addNum addNum = new addNum();

        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    while (true){
                        if (addNum.num>=1000)
                            return;
                        addNum.add();
                        System.out.println(addNum.num);
                    }
                }
            }.start();

        }
    }


    public int num = 0;

    public synchronized void add() {
        synchronized (this) {
            num++;
        }
    }
}
