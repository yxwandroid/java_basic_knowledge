package com.wilson.java.boxing;
//https://www.cnblogs.com/dolphin0520/p/3780005.html
public class BoxingDemo {
    public static void main(String[] args) {
        //装箱拆箱
        Integer m = 10;  //装箱
        int n = m;   //拆箱


        Integer i=100;
        Integer j=100;
        Integer k=300;
        Integer r=300;

        //对象对比
        System.out.println(i==j);
        System.out.println(k==r);
        // 值对比
        System.out.println(i.equals(j));
        System.out.println(k.equals(r));

        Integer zhuangxiang = Integer.valueOf(100);

    }
}
