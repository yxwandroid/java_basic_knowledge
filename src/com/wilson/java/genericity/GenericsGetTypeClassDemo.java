package com.wilson.java.genericity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://www.jianshu.com/p/6bb9b8d6ee7a
//获取泛型类型方式
class GenericsGetClassTypeDemo {
    public static void main(String[] args) {


        //写法1
        Type genericSuperclass = Work.class.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        System.out.println(parameterizedType);

        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type type = actualTypeArguments[0];
        System.out.println(type);



        //写法2
        Class<User> genericClass = new Work().getGenericClass();
        System.out.println(genericClass);



        //写法3 匿名内部类的方式
        Class<User> genericClass1 = new SuperWork<User>() {}.getGenericClass();
        System.out.println(genericClass1);
    }
}

abstract class SuperWork<T> {
    public Class<T> getGenericClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}

class Work extends SuperWork<User> {

}

class User {

}