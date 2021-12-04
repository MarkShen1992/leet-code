package com.github.basic.sort.algs;

import com.github.basic.sort.utils.SwapUtils;

/**
 * Sort Algorithms
 */
public class SortAlgsUtils {

    /**
     * 选择排序
     * 
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    SwapUtils.swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 冒泡排序算法
     * 
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtils.swap(arr, j, j + 1);
                }
            }
        }
    }
}
