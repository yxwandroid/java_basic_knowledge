package com.wilson.java.thread;

import java.util.concurrent.CompletableFuture;

public class CompletedFutureDemo {

    static void completedFutureExample() {
        CompletableFuture cf = CompletableFuture.completedFuture("message");
        boolean done = cf.isDone();
        System.out.println(done);
//        assertTrue(cf.isDone());
//        assertEquals("message", cf.getNow(null));
    }

    public static void main(String[] args) {
        completedFutureExample();
    }
}
