package com.hackerrank.challenges.misc;

public class Mathematics {

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(String.format("power(%d, %d) = %d", x, n, power(x, n)));
        System.out.println(String.format("multiply(%d, %d) = %d", x, n, multiply(x, n)));
    }

    static long power(long x, long n) {
        return powerRecursive(x, n);
    }

    static long multiply(long x, long n) {
        return multiplyRecursive(x, n);
    }

    static long multiplyStandard(long x, long n) {
        return x * n;
    }

    static long powerStandard(long x, long n) {
        return Math.round(Math.pow(x, n));
    }

    static long powerRecursive(long x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        return x * powerRecursive(x, n - 1);
    }

    static long multiplyRecursive(long x, long y) {
        if (x == 0 || y == 0) {
            return 0;
        }

        if (x == 1) {
            return y;
        }

        if (y == 1) {
            return x;
        }

        return x + multiplyRecursive(x, y - 1);
    }

}
