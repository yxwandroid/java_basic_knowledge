package com.wilson.java.thread.producer_consumer.wait.notify;


import java.util.ArrayList;

/**
 * https://www.cnblogs.com/eenio/p/11385090.html
 *
 * 生产者消费者  wait和notify 实现方式
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {
        try {
            String lock = "lock";
            Produce p = new Produce(lock);
            Reduce r = new Reduce(lock);
            ThreadP threadP = new ThreadP(p);
            ThreadR threadR = new ThreadR(r);
            threadP.start();
            threadR.start();
            ThreadR.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


class MyList {
    public static ArrayList<String> list = new ArrayList();

    public MyList() {
    }

    public static int getSize() {
        return list.size();
    }
}

class Produce {
    private String lock;

    public Produce(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (MyList.getSize() != 0) {   //无需生产
                    lock.wait();
                }
                //生产
                String temp = "设置了值" + System.currentTimeMillis();
                System.out.println(temp);
                MyList.list.add(temp);


                Thread.sleep(1000);
                lock.notify();  //通知消费者
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


//消费者
class Reduce {
    private String lock;

    public Reduce(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (MyList.getSize() == 0) {   //等待生产
                    lock.wait();
                }
                //消费
                System.out.println("获取到的值是：" + MyList.list.remove(0));
                lock.notify();  //通知生产者
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadP extends Thread {
    private Produce produce;

    public ThreadP(Produce p) {
        this.produce = p;
    }

    @Override
    public void run() {
        while (true) {
            produce.setValue();
        }
    }
}

class ThreadR extends Thread {
    private Reduce reduce;

    public ThreadR(Reduce r) {
        this.reduce = r;
    }

    @Override
    public void run() {
        while (true) {
            reduce.getValue();
        }
    }
}