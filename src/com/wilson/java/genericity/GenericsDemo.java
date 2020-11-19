package com.wilson.java.genericity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//https://blog.csdn.net/qq_36761831/article/details/82289786?utm_source=app
//泛型 泛型檫除  为什么出泛型檫除 是为了兼容java 1.5 版本之前的
public class GenericsDemo {
    public static void main(String[] args) {
        List<String> ll = new ArrayList<>();
        List<Integer> kk = new ArrayList<>();
        System.out.println(ll.getClass());//输出：class java.util.ArrayList
        System.out.println(kk.getClass());//输出：class java.util.ArrayList

        //为相等是因为类型檫除
        System.out.println(ll.getClass() == kk.getClass());//输出：true




        //可以利用泛型檫除的原理 使用反射绕过正常开发的中编译不允许的限制
        ArrayList<Integer> list = new ArrayList<>();
        list.add(222);
        try {
            Method add = list.getClass().getDeclaredMethod("add", Object.class);
            add.invoke(list,"test");
            add.invoke(list,3.4);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        for (Object o:list){
            System.out.println(o);
        }




    }
}


