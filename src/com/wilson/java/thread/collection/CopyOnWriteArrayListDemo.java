package com.wilson.java.thread.collection;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.get(0);
        copyOnWriteArrayList.remove(0);

    }
}
