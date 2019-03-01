package com.hackerrank.challenges;

public class RepeatedString {

    public static void main(String[] args) {
        System.out.println("repeatedString(\"aba\", 10) = "+repeatedString("aba", 10));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long result = 0;
        char[] chars = s.toCharArray();
        long dividend = n / chars.length;
        long remainder = n % chars.length;
        long countAinS = 0;

        for (int i = 0; i < chars.length; i++) {
            if ('a'==chars[i]) {
                countAinS++;
            }
        }

        result = dividend * countAinS;

        for (int i = 0; i < remainder; i++) {
            if ('a'==chars[i]) {
                result++;
            }
        }

        return result;
    }

}
