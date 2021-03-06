package com.wilson.java.lru_demo.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used) 最简单实现
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //缓存大小
    private int cacheSize;

    public LRUCache(int cacheSize) {
        //第三个参数true是关键
        super(10, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 缓存是否已满  当缓存满的时候进行删除链表尾部的元素
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        boolean r = size() > cacheSize;
        if (r) {
            System.out.println("清除缓存key：" + eldest.getKey());
        }
        return r;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }



    public static  void main(String []arr){
        LRUCache<String, String> cache = new LRUCache<String, String>(5);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
        cache.put("5", "5");
        System.out.println("初始：");
        System.out.println(cache.keySet());
        System.out.println("访问3：");
        cache.get("3");
        System.out.println(cache.keySet());
        System.out.println("访问2：");
        cache.get("2");
        System.out.println(cache.keySet());
        System.out.println("增加数据6,7：");
        cache.put("6", "6");
        cache.put("7", "7");
        System.out.println(cache.keySet());

    }
}