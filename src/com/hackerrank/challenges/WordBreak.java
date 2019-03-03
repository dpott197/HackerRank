package com.hackerrank.challenges;

/**
 * https://www.geeksforgeeks.org/word-break-problem-dp-32/
 */
public class WordBreak {

    // Driver program to test above functions
    // FIXME
    public static void main(String[] args) {
        String[] strings = new String[]{"ilikesamsung","iiiiiiii","","ilikelikeimangoiii","samsungandmango","samsungandmangok"};
        for (String string : strings) {
            String result = wordBreak(string) ? "YES" : "NO";
            System.out.println(String.format("wordBreak(%s) = %s", string, result));
        }
    }

    // returns true if string can be segmented into space
    // separated words, otherwise returns false
    static boolean wordBreak(String string) {
        int size = string.length();

        // Base case
        if (size == 0) return true;

        // Try all prefixes of lengths from 1 to size
        for (int i = 1; i <= size; i++) {
            // The parameter for dictionaryContains is
            // string.substring(0, i) which is prefix (of input
            // string) of length 'i'. We first check whether
            // current prefix is in  dictionary. Then we
            // recursively check for remaining string
            // string.substring(i, size-i) which is suffix of
            // length size-i
            if (dictionaryContains(string.substring(0, i)) &&
                    wordBreak(string.substring(i, size - i)))
                return true;
        }

        // If we have tried all prefixes and
        // none of them worked
        return false;
    }

    static boolean dictionaryContains(String word) {
        String dictionary[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};
        int size = dictionary.length / dictionary[0].length();
        for (int i = 0; i < size; i++) {
            if (dictionary[i].compareTo(word) == 0) {
                return true;
            }

        }

        return false;
    }

}
