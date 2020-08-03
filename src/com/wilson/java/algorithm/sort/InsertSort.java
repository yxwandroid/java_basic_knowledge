package com.wilson.java.algorithm.sort;

/*插入排序优于 选择排序 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 9, 2}; //5
//        int[] arr = {5, 4, 9, 2}; 3
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        insertSort(arr);
    }


    /**
     * 选择排序是每一次都找到最小的元素   循环次数是
     *
     * @param a
     */
    public static void insertSort(int[] a) {
        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = a[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < a[j]) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            a[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }

        System.out.println();
        System.out.println("排序前数组为：");
        for (int num : a) {
            System.out.print(num + " ");
        }
    }

}
