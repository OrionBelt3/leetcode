package com.leetcode.task14;

public class Main {
    public static void main(String[] args) {
        String [] strs = {
                "rewqn",
                "rew",
                "rewqnds",
                "re",
                "rewqnaaa"
        };

        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();
        String pattern = strs[0];
        int count = 0;
        boolean flag = false;

        for (int i = 0; i < pattern.length(); ++i) {

            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].length() == i || pattern.charAt(i) != strs[j].charAt(i)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }

            result.append(pattern.charAt(i));
        }

        return result.toString();
    }
}