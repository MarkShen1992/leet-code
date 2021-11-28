package com.github.basic.sort;

import com.github.basic.sort.utils.SwapUtils;

/**
 * @author MarkShen
 * @since 2021.11.27
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5, 2};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    SwapUtils.swap(arr, i, j);
                }
            }
        }

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
