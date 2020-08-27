
#### 多线程面试题

1,多线程操作变量累加到10000
   
     参见 ThreadSynchronized类
     参见 MultiThreadAddNum类
   
2,多线程交替打印ABC十次的实现方法
 
     参见  ReentrantLockDemo
  
  
3,使用多线程串行打印ABC  

     参见
      JoinABC类 利用join特性实现
      NewSingleThreadExecutorABC类   利用单例线程池实现
      FutureTaskABC类   利用FuturenTask线程阻塞实现
      CountDownLatchABC类  //利用CountDownLatch等待别的线程执行完之后执行才执行自己的逻辑实现
      BlockingQueueABC类  //利用阻塞队列实现  


4,写一个死锁的场景  
    
     参见 DeadLockDemo类
   
5,  CyclicBarrier类的使用   
     
    现让一组线程等待至某个状态之后再全部同时执行
    参见 CyclicBarrierDemo类
    
    
6,  CountDownLatch类的使用
     
     
     一个线程或多个线程一直等待，直到其他线程执行的操作完成。 才执行本线程
     
     
7 两个线程交替打印0-100 
    
     方式1 使用synchronized同步锁争抢的方式  参考alternateNumDemo
     方式2 使用synchronized同步锁  wait notify的方式  参考alternateNumDemo2
     方式3 使用ReentrantLocak方式进行打印 AlternateNumDemo3
  
  三个线程交替打印0-100 
  
    方式2 使用synchronized同步锁  wait notify的方式  参考AlternateNumDemo4
    方式3 使用ReentrantLocak方式进行打印 参考 AlternateNumDemo5
    

