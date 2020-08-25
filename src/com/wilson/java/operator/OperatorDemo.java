package com.wilson.java.operator;

public class OperatorDemo {
    public static void main(String[] args) {


        //位运算符
        // 按位与运算 &
        //& 如果相对应位都是1，则结果为1，否则为0
        int num = 3 & 1;
        System.out.println(num);


        //取余 %
        int num2 = 5 % 3;
        System.out.println(num2);

        //无符号右移
        int num3= 5>>>1;
        System.out.println(num3);
    }
}
