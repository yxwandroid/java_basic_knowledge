package com.wilson.java.algorithm.lookup;

/**
 * 二分查找
 * 对有序数组的查找
 * 两种方式
 *    1, 使用while循环
 *    2, 是递归的方式进行查找
 */
public class binarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11};
        int value = 5;
        System.out.print(" \n ~ 运算符 取反:" + ~value);
        int value2 = 12 >>> 1;
        System.out.print(" \n >>>  运算符 无符号右移:" + value2);

        System.out.print(" \n二分查找算法非递归 :");
        int index = binarySearch(arr, value, 0, arr.length - 1);
        System.out.print(" \n算法 :" + index);

        System.out.print(" \n二分查找算法递归 :");
        int index2 = recursionBinarySearch(arr, value, 0, arr.length - 1);
        System.out.print(" \n算法2 :" + index2);

    }


    //二分法查找 不是递归
    static int binarySearch(int[] array, int value, int low, int high) {

        if (value < array[low] || value > array[high] || low > high)
            return -1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = array[mid];

            if (midVal < value) {
                low = mid + 1;
            } else if (midVal > value) {
                high = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~low;  // value not present
    }


    static int recursionBinarySearch(int[] arr, int value, int low, int high) {
        if (value < arr[low] || value > arr[high] || low > high)
            return -1;

        int mid = (low + high) >>> 1;
        if (arr[mid] > value) {
            recursionBinarySearch(arr, value, 0, mid - 1);
        } else if (arr[mid] < value) {
            recursionBinarySearch(arr, value, mid + 1, high);
        } else {
            return mid;
        }
        return -1;
    }

}
