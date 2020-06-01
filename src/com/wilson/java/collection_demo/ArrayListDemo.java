package com.wilson.java.collection_demo;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ArrayList 封装了一个可以扩容的数组 当数据大于数组的长度的时候,数组变为原来长度的1.5倍 然后把老数组的数据copy到新的数组里面
 * 因为封装的是数组 所以可以利用数组的下标进行获取性能比较好 但是根据下标删除的话性能会比较差 因为需要是使用System.arrayCopy方法进行数据的copy
 *
 * 使用add方法的时候会使用 ensureCapacityInternal 进行判断是否需要扩容
 */
public class ArrayListDemo {

    public final static void main(String arg[]) {


        ArrayList<String> strList = new ArrayList<>();

       strList.add("1");
       strList.add("2");
       strList.add("3");
       strList.add("4");
       strList.add(3,"22");


    }
}

