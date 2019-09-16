package com.wilson.java.wilson;

import java.util.Arrays;

/**
 *
 *
 * 排序算法
 *
 * Created by yangxuewu on 2018/7/9.
 */
public class Demo2 {


    public static void main(String[] args) {
        System.out.print("hello world");
        int[] numbers = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
//        System.out.print(Arrays.toString(numbers));
//        quickSort(numbers, 0, numbers.length - 1);
//        System.out.print(Arrays.toString(numbers));

         bubbleSort(numbers);
         System.out.print(Arrays.toString(numbers));
    }


    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr, int left, int right) {
        //如果left不小于right  说明只有一个元素
        if (left >= right) {
            return;
        }
        //设置最左边的为基准点
        int p = arr[left];
        int i = left;
        int j = right;
        //把要排序的序列比p大的放在右边 比p小的放在左边
        while (i < j) {
            //j 向左移动
            while (arr[j] >= p && i < j) {
                j--;
            }
            //i 向右移动
            while (arr[i] <= p && i < j) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        arr[left] = arr[i];
        arr[i] = p;
        //对序列中 i 左边的元素进行快速排序
        quickSort(arr, left, i - 1);
        //对序列中 i 右边的元素进行快速排序
        quickSort(arr, i + 1, right);
    }

}
