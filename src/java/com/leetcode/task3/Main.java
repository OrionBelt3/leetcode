package com.leetcode.task3;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the str: ");
        String s = console.next();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.print("Result: ");
        System.out.println(result);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int size = s.length();
        int left = 0;
        int i = 0;
        int maxLength = 0;

        for (; i < size; ++i) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                if (maxLength < i - left) {
                    maxLength = i - left;
                }
                left = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), i);
            } else {
                if (i == size - 1) {
                    if (maxLength < i - left + 1) {
                        maxLength = i - left + 1;
                    }
                }
                map.put(s.charAt(i), i);
            }
        }
        return maxLength;
    }
}
