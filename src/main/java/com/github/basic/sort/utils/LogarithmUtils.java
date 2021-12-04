package com.github.basic.sort.utils;

import java.util.Arrays;

/**
 * 设计对数器的步骤： 1. 有一个你要测的方法a； 2.实现一个绝对正确即使复杂度不好的方法b； 3.实现一个随机样本产生器； 4.实现比对的方法； 5.把方法a和方法b比对很多次来验证方法a是否正确
 * 6.如果有一个样本使得比对出错，打印样本分析是哪个方法出错 7.当样本数量很多时比对测试依然正确，可以确定方法a已经正确
 *
 * @author MarkShen
 */
public class LogarithmUtils {

    /**
     * 可以直接用一些库函数来进行测试
     *
     * @param arr
     */
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 随机数生成器
     *
     * @param size
     * @param value
     * @return
     */
    public static int[] generateRandomArray(int size, int value) {
        // Math.random() -> double [0,1)
        // (int) ((size + 1) * Math.random()) -> [0,size]整数
        // 生成长度随机[0, size]的数组
        int[] arr = new int[(int)((size + 1) * Math.random())];

        // 一个随机数减去另一个随机数，生成[-value, value]的随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((value + 1) * Math.random()) - (int)(value * Math.random());
        }
        return arr;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null && arr2 == null)
            return true;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr != null && arr.length > 0) {
            for (int e : arr) {
                System.out.print(e + " ");
            }
        }
    }

    /**
     * 拷贝数组
     * 
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }
}