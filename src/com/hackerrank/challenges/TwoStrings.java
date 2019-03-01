package com.hackerrank.challenges;

public class TwoStrings {

    // Brute Force, Slow
    static String twoStrings(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "NO";
        }

        for (int end = 0; end < s1.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (s2.contains(s1.substring(start, end))) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

}
