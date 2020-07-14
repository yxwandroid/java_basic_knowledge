package com.wilson.java.collection_demo.arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * ArrayList 封装了一个可以扩容的数组 当数据大于数组的长度的时候,数组变为原来长度的1.5倍 然后把老数组的数据copy到新的数组里面
 * 因为封装的是数组 所以可以利用数组的下标进行获取性能比较好 但是根据下标删除的话性能会比较差 因为需要是使用System.arrayCopy方法进行数据的copy
 * <p>
 * 使用add方法的时候会使用 ensureCapacityInternal 进行判断是否需要扩容
 */
public class ArrayListDemo {

    public final static void main(String arg[]) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("1");







        HashSet c = new HashSet();
        c.add("222222");
        c.add("2");

        ArrayList arrayList = new ArrayList<>(c);
        arrayList.size();

//       strList.add("2");
//       strList.add("3");
//       strList.add("4");
//       strList.add(3,"22");


    }


//    public static void main(String[] args){
//        //测试添加操作
//        MyArrayList<String> myArrayList = new MyArrayList<>();
//        myArrayList.add("Android");
//        myArrayList.add("Web");
//        myArrayList.add("IOS");
//        printArrayList(myArrayList.iterator());
//        //测试更新以及删除操作
//        myArrayList.set(1,"JAVA");
//        myArrayList.remove(0);
//        myArrayList.remove("IOS");
//        printArrayList(myArrayList.iterator());
//        //测试addAll操作
//        List<String> list = new ArrayList<>();
//        list.add("PHP");
//        list.add("C++");
//        myArrayList.addAll(list);
//        printArrayList(myArrayList.iterator());
//        //测试查找位置操作
//        myArrayList.add("JAVA");
//        myArrayList.add("HTML");
//        printArrayList(myArrayList.iterator());
//        System.out.println("是否存在JAVA课程：" + myArrayList.contains("JAVA"));
//        System.out.println("JAVA课程的开始位置：" + myArrayList.indexOf("JAVA"));
//        System.out.println("JAVA课程的最后位置：" + myArrayList.lastIndexOf("JAVA"));
//    }
//
//
//    private static void printArrayList(Iterator iterator){
//        System.out.print("当前ArrayList为：");
//        while (iterator.hasNext()){
//            System.out.print(iterator.next() + " ");
//        }
//        System.out.println();
//    }
}

