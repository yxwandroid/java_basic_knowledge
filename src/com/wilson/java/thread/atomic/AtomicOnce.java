package com.wilson.java.thread.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 保证多线程执行的情况下代码只执行一次的方式
 */
public class AtomicOnce {

    public static void main(String[] args) {
        InitXxxService initXxxService = new InitXxxService();
        new Thread(() -> {
            initXxxService.init();
        }).start();
        new Thread(() -> {
            initXxxService.init();
        }).start();
        new Thread(() -> {
            initXxxService.init();
        }).start();
        new Thread(() -> {
            initXxxService.init();
        }).start();
    }

}


class InitXxxService {

    private AtomicBoolean initState = new AtomicBoolean(false);

    public void init() {
        // 若是当前值和期望值相等就更新值为true
        //参考https://my.oschina.net/haoran100/blog/712485
        if (!initState.compareAndSet(false, true)) {//init once
            return;
        }
        //TODO 写初始化代码
        System.out.println("初始化代码");
    }
}