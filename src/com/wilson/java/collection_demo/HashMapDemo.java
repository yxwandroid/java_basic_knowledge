package com.wilson.java.collection_demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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
