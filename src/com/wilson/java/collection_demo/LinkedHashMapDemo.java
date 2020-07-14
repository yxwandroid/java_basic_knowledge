package com.wilson.java.collection_demo;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * linkedHashMap为什么能用来做LURCache
 * <p>
 * LinkedHashMap自身已经实现了顺序存储，默认情况下是按照元素的添加顺序存储，也可以启用按照访问顺序存储，即最近读取的数据放在最前面，最早读取的数据放在最后面，然后它还有一个判断是否删除最老数据的方法，默认是返回false，即不删除数据，我们使用LinkedHashMap实现LRU缓存的方法就是对LinkedHashMap实现简单的扩展，扩展方式有两种，一种是inheritance，一种是delegation，具体使用什么方式看个人喜好
 * <p>
 * 自己总结:
 * 已经实现了顺序存储 默认情况下是按照元素的添加顺序存储，
 */
public class LinkedHashMapDemo {

    public final static void main(String arg[]) {

        final int cacheSize = 100;
        LinkedHashMap<Integer, String> myLinkedH = new LinkedHashMap<Integer, String>((int) Math.ceil(cacheSize / 0.75f) + 1, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return super.removeEldestEntry(eldest);
            }

        };
//        myLinkedH.get()

    }
}

