package com.github.utils;

/**
 * 交换两个数
 */
public class SwapUtils {

    /**
     * 位运算实现两个数交换
     * 
     * @param arr
     * @param i
     * @param j
     */
    public static void bitSwap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /**
     * 交换两数数的值
     * 
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
