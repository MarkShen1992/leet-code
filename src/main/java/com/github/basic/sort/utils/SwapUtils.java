package com.github.basic.sort.utils;

/**
 * 交换两个数工具类
 * 
 * @since 2021.11.27
 */
public class SwapUtils {

    /**
     * 交换
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
