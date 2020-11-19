package com.wilson.java.operator;

public class OperatorDemo {
    public static void main(String[] args) {


        //位运算符
        // 按位与运算 &
        //& 如果相对应位都是1，则结果为1，否则为0
        int num0 = 0 & 1;
        int num1 = 1 & 1;
        int num2 = 2 & 1;
        int num3 = 3 & 1;
        int num4 = 4 & 1;
        System.out.println(num0);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);



        //按位取反~   	非运算：按位补运算符翻转操作数的每一位
        int  dd  =~1;
//        int  dd =7&(~1);
        System.out.println(dd);
        int suCai = 1; //素材
        int zhenRen = 1 << 1;  //真人
        int huaZhongHua = 1 << 2; //画中画
        System.out.println(zhenRen);
        System.out.println(huaZhongHua);

//
//        //取余 %
//        int num2 = 5 % 3;
//        System.out.println(num2);
//
//        //无符号右移
//        int num3 = 5 >>> 1;
//        System.out.println(num3);


//        仅环境     1<<1  2
//        仅音频      1
//        环境和音频     (1<<1) | 1  3
//        环境和音频都不选  0
        //    仅环境
//        int num4 = 1 <<2;
//        System.out.println(num4);
////    仅音频      1
////    环境和音频
//        int num5 = (1 << 1) | 1;
//        System.out.println(num5);
//    环境和音频都不选  0
    }


}
