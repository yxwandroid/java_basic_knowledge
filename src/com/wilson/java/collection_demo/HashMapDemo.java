package com.wilson.java.collection_demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *  容量必须是2的幂为什么
 * Java的%、/操作比&慢10倍左右，因此采用&运算会提高性能。
 * https://blog.csdn.net/u014532901/article/details/78936283#31-%E5%AE%B9%E9%87%8F%E5%BF%85%E9%A1%BB%E6%98%AF2%E7%9A%84%E5%B9%82
 */

public class HashMapDemo {

    /**
     * The default initial capacity - MUST be a power of two.
     *  1左移4位 是16 默认hashmap的长度是16
     *
     */
    public final  static void main(String arg[]){
//        System.out.print("----hashMap---------- ");
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", "josan");
        String name = hashMap.get("name");

        new Hashtable<>();


        System.out.print(1 << 10);

    }
}
