package com.github.helloalgo.ch0;

public class Ch0000SwapDemo {
    public static void main(String[] args) {
        int a = 9;
        int b = 2;
        System.out.println(a + "\t" + b);

        // 位运算实现两数交换
        b = a ^ b;
        a = a ^ b;
        b = a ^ b;
        System.out.println(a + "\t" + b);
    }
}
