package com.hackerrank.challenges;

import java.util.HashMap;

/**
 * https://www.hackerrank.com/challenges/sock-merchant
 */
public class SockMerchant {

    public static void main(String[] args) {
        int[] ar = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        int n = ar.length; // Not really necessary, but this is how the problem is defined.
        System.out.println("sockMerchant(n, ar) = "+sockMerchant(ar.length, ar));
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(ar[i])) {
                map.put(ar[i], map.get(ar[i])+1);
            } else {
                map.put(ar[i], 1);
            }
        }

        for (Integer value : map.values()) {
            result += value/2;
        }

        return result;
    }

}
