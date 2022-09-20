package com.leetcode.task28;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String haystack;
        String needle;

        Scanner console = new Scanner(System.in);

        System.out.print("1) ");
        haystack = console.next();
        System.out.print("2) ");
        needle = console.next();
        System.out.println("Position: " + new Solution().strStr(haystack, needle));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int [] pi = piFunction(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                ++i;
                ++j;

            } else {
                if (j != 0) {
                    j = pi[j-1];
                } else {
                    ++i;
                }
            }
        }

        return -1;
    }

    public int [] piFunction (String str) {
        int [] pi = new int[str.length()];
        int j = 0;
        pi[0] = 0;

        for (int i = 1; i < str.length();) {
            if (str.charAt(i) == str.charAt(j)) {
                pi[i] = j + 1;
                ++j;
                ++i;
            } else {
                if (j == 0) {
                    pi[i] = 0;
                    ++i;
                } else {
                    j = pi[j - 1];
                }
            }
        }
        return pi;
    }
}
