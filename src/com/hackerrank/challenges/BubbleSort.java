package com.hackerrank.challenges;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = new int[]{0, 9, 3, 0, 8, 8};
        System.out.println(String.format("bubbleSort(%s) = %s", Arrays.toString(a), Arrays.toString(bubbleSort(a))));
    }

    public static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    // Swap
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        return a;
    }

}
