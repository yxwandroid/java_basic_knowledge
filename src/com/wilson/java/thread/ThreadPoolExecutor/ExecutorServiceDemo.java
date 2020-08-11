package com.wilson.java.thread.ThreadPoolExecutor;

import java.util.concurrent.*;



//        Executor;
//        ExecutorService
//        AbstractExecutorService
//        ScheduledExecutorService
//        ScheduledThreadPoolExecutor
//        ThreadPoolExecutor
public class ExecutorServiceDemo {


    public static void main(String[] args) {
        System.out.print("-------wilson-------");
        ExecutorServiceDemo  executorServiceDemo=new ExecutorServiceDemo();
        executorServiceDemo.executorService();


        for (int i = 0; i < 100; i++) {

            final int finalI = i;
            executorServiceDemo.executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                }
            });
        }

    }


    ThreadPoolExecutor executorService = null;
    //在调度器里面创建线程池

    /**
     * SynchronousQueue  无缓冲等待队列
     * https://blog.csdn.net/qq_26881739/article/details/80983495
     * @return
     */
    public synchronized ExecutorService executorService() {
        if (executorService == null) {
            executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable runnable) {
                    Thread result = new Thread(runnable, "thread 2");
                    result.setDaemon(true);
                    return result;
                }
            });
//            executorService = new ThreadPoolExecutor(2, 6, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(), Util.threadFactory("OkHttp Dispatcher", false));
//            executorService = new ThreadPoolExecutor(2, 6, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(33), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return executorService;
    }

}
