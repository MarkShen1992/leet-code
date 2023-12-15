package com.github.helloalgo.ch0;

import com.github.utils.SwapUtils;

public class Ch0001BinarySearch {
    public static void main(String[] args) {
        // 二分法查找
        int[] arr = {1, 6, 8, 3, 6};

        // 查找第一个元素 {} 的下标
        sort(arr);

        // 二分法查找前需要先对要排序的数组排序
        int i = binarySearch(arr, 0, arr.length, 6);
        if (i < 0) {
            System.out.println("not found the key.");
        }
        System.out.println(i);
    }

    /**
     * 选择排序算法
     * 
     * @param arr
     */
    private static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    SwapUtils.bitSwap(arr, i, j);
                }
            }
        }
    }

    /**
     * 二分法查找
     * 
     * @param arr
     *            数组
     * @param fromIndex
     *            开始下标
     * @param toIndex
     *            结束下标
     * @param key
     *            要查找的值
     * @return
     */
    private static int binarySearch(int[] arr, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1; // unsigned right shift
            int midVal = arr[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -(low + 1); // key not found.
    }
}
