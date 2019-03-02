package com.hackerrank.challenges;

import java.util.HashMap;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 */
public class RansomNote {

    public static void main(String args[]) {
        String[] magazine = new String[]{"give", "me", "one", "grand", "today", "night"};
        String[] note = new String[]{"two", "times", "two", "is", "four"}; // false
//        String[] note = new String[]{"Give", "me"}; // false
//        String[] note = new String[]{"give", "me"}; // true
        System.out.println(String.format("checkMagazine(%s, %s) = %s", magazine, note, checkMagazine(magazine, note)));
    }

    static boolean checkMagazine(String[] magazine, String[] note) {
        return checkMagazineHash(magazine, note);
    }

    static boolean checkMagazineBrute(String[] magazine, String[] note) {
        if (magazine == null || note == null) {
            return false;
        }

        for (String n : note) {
            boolean isFound = false;
            for (String m : magazine) {
                if (m.equals(n)) {
                    isFound = true;
                    break;
                }
            }

            if (isFound) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    static boolean checkMagazineHash(String[] magazine, String[] note) {
        if (magazine == null || note == null) {
            return false;
        }

        HashMap<String, Integer> magazineMap = new HashMap<>();
        for (String m : magazine) {
            if (magazineMap.containsKey(m)) {
                magazineMap.put(m, magazineMap.get(m) + 1);
            } else {
                magazineMap.put(m, 1);
            }
        }

        for (String n : note) {
            if (!magazineMap.containsKey(n) || magazineMap.get(n) <= 0) {
                return false;
            } else {
                magazineMap.put(n, magazineMap.get(n) - 1);
            }
        }

        return true;
    }
}
