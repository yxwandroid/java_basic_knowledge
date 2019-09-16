package com.wilson.java.wilson.thread;

/**
 * Created by yangxuewu on 2018/8/7.
 *
 * 使用 interrupt 终止线程
 *
 */
public class ThreadInterrupt extends  Thread {

    @Override
    public void run() {
        for (int i = 0;i<100000;i++){
            System.out.println("run");
        }
        System.out.println("stop");
    }

    public  static void main(String[] args) throws Exception{

        ThreadInterrupt thread = new ThreadInterrupt();
        thread.start();
        sleep(2000); // 主线程延迟5秒
        thread.interrupt();
        System.out.println("线程退出!");


        
    }
}
