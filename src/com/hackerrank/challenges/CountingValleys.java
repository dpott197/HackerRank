package com.hackerrank.challenges;

/**
 * https://www.hackerrank.com/challenges/counting-valleys
 */
public class CountingValleys {

    public static void main(String[] args) {
        String s = "UDDDUDUU";
        int n = s.length();
        System.out.println(String.format("countingValleys(%d, %s) = %d",n,s,countingValleys(n,s)));
    }

    static int countingValleys(int n, String s) {
        int valleys = 0;
        int elevation = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == 'U') {
                elevation++;
            }

            if (c == 'D') {
                elevation--;
            }

            if (elevation == 0 && chars[i] == 'U') {
                valleys++;
            }
        }

        return valleys;
    }

}

