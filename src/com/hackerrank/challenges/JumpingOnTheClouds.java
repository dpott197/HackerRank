package com.hackerrank.challenges;

import java.io.*;
import java.util.*;

/**
 * Problem
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *
 * Solution
 * https://github.com/smholsen/HackerRank/blob/master/Practice/Algorithms/Implementation/JumpingOnTheClouds/Solution.java
 */
public class JumpingOnTheClouds {

    public static void main(String[] args) {
        int[] c = new int[]{0,0,1,0,0,1,0};
        System.out.println("jumpingOnClouds([0,0,1,0,0,1,0]) = " + jumpingOnClouds(c));
    }

    // Complete the jumpingOnClouds function below.
    public static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;
        while (i < c.length) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                jumps++;
                i = i + 2;
            } else if (i + 1 < c.length && c[i + 1] == 0) {
                jumps++;
                i = i + 1;
            } else {
                i = c.length; // FIXME
                // throws Exception("Game cannot be completed");
            }
        }

        return jumps;
    }

}
