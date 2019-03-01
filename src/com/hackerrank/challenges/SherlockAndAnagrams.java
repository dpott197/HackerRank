package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 */
public class SherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // Keep track of how many anagrams we've seen
        int totalCount = 0;

        // Generate all substrings O(N^2)
        for(int i = 0 ; i < s.length(); i++)
        {
            for(int j=i+1 ; j <= s.length(); j++)
            {
                String currentSubString = s.substring(i,j);

                // Sort all strings E.g. ab & ba both == ab now
                char[] chars = currentSubString.toCharArray();
                Arrays.sort(chars);
                currentSubString = String.valueOf(chars);

                // If sorted substring has been seen before
                if(map.containsKey(currentSubString))
                {
                    // Check how many times we've seen it and add that amount to the count
                    int value = map.get(currentSubString);
                    totalCount=totalCount+value;

                    // Increment the times we've seen the string
                    map.put(currentSubString, value+1);
                }
                else
                {
                    // Never seen it before = insert and set to 1 to indicate we've now seen it
                    map.put(currentSubString, 1);
                }
            }
        }

        return totalCount;
    }

}
