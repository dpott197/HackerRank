package com.hackerrank.challenges.misc;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

public class CountingPairs {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 5, 9, 2, 12, 3};
        int delta = 2;
        System.out.println(String.format("countPairsWithDifference(%s, %d) = %d", arr, delta, countPairsWithDifference(arr, delta)));
    }

    static int countPairsWithDifference(int[] arr, int delta) {
        return countPairsWithDiffK(arr, arr.length, delta);
    }

    static int countPairsWithDifferenceOptimal(int[] arr, int delta) {
        int count = 0;

        HashSet<Integer> map = new HashSet<>();
        for (int e : arr) {
            map.add(e);
            if (map.contains(e + delta)) {
                count++;
            }
        }

        return count;
    }

    /* An efficient program to count pairs with difference k when the range
   numbers is small */
    private static final int MAX = 1000;
    static int countPairsWithDiffK(int arr[], int n, int k) {
        int count = 0;  // Initialize count

        // Initialize empty hashmap.
        HashMap<Integer, Boolean> hashmap = new HashMap<>();

        // Insert array elements to hashmap
        for (int i = 0; i < n; i++) {
            hashmap.put(arr[i], true);
        }

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            if (x - k >= 0 && hashmap.containsKey(x - k) && hashmap.get(x - k)) {
                count++;
            }

            if (x + k < MAX && hashmap.containsKey(x + k) && hashmap.get(x + k)) {
                count++;
            }

            hashmap.put(x, false);
        }
        return count;
    }

    static int countPairsWithDifferenceNaive(int[] arr, int delta) {
        int count = 0;

        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    continue;
                }

                int diff = arr[i] - arr[j];
                map.put(new Pair<>(arr[i], arr[j]), diff);
                map.put(new Pair<>(arr[j], arr[i]), -diff);

                if (diff == delta) {
                    count++;
                }
            }
        }

        return count;
    }

}
