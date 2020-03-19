package com.wilson.java.algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 9, 2}; //5
//        int[] arr = {5, 4, 9, 2}; 3
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        BubbleSort(arr);
    }


    /**
     * 冒泡排序
     *
     * 外层循环控制趟数  趟数 = arr.length- 1
     *
     * @param arr
     */
    static void BubbleSort(int[] arr) {
        if (arr == null || arr.length <=1) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }



                System.out.println();
                System.out.println("第" + j + "次：");
                for (int num : arr) {
                    System.out.print(num + " ");
                }

            }


            System.out.println();
            System.out.println("第" + i + "趟过程的数组为：");
            for (int num : arr) {
                System.out.print(num + " ");
            }

        }


        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
