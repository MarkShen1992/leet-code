package com.github.n0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MarkShen
 * @since 2020.10.13
 */
public class TwoSum {

    /**
     * 一种解题思路：排列组合思想
     *
     * @param arr
     * @param target
     * @return
     */
    static int[] twoSum(int[] arr, int target) {
        int length = arr.length;

        if (arr == null || length < 2)
            return null;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }

    /**
     * 另一种解题思路
     *
     * @param arr
     * @param target
     * @return
     */
    static int[] twoSum02(int[] arr, int target) {
        int length = arr.length;

        if (arr == null || length < 2)
            return null;

        // number => index
        Map<Integer, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (numberMap.containsKey(target - arr[i])) {
                return new int[] {numberMap.get(target - arr[i]), i};
            }
            numberMap.put(arr[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 5, 9};
        int[] result = twoSum02(arr, 10);

        if (result.length == 0) {
            System.out.println("这组数据中没有满足条件的数据......");
        } else {
            System.out.format("满足条件数据的下标 {%d, %d}", result[0], result[1]);
        }
    }
}