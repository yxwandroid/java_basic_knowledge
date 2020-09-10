package com.wilson.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 什么是反射
 * 反射就是在运行时才知道要操作的类是什么，并且可以在运行时获取类的完整构造，并调用对应的方法。
 */
public class ReflectDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //正常的调用
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());
        //使用反射调用
        Class clz = Class.forName("com.wilson.java.reflect.Apple");
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        Constructor appleConstructor = clz.getConstructor();
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        Object invoke = getPriceMethod.invoke(appleObj);
        System.out.println("Apple Price:" + invoke);


        Class<Apple> appleClass = Apple.class;
        //获取类的属性  只能获取非私有的属性
        Field[] fields = appleClass.getFields();
        for (Field field : fields) {
            String name = field.getName();
            System.out.println(name);
        }

        System.out.println("--------");
        Field[] declaredField = appleClass.getDeclaredFields();
        for (Field field : declaredField) {
            String name = field.getName();
            System.out.println(name);
        }


    }
}


