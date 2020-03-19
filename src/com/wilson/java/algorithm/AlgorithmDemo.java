package com.wilson.java.algorithm;

public class AlgorithmDemo {


    public static void main(String[] args) {
        // write your code here
        System.out.print("二分法算法 :");
        int[] arr = {1, 3, 5, 7, 9, 11};
        int value = 5;
        System.out.print(" \n ~ 运算符 取反:" + ~value);
        int value2 = 12 >>> 1;

        System.out.print(" \n >>>  运算符 无符号右移:" + value2);

        int index = binarySearch(arr, arr.length, value);
        System.out.print(" \n算法 :" + index);

    }

    //二分法排序
    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }


}
