package com.wilson.java.thread.interview.abc;

/**
 * https://blog.csdn.net/Evankaka/article/details/80800081
 * join 让当前线程执行完之后执行接下来的逻辑
 */
public class JoinABC {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("A");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadA.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    threadB.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
            }
        });


        threadC.start();
        threadB.start();
        threadA.start();


//            threadA.join();
//            threadB.join();
//            threadC.join();


    }


}
