package com.wilson.java.thread;


/**
 * Created by yangxuewu on 2018/8/7.
 * <p>
 * 使用 interrupt 终止线程
 */
public class ThreadInterruptDemo extends Thread {


    private volatile static boolean on = false;



    // 退出方式3
    @Override
    public void run() {
        while(!on){
            try {  System.out.println("线程运行!");
                Thread.sleep(10000000);
            } catch (InterruptedException e) {
                System.out.println("caught exception: "+e);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        ThreadInterruptDemo thread = new ThreadInterruptDemo();
        thread.start();
        Thread.sleep(1000); // 主线程延迟5秒
        ThreadInterruptDemo.on = true;
        thread.interrupt();
        System.out.println("线程退出!");


    }

//    // 退出方式2
//    @Override
//    public void run() {
//        while (!on) {
//            if (Thread.currentThread().isInterrupted()) {
//                System.out.println("Yes,I am interruted,but I am still running");
//            } else {
//                System.out.println("not yet interrupted");
//            }
//        }
//
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        ThreadInterruptDemo thread = new ThreadInterruptDemo();
//        thread.start();
//        sleep(2000); // 主线程延迟5秒
//        ThreadInterruptDemo.on = true;
//        System.out.println("线程退出!");
//
//
//    }


// 退出方式1
//    @Override
//    public void run() {
//        while (true) {
//            if (Thread.currentThread().isInterrupted()) {
//                System.out.println("Yes,I am interruted,but I am still running");
//                return;
//            } else {
//                System.out.println("not yet interrupted");
//            }
//        }
//
//    }

//    public static void main(String[] args) throws Exception {
//
//        ThreadInterruptDemo thread = new ThreadInterruptDemo();
//        thread.start();
//        sleep(2000); // 主线程延迟5秒
////        thread.interrupt();
//        ThreadInterruptDemo.on =true;
//        System.out.println("线程退出!");
//
//
//    }
}
