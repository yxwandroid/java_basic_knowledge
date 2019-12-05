package com.wilson.java.collection_demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapDemo {

    public final  static void main(String arg[]){
        System.out.print("----hashMap---------- ");
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", "josan");
        String name = hashMap.get("name");

        new Hashtable<>();


        System.out.print(1 << 30);

    }
}
