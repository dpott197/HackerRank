package com.hackerrank.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountingTriplets {

    // r = 4
    // arr = [1,4,16,64]

    public static void main(String[] args) {
        List<Long> arr = new ArrayList<Long>();
        arr.add(1L);
        arr.add(4L);
        arr.add(16L);
        arr.add(64L);

        long r = 4;
        System.out.println(String.format("countTriplets(%s, %s) = %s", arr, r, countTriplets(arr, r)));
    }

    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> map1 = new HashMap();
        HashMap<Long, Long> map2 = new HashMap();
        long count = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            long a = arr.get(i);
            if (map1.containsKey(a * r)) {
                long c = map1.get(a * r);
                if (map2.containsKey(a)) {
                    map2.put(a, map2.get(a) + c);
                } else {
                    map2.put(a, c);
                }
            }

            if (map2.containsKey(a * r)) {
                count += map2.get(a * r);
            }


            if (map1.containsKey(a)) {
                map1.put(a, map1.get(a) + 1L);
            } else {
                map1.put(a, 1L);
            }
        }
        return count;
    }

}
