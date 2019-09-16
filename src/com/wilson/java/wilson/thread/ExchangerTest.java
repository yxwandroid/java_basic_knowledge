package com.wilson.java.wilson.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  参考 https://blog.csdn.net/u012758088/article/details/70314271
 * Created by yangxuewu on 2018/8/13.
 */
public class ExchangerTest {





    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        final Exchanger<User> exchanger = new Exchanger<User>();

        service.execute(() -> {
            try {

                User wilson = new User("wilson", 20);
                System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + wilson.toString() + "换出去");

                Thread.sleep((long) (Math.random() * 10000));

                User user2 =  exchanger.exchange(wilson);
                System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + user2.toString());
            } catch (Exception e) {

            }
        });

        service.execute(() -> {
            try {
                User user = new User("yangxuewu", 211);
                System.out.println("线程" + Thread.currentThread().getName() + "正在把数据" + user.toString() + "换出去");

                Thread.sleep((long) (Math.random() * 10000));

                User data2 =  exchanger.exchange(user);
                System.out.println("线程" + Thread.currentThread().getName() + "换回的数据为" + data2.toString());
            } catch (Exception e) {

            }
        });
    }
}

class User {
    String Name;

    int  Age;

    public User(String name, int age) {
        Name = name;
        Age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}