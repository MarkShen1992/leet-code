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

    /**
     * 快速排序
     * 
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length < 2) {
            return;
        }

        if (low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                SwapUtils.swap(arr, i, j);
            }
        }
        SwapUtils.swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * 快速排序第二种方式
     * 
     * @param arr
     * @param L
     * @param R
     */
    public static void quickSort2(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return;
        }

        if (L >= R) {
            return;
        }
        int left = L, right = R;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left >= right) {
                arr[left] = pivot;
            }
        }
        quickSort2(arr, L, right - 1);
        quickSort2(arr, right + 1, R);
    }
}