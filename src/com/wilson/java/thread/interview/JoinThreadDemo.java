package com.wilson.java.thread.interview;

//join
//串行执行 A  B  主线程
public class JoinThreadDemo {

    public static void main(String[] args) {

        try {
            AThread a = new AThread("A");
            a.start();
            a.join();
            AThread  B= new AThread("B");
            B.start();
            B.join();

            System.out.println("main start");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }





    static class AThread extends Thread {
        public AThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            System.out.printf("%s start\n",this.getName());
            for (int i = 0; i < 1000; i++) {

            }

            System.out.printf("%s finish\n",this.getName());

        }
    }
}
