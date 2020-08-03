package com.wilson.java.algorithm.sort;

/*选择排序  优于冒泡排序 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 9, 2}; //5
//        int[] arr = {5, 4, 9, 2}; 3
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        SelectSort(arr);
    }


    /**
     *
     * 选择排序是每一次都找到最小的元素   循环次数是
     * @param a
     */
    static void SelectSort(int[] a) {
        if (a == null || a.length <= 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int flag = i; // 将当前下标定义为最小值下标
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < temp) {// a[j] < temp 从小到大排序；a[j] > temp 从大到小排序
                    temp = a[j];
                    flag = j; // 如果有小于当前最小值的关键字将此关键字的下标赋值给flag
                }
            }
            if (flag != i) {
                a[flag] = a[i];
                a[i] = temp;
            }
        }

        System.out.println();
        System.out.println("排序前数组为：");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

}
