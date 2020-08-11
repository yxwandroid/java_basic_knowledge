package com.wilson.java.thread.collection;


import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {


        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1","1");
        concurrentHashMap.get("1");
        concurrentHashMap.remove("1");


    }
}
