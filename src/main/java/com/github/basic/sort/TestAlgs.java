package com.github.basic.sort;

import com.github.basic.sort.algs.SortAlgsUtils;
import com.github.basic.sort.utils.LogarithmUtils;

/**
 * @author MarkShen
 * @since 2021.12.04
 */
public class TestAlgs {
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] arr1 = LogarithmUtils.generateRandomArray(size, value);
            int[] arr2 = LogarithmUtils.copyArray(arr1);
            int[] arr3 = LogarithmUtils.copyArray(arr1);

            // 要测试的算法
            SortAlgsUtils.bubbleSort(arr1);

            LogarithmUtils.rightMethod(arr2);
            if (!LogarithmUtils.isEqual(arr1, arr2)) {
                succeed = false;
                LogarithmUtils.printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "bad...");
    }
}
