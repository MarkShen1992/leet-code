package com.github.basic.math;

/**
 * 最大公约数
 */
public class GCD {
    public static void main(String[] args) {
        int a = 12997, b = 615;
        int max, min;
        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        int gcd = 0;
        while (max % min != 0) {
            gcd = max % min;
            max = min;
            min = gcd;
        }
        System.out.println(min);
        System.out.println(gcd(a, b));
    }

    static int gcd(int max, int min) {
        if (min == 0) {
            return max;
        }
        return gcd(min, max % min);
    }
}
