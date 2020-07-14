package com.wilson.java.collection_demo;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程不安全
 */
public class LinkedListDemo {
    public static void main(String []arr){
        LinkedList<String>  strLists    = new LinkedList<>();
        strLists.add("ee");
        strLists.get(0);
        strLists.remove(0);
    }
}
