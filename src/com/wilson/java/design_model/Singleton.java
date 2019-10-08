package com.wilson.java.design_model;



//6 枚举 可读性太差

//5,静态内部类
//优点：懒加载，线程安全，推荐使用
public class Singleton {
    private Singleton() {
    }


    public static Singleton getInstance() {

        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {

        private static final Singleton singleton = new Singleton();
    }
}

//4,懒汉式线程 (双重检查锁定)
//优点  懒加载  线程安全  效率高
//缺点  volatile影响一点性能  高并发下有一定的缺陷
//public  class  Singleton{
//
//    private Singleton() {
//    }
//
//    private volatile static Singleton singleton= null;
//
//    public static   Singleton getInstance(){
//        if (singleton==null){
//            synchronized (Singleton.class){
//                if (singleton==null){
//                    singleton= new Singleton();
//                }
//            }
//        }
//        return  singleton;
//    }
//}

////3,懒汉式线程安全
//优点 实现了懒加载的机制  线程安全
//缺点 使用了synchronize造成不必要的内存开销
//public  class  Singleton{
//
//
//    private Singleton() {
//    }
//
//    private static Singleton singleton= null;
//
//
//    public static  synchronized  Singleton getInstance(){
//
//        if (singleton==null){
//            singleton= new Singleton();
//        }
//        return  singleton;
//    }
//}

// 2,懒汉式 线程不安全
// 优点 使用了懒加载方式
// 缺点 线程不安全
//public class Singleton {
//    private Singleton() {
//    }
//
//
//    private static Singleton singleton = null;
//
//    public static Singleton getInstance() {
//        if (singleton == null) {
//
//            singleton = new Singleton();
//        }
//
//        return singleton;
//    }
//}


//1,饿汉式
// 优点 写法简单 线程安全
// 缺点 没有使用过的话会造成内存的浪费
//
//public class Singleton {
//
//    private Singleton() {
//    }
//
//    private  static  Singleton singleton=new Singleton();
//
//    public static  Singleton getInstance(){
//
//        return  singleton;
//
//    }
//}
