package com.wilson.java.algorithm.lookup;

/**
 * 顺序查找
 * 时间复杂度为 O(n)
 */
public class SequentialSearch {

    public static void main(String[] args) {

    }

    /**
     * 顺序查找 for 循环  返回下标
     */
    public static int sequentialSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }

    /**
     * 顺序查找while循环  返回下标
     * @param a
     * @param key
     * @return
     */
    public static int sequentialSearch2(int[] a, int key) {
        int index = a.length - 1;
        a[0] = key;// 将下标为0的数组元素设置为哨兵
        while (a[index] != key) {
            index--;
        }
        return index;

    }
}
