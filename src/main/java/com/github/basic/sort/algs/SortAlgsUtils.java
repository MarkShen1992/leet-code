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

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]) {
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

    /**
     * 插入排序算法
     * 
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 从第2个数开始与第一个数作比较，如果第二个数比第一个数小，交换，保证前两个数有序
        // 否则，进行下一轮循环
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    SwapUtils.swap(arr, j, j - 1);
                } else {
                    j = 1; // 为了减少循环次数，算法优化
                }
            }
        }
    }

    /**
     * 希尔排序
     * 
     * @see https://stackoverflow.com/questions/2539545/fastest-gap-sequence-for-shell-sort
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int gap = 1;
        while (gap <= arr.length / 3) {
            gap = gap * 3 + 1;
        }

        for (int h = gap; h > 0; h = (h - 1) / 3) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j > h - 1; j -= h) {
                    if (arr[j - h] > arr[j]) {
                        SwapUtils.swap(arr, j, j - h);
                    } else {
                        j = 1; // 为了减少循环次数，算法优化
                    }
                }
            }
        }
    }
}